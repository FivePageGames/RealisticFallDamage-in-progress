package www.fivepagegames.realFd.events;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import www.fivepagegames.realFd.main.Main;

public class fallDamage implements Listener{ 
	
	private HashMap<UUID, Integer> damage = new HashMap<UUID, Integer>();
	
	@EventHandler
	public void playerDamage(EntityDamageEvent e){
		if(!(e.getEntity() instanceof Player)){
			return;
		}
		Entity damaged = e.getEntity();
		Player player = (Player) damaged;
		if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
			if(!damage.containsKey(damaged.getUniqueId())){
				damage.put(damaged.getUniqueId(), 1);
				player.sendMessage(Main.prefix + ChatColor.RED + "Je hebt pijn aan je been, Doe het rustig aan!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
				return;
			}
			if(damage.containsKey(damaged.getUniqueId()) && damage.get(damaged.getUniqueId()) == 1){
				damage.replace(damaged.getUniqueId(), 2);
				player.sendMessage(Main.prefix + ChatColor.RED + "Je bent voor de 2de keer gevallen, Als je zo door gaat moet je nog naar het ziekenhuis!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 400, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 1));
				return;
			}
			if(damage.containsKey(damaged.getUniqueId()) && damage.get(damaged.getUniqueId()) == 2){
				damage.replace(damaged.getUniqueId(), 3);
				player.sendMessage(Main.prefix + ChatColor.RED + "Je bent voor de 3de keer gevallen, Je moet nu echt oppassen met wat je doet!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 800, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 800, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 800, 2));
				return;
			}
			if(damage.containsKey(damaged.getUniqueId()) && damage.get(damaged.getUniqueId()) == 3){
				damage.replace(damaged.getUniqueId(), 4);
				player.sendMessage(Main.prefix + ChatColor.RED + "Je bent voor de 4de keer gevallen, Als je nog 1 keer valt, moet je naar het ziekenhuis!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1200, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 3));
				return;
			}
			if(damage.containsKey(damaged.getUniqueId()) && damage.get(damaged.getUniqueId()) == 4){
				damage.replace(damaged.getUniqueId(), 5);
				player.sendMessage(Main.prefix + ChatColor.RED + "Je hebt je benen gebroken, Je moet zo snel mogelijk afgeleverd worden naar het ziekenhuis!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1500, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1500, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30000000, 4));
				return;
			}
			if(damage.containsKey(damaged.getUniqueId()) && damage.get(damaged.getUniqueId()) >= 5){
				damage.replace(damaged.getUniqueId(), damage.get(damaged.getUniqueId()) + 1);
				player.sendMessage(Main.prefix + ChatColor.RED + "Je bent voor de " + damage.get(damaged.getUniqueId()) + "de keer gevallen, Je moet zo snel mogelijk een ziekenhuis opzoeken!!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 3000, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 2000, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30000000, 4));
				return;
			}
		}
	}

}
