package me.lost.main.listener;

import me.lost.main.Commands.StaffChat;
import me.lost.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    public Main plugin;

    public ChatListener(Main pl){
        this.plugin = pl;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();
        String prefix = ChatColor.translateAlternateColorCodes('&', "&9[&bStaffChat&9] &a");
        String mensage = e.getMessage();

        if(StaffChat.staff.contains(p)){

            e.setCancelled(true);
            for(Player staff : Bukkit.getServer().getOnlinePlayers()){
                if(staff.hasPermission("StaffChat.use")){
                    staff.sendMessage(prefix+staff.getDisplayName()+ChatColor.GRAY+"> "+mensage);
                }
            }
        }

    }
}
