package net.wind.rebirth.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.kaupenjoe.tutorialmod.item.ModArmorMaterials
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod

class RebirthItems {

    companion object {

        val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
        val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))

        val RUBY_HELMET = registerItem("ruby_helmet", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, FabricItemSettings()))
        val RUBY_CHESTPLATE = registerItem("ruby_chestplate", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))
        val RUBY_LEGGINGS = registerItem("ruby_leggings", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, FabricItemSettings()))
        val RUBY_BOOTS = registerItem("ruby_boots", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, FabricItemSettings()))



        private fun addItemsToIngredientTabItemGroup(entries: FabricItemGroupEntries){
            entries.add(RUBY)
            entries.add(RAW_RUBY)
        }

        private fun registerItem(name: String, item: Item ): Item{
            return net.minecraft.registry.Registry.register(Registries.ITEM, Identifier(RebirthMod.MOD_ID, name), item)
        }

        fun registerModItems() {
            RebirthMod.logger.info("Registering Mod Items for " + RebirthMod.MOD_ID)

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(RebirthItems::addItemsToIngredientTabItemGroup)
        }
    }

}