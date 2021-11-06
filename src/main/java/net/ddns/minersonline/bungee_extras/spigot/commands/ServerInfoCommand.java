package net.ddns.minersonline.bungee_extras.spigot.commands;

import net.ddns.minersonline.bungee_extras.CommonExtras;
import net.ddns.minersonline.bungee_extras.spigot.BungeeExtras;
import net.ddns.minersonline.bungee_extras.spigot.PluginMessage;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ServerInfoCommand implements CommandExecutor {
    private final CommonExtras plugin;

    public ServerInfoCommand(BungeeExtras plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player player){
            if(command.getName().equalsIgnoreCase("inserv")){
                if(args.length < 1){
                    commandSender.sendMessage(
                            ChatColor.RED + "You must specify a server name!"
                    );
                    return false;
                }
                ((BungeeExtras)this.plugin).getLogger().info(Arrays.toString(args));
                ((BungeeExtras)this.plugin).pluginMessage.send_server_info(player, args[1]);
            }
        }
        return true;
    }
}
