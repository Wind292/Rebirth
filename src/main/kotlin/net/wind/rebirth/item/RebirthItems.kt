package net.wind.rebirth.item

import GroundWandItem
import IceWandItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.wind.rebirth.item.material.ModArmorMaterials
import net.wind.rebirth.item.material.ModToolMaterial
import net.kaupenjoe.tutorialmod.item.custom.ModArmorItemWithFullSetBonus
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod
import net.wind.rebirth.item.custom.DarkMagicCrownItem
import net.wind.rebirth.item.custom.MagicCrownItem


class RebirthItems {

    companion object {

        val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
        val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))

        val RUBY_HELMET = registerItem("ruby_helmet", ModArmorItemWithFullSetBonus(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, FabricItemSettings()))
        val RUBY_CHESTPLATE = registerItem("ruby_chestplate", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))
        val RUBY_LEGGINGS = registerItem("ruby_leggings", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, FabricItemSettings()))
        val RUBY_BOOTS = registerItem("ruby_boots", ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, FabricItemSettings()))

        val RUBY_SWORD = registerItem("ruby_sword", SwordItem(ModToolMaterial.RUBY, 8, -4f+ 1.6f, FabricItemSettings()))
        val RUBY_LONGSWORD = registerItem("ruby_longsword", SwordItem(ModToolMaterial.RUBY, 13, -4f+.7f, FabricItemSettings()))
        val RUBY_PICKAXE = registerItem("ruby_pickaxe", PickaxeItem(ModToolMaterial.RUBY, 6, -4f+ 1.2f, FabricItemSettings()))
        val RUBY_AXE = registerItem("ruby_axe", AxeItem(ModToolMaterial.RUBY, 10.0f, -4f+ 1.15f, FabricItemSettings()))
        val RUBY_SHOVEL = registerItem("ruby_shovel", ShovelItem(ModToolMaterial.RUBY, 5.0f, -4f+ 1f, FabricItemSettings()))
        val RUBY_HOE = registerItem("ruby_hoe", HoeItem(ModToolMaterial.RUBY, 4, -4f+ .5f, FabricItemSettings()))

        val MAGIC_CROWN = registerItem("magic_crown", MagicCrownItem(ModArmorMaterials.MAGIC, ArmorItem.Type.HELMET, FabricItemSettings()))
        val DARK_MAGIC_CROWN = registerItem("dark_magic_crown", DarkMagicCrownItem(ModArmorMaterials.DARK_MAGIC, ArmorItem.Type.HELMET, FabricItemSettings()))

        val ICE_WAND: Item = registerItem("ice_wand", IceWandItem(FabricItemSettings()))

        val GROUND_WAND: Item = registerItem("ground_wand", GroundWandItem(FabricItemSettings()))

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

            RebirthMod.logger.info("Registering Magic Crown logic for " + RebirthMod.MOD_ID)
//            MagicCrownDamageLogic.registerDamageEventListener()


        }
        fun hasItemInInventory(player: PlayerEntity, itemToCheck: Item): Boolean {
            for (itemStack in player.inventory.main) {
                if (itemStack.item === itemToCheck) {
                    return true // The item is found in the player's inventory
                }
            }
            return false // The item is not found in the player's inventory
        }

    }



}