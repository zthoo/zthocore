package me.ztho.zthocore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class VanishCommand extends JavaPlugin implements Listener{

    public ArrayList<Player> inVanish = new ArrayList<Player>();

    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public void onDisable(){

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(cmd.getName().equalsIgnoreCase("vanish")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("INVALID SENDER");
                return true;
            }
            Player p = (Player) sender;
            if(p.hasPermission("BeastCraft3.Vanish")){

                if(inVanish.contains(p)){

                    Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();
                    for(Player player : onlinePlayers ) {
                        player.showPlayer(p);
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage("§aYou are now in visible");
                        inVanish.remove(p);
                    }

                } else {

                    Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();
                    for(Player player : onlinePlayers ) {
                        if(player.hasPermission("BeastCraft3.Vanish")){
                            player.showPlayer(p);

                        } else {
                            player.hidePlayer(p);
                            p.setAllowFlight(true);
                            p.setFlying(true);
                            p.sendMessage("§aYou are now in vanish");
                            inVanish.add(p);
                        }

                    }
                }

            } else {
                p.sendMessage("§cSorry buddy, you dont have permission to do this :)");
            }


        }
        return false;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for (Player p : inVanish) {
            e.getPlayer().hidePlayer(p);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();

        if(inVanish.contains(p)){
            e.setCancelled(true);
            p.sendMessage("§cCome on man, you cant break blocks while your in vanish.. Seriously bro?");
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();

        if(inVanish.contains(p)){
            e.setCancelled(true);
            p.sendMessage("§cCome on man, you cant place blocks while your in vanish.. Seriously bro?");
        }
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();

        if(inVanish.contains(p)){
            e.setCancelled(true);
            p.sendMessage("§cAre you really trying to drop items?");
        }

    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if ((e.getEntity() instanceof Player))
            for (Player p : inVanish) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "Bro, You cant damage people like this.");
            }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();

        if(inVanish.contains(p)){
            e.setCancelled(true);
            p.setCanPickupItems(false);
        }

    }


}