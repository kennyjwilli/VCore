
package net.vectorgaming.vcore.commands;

import net.vectorgaming.vcore.VCore;
import net.vectorgaming.vcore.VCoreAPI;
import net.vectorgaming.vcore.framework.VertexPlugin;
import net.vectorgaming.vcore.framework.commands.VCommand;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Kenny
 */
public class TestCommand extends VCommand
{
    public TestCommand() {
        super("test", VCoreAPI.getPlugin());
        this.addSubCommand(new TestSubCommand());
    }

    @Override
    public void run(VertexPlugin plugin, CommandSender cs, String[] args)
    {
        System.out.println("Hello World!");
    }

    @Override
    public String getDescription()
    {
        return("tt");
    }

    @Override
    public String getUsage()
    {
        return("usage");
    }

    @Override
    public String getPermission()
    {
        return("test");
    }

    @Override
    public boolean isPlayerOnlyCommand()
    {
        return true;
    }

    @Override
    public Integer getMinArgsLength()
    {
        return 0;
    }

}
