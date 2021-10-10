package net.ddns.minersonline;

import net.ddns.minersonline.commands.GUICommand;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeExtras extends Plugin{
    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new GUICommand(this));
        getProxy().getPluginManager().registerListener(this, new Events(this));
    }
}
