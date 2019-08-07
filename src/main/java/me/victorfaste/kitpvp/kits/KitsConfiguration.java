package me.victorfaste.kitpvp.kits;
import java.util.HashMap;
import java.util.Map;

import me.victorfaste.kitpvp.KitPvP;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KitsConfiguration  {

    //kits
    private static HashMap<String, String> cooldown;
    private static HashMap<String, String> kit;

    public static void setKit(Player player, String kit) {
        KitsConfiguration.kit.put(player.getName(), kit);
    }

    public static boolean Kit(Player player, String kit) {
        return KitsConfiguration.kit.get(player.getName()) != null && KitsConfiguration.kit.get(player.getName()).equals(kit);
    }

    public static void setCooldown(Player player, String kit, int temp) {
        KitsConfiguration.cooldown.put(player.getName(), kit);
        new BukkitRunnable() {
            @Override
            public void run() {
                KitsConfiguration.cooldown.remove(player.getName(), kit);
            }
        }.runTaskLater(KitPvP.getInstance(), 20 * temp);
    }

    public static boolean Cooldown(Player player, String kit) {
        return KitsConfiguration.cooldown.get(player.getName()) != null && KitsConfiguration.cooldown.get(player.getName()).equals(kit);
    }



   //skills
    static {
        cooldown = new HashMap<>();
        kit = new HashMap<>();
    }
    public static Map<String, String> powerMap = new HashMap();

    public static String nameKit(String Origin)
    {
        if (Origin.length() == 0) {
            return Origin;
        }
        return Origin.substring(0, 1).toUpperCase() + Origin.substring(1);
    }

    public static String getskills(Player player)
    {
        if (!powerMap.containsKey(player.getName())) {
            powerMap.put(player.getName(), "Nenhum");
        }
        return (String)powerMap.get(player.getName());
    }

    public static void setskills(Player player, String skills)
    {
        powerMap.put(player.getName(), skills);
    }

    public static void removeskills(Player player)
    {
        powerMap.remove(player.getName());
    }




}
