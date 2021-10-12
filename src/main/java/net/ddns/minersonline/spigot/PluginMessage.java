package net.ddns.minersonline.spigot;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.ddns.minersonline.CommonExtras;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessage implements PluginMessageListener {
    private CommonExtras plugin = CommonExtras.getInstance();
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord")) return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subChannel = input.readUTF();
        System.out.println(subChannel);
    }

    public static void send_server_info(Player player){
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("GetServer");
        assert CommonExtras.getInstance() != null;
        player.sendPluginMessage((BungeeExtras)CommonExtras.getInstance(), "BungeeCord", output.toByteArray());
    }
}

