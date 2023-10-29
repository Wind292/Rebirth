package net.wind.rebirth.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.kaupenjoe.tutorialmod.item.ModArmorMaterials
import net.kaupenjoe.tutorialmod.item.ModToolMaterial
import net.kaupenjoe.tutorialmod.item.custom.ModArmorItemWithFullSetBonus
import net.minecraft.block.Block
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod

class RebirthItems {

    companion object {

        val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
        val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))

        val RUBY_HELMET = registerItem("ruby_helmet", ModArmorItemWithFullSetBonus(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, FabricItemSettings()))
        val RUBY_CHESTPLATE = registerItem("ruby_chestplate", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))
        val RUBY_LEGGINGS = registerItem("ruby_leggings", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, FabricItemSettings()))
        val RUBY_BOOTS = registerItem("ruby_boots", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, FabricItemSettings()))

        val RUBY_SWORD = registerItem("ruby_sword", SwordItem(ModToolMaterial.RUBY, 9, -4f+ 1.6f, FabricItemSettings()))
        val RUBY_LONGSWORD = registerItem("ruby_longsword", SwordItem(ModToolMaterial.RUBY, 13, -4f+.7f, FabricItemSettings()))
        val RUBY_PICKAXE = registerItem("ruby_pickaxe", PickaxeItem(ModToolMaterial.RUBY, 6, -4f+ 1.2f, FabricItemSettings()))
        val RUBY_AXE = registerItem("ruby_axe", AxeItem(ModToolMaterial.RUBY, 9.0f, -4f+ 1.15f, FabricItemSettings()))
        val RUBY_SHOVEL = registerItem("ruby_shovel", ShovelItem(ModToolMaterial.RUBY, 5.0f, -4f+ 1f, FabricItemSettings()))
        val RUBY_HOE = registerItem("ruby_hoe", HoeItem(ModToolMaterial.RUBY, 4, -4f+ .5f, FabricItemSettings()))

        private fun addItemsToIngredientTabItemGroup(entries: FabricItemGroupEntries){
            entries.add(RUBY)
            entries.add(RAW_RUBY)
        }

        private fun registerItem(name: String, item: Item ): Item{
            return net.minecraft.registry.Registry.register(Registries.ITEM, Identifier(RebirthMod.MOD_ID, name), item)
        }
    private fun registerBlock(name: String, block: Block): Block{
        return net.minecraft.registry.Registry.register(Registries.BLOCK, Identifier(RebirthMod.MOD_ID, name), block)
    }
        fun registerModItems() {
            RebirthMod.logger.info("Registering Mod Items for " + RebirthMod.MOD_ID)

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(RebirthItems::addItemsToIngredientTabItemGroup)
        }
    }



}