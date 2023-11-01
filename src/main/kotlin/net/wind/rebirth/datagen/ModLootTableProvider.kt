package net.wind.rebirth.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LeafEntry
import net.minecraft.loot.entry.LootPoolEntry
import net.minecraft.loot.function.ApplyBonusLootFunction.oreDrops
import net.minecraft.loot.function.ExplosionDecayLootFunction
import net.minecraft.loot.function.LootFunctionConsumingBuilder
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.wind.rebirth.block.RebirthBlocks
import net.wind.rebirth.item.RebirthItems


class ModLootTableProvider(dataOutput: FabricDataOutput?) : FabricBlockLootTableProvider(dataOutput) {
    override fun generate() {
        addDrop(RebirthBlocks.RAW_RUBY_BLOCK)
        addDrop(RebirthBlocks.RUBY_BLOCK)
        addDrop(RebirthBlocks.HAMMER_BLOCK)
        addDrop(RebirthBlocks.SOUND_BLOCK)

        addDrop(RebirthBlocks.RUBY_ORE, multipleDroppings(RebirthBlocks.RUBY_ORE, RebirthItems.RUBY, 2f, 5f))
        addDrop(RebirthBlocks.DEEPSLATE_RUBY_ORE, multipleDroppings(RebirthBlocks.DEEPSLATE_RUBY_ORE, RebirthItems.RUBY, 1f, 3f))
        addDrop(RebirthBlocks.TOMATO_PLANT, multipleDroppings(RebirthBlocks.TOMATO_PLANT, RebirthItems.TOMATO, 2f, 3f))

    }

    fun multipleDroppings(drop: Block?, item: Item?, min: Float, max: Float): LootTable.Builder {
        return dropsWithSilkTouch(
            drop, applyExplosionDecay(
                drop!!,
                (ItemEntry.builder(item)
                    .apply(
                        SetCountLootFunction
                            .builder(
                                UniformLootNumberProvider
                                    .create(min, max)
                            )
                    ) as LeafEntry.Builder<*>)
                    .apply(oreDrops(Enchantments.FORTUNE))
            ) as LootPoolEntry.Builder<*>
        )
    }
}