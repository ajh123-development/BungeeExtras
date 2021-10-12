package net.ddns.minersonline.spigot;
import net.ddns.minersonline.CommonExtras;
import org.bukkit.plugin.java.JavaPlugin;

public class BungeeExtras extends JavaPlugin implements CommonExtras {
    private static BungeeExtras plugin = null;
    @Override
    public void onEnable() {
        BungeeExtras.plugin = this;
    }

    public static CommonExtras getInstance() {
        return BungeeExtras.plugin;
    }
}
