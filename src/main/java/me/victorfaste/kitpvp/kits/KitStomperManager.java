package me.victorfaste.kitpvp.kits;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class KitStomperManager implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Player player = (Player) event.getEntity();


        if ((event.getCause() == EntityDamageEvent.DamageCause.FALL) && (KitsConfiguration.getskills(player).equalsIgnoreCase("Kit stomper"))) {

            if (event.getEntity() instanceof Player) {
                if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    for (Entity entity : player.getNearbyEntities(3, 3, 3)) {
                        Player entityPlayer = (Player) entity;
                        entityPlayer.damage(event.getDamage());
                    }
                }
                if (event.getDamage() > 4.0) {
                    player.damage(4.0);
                    event.setCancelled(true);
                }
            }

        }

    }
}
