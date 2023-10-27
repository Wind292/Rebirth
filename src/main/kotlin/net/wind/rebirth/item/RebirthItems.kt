package net.wind.rebirth.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.kaupenjoe.tutorialmod.item.ModArmorMaterials
import net.kaupenjoe.tutorialmod.item.ModToolMaterial
import net.kaupenjoe.tutorialmod.item.custom.ModArmorItemWithFullSetBonus
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod


class RebirthItems {

    companion object {

        val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
        val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))
        val E_ITEM: Item = registerItem("e", Item(FabricItemSettings()))

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

        val MAGIC_CROWN = registerItem("magic_crown", MagicCrownCreationLogic(ModArmorMaterials.MAGIC, ArmorItem.Type.HELMET, FabricItemSettings()))

        //dragonscale and steel
        val STEEL_HAMMER: Item = registerItem("steel_hammer", Item(FabricItemSettings()))

        val DRAGON_SCALE: Item = registerItem("dragon_scale", Item(FabricItemSettings()))

        val HIGH_GRADE_STEEL_INGOT: Item = registerItem("high_grade_steel_ingot", Item(FabricItemSettings()))
        val LOW_GRADE_STEEL_INGOT: Item = registerItem("low_grade_steel_ingot", Item(FabricItemSettings()))

        val COKE_COAL: Item = registerItem("coke_coal", Item(FabricItemSettings()))
        val COKE_COAL_POWDER: Item = registerItem("coke_coal_powder", Item(FabricItemSettings()))
        val COAL_POWDER: Item = registerItem("coal_powder", Item(FabricItemSettings()))

        val HIGH_GRADE_STEEL_CHAINMAIL: Item = registerItem("high_grade_steel_chainmail", Item(FabricItemSettings()))
        val LOW_GRADE_STEEL_CHAINMAIL: Item = registerItem("low_grade_steel_chainmail", Item(FabricItemSettings()))

        val HIGH_GRADE_BURDEN: Item = registerItem("high_grade_burden", Item(FabricItemSettings()))
        val LOW_GRADE_BURDEN: Item = registerItem("low_grade_burden", Item(FabricItemSettings()))





        private fun addItemsToIngredientTabItemGroup(entries: FabricItemGroupEntries){
            entries.add(RUBY)
            entries.add(RAW_RUBY)
        }

        private fun registerItem(name: String, item: Item ): Item{
            return net.minecraft.registry.Registry.register(Registries.ITEM, Identifier(RebirthMod.MOD_ID, name), item)
        }
//        private fun registerItemWithDurability(name: String, item: Item , durability: Int): Item{
//            var newItem = item // declare newItem as var
//            newItem.maxDamage = durability // set max durability
//            return net.minecraft.registry.Registry.register(Registries.ITEM, Identifier(RebirthMod.MOD_ID, name), newItem)
//        }


        fun registerModItems() {
            RebirthMod.logger.info("Registering Mod Items for " + RebirthMod.MOD_ID)
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(RebirthItems::addItemsToIngredientTabItemGroup)

            RebirthMod.logger.info("Registering Magic Crown logic for " + RebirthMod.MOD_ID)
//            MagicCrownDamageLogic.registerDamageEventListener()


        }
    }

}