package org.m7moud.skypvpt.Listeners;

import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.m7moud.skypvpt.Plugin;
import static org.m7moud.skypvpt.Plugin.colorize;
import static org.m7moud.skypvpt.Plugin.getBlindnessAxe;
import static org.m7moud.skypvpt.Plugin.getPoisonAxe;
import static org.m7moud.skypvpt.Plugin.getStrengthAxe;
import static org.m7moud.skypvpt.Plugin.getWeaknessAxe;

public class PlayerDamageListener implements Listener{

	    private final int cooldown = 5; //seconds
    private final HashMap<Player, Long> playerCooldown = new HashMap<>();
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {


            Player damager = (Player) e.getDamager();

            Player victim = (Player) e.getEntity();

            if (Math.random() < 0.4) {


                damager.playSound(damager.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                damager.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));

            }

            ItemStack item = damager.getItemInHand();

            if (item.getType() != Material.DIAMOND_AXE)
                return;

            String itemName = item.getItemMeta().getDisplayName();

            long currentTime = System.currentTimeMillis();
            long lastEffectTime = playerCooldown.getOrDefault(damager, 0L);
            long timeSinceLastEffect = currentTime - lastEffectTime;

            if (itemName.equalsIgnoreCase(colorize(getBlindnessAxe().getName()))) {
                damager.playSound(victim.getLocation(), Sound.GLASS, 5.0F, 5.0F);

                if (timeSinceLastEffect < cooldown * 1000) return;

                if (Math.random() < 0.4) {
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 0));
                    playerCooldown.put(damager, currentTime);
                    damager.playEffect(victim.getLocation(), Effect.POTION_BREAK, 14);
                }

            } else if (itemName.equalsIgnoreCase(Plugin.colorize(getPoisonAxe().getName()))) {
                damager.playSound(victim.getLocation(), Sound.GLASS, 5.0F, 5.0F);

                if (timeSinceLastEffect < cooldown * 1000) return;

                if (Math.random() < 0.4) {
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
                    playerCooldown.put(damager, currentTime);
                    damager.playEffect(victim.getLocation(), Effect.POTION_BREAK, 14);

                }
            } else if (itemName.equalsIgnoreCase(Plugin.colorize(getStrengthAxe().getName()))) {
                damager.playSound(victim.getLocation(), Sound.GLASS, 5.0F, 5.0F);

                if (timeSinceLastEffect < cooldown * 1000) return;

                if (Math.random() < 0.35) {
                    damager.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 80, 1));
                    playerCooldown.put(damager, currentTime);
                    damager.playEffect(damager.getLocation(), Effect.POTION_BREAK, 14);
                }
            } else if (itemName.equalsIgnoreCase(Plugin.colorize(getWeaknessAxe().getName()))) {
                damager.playSound(victim.getLocation(), Sound.GLASS, 5.0F, 5.0F);

                if (timeSinceLastEffect < cooldown * 1000) return;

                if (Math.random() < 0.4) {
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 80, 1));
                    playerCooldown.put(damager, currentTime);
                    damager.playEffect(victim.getLocation(), Effect.POTION_BREAK, 14);
                }
            }
        }
	 	
	}
	
}

