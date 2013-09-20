
package net.vectorgaming.vcore;

import net.vectorgaming.vcore.framework.ColorScheme;
import net.vectorgaming.vcore.framework.VertexAPI;

/**
 *
 * @author Kenny
 */
public class VCoreAPI extends VertexAPI
{    
    public VCoreAPI(VCore plugin) {super(plugin);}
    
    private static DefaultColorScheme colorScheme = new DefaultColorScheme();
    public static ColorScheme getColorScheme() {return colorScheme;}

}
