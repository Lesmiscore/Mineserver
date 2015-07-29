package org.mineserver.command.defaults;

import org.mineserver.command.CommandSender;
import org.mineserver.command.Command;
import org.mineserver.ChatColor;
import org.mineserver.entity.Player;
import org.mineserver.Mineserver;

public class KickCommand extends VanillaCommand{
	public KickCommand() {
        super("kick");
        this.description = "Removes the specified player from the server";
        this.usageMessage = "/kick <player> [reason ...]";
        this.setPermission("mineserver.command.kick");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!testPermission(sender)) return true;
        if (args.length < 1 || args[0].length() == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
            return false;
        }
	  Player player = (Player) sender; //Temporary. Apprently
	  //Player player = Mineserver.getServer().getPlayer(args[1]); dont work
		
		if(player != null){
		String reason = "Kicked by someone";
		if(args.length > 1){
	    	if(reason == null){
		     	reason = "Kicked by admin";
	     	} else{
		    	reason = createString(args, 1);
	    	}
		}
		player.kick(reason);
		sender.sendMessage("Kicked " + player.getName() + ". Reason: " + reason);
		} else{
			sender.sendMessage(ChatColor.RED + "Player, '" + player.getName() + "', was not found");
		}
		return true;
		
	}
}