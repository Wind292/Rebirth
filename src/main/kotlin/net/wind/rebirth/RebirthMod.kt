package net.wind.rebirth

import HealCommand
import net.fabricmc.api.ModInitializer
import net.wind.rebirth.block.RebirthBlocks
import net.wind.rebirth.commands.RebirthCommands
import net.wind.rebirth.item.RebirthItemGroup
import net.wind.rebirth.item.RebirthItems
import net.wind.rebirth.sounds.RebirthSounds
import org.slf4j.LoggerFactory



object RebirthMod : ModInitializer {
	val MOD_ID = "rebirth"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.


		RebirthItems.registerModItems()
		RebirthItemGroup.registerItemGroups()
		RebirthBlocks.registerModBlocks()

		RebirthBlocks.registerModOreSpawn() // lmao not like OreSpawn mod, is for generating ore\
		RebirthCommands.registerCommands()

		RebirthBlocks.registerModOreSpawn() // lmao not like OreSpawn mod, is for generating ore

		RebirthSounds.registerSounds()
	}
}