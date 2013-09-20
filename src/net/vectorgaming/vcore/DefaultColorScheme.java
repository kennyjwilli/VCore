
package net.vectorgaming.vcore;

import net.vectorgaming.vcore.framework.ColorScheme;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

/**
 *
 * @author Kenny
 */
public class DefaultColorScheme implements ColorScheme
{
    @Override
    public ChatColor getPluginColor() {return ChatColor.DARK_BLUE;}

    @Override
    public ChatColor getArgumentColor() {return ChatColor.YELLOW;}

    @Override
    public ChatColor getErrorColor() {return ChatColor.RED;}

    @Override
    public String getTitleBar(String titleName) 
    {
        String solidLine = ChatColor.RED+""+ChatColor.STRIKETHROUGH+StringUtils.repeat(" ", 30);
        return solidLine+ChatColor.AQUA+" [ "+titleName+" ] "+ChatColor.RESET+solidLine;
    }

}
