package www.fivepagegames.wapencheck;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import www.fivepagegames.wapencheck.commands.WapenCheck;

public class Main extends JavaPlugin {

	public static String prefix = ChatColor.WHITE + "[" + ChatColor.RED + "Wapencheck" + ChatColor.WHITE + "] ";

	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage(prefix + "De " + ChatColor.LIGHT_PURPLE + "WapenCheck " + ChatColor.WHITE + "plugin is succesvol " + ChatColor.GREEN + " aangezet!");
		getCommand("wapencheck").setExecutor(new WapenCheck());
	}

	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage(prefix + "De " + ChatColor.LIGHT_PURPLE + "WapenCheck " + ChatColor.WHITE + "plugin is succesvol " + ChatColor.RED + " uitgezet!");
	}
}
