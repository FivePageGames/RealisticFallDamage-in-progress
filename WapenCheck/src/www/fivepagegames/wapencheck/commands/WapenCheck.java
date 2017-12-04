package www.fivepagegames.wapencheck.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import www.fivepagegames.wapencheck.Main;

public class WapenCheck implements CommandExecutor {

	private String prefix = Main.prefix;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("wapencheck")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(prefix + "Alleen spelers kunnen dit doen!");
				return true;
			}
			Player p = (Player) sender;
			if (!(p.hasPermission("wapencheck.check"))) {
				p.sendMessage(prefix + ChatColor.RED + "Je hebt hier geen permissies voor!");
				return true;
			}
			if (args.length <= 0) {
				for (Player targets : Bukkit.getOnlinePlayers()) {
					if (targets.getInventory().contains(Material.WOOD_SWORD)) {
						p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + targets.getDisplayName()
								+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
								+ ChatColor.BOLD.toString() + "mes!");

					}
					if (targets.getInventory().contains(Material.BOW)) {
						p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + targets.getDisplayName()
								+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
								+ ChatColor.BOLD.toString() + "gun!");
					}
					if (targets.getInventory().contains(Material.FERMENTED_SPIDER_EYE)) {
						p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + targets.getDisplayName()
								+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
								+ ChatColor.BOLD.toString() + "wapenstok!");
					}
					if (targets.getInventory().contains(Material.IRON_HOE)) {
						p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + targets.getDisplayName()
								+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
								+ ChatColor.BOLD.toString() + "tazer");
					}
					if (targets.getInventory().contains(Material.SPIDER_EYE)) {
						p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + targets.getDisplayName()
								+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
								+ ChatColor.BOLD.toString() + "knuppel!");
					}
					if (targets.getInventory().contains(Material.NETHERRACK)) {
						p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + targets.getDisplayName()
								+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
								+ ChatColor.BOLD.toString() + "bivak!");
					}
				}
				return true;

			}
			if (args[0].length() >= 0) {
				final Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					p.sendMessage(prefix + ChatColor.RED + "Die speler bestaat niet of is niet online!");
					return true;
				}
				if (target.getInventory().contains(Material.WOOD_SWORD)) {
					p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + target.getDisplayName()
							+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
							+ ChatColor.BOLD.toString() + "mes!");

				}
				if (target.getInventory().contains(Material.BOW)) {
					p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + target.getDisplayName()
							+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
							+ ChatColor.BOLD.toString() + "gun!");
				}
				if (target.getInventory().contains(Material.FERMENTED_SPIDER_EYE)) {
					p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + target.getDisplayName()
							+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
							+ ChatColor.BOLD.toString() + "wapenstok!");
				}
				if (target.getInventory().contains(Material.IRON_HOE)) {
					p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + target.getDisplayName()
							+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
							+ ChatColor.BOLD.toString() + "tazer");
				}
				if (target.getInventory().contains(Material.SPIDER_EYE)) {
					p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + target.getDisplayName()
							+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
							+ ChatColor.BOLD.toString() + "knuppel!");
				}
				if (target.getInventory().contains(Material.NETHERRACK)) {
					p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + target.getDisplayName()
							+ ChatColor.LIGHT_PURPLE + " heeft een " + ChatColor.LIGHT_PURPLE
							+ ChatColor.BOLD.toString() + "bivak!");
				} else {
					p.sendMessage(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + target.getDisplayName()
							+ ChatColor.LIGHT_PURPLE + " is helemaal clean!");
				}

			} else {
				p.sendMessage(prefix + ChatColor.RED + "USAGE: /wapencheck {PLAYER} or /wapencheck");
				return true;
			}
			return true;
		}
		return false;
	}

}