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
        p.sendMessage(ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        p.sendMessage(ChatColor.GOLD + "            zthoCore | Pomoc");
        p.sendMessage(ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        p.sendMessage("");
        p.sendMessage(ChatColor.AQUA + "Lista dostępnych komend:");
        p.sendMessage("");
        p.sendMessage(ChatColor.WHITE + "/pomoc" + ChatColor.GOLD + " - " + ChatColor.YELLOW + "Pokazuje dostępne komendy na serwerze");
        p.sendMessage(ChatColor.WHITE + "/vanish" + ChatColor.GOLD + " - " + ChatColor.YELLOW + "Pozwala włączyć niewidzialność (Only ADMIN)");
        p.sendMessage(ChatColor.WHITE + "/kick" + ChatColor.GOLD + " - " + ChatColor.YELLOW + "Pozwala na wyrzucenie gracza (Only ADMIN)");
        p.sendMessage(ChatColor.WHITE + "/ban" + ChatColor.GOLD + " - " + ChatColor.YELLOW + "Pozwala na zbanowanie gracza (Only ADMIN)");
        p.sendMessage(ChatColor.WHITE + "/unban" + ChatColor.GOLD + " - " + ChatColor.YELLOW + "Pozwala na odbanowanie gracza (Only ADMIN)");
        p.sendMessage(ChatColor.WHITE + "/chat" + ChatColor.GOLD + " - " + ChatColor.YELLOW + "Pozwala zarządzać chatem (Only ADMIN)");
        return false;
    }
}
