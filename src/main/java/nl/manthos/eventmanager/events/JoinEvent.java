package nl.manthos.eventmanager.events;

import nl.manthos.eventmanager.EventManager;
import nl.manthos.eventmanager.util.Formatting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private EventManager main;

    public JoinEvent (EventManager main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin (PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.getName().equalsIgnoreCase("manthos")) {

            player.sendMessage(Formatting.format("&eHey, wat leuk! Ze gebruiken &6&lEventManager &7(" + main.getDescription().getVersion() + ")&e!"));
        }
    }
}
