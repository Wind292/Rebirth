package net.wind.rebirth

import net.fabricmc.api.ModInitializer
import net.wind.rebirth.block.RebirthBlocks
import net.wind.rebirth.item.RebirthItemGroup
import net.wind.rebirth.item.RebirthItems
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
		RebirthBlocks.registerModOreSpawn() // lmao not like OreSpawn mod, is for generating ore
		PlayerCraftingCallback.EVENT.register { player, inventory, result ->
			// Check if the crafting result is not null and do something
			if (result != null && !result.isEmpty()) {
				// Do something when a player crafts an item
				// For example, print a message to the console
				System.out.println(
					("Player " + player.getName().getString()).toString() + " crafted: " + result.getName().getString()
				)

				// You can add your custom code here to execute when a player crafts something
				// For instance, trigger additional actions, effects, or modify the game state.
			}
		}

	}
}