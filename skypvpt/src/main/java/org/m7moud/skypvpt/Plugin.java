package org.m7moud.skypvpt;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import org.m7moud.skypvpt.Axes.Axe;
import org.m7moud.skypvpt.Commands.AxesShopCommand;
import org.m7moud.skypvpt.Listeners.InventoryClickListener;
import org.m7moud.skypvpt.Listeners.PlayerDamageListener;
import org.m7moud.skypvpt.Listeners.PlayerDeath;

import net.md_5.bungee.api.ChatColor;

    

public class Plugin extends JavaPlugin {

    private  static Plugin instance;
	
    @Override
    public void onEnable() {

        instance = this;
    	
        getLogger().info("Vartics SkyPvP Util Enabled");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        
        // Listeners
        getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        
        //Commands
        getCommand("axeshop").setExecutor(new AxesShopCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Vartics SkyPvP Util Disabled");
        
    }
    public static String colorize(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    public static Plugin getInstance(){
        return instance;
    }


    public static Axe getStrengthAxe(){
        

        Axe strengthAxe = new Axe("&aStrength Axe", new Object[]{Enchantment.DURABILITY, 3}, true, 500);
        strengthAxe.setName(colorize(getInstance().getConfig().getString("strength-axe")));

        return strengthAxe;
    }
    public static Axe getPoisonAxe(){
        
        
        Axe poisonAxe = new Axe("&aPosion Axe", new Object[]{Enchantment.DURABILITY, 3}, true, 450);

        poisonAxe.setName(colorize(getInstance().getConfig().getString("posion-axe")));
        
        return poisonAxe;

    }

    public static Axe getWeaknessAxe(){
        Axe weaknessAxe = new Axe("&aWeakness Axe", new Object[]{Enchantment.DURABILITY, 3}, true, 400);
        weaknessAxe.setName(colorize(getInstance().getConfig().getString("weakness-axe")));

        
        return weaknessAxe;
    }
    public static Axe getBlindnessAxe(){
        Axe blindnessAxe = new Axe("&aBlindness Axe", new Object[]{Enchantment.DURABILITY, 3}, true, 450);
        blindnessAxe.setName(colorize(getInstance().getConfig().getString("blindness-axe")));

        return blindnessAxe;
    }
}
