package net.ddns.minersonline;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeExtras extends Plugin{
    @Override
    public void onEnable() {
        // You should not put an enable message in your plugin.
        // BungeeCord already does so
        getLogger().info("Yay! It loads!");
    }
}
