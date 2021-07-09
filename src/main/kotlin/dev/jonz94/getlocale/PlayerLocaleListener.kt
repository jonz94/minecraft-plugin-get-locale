package dev.jonz94.getlocale

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerLocaleChangeEvent
import java.util.*

class PlayerLocaleListener : Listener {
    private val locales = mutableMapOf<UUID, String>()

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val server = player.server
        val locale = player.locale

        locales[player.uniqueId] = player.locale

        server.consoleSender.sendMessage("Player ${player.name}(${player.uniqueId})'s locale is $locale")
        server.consoleSender.sendMessage("current locales: $locales")

    }

    @EventHandler
    fun onPlayerLocaleChange(event: PlayerLocaleChangeEvent) {
        val player = event.player
        val server = player.server

        locales[player.uniqueId] = event.locale

        server.consoleSender.sendMessage("Player ${player.name}(${player.uniqueId})'s locale is ${player.locale}, and event's locale is ${event.locale}")
        server.consoleSender.sendMessage("current locales: $locales")
    }
}
