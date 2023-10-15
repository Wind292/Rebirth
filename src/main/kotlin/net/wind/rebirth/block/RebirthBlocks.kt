package net.wind.rebirth.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.MapColor
import net.minecraft.block.enums.Instrument
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod


class RebirthBlocks {
    companion object{
//        val RUBY_BLOCK = Blocks.register(
//            "ruby_block", Block(
//                AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).instrument(
//                    Instrument.IRON_XYLOPHONE
//                ).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)
//            )
//        )
        // You can do it like this also
        val RUBY_BLOCK = registerBlock("ruby_block", Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)))


        fun registerBlock(name: String, block: Block): Block {
            registerBlockItem(name, block);
            return Registry.register(Registries.BLOCK, Identifier(RebirthMod.MOD_ID,name), block)
        }
        fun registerBlockItem(name: String, block: Block ): Item {
            return Registry.register(Registries.ITEM, Identifier(RebirthMod.MOD_ID, name), BlockItem(block,FabricItemSettings()))
        }
        public fun registerModBlocks() {
            RebirthMod.logger.info("Registering Mod Blocks for " + RebirthMod.MOD_ID)
        }
    }
}