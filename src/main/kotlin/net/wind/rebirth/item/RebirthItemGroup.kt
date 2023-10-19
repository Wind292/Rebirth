package net.wind.rebirth.item

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod
import net.wind.rebirth.block.RebirthBlocks


object RebirthItemGroup {
    val REBIRTH_GROUP: ItemGroup = FabricItemGroup.builder()
        .icon { ItemStack(RebirthItems.RUBY) }
        .displayName(Text.translatable("itemGroup.rebirth.rebirth_group"))
        .entries { _, entries ->

            entries.add(RebirthItems.RUBY)
            entries.add(RebirthItems.RAW_RUBY)
            entries.add(RebirthBlocks.RUBY_BLOCK)
            entries.add(RebirthBlocks.RAW_RUBY_BLOCK)
            entries.add(RebirthBlocks.RUBY_ORE)
            entries.add(RebirthBlocks.DEEPSLATE_RUBY_ORE)

            entries.add(RebirthItems.RUBY_HELMET)
            entries.add(RebirthItems.RUBY_CHESTPLATE)
            entries.add(RebirthItems.RUBY_LEGGINGS)
            entries.add(RebirthItems.RUBY_BOOTS)


            entries.add(RebirthItems.RUBY_SWORD)
            entries.add(RebirthItems.RUBY_LONGSWORD)
            entries.add(RebirthItems.RUBY_PICKAXE)
            entries.add(RebirthItems.RUBY_AXE)
            entries.add(RebirthItems.RUBY_SHOVEL)
            entries.add(RebirthItems.RUBY_HOE)


        }
        .build()




    fun registerItemGroups() {
        RebirthMod.logger.info("Registering Item Groups for ${RebirthMod.MOD_ID}")
        Registry.register(Registries.ITEM_GROUP, Identifier("rebirth", "rebirth_group"), REBIRTH_GROUP)
    }
}
