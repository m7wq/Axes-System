package org.m7moud.skypvpt.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import static org.m7moud.skypvpt.Plugin.colorize;

public class PlayerDeath implements Listener {

    HashMap<Player, List<ItemStack>> lockedItems = new HashMap<>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        

        Player victim = e.getEntity();

        Player killer = victim.getKiller();

        

        for(ItemStack item : victim.getInventory().getContents()){
            if(!item.hasItemMeta())
                continue;

            if(!item.getItemMeta().hasLore())
                continue;

            if(!item.getItemMeta().getLore().contains(colorize("&cLOCKED")))
                continue;

            e.getDrops().remove(item);
            
            List<ItemStack> list = new ArrayList<>();

            if (!lockedItems.containsKey(victim)) {
                lockedItems.put(victim, new ArrayList<>());
            }

            lockedItems.get(victim).add(item);
        }

        
        if(killer == null) 
        return;

        killer.playSound(killer.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);

        victim.getWorld().dropItem(victim.getLocation(), new ItemStack(Material.GOLD_INGOT, 3));

        
        

    }

    @EventHandler
    public void respawnPlayerEvent(PlayerRespawnEvent e){
        if (!lockedItems.containsKey(e.getPlayer())) 
            return;

        Player player = e.getPlayer();

        player.getInventory().clear();
        for(ItemStack item : lockedItems.get(player)){
            player.getInventory().addItem(item);
        }
        lockedItems.remove(player);
            
        
    }

}
