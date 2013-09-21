
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
        cs.sendMessage("Hello World!");
    }

    @Override
    public String getDescription()
    {
        return("This is a test command");
    }

    @Override
    public String getUsage()
    {
        return("/test");
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
