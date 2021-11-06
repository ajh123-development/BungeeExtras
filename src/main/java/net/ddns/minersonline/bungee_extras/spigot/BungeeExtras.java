package net.ddns.minersonline.bungee_extras.spigot;
import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.lang.ExpressionType;
import net.ddns.minersonline.bungee_extras.CommonExtras;
import net.ddns.minersonline.bungee_extras.spigot.commands.ServerInfoCommand;
import net.ddns.minersonline.bungee_extras.spigot.skript.expressions.ExprLocationOfCitizen;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;

public class BungeeExtras extends JavaPlugin implements CommonExtras {
    public static BungeeExtras plugin = null;
    public PluginMessage pluginMessage = new PluginMessage(this);
    public SkriptAddon addon;
    @Override
    public void onEnable() {
        BungeeExtras.plugin = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", pluginMessage);

        if (this.getServer().getPluginManager().isPluginEnabled("Skript")) {
            addon = Skript.registerAddon(this);
            try {
                //This will register all our syntax for us.
                addon.loadClasses("net.ddns.minersonline.bungee_extras.spigot", "skript");
                if (this.getServer().getPluginManager().isPluginEnabled("Skript")) {
                    Skript.registerExpression(ExprLocationOfCitizen.class, Location.class, ExpressionType.SIMPLE,
                            "location of citizen %number%");
                }else {
                    this.getLogger().warning("Citizens not found, disabling Citizens support!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.getLogger().warning("Skript not found, disabling Skript support!");
        }


        Objects.requireNonNull(this.getCommand("inserv")).setExecutor(new ServerInfoCommand(this));
    }

    public CommonExtras getInstance() {
        return plugin;
    }


}
