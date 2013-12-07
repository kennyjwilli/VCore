
package net.vectorgaming.vcore.framework.commands;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_7_R1.CraftServer;

/**
 *
 * @author Kenny
 */
public class CommandManager 
{
    private static CommandMap commandMap;
    private static ArrayList<VCommand> commands = new ArrayList<>();
    
    static
    {
        try
        {
            final Field f = CraftServer.class.getDeclaredField("commandMap");
            f.setAccessible(true);
            commandMap = (CommandMap) f.get(Bukkit.getServer());
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex)
        {
            Logger.getLogger(CommandManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Dynamically registers a command into Bukkit. The command is not required to be added in the
     * plugin.yml
     * @param command Command to be registered
     */
    public static void registerCommand(VCommand command)
    {
        commandMap.register(command.getName(), command);
        commands.add(command);
    }
    
    /**
     * Checks to see if the given command has been registered
     * @param command Name of the command to check
     * @return TRUE if the command does exist
     */
    public static boolean commandExists(String command)
    {
        for(VCommand cmd : commands)
        {
            if(cmd.getName().equalsIgnoreCase(command))
                return true;
        }
        return false;
    }
    
    /**
     * Returns a list of commands that have been registered with the plugin
     * @return A list of commands
     */
    public static ArrayList<VCommand> getCommands() 
    {
        return commands;
    }
}
