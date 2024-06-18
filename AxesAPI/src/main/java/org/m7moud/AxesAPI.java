package org.m7moud;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.m7moud.Axe.Axe;

public class AxesAPI extends JavaPlugin {

    @Override
    public void onEnable() {

    }

   
    @Override
    public void onDisable() {
        
    }

    

    // API METHODS


    public static ItemStack createAxeItemStack(Axe axe){
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);

      

        ItemMeta meta = item.getItemMeta();

        meta.setLore(axe.getLore());

        for(Enchantment ench : axe.getEnchants().keySet()){
            meta.addEnchant(ench, meta.getEnchantLevel(ench), false);
        }

        return item;
    }   
}
