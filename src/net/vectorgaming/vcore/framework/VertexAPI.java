
package net.vectorgaming.vcore.framework;


/**
 *
 * @author Kenny
 */
public abstract class VertexAPI 
{
    private static VertexPlugin plugin;
    public VertexAPI(VertexPlugin plugin)
    {
        this.plugin = plugin;
    }
    
    public static VertexPlugin getPlugin() {return plugin;}
}
