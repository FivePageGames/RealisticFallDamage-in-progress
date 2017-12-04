package www.fivepagegames.realFd.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import www.fivepagegames.realFd.main.Main;

public class Reset implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("realfdbehandel")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Main.prefix + "Alleen spelers kunnen dit command uitvoeren!");
				return true;
			} else {
				Player player = (Player) sender;
				final Player target = Bukkit.getServer().getPlayer(args[0]);
				if (!player.hasPermission("realfd.behandel")) {
					player.sendMessage(Main.prefix + "Je hebt hier geen permissies voor!");
					return true;
				} else {
					if ((args.length <= 2) || (target == null)) {
						player.sendMessage(
								Main.prefix + ChatColor.RED + "Deze speler bestaat niet, of is niet online!");
						return true;
					}
					if (target != null) {
						target.removePotionEffect(PotionEffectType.BLINDNESS);
						target.removePotionEffect(PotionEffectType.SLOW);
						target.removePotionEffect(PotionEffectType.HUNGER);
						target.sendMessage(Main.prefix + "Je bent succesvol behandeld door: " + player.getName()
								+ ", je moet zo veel mogelijk rust hebben anders kan je weer een breuk krijgen!");
						player.sendMessage(Main.prefix + "Je hebt succesvol " + target.getName() + " behandeld!");
						return true;

					}
				}
			}
		}
		return false;
	}

}
