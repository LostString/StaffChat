package me.lost.main.Commands;

import me.lost.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class StaffChat implements CommandExecutor {

    public Main plugin;

    public StaffChat(Main pl){
        this.plugin = pl;
    }

    public static ArrayList<Player> staff = new ArrayList<Player>();

    String prefix = ChatColor.translateAlternateColorCodes('&', "&b&lSTAFF ");
    String Activado = ChatColor.translateAlternateColorCodes('&', prefix+"&aAhora estas hablando por el chat de staff");
    String Desactivado = ChatColor.translateAlternateColorCodes('&', prefix+"&cAhora estas hablando por el chat global");
    String Noperm = ChatColor.translateAlternateColorCodes('&', prefix+"&cNo tienes permisos para usar este comando");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("sc")){

            if(!(sender instanceof Player)){
                sender.sendMessage(ChatColor.RED+"Este comando es solo para los jugadores");
                return true;
            }

            Player p = (Player) sender;
            if (args.length == 0){

                if (!(p.hasPermission("StaffChat.use"))){
                    p.sendMessage(Noperm);
                    return true;
                }

                if(staff.contains(p)){
                    staff.remove(p);
                    p.sendMessage(Desactivado);
                    return true;
                }else{
                    staff.add(p);
                    p.sendMessage(Activado);
                    return true;
                }
            }
            if (args.length >= 1){
                p.sendMessage(prefix+ChatColor.RED+"Usa /sc");
                return true;
            }
        }
        return false;
    }
}
