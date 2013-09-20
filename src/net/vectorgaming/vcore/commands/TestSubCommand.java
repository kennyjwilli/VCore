
package net.vectorgaming.vcore.commands;

import net.vectorgaming.vcore.VCoreAPI;
import net.vectorgaming.vcore.framework.VertexPlugin;
import net.vectorgaming.vcore.framework.commands.SubCommand;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Kenny
 */
public class TestSubCommand extends SubCommand
{
    public TestSubCommand()
    {
        super("test", VCoreAPI.getPlugin());
    }
    
    @Override
    public void run(VertexPlugin plugin, CommandSender cs, String[] args)
    {
        cs.sendMessage("reached subcommand!");
    }

    @Override
    public String getDescription()
    {
        return "desc";
    }

    @Override
    public String getUsage()
    {
        return "test";
    }

    @Override
    public String getPermission()
    {
        return "test.test";
    }

    @Override
    public Integer getMinArgsLength()
    {
        return 0;
    }

    @Override
    public boolean isPlayerOnlyCommand()
    {
        return false;
    }

}
