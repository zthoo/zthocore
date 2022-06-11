package me.ztho.zthocore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PomocCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        // 1000 Auto-generated method stub
        Player p = (Player)sender;
        p.sendMessage(ChatColor.BLUE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        p.sendMessage(ChatColor.LIGHT_PURPLE + "            Komenda Pomoc");
        p.sendMessage(ChatColor.BLUE + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        p.sendMessage("");
        p.sendMessage(ChatColor.AQUA + "Lista dostępnych komend:");
        p.sendMessage("");
        p.sendMessage(ChatColor.WHITE + "/pomoc" + ChatColor.GOLD + " - " + ChatColor.YELLOW + "Pokazuje dostępne komendy na serwerze");
        return false;
    }
}
