package org.m7moud.skypvpt.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.m7moud.skypvpt.Plugin;
import org.m7moud.skypvpt.Axes.*;
import static org.m7moud.skypvpt.Plugin.colorize;

public class AxesUtil {
	
	public static ItemStack createAxe(Axe axe) {
		ItemStack item = new ItemStack(Material.DIAMOND_AXE);
		
		ItemMeta meta = item.getItemMeta();

		Object[] arr = axe.getEnchAndLevel();

		Enchantment ench = (Enchantment) arr[0];
		int enchLevel = (Integer) arr[1];
		
		meta.setDisplayName(colorize(axe.getName()));
		
		meta.addEnchant(ench, enchLevel, false);
		
		Boolean isForShop = axe.getInShop();
		Integer cost = axe.getCost();
		
		
		List<String> lore = new ArrayList();
		
		if(isForShop) {
			
			List<String> loreNotLocked = Plugin.getInstance().getConfig().getStringList("lore.not-locked");

			
			for(String string : loreNotLocked) {
				if(string.contains("%cost%")) {
					string = string.replace("%cost%", String.valueOf(cost));
					lore.add(colorize(string));
					continue;
				}
				lore.add(colorize(string));
			}

			
		}else {
			

			List<String> lockedLoreList = Plugin.getInstance().getConfig().getStringList("lore.locked");

			for(String s : lockedLoreList) {
				lore.add(colorize(s));
			}
		}
		
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		return item;
	}

}
