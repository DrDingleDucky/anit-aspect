package me.drdingleducky.antiaspect;

import org.bukkit.plugin.java.JavaPlugin;

public final class AntiAspect extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello From Anti-Aspect!");
        EnchantEventHandler enchantEventHandler = new EnchantEventHandler(this);
        getServer().getPluginManager().registerEvents(enchantEventHandler, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye From Anti-Aspect!");
    }
}
