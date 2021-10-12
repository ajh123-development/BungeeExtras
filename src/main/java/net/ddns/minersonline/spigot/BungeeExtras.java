package net.ddns.minersonline.spigot;
import net.ddns.minersonline.CommonExtras;
import org.bukkit.plugin.java.JavaPlugin;

public class BungeeExtras extends JavaPlugin implements CommonExtras {
    public static BungeeExtras plugin = null;
    @Override
    public void onEnable() {
        BungeeExtras.plugin = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessage());
    }

    public static CommonExtras getInstance() {
        return BungeeExtras.plugin;
    }
}
