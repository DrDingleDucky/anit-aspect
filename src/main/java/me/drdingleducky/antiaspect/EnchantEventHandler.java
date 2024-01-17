package me.drdingleducky.antiaspect;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class EnchantEventHandler implements Listener {

    private final AntiAspect plugin;

    private int enchantmentLevel = 1;

    public EnchantEventHandler(AntiAspect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
        for (EnchantmentOffer offer : event.getOffers()) {
            if (offer != null && offer.getEnchantment().equals(Enchantment.FIRE_ASPECT)) {
                offer.setEnchantment(Enchantment.DAMAGE_ALL);
                if (event.getEnchantmentBonus() <= 4) {
                    offer.setEnchantmentLevel(1);
                    enchantmentLevel = 1;
                } else if (event.getEnchantmentBonus() <= 8) {
                    offer.setEnchantmentLevel(2);
                    enchantmentLevel = 2;
                } else if (event.getEnchantmentBonus() <= 11) {
                    offer.setEnchantmentLevel(3);
                    enchantmentLevel = 3;
                } else if (event.getEnchantmentBonus() <= 15) {
                    offer.setEnchantmentLevel(4);
                    enchantmentLevel = 4;
                }
            }
        }
    }

    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
            if (event.getItem().getEnchantments().containsKey(Enchantment.FIRE_ASPECT)) {
                event.getItem().removeEnchantment(Enchantment.FIRE_ASPECT);
                event.getItem().removeEnchantment(Enchantment.DAMAGE_ALL);
                event.getItem().addEnchantment(Enchantment.DAMAGE_ALL, enchantmentLevel);
            }
        }, 1);
    }
}
