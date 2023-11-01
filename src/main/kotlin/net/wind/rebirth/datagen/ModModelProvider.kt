package net.wind.rebirth.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.wind.rebirth.block.RebirthBlocks
import net.wind.rebirth.item.RebirthItems

class ModModelProvider(output: FabricDataOutput?) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator?) {
        if (blockStateModelGenerator == null) {
            return
        }
        blockStateModelGenerator.registerSimpleCubeAll(RebirthBlocks.HAMMER_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(RebirthBlocks.SOUND_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(RebirthBlocks.DEEPSLATE_RUBY_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(RebirthBlocks.RUBY_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(RebirthBlocks.RUBY_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(RebirthBlocks.RAW_RUBY_BLOCK)

        blockStateModelGenerator.registerFlowerbed(RebirthBlocks.TOMATO_PLANT)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator?) {
        if (itemModelGenerator == null) {
            return
        }
        itemModelGenerator.register(RebirthItems.RUBY, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.RAW_RUBY, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.COAL_POWDER, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.COKE_COAL_POWDER, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.DARK_MAGIC_CROWN, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.MAGIC_CROWN, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.DRAGON_SCALE, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.HIGH_GRADE_BURDEN, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.HIGH_GRADE_STEEL_CHAINMAIL, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.HIGH_GRADE_STEEL_CHAINMAIL, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.HIGH_GRADE_STEEL_INGOT, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.LOW_GRADE_BURDEN, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.LOW_GRADE_STEEL_CHAINMAIL, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.LOW_GRADE_STEEL_CHAINMAIL, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.LOW_GRADE_STEEL_INGOT, Models.GENERATED)
        itemModelGenerator.register(RebirthItems.TOMATO, Models.GENERATED)










    }
}