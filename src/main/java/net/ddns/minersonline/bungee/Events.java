package net.ddns.minersonline.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public class Events implements Listener {
    BungeeExtras main;
    public Events(BungeeExtras main){
        this.main = main;
    }

    @EventHandler
    public void postLoginEvent(PostLoginEvent event){
        ProxiedPlayer player = event.getPlayer();
        main.getLogger().info(ChatColor.AQUA+"Player Joined: "+ ChatColor.GREEN+player.getDisplayName());

        if(FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
            FloodgatePlayer flood_player = FloodgateApi.getInstance().getPlayer(player.getUniqueId());
            flood_player.sendForm(SimpleForm.builder()
                    .title("Select Server")
                    .button("Survival")
                    .button("Creative")
                    .responseHandler((form,responseData)->{
                        SimpleFormResponse response = form.parseResponse(responseData);
                        if (!response.isCorrect()) {
                            return;
                        }

                        switch (response.getClickedButtonId()) {
                            case 0:
                                main.getLogger().info(ChatColor.AQUA+player.getDisplayName()+ ChatColor.GREEN+
                                        " pressed button 0");
                                break;
                            case 1:
                                main.getLogger().info(ChatColor.AQUA+player.getDisplayName()+ ChatColor.GREEN+
                                        " pressed button 1");
                                break;
                        }
                    })
            );
            return;
        }
        player.sendMessage(new TextComponent(""));
    }
}
