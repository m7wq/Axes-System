package org.m7moud.skypvpt.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.m7moud.skypvpt.Axes.Axe;
import org.m7moud.skypvpt.Plugin;
import static org.m7moud.skypvpt.Plugin.getBlindnessAxe;
import static org.m7moud.skypvpt.Plugin.getPoisonAxe;
import static org.m7moud.skypvpt.Plugin.getStrengthAxe;
import static org.m7moud.skypvpt.Plugin.getWeaknessAxe;
import org.m7moud.skypvpt.Utils.AxesUtil;

public class InventoryClickListener implements Listener{
	
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		
		
		
		if(!e.getClickedInventory().getTitle().equalsIgnoreCase("AXES SHOP"))
			return;
		
		String noGoldMessage = Plugin.getInstance().getConfig().getString("no-enough-gold-message")
				.replace("%prefix%", Plugin.getInstance().getConfig().getString("prefix"));
		String successPurchase = Plugin.getInstance().getConfig().getString("successfully-purchased")
				.replace("%prefix%", Plugin.getInstance().getConfig().getString("prefix"));
		
		Player player = (Player) e.getWhoClicked();
		
		switch(e.getSlot()) {
			case 10:
				if(!player.getInventory().contains(Material.GOLD_INGOT, Plugin.getWeaknessAxe().getCost())) {
					player.sendMessage(Plugin.colorize(noGoldMessage));
					
				}else {
					player.sendMessage(Plugin.colorize(successPurchase.replace("%item_name%",
							Plugin.getWeaknessAxe().getName())));

					Axe weaknessAxe = getWeaknessAxe();
					weaknessAxe.setInShop(false);
					player.getInventory().addItem(AxesUtil.createAxe(weaknessAxe));
					player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, Plugin.getWeaknessAxe().getCost()));
				}
				break;
			case 16:
				if(!player.getInventory().contains(Material.GOLD_INGOT, Plugin.getBlindnessAxe().getCost())) {
					player.sendMessage(Plugin.colorize(noGoldMessage));
					
				}else {
					player.sendMessage(Plugin.colorize(successPurchase.replace("%item_name%", Plugin.getBlindnessAxe().getName())));
					Axe blindnessAxe = getBlindnessAxe();
					blindnessAxe.setInShop(false);
					player.getInventory().addItem(AxesUtil.createAxe(blindnessAxe));
					player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, Plugin.getBlindnessAxe().getCost()));

				}
				break;
			case 12:
				if(!player.getInventory().contains(Material.GOLD_INGOT, Plugin.getPoisonAxe().getCost())) {
					player.sendMessage(Plugin.colorize(noGoldMessage));
					
				}else {
					player.sendMessage(Plugin.colorize(successPurchase.replace("%item_name%", Plugin.getPoisonAxe().getName())));
					Axe posionAxe = getPoisonAxe();
					posionAxe.setInShop(false);
					
					player.getInventory().addItem(AxesUtil.createAxe(posionAxe));
					player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, Plugin.getPoisonAxe().getCost()));

				}
				break;
			case 14:
				if(!player.getInventory().contains(Material.GOLD_INGOT, Plugin.getStrengthAxe().getCost())) {
					player.sendMessage(Plugin.colorize(noGoldMessage));
				}else {
					player.sendMessage(Plugin.colorize(successPurchase.replace("%item_name%", Plugin.getStrengthAxe().getName())));
					Axe strengthAxe = getStrengthAxe();
					strengthAxe.setInShop(false);
					player.getInventory().addItem(AxesUtil.createAxe(strengthAxe));
					player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, Plugin.getStrengthAxe().getCost()));

				}
			
		}
	}


}
