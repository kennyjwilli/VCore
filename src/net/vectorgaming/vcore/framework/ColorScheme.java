
package net.vectorgaming.vcore.framework;

import org.bukkit.ChatColor;

/**
 *
 * @author Kenny
 */
public interface ColorScheme 
{
    public ChatColor getPluginColor();
    public ChatColor getArgumentColor();
    public ChatColor getErrorColor();
    public String getTitleBar(String titleName);
}
