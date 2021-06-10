package nl.manthos.eventmanager.commands;

import nl.manthos.eventmanager.EventManager;
import nl.manthos.eventmanager.config.SettingsConfig;
import nl.manthos.eventmanager.panels.EventGUI;
import nl.manthos.eventmanager.util.Formatting;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EventManagerCommand implements CommandExecutor {

    private SettingsConfig settingsConfig;
    private EventManager main;
    private EventGUI eventGUI;

    public EventManagerCommand(EventManager main) {
        this.main = main;
        this.settingsConfig = main.settingsConfig;
        this.eventGUI = new EventGUI(main);
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (player.hasPermission("eventmanager.event")) {

                this.eventGUI.eventUI(player);
                return true;
            } else {
                player.sendMessage(Formatting.format(this.settingsConfig.getConfig().getString("no-permission")));
                return false;
            }
        }
        return true;
    }
}
