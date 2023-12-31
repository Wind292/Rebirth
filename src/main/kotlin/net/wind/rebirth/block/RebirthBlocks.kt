package net.wind.rebirth.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.FlowerBlock
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod
import net.wind.rebirth.block.custom.HammerBlock

class RebirthBlocks {

    companion object{


        // You can do it like this also
        val RUBY_BLOCK = registerBlock("ruby_block", Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)))

        val RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)))

        val DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).hardness(6.0f)))
        val RUBY_ORE = registerBlock("ruby_ore", Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).hardness(4.5f)))
        val RUBY_ORE_PLACE_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier("rebirth", "ruby_ore"))

        val HAMMER_BLOCK = registerBlock("hammer_block", HammerBlock(FabricBlockSettings.copyOf(Blocks.SMITHING_TABLE)))

        val SOUND_BLOCK = registerBlock("sound_block", SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)))


        val TOMATO_PLANT = registerBlock("tomato_plant", FlowerBlock(StatusEffects.GLOWING,200,FabricBlockSettings.copyOf(Blocks.POPPY).nonOpaque().noCollision()))



        private fun registerBlock(name: String, block: Block): Block {
            registerBlockItem(name, block)
            return Registry.register(Registries.BLOCK, Identifier(RebirthMod.MOD_ID,name), block)
        }
        private fun registerBlockItem(name: String, block: Block ): Item {
            return Registry.register(Registries.ITEM, Identifier(RebirthMod.MOD_ID, name), BlockItem(block,FabricItemSettings()))
        }
        fun registerModBlocks() {
            RebirthMod.logger.info("Registering Mod Blocks for " + RebirthMod.MOD_ID)
        }
        fun registerModOreSpawn() {
//            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACE_KEY)
        }
     }
}
