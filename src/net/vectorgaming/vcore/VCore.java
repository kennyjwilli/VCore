package net.vectorgaming.vcore;

import net.vectorgaming.vcore.commands.TestCommand;
import net.vectorgaming.vcore.framework.VertexPlugin;
import net.vectorgaming.vcore.framework.VertexAPI;
import net.vectorgaming.vcore.framework.commands.CommandManager;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Kenny
 */
public class VCore extends VertexPlugin
{
    private VCoreAPI api;
    
    public void onEnable()
    {
        api = new VCoreAPI(this);
        setupCommands();
    }

    @Override
    public Plugin getPlugin() {return this;}

    @Override
    public VertexAPI getAPI()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onDisable(){}

    @Override
    public void setupCommands()
    {
        CommandManager.registerCommand(new TestCommand());
    }
}
