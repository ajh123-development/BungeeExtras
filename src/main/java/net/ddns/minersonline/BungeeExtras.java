package net.ddns.minersonline;

import net.ddns.minersonline.commands.GUICommand;
import net.md_5.bungee.api.plugin.Plugin;
import org.geysermc.floodgate.api.FloodgateApi;

public class BungeeExtras extends Plugin{
    public FloodgateApi flood_api;
    @Override
    public void onEnable() {
        flood_api = FloodgateApi.getInstance();
        getProxy().getPluginManager().registerCommand(this, new GUICommand(this));
        getProxy().getPluginManager().registerListener(this, new Events(this));
    }
}
