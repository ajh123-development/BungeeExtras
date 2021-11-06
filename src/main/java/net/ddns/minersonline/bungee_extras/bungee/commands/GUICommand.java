package net.ddns.minersonline.bungee_extras.bungee.commands;

import net.ddns.minersonline.bungee_extras.bungee.BungeeExtras;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.geysermc.floodgate.api.FloodgateApi;

public class GUICommand extends Command {
    BungeeExtras main;
    public GUICommand(BungeeExtras main) {
        super("gui");
        this.main = main;
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ProxiedPlayer player){
            player.sendMessage(new TextComponent(
                    ChatColor.AQUA+"Your UUID is: "+ ChatColor.GREEN+player.getUniqueId().toString()
            ));
            String edition="Java";
            if(FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
                edition="Bedrock";
            }
            player.sendMessage(new TextComponent(
                    ChatColor.AQUA+"Your Minecraft Edition is: "+ ChatColor.GREEN+edition
            ));
        }
    }
}
