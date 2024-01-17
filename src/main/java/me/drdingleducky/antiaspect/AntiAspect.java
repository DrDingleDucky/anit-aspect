package me.drdingleducky.antiaspect;

import org.bukkit.plugin.java.JavaPlugin;

public final class AntiAspect extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello from Anti-Aspect");
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye from Anti-Aspect");
    }
}
