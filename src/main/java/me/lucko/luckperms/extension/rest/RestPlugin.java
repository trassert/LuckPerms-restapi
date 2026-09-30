package me.lucko.luckperms.extension.rest;

import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.java.JavaPlugin;

public class RestPlugin extends JavaPlugin {
    private RestServer server;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        LuckPerms luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        if (luckPerms == null) {
            getLogger().severe("LuckPerms is not available.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Thread thread = Thread.currentThread();
        ClassLoader previousContextClassLoader = thread.getContextClassLoader();
        thread.setContextClassLoader(RestPlugin.class.getClassLoader());
        try {
            this.server = new RestServer(luckPerms, new RestConfig(getConfig()));
        } finally {
            thread.setContextClassLoader(previousContextClassLoader);
        }
    }

    @Override
    public void onDisable() {
        if (this.server != null) {
            this.server.close();
            this.server = null;
        }
    }
}