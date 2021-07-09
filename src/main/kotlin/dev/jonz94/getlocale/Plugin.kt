package dev.jonz94.getlocale

import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class Plugin : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerLocaleListener(), this)
        server.consoleSender.sendMessage("Get locale is working")
    }
}
