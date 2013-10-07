
package net.vectorgaming.vcore.framework.commands;

import java.util.ArrayList;
import java.util.Arrays;
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
    private ArrayList<SubCommand> subCommands = new ArrayList<>();
    
    /**
     *
     * @param command Name of the command
     * @param plugin Plugin the command is coming from
     */
    protected VCommand(String command, VertexPlugin plugin)
    {
        super(command);
        this.plugin = plugin;
    }
    
    /**
     *
     * @param command Name of the command
     * @param aliases A list of aliases for the command
     * @param plugin Plugin the command is coming from
     */
    protected VCommand(String command, List<String> aliases, VertexPlugin plugin)
    {
        super(command);
        this.plugin = plugin;
        this.setAliases(aliases);
    }
        
    /**
     * Called whenever the command is ran
     * @param cs Sender of the command
     * @param args Arguments after the command
     */
    public abstract void run(CommandSender cs, String[] args);
    
    /**
     * Returns the description of the command and what it does.
     * @return Command description
     */
    public abstract String getDescription();
    
    /**
     * Returns a String stating how the command should be properly used
     * @return Command usage
     */
    public abstract String getUsage();
    
    /**
     * Returns the permission required for a player to use the command
     * @return Permission node for the command
     */
    public abstract String getPermission();
    
    /**
     * Returns the minimum amount of arguments required for the command to be executed
     * @return Minimum amount of arguments
     */
    public abstract Integer getMinArgsLength();
    
    /**
     * Returns the maximum number of arguments the command can have. If there is no restriction on
     * maximum arguments, give this method a negative value
     * @return Maximum amount of arguments
     */
    public abstract Integer getMaxArgsLength();
    
    /**
     * Checks to see if the command can only be executed by a player
     * @return True if can only be used by a player
     */
    public abstract boolean isPlayerOnlyCommand();
    
    /**
     * Returns a list of sub commands that the command has registered. 
     * 
     * This list should be empty if the command has no sub commands
     * @return A list of sub commands
     */
    public ArrayList<SubCommand> getSubCommands() 
    {
        return subCommands;
    }
    
    /**
     * Adds a sub command to the super command
     * @param c Sub command that should be added
     */
    public void addSubCommand(SubCommand c) 
    {
        subCommands.add(c);
    }
    
    /**
     * Removes a sub command from the super command
     * @param c Sub command that should be removed
     */
    public void removeSubCommand(SubCommand c) 
    {
        subCommands.remove(c);
    }
    
    /**
     * Adds an alias to the command. This alias can be used as a substitute to execute the command
     * @param alias Name of the alias
     */
    public void addAlias(String alias)
    {
        List<String> aliases = getAliases();
        if(!aliases.contains(alias))
        {
            aliases.add(alias);
        }
        setAliases(aliases);
    }
    
    /**
     * Returns the plugin that the command is being sent from
     * @return Plugin sending the command
     */
    public VertexPlugin getPlugin() 
    {
        return plugin;
    }
    
    /**
     * Sends the sender a message prefixed by brackets surrounding the plugin's name
     * @param cs Sender to send the message to
     * @param message Message to send to the sender
     */
    public void sendMessage(CommandSender cs, String message)
    {
        cs.sendMessage(ChatColor.BLACK+"["+VCoreAPI.getColorScheme().getPluginColor()+plugin.getName()+ChatColor.BLACK+"] "+ChatColor.WHITE+message);
    }
    
    /**
     * Sends the sender an error message using the default color scheme
     * @param cs Sender to send the message to
     * @param message Message to send the sender
     */
    public void sendErrorMessage(CommandSender cs, String message)
    {
        cs.sendMessage(VCoreAPI.getColorScheme().getErrorColor()+"Error: "+message);
    }
    
    /**
     * This method executes the command going through all checks to ensure the sender can
     * execute the command. 
     * 
     * The method should NOT be overriden.
     * @param cs Sender of the command
     * @param lbl Command name
     * @param args Command arguments
     * @return boolean value
     */
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
        
        if(args.length > getMaxArgsLength())
        {
            sendErrorMessage(cs, "Too many command arguments.");
            cs.sendMessage(ChatColor.RED+"Usage: "+getUsage());
        }
        
        //Runs subcommand if needed
        if(args.length >= 1 && !getSubCommands().isEmpty())
        {
            for(SubCommand c : getSubCommands())
            {
                if(c.getName().equalsIgnoreCase(args[0]))
                {
                    String[] subArgs = Arrays.copyOfRange(args, 1, args.length);
                    c.execute(cs, lbl, subArgs);
                    return true;
                }
            }
        }
        
        run(cs, args);
        return true;
    }
}
