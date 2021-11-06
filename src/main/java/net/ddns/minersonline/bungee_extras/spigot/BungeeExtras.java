package net.ddns.minersonline.bungee_extras.spigot;
import net.ddns.minersonline.bungee_extras.CommonExtras;
import net.ddns.minersonline.bungee_extras.spigot.commands.ServerInfoCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class BungeeExtras extends JavaPlugin implements CommonExtras {
    public static BungeeExtras plugin = null;
    public PluginMessage pluginMessage = new PluginMessage(this);
    @Override
    public void onEnable() {
        BungeeExtras.plugin = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", pluginMessage);
        Objects.requireNonNull(this.getCommand("inserv")).setExecutor(new ServerInfoCommand(this));
    }

    public CommonExtras getInstance() {
        return plugin;
    }
}
