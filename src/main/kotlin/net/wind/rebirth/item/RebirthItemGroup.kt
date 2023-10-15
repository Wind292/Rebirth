package net.wind.rebirth.item

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod


object RebirthItemGroup {
    val REBIRTH_GROUP: ItemGroup = FabricItemGroup.builder()
        .icon { ItemStack(RebirthItems.RUBY) }
        .displayName(Text.translatable("itemGroup.rebirth.rebirth_group"))
        .entries { _, entries ->

            entries.add(RebirthItems.RUBY)
            entries.add(RebirthItems.RAW_RUBY)

        }
        .build()




    fun registerItemGroups() {
        RebirthMod.logger.info("Registering Item Groups for ${RebirthMod.MOD_ID}")
        Registry.register(Registries.ITEM_GROUP, Identifier("rebirth", "rebirth_group"), REBIRTH_GROUP)
    }
}
