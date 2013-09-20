
package net.vectorgaming.vcore.framework.commands;

import java.util.List;
import net.vectorgaming.vcore.VCoreAPI;
import net.vectorgaming.vcore.framework.VertexPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

/**
 *
 * @author Kenny
 */
public abstract class VCommand extends Command
{
    private VertexPlugin plugin;
    
    protected VCommand(String command, VertexPlugin plugin)
    {
        super(command);
        this.plugin = plugin;
    }
    
    protected VCommand(String command, List<String> aliases, VertexPlugin plugin)
    {
        super(command);
        this.plugin = plugin;
        this.setAliases(aliases);
    }
        
    public abstract void run(VertexPlugin plugin, CommandSender cs, String[] args);
    public abstract String getDescription();
    public abstract String getUsage();
    public abstract String getPermission();
    public abstract Integer getMinArgsLength();
    public abstract boolean isPlayerOnlyCommand();
    
    public VertexPlugin getPlugin() {return plugin;}
    
    public void sendMessage(CommandSender cs, String message)
    {
        cs.sendMessage(ChatColor.BLACK+"["+VCoreAPI.getColorScheme().getPluginColor()+plugin.getName()+ChatColor.BLACK+"] "+ChatColor.WHITE+message);
    }
    
    public void sendErrorMessage(CommandSender cs, String message)
    {
        cs.sendMessage(VCoreAPI.getColorScheme().getErrorColor()+"Error: "+message);
    }
    
    @Override
    public final boolean execute(CommandSender cs, String lbl, String[] args)
    {
        if(isPlayerOnlyCommand() && cs instanceof ConsoleCommandSender)
        {
            System.out.println("["+plugin.getName()+"] This command can only be executed by a player.");
            return true;
        }
        
        if(!cs.hasPermission(getPermission()))
        {
            sendMessage(cs, ChatColor.RED+"You don't have permission.");
            return true;
        }
        
        if(args.length < getMinArgsLength())
        {
            cs.sendMessage(ChatColor.RED+"Usage: "+getUsage());
            return true;
        }
        
        run(plugin, cs, args);
        return true;
    }
}
