package org.m7moud.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.m7moud.Events.DropLockedItemEvent;

import net.md_5.bungee.api.ChatColor;


public class DropListener implements Listener{

    public HashMap<Player, List<ItemStack>> lockedItems = new HashMap<Player,List<ItemStack>>();
    

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){

        DropLockedItemEvent lockedItemEvent = new DropLockedItemEvent();


        Bukkit.getServer().getPluginManager().callEvent(lockedItemEvent);


        if(!lockedItemEvent.isCancelled())
            return;


        if(e.getItemDrop() == null) return;

        if(!e.getItemDrop().getItemStack().hasItemMeta()) return;

        if(!e.getItemDrop().getItemStack().getItemMeta().hasLore()) return;

        ItemMeta meta = e.getItemDrop().getItemStack().getItemMeta();

        if(!meta.getLore().contains(colorize(lockedItemEvent.getLockedString()))) return;

        e.setCancelled(true);
        
    }


    @EventHandler
    public void onDropAfterDeath(PlayerDeathEvent e){

        DropLockedItemEvent lockedItemEvent = new DropLockedItemEvent();


        Bukkit.getServer().getPluginManager().callEvent(lockedItemEvent);


        if(!lockedItemEvent.isCancelled()) return;

         Player  victim = e.getEntity();

         List<ItemStack> list = new ArrayList<ItemStack>();

        for(ItemStack item : victim.getInventory().getContents()){
            if(!item.hasItemMeta()) continue;

            ItemMeta meta = item.getItemMeta();

            if(!meta.hasLore()) continue;

            if(!meta.getLore().contains(colorize(lockedItemEvent.getLockedString()))) continue;

            list.add(item);          

            e.getDrops().remove(item);
        }

        lockedItems.put(victim, list);


        victim.getInventory().clear();


    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        
        if(!lockedItems.containsKey(e.getPlayer())) return;

        

        Player player = e.getPlayer();

        player.getInventory().clear();

        for(ItemStack item : lockedItems.get(player)){
            
            player.getInventory().addItem(item);

        }


    }
    private  String colorize(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
