package org.m7moud.Axe;

import java.util.List;
import java.util.Map;

import org.bukkit.enchantments.Enchantment;

public class Axe {

    String name;
    List<String> lore;
    Map<Enchantment, Integer> enchants;

    public Axe(Map<Enchantment, Integer> enchants, List<String> lore, String name) {
        this.enchants = enchants;
        this.lore = lore;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public   void setName(String name) {
        this.name = name;
    }

    public List<String> getLore() {
        return lore;
    }

    public   void setLore(List<String> lore) {
        this.lore = lore;
    }


    public Map<Enchantment, Integer> getEnchants() {
        return enchants;
    }

    public void setEnchants(Map<Enchantment, Integer> enchants) {
        this.enchants = enchants;
    }

}
