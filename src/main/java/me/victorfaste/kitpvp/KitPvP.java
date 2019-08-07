package me.victorfaste.kitpvp;

import me.victorfaste.kitpvp.kits.KitStomperManager;
import me.victorfaste.kitpvp.utils.InstantSoup;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public  class KitPvP extends JavaPlugin {


    public static KitPvP instance;

    public static KitPvP getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
         PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new InstantSoup(), this);
        pluginManager.registerEvents(new KitStomperManager(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
