package me.ztho.zthocore;

import com.sun.tools.javac.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.lang.reflect.Field;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;


public final class ZthoCore extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        System.out.print("---------------------------------------");
        System.out.print("\n\n» Wlaczono plugin zthoCore wersji 1.0.1 | https://core.ztho.pl/ | https://github.com/zthoo/zthocore | Milej zabawy!\n");
        System.out.print("\n» Wykryto nowa wersje pluginu zthoCore - 1.0.2 | Dostepny na https://core.ztho.pl/");
        System.out.print("\n\n---------------------------------------\n\n");
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);

        // Commands
        getCommand("pomoc").setExecutor(new PomocCommand());
        getCommand("vanish").setExecutor(new VanishCommand());

        // Events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ServerMotd(), this);

        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args) {

        if(command.getName().equals("printMessageFromConfig")) {
            Player player = (Player) sender;

        }

        return false;
    }
    public class ServerMotd implements Listener {

        @EventHandler
        public void onPing(ServerListPingEvent event) {
            String motd = getConfig().getString("Motd");
            event.setMotd(motd.replace("&","§"));
        }
    }
}

