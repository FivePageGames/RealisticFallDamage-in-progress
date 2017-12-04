package www.fivepagegames.realFd.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import www.fivepagegames.realFd.commands.Help;
import www.fivepagegames.realFd.commands.Reset;
import www.fivepagegames.realFd.events.fallDamage;


public class Main extends JavaPlugin{
	
	public static String prefix = ChatColor.BLUE + "[" + ChatColor.WHITE + "RealFD" + ChatColor.BLUE + "] " + ChatColor.WHITE;
	
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "De plugin is " + ChatColor.GREEN + "succesvol aangezet!");
		Bukkit.getServer().getPluginManager().registerEvents(new fallDamage(), this);
		getCommand("realisticfd").setExecutor(new Help());
		getCommand("realfdbehandel").setExecutor(new Reset());
	}
	
	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "De plugin is " + ChatColor.GREEN + "succesvol " + ChatColor.RED + "uitgezet!");
		saveConfig();
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
