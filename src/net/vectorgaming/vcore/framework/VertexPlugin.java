
package net.vectorgaming.vcore.framework;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Kenny
 */
public abstract class VertexPlugin extends JavaPlugin
{
    public abstract void onEnable();
    public abstract void onDisable();
    public abstract void setupCommands();
    public abstract Plugin getPlugin();
}
