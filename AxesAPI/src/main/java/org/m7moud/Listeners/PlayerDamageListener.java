package org.m7moud.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.m7moud.Axe.Axe;
import org.m7moud.Events.PlayerDamagePlayerWithAxeEvent;

public class PlayerDamageListener implements Listener{

    @EventHandler
    public void  onPlayerDamage(EntityDamageByEntityEvent e){

        if(!(e.getEntity() instanceof Player) || !(e.getDamager() instanceof Player)) return;

        Player damager = (Player) e.getDamager();
        Player victim = (Player) e.getEntity();

        ItemStack itemInHand = damager.getItemInHand();

        if(itemInHand.getType() != Material.DIAMOND_AXE) return;

    

        Axe axe = new Axe(itemInHand.getItemMeta().getEnchants(),
         itemInHand.getItemMeta().getLore(),
          itemInHand.getItemMeta().getDisplayName());
        
        PlayerDamagePlayerWithAxeEvent damageEvent = new PlayerDamagePlayerWithAxeEvent(axe, damager, victim);

   

        Bukkit.getServer().getPluginManager().callEvent(damageEvent);

        if(damageEvent.isCancelled()) e.setCancelled(true);
    }

}
