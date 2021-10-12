package net.ddns.minersonline.spigot;
import net.ddns.minersonline.CommonExtras;
import net.ddns.minersonline.spigot.commands.ServerInfoCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class BungeeExtras extends JavaPlugin implements CommonExtras {
    public static BungeeExtras plugin = null;
    @Override
    public void onEnable() {
        BungeeExtras.plugin = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessage());
        Objects.requireNonNull(this.getCommand("inserv")).setExecutor(new ServerInfoCommand());
    }

    public static CommonExtras getInstance() {
        return BungeeExtras.plugin;
    }
}
