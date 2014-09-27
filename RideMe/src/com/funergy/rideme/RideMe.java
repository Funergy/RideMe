/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.rideme;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Funergy
 *
 */
public class RideMe extends JavaPlugin implements Listener{
	

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		for(Player p:Bukkit.getOnlinePlayers()){
			p.setAllowFlight(false);
		}
	}
	@EventHandler
	public void playerinteractentity(PlayerInteractEntityEvent e){
		if(e.getRightClicked() instanceof Player){
		if(e.getPlayer().getItemInHand().getType() == Material.DEAD_BUSH){
			if(e.getPlayer().getPassenger() == null){
			e.getRightClicked().setPassenger(e.getPlayer());
			}else{
				e.getPlayer().sendMessage("§cYou can't ride this person.");
			}
		}
		}
	}
	
	@EventHandler
	public void leaveVehicleEven(VehicleExitEvent e){
		if(e.getExited() instanceof Player){
			Player p = (Player) e.getExited();
		}
		
	}
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(command.getName().equalsIgnoreCase("deadbush")){
			if(sender.isOp()){
			for(Player p : Bukkit.getOnlinePlayers()){
				p.getInventory().addItem(new ItemStack(Material.DEAD_BUSH,1));
			}
			}
		}
		return false;
	}
	

}
