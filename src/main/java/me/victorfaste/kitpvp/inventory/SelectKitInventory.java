package me.victorfaste.kitpvp.inventory;

import me.victorfaste.kitpvp.KitPvP;
import me.victorfaste.kitpvp.kits.KitsConfiguration;
import me.victorfaste.kitpvp.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

public class SelectKitInventory implements Listener {

    private Inventory inventory;

    public SelectKitInventory() {
        KitPvP kitPvPInstance = KitPvP.getInstance();

        PluginManager pluginManager = kitPvPInstance.getServer().getPluginManager();
        pluginManager.registerEvents(this, kitPvPInstance);

        this.build();
    }

    private void build() {
        Inventory inventory = Bukkit.createInventory(null, 6 * 9, "Seletor de kits");
        ItemStack velocityKit = new ItemBuilder(Material.POTION)
                .name("Kit velocity")
                .lore("§6Ao pegar esse kit você recebe efeito de velocidade infinita!")
                .durability(16)
                .build();
        ItemStack stomperKit = new ItemBuilder(Material.DIAMOND_BOOTS)
                .name("Kit stomper")
                .lore("§6Ao pegar esse kit você pode cair em cima dos seus inimigos e irá dar um dano")
                .build();
        ItemStack pvpKit = new ItemBuilder(Material.IRON_CHESTPLATE)
                .name("Kit pvp")
                .lore("§6Clique para pegar o kit e ir batalhar com uma proteção melhor")
                .build();
        inventory.setItem(14, velocityKit);
        inventory.setItem(18, stomperKit);
        inventory.setItem(20, pvpKit);

    }

    public Inventory getInventory() {
        return inventory;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getClickedBlock().getType() == Material.CHEST) {
                    event.setCancelled(true);
                    player.openInventory(inventory);
                }

            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();

        if (inventory.getTitle().equalsIgnoreCase("Seletor de kits")) {
            ItemStack currentItem = event.getCurrentItem();

            if (currentItem != null && currentItem.getType() != Material.AIR) {
                event.setCancelled(true);

                if (currentItem.getItemMeta().getDisplayName().equalsIgnoreCase("Kit stomper")) {
                    player.sendMessage("§cVocê pegou o kit stomper.");
                    player.getInventory().clear();
                    player.setAllowFlight(false);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.getInventory().setArmorContents(null);
                    KitsConfiguration.removeskills(player);
                    KitsConfiguration.setskills(player, "Kit stomper");
                    player.closeInventory();

                }
            }
        }


    }
}
