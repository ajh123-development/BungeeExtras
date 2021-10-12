package net.ddns.minersonline.spigot.commands;

import net.ddns.minersonline.spigot.PluginMessage;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player player){
            if(command.getName().equalsIgnoreCase("inserv")){
                if(args.length <= 1){
                    commandSender.sendMessage(
                            ChatColor.RED + "You must specify a server name!"
                    );
                    return false;
                }
                PluginMessage.send_server_info(player);
            }
        }
        return true;
    }
}
