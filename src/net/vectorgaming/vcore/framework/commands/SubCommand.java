
package net.vectorgaming.vcore.framework.commands;

import java.util.List;
import net.vectorgaming.vcore.framework.VertexPlugin;

/**
 *
 * @author Kenny
 */
public abstract class SubCommand extends VCommand
{
     protected SubCommand(String command, VertexPlugin plugin)
    {
        super(command, plugin);
    }
    
    protected SubCommand(String command, List<String> aliases, VertexPlugin plugin)
    {
        super(command, aliases, plugin);
    }
}
