package org.m7moud.skypvpt.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.m7moud.skypvpt.Utils.ShopUtils;

public class AxesShopCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player))
			return false;
		
		
		Player player = (Player) sender;
		Inventory inv = ShopUtils.getAxesShop(player);

		if (inv == null){
			throw new CommandException();
		}
		player.openInventory(inv);
		return false;
	}

}
