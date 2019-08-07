package me.victorfaste.kitpvp.utils;


import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @class 6 - (Entidades + HologramBuilder OO)
 * <p>
 * new HologramBuilder(Location location)
 * .title(String title = "TESTE")
 * .show();
 */
public class HologramBuilder {

    private Location location;
    private String title;

    private Map<String, Object> armorStandConfigurations;

    private ArmorStand armorStand;

    // Iniciando a variavel
    public HologramBuilder(Location location) {
        this.location = location.clone().subtract(0, 0.7, 0);
        // Pesquisar sobre:
        // - HashMap
        // - LinkedHashMap
        // - WeakHashMap
        this.armorStandConfigurations = new WeakHashMap<>();
    }

    // Definindo o valor da variavel (title)
    public HologramBuilder title(String title) {
        this.title = title;

        return this;
    }

    public HologramBuilder head(ItemStack headItemStack) {
        this.armorStandConfigurations.put("HEAD", headItemStack);

        return this;
    }

    // Definindo/spawnando o armor_stand e configurando-o
    public void show() {
        this.armorStand = (ArmorStand) location.getWorld()
                .spawnEntity(location, EntityType.ARMOR_STAND);

        this.armorStand.setVisible(false);
        this.armorStand.setGravity(false);
        this.armorStand.setCustomNameVisible(true);
        this.armorStand.setCustomName(this.title);

        if (this.armorStandConfigurations.containsKey("HEAD"))
            this.armorStand.setHelmet((ItemStack) this.armorStandConfigurations.get("HEAD"));
    }
}
