package www.fivepagegames.realFd.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import www.fivepagegames.realFd.main.Main;

public class Help implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("realisticfd")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)){
					sender.sendMessage(Main.prefix + "Alleen spelers kunnen dit command uitvoeren!");
					return true;
				} else {
					Player player = (Player) sender;
					player.sendMessage(Main.prefix + ">>");
					player.sendMessage(ChatColor.GRAY + "---------");
					player.sendMessage("  " + ChatColor.DARK_PURPLE + "/realisticfd help > " + ChatColor.GRAY + "Laat deze pagina zien!");
					player.sendMessage("  " + ChatColor.DARK_PURPLE + "/realisticfd check > " + ChatColor.GRAY + "Check of de damage aan staat!");
					return true;
				}
			}
			if(args[1].equalsIgnoreCase("help")) {
				Player player = (Player) sender;
				player.sendMessage(Main.prefix + ">>");
				player.sendMessage(ChatColor.GRAY + "---------");
				player.sendMessage("  " + ChatColor.DARK_PURPLE + "/realisticfd help > " + ChatColor.GRAY + "Laat deze pagina zien!");
				player.sendMessage("  " + ChatColor.DARK_PURPLE + "/realisticfd check > " + ChatColor.GRAY + "Check of de damage aan staat!");
				return true;
			}
		}
		return false;
	}

}
