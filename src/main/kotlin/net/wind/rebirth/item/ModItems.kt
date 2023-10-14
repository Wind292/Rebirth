package net.wind.rebirth.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod

class ModItems {

    companion object {

        val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))

        private fun addItemsToIngredientTabItemGroup(entries: FabricItemGroupEntries){
            entries.add(RUBY)
        }

        private fun registerItem(name: String, item: Item ): Item{
            return net.minecraft.registry.Registry.register(Registries.ITEM, Identifier(name), item)
        }

        fun registerModItems() {
            RebirthMod.logger.info("Registering Mod Items for " + RebirthMod.MOD_ID)

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup)
        }
    }

}