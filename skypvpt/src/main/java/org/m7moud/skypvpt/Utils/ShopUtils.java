package org.m7moud.skypvpt.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.m7moud.skypvpt.Axes.Axe;
import static org.m7moud.skypvpt.Plugin.getBlindnessAxe;
import static org.m7moud.skypvpt.Plugin.getPoisonAxe;
import static org.m7moud.skypvpt.Plugin.getStrengthAxe;
import static org.m7moud.skypvpt.Plugin.getWeaknessAxe;

public class ShopUtils {



    public static Inventory getAxesShop(Player player){

        Inventory inv = Bukkit.createInventory(player, 27, "AXES SHOP");

        Axe weaknessAxe = getBlindnessAxe();
        Axe blindnessAxe = getWeaknessAxe();
        Axe poisonAxe = getPoisonAxe();
        Axe strengthAxe = getStrengthAxe();

        inv.setItem(10, AxesUtil.createAxe(weaknessAxe));
        inv.setItem(16, AxesUtil.createAxe(blindnessAxe));
        inv.setItem(12, AxesUtil.createAxe(poisonAxe));
        inv.setItem(14, AxesUtil.createAxe(strengthAxe));



        return inv;
    }


}
