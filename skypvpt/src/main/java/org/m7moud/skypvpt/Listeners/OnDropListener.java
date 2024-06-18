package org.m7moud.skypvpt.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static org.m7moud.skypvpt.Plugin.colorize;

public class OnDropListener implements Listener{
    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if (e.getItemDrop() == null)
        return;

        ItemStack item = e.getItemDrop().getItemStack();
        
        if(!item.hasItemMeta())
            return;

        ItemMeta meta = item.getItemMeta();

        if(!meta.hasLore())
            return;

        if(meta.getLore().contains(colorize("&cLOCKED")))
            e.setCancelled(true);
    }

}
