package me.lost.main;

import me.lost.main.Commands.StaffChat;
import me.lost.main.listener.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        registerEvents();

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents() {
        getCommand("sc").setExecutor(new StaffChat(this));
    }
    public void registerCommands() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new ChatListener(this), (this));
    }
}
