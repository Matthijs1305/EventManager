package nl.manthos.eventmanager.config;

import nl.manthos.eventmanager.EventManager;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SettingsConfig {

    private EventManager main;
    private String fileName = "settings.yml";
    private File file;
    private YamlConfiguration config;

    public SettingsConfig(EventManager main) {

        file = new File(main.getDataFolder(), fileName);
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.config = new YamlConfiguration().loadConfiguration(file);
        this.setup();
        this.save();
    }

    public YamlConfiguration getConfig() {
        return this.config;
    }

    private void setup() {
        config.options().copyDefaults(true);
        config.addDefault("no-permission", "&6&lEvent&e&lManager &7- You don't have the permission to use this command!");
        config.addDefault("gui.title", "&6&lSelect Event");
        config.addDefault("gui.size", 36);
        config.addDefault("itemstacks.close.enabled", true);
        config.addDefault("itemstacks.close.slot", 35);
        config.addDefault("itemstacks.close.name", "&c&lClose");
        config.addDefault("itemstacks.close.glow", true);
        config.addDefault("itemstacks.event-1.enabled", true);
        config.addDefault("itemstacks.event-1.slot", 10);
        config.addDefault("itemstacks.event-1.name", "&6&lEvent 1");
        config.addDefault("itemstacks.event-1.glow", true);
        config.addDefault("itemstacks.event-2.enabled", true);
        config.addDefault("itemstacks.event-2.slot", 12);
        config.addDefault("itemstacks.event-2.name", "&d&lEvent 2");
        config.addDefault("itemstacks.event-2.glow", true);
        config.addDefault("itemstacks.event-3.enabled", true);
        config.addDefault("itemstacks.event-3.slot", 14);
        config.addDefault("itemstacks.event-3.name", "&a&lEvent 3");
        config.addDefault("itemstacks.event-3.glow", true);
        config.addDefault("itemstacks.event-4.enabled", true);
        config.addDefault("itemstacks.event-4.slot", 16);
        config.addDefault("itemstacks.event-4.name", "&b&lEvent 4");
        config.addDefault("itemstacks.event-4.glow", true);
        this.save();
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
