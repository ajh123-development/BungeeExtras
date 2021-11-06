package net.ddns.minersonline.bungee_extras.spigot;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.ddns.minersonline.bungee_extras.CommonExtras;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessage implements PluginMessageListener {
    private final CommonExtras plugin;

    public PluginMessage(BungeeExtras plugin){
        this.plugin = plugin;
    }


    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord")) return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subChannel = input.readUTF();
        if(subChannel.equals("ServerIP")){
            ((BungeeExtras)this.plugin).getLogger().info(input.readUTF());
            ((BungeeExtras)this.plugin).getLogger().info(input.readUTF());
            ((BungeeExtras)this.plugin).getLogger().info(String.valueOf(input.readUnsignedShort()));
        }
    }

    public void send_server_info(Player player, String server){
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("ServerIP");
        output.writeUTF(server);
        assert plugin.getInstance() != null;
        player.sendPluginMessage((BungeeExtras)plugin.getInstance(), "BungeeCord", output.toByteArray());
    }
}

