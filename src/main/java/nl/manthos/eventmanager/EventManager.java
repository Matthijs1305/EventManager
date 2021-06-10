package nl.manthos.eventmanager;

import nl.manthos.eventmanager.commands.EventManagerCommand;
import nl.manthos.eventmanager.config.SettingsConfig;
import nl.manthos.eventmanager.events.JoinEvent;
import nl.manthos.eventmanager.panels.EventGUI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class EventManager extends JavaPlugin {

    public SettingsConfig settingsConfig;


    @Override
    public void onEnable() {
        // Plugin startup logic
        this.settingsConfig = new SettingsConfig(this);

        this.getCommand("eventmanager").setExecutor(new EventManagerCommand(this));

        registerListeners(
                new JoinEvent(this),
                new EventGUI(this)
        );
    }

    public void registerListeners(Listener... listeners) {
        Arrays.asList(listeners).forEach(listener ->
                Bukkit.getPluginManager().registerEvents(listener, this)
        );
    }
}
