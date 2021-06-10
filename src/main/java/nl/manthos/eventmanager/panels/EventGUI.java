package nl.manthos.eventmanager.panels;

import nl.manthos.eventmanager.EventManager;
import nl.manthos.eventmanager.config.SettingsConfig;
import nl.manthos.eventmanager.util.Formatting;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventGUI implements Listener {

    private EventManager main;
    private SettingsConfig settingsConfig;

    public EventGUI(EventManager main) {
        this.main = main;
        this.settingsConfig = main.settingsConfig;
    }

    public void eventUI(Player player) {

        //START
        Inventory inv = Bukkit.createInventory(null, settingsConfig.getConfig().getInt("gui.size"), Formatting.format(settingsConfig.getConfig().getString("gui.title")));

        //SET ITEMS
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.close.enabled")) {
            inv.setItem(this.settingsConfig.getConfig().getInt("itemstacks.close.slot"), closeButton());
        }
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-1.enabled")) {
            inv.setItem(this.settingsConfig.getConfig().getInt("itemstacks.event-1.slot"), event1());
        }
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-2.enabled")) {
            inv.setItem(this.settingsConfig.getConfig().getInt("itemstacks.event-2.slot"), event2());
        }
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-3.enabled")) {
            inv.setItem(this.settingsConfig.getConfig().getInt("itemstacks.event-3.slot"), event3());
        }
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-4.enabled")) {
            inv.setItem(this.settingsConfig.getConfig().getInt("itemstacks.event-4.slot"), event4());
        }

        //FINISH
        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        if (!(e.getWhoClicked() instanceof Player)) return;
        if (e.getRawSlot() == -999) return;
        if (e.getCurrentItem() == null) return;
        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
        String currentName = current.getItemMeta().getDisplayName();

        if (currentName.equals(closeButton().getItemMeta().getDisplayName())) {

            player.closeInventory();
        }
    }

    private ItemStack closeButton() {
        ItemStack is = new ItemStack(Material.BARRIER);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(Formatting.format(settingsConfig.getConfig().getString("itemstacks.close.name")));
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.close.glow")) {
            im.addEnchant(Enchantment.LUCK, 1, false);
        }
        is.setItemMeta(im);
        return is;
    }

    private ItemStack event1() {
        ItemStack is = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(Formatting.format(settingsConfig.getConfig().getString("itemstacks.event-1.name")));
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-1.glow")) {
            im.addEnchant(Enchantment.LUCK, 1, false);
        }
        is.setItemMeta(im);
        return is;
    }

    private ItemStack event2() {
        ItemStack is = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(Formatting.format(settingsConfig.getConfig().getString("itemstacks.event-2.name")));
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-2.glow")) {
            im.addEnchant(Enchantment.LUCK, 1, false);
        }
        is.setItemMeta(im);
        return is;
    }

    private ItemStack event3() {
        ItemStack is = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(Formatting.format(settingsConfig.getConfig().getString("itemstacks.event-3.name")));
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-3.glow")) {
            im.addEnchant(Enchantment.LUCK, 1, false);
        }
        is.setItemMeta(im);
        return is;
    }

    private ItemStack event4() {
        ItemStack is = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(Formatting.format(settingsConfig.getConfig().getString("itemstacks.event-4.name")));
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        if (this.settingsConfig.getConfig().getBoolean("itemstacks.event-4.glow")) {
            im.addEnchant(Enchantment.LUCK, 1, false);
        }
        is.setItemMeta(im);
        return is;
    }
}
