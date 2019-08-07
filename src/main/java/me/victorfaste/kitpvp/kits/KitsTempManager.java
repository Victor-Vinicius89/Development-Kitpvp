package me.victorfaste.kitpvp.kits;
import java.util.HashMap;

import me.victorfaste.kitpvp.KitPvP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KitsTempManager {


    public static HashMap<Player, Long> run = new HashMap();

    public static void add(final Player player, int seconds)
    {
        long cooldownLength = System.currentTimeMillis() + seconds * 1000;

        run.remove(player);
        run.put(player, cooldownLength);
        Bukkit.getScheduler().scheduleSyncDelayedTask(KitPvP.getInstance(),   new Runnable()
        {
            public void run()
            {
                run.remove(player);
            }
        }, seconds * 20);
    }

    public static long temp(Player player)
    {
        long cooldownLength = (Long) run.get(player);
        long left = (cooldownLength - System.currentTimeMillis()) / 1000L;
        return left;
    }

    public static boolean addTemp(Player player)
    {
        return run.containsKey(player);
    }

    public static void removeTemp(Player player)
    {
        run.remove(player);
    }
}
