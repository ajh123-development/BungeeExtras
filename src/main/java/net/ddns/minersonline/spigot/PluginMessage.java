package net.ddns.minersonline.spigot;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.ddns.minersonline.CommonExtras;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessage implements PluginMessageListener {
    private CommonExtras plugin = CommonExtras.getInstance();
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord")) return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subChannel = input.readUTF();

    }

    public void server_info(Player player, String server){
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF(server);
        output.writeUTF(player.getDisplayName());
        player
    }
}

