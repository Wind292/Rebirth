package net.kaupenjoe.tutorialmod

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.wind.rebirth.datagen.ModBlockTagProvider
import net.wind.rebirth.datagen.ModLootTableProvider
import net.wind.rebirth.datagen.ModModelProvider
import net.wind.rebirth.datagen.ModRecipeProvider
import java.util.concurrent.CompletableFuture

class TutorialModDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()
		pack.addProvider { output: FabricDataOutput?, registriesFuture: CompletableFuture<WrapperLookup?>? ->
			ModBlockTagProvider(
				output,
				registriesFuture
			)
		}

		pack.addProvider { dataOutput: FabricDataOutput? ->
			ModLootTableProvider(
				dataOutput
			)
		}
		pack.addProvider { output: FabricDataOutput? ->
			ModModelProvider(
				output
			)
		}

	}
}