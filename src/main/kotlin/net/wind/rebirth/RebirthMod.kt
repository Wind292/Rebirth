package net.wind.rebirth

import net.fabricmc.api.ModInitializer
import net.wind.rebirth.item.RebirthItemGroup
import net.wind.rebirth.item.RebirthItems
import org.slf4j.LoggerFactory

object RebirthMod : ModInitializer {
	val MOD_ID = "rebirth"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.

		logger.info("Hello Fabric world!")

		RebirthItems.registerModItems()
		RebirthItemGroup.registerItemGroups()

	}
}