
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
    
    /*
    74 characters per chat line
    */

    @Override
    public String getTitleBar(String titleName)
    {
        int titleLength = titleName.toCharArray().length;
        double hrHalfLength = (((-.67) * titleLength) + 76.67) / 2;
        double total = ((hrHalfLength * 2) + titleLength + 6);
        if(total > 74)
        {
            hrHalfLength = hrHalfLength - (total - 74) / 2;
        }
        hrHalfLength = hrHalfLength - 4;
        String solidLine = ChatColor.RED+""+ChatColor.STRIKETHROUGH+StringUtils.repeat(" ", (int) hrHalfLength);
        return solidLine+ChatColor.AQUA+" [ "+titleName+" ] "+ChatColor.RESET+solidLine;
    }
    
    /**
     * Creates a horizontal line
     * @return A horizonal line
     */
    public String createHorizotalLine()
    {
        return ChatColor.STRIKETHROUGH+StringUtils.repeat(" ", 74);
    }

}
