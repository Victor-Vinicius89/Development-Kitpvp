package me.victorfaste.kitpvp.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InstantSoup implements Listener {


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();
        double health = player.getHealth();

        if (action.equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getItemInHand().getType() == Material.BEETROOT_SOUP) {
                if (health < 20 && health >= 13) {
                    player.setHealth(20);
                } else if (health < 20 && health < 13) {
                    player.setHealth(health + 7.0);
                    player.getItemInHand().setType(Material.BOWL);
                }

            }

        }
    }
}
