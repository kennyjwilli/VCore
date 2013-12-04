
package net.vectorgaming.vcore.framework;

import net.vectorgaming.vcore.VCore;


/**
 *
 * @author Kenny
 */
public class VertexAPI 
{
    private static VertexPlugin plugin;
    
    public VertexAPI(VCore instance)
    {
        plugin = instance;
    }
    
    public static VertexPlugin getPlugin()
    {
        return plugin;
    }
}
