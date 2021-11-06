package net.ddns.minersonline.bungee_extras.bungee;

import net.ddns.minersonline.bungee_extras.CommonExtras;
import net.ddns.minersonline.bungee_extras.bungee.commands.GUICommand;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeExtras extends Plugin implements CommonExtras {
    public static BungeeExtras plugin = null;
    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new GUICommand(this));
        getProxy().getPluginManager().registerListener(this, new Events(this));
        plugin = this;
    }

    public CommonExtras getInstance() {
        return plugin;
    }
}
