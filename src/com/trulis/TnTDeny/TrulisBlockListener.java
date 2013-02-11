package com.trulis.TnTDeny;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;


public class TrulisBlockListener implements Listener{
	
	public static TnTDeny plugin;
	public static Material[] blacklist = {Material.TNT};
	

	public void onBlockPlace(BlockPlaceEvent event){
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		
		
		for(Material blocked : blacklist){
			if(blocked == block){
				if(player.isOp() || player.hasPermission("TnTDeny.allow")){}else{
					event.getBlock().setType(Material.AIR);
					player.sendMessage("You are not allowed to place " + ChatColor.DARK_RED + blocked);
				}
			}
		}
	}
	

}
