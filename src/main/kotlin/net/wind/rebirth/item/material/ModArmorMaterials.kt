package net.wind.rebirth.item.material

import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.wind.rebirth.RebirthMod
import net.wind.rebirth.item.RebirthItems
import java.util.function.Supplier

enum class ModArmorMaterials(
    private val armorName: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: IntArray,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Supplier<Ingredient>
) : ArmorMaterial {
    RUBY("ruby", 30, intArrayOf(4, 9, 7, 4), 48,
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3f, 0.0f, Supplier<Ingredient> {
            Ingredient.ofItems(
                RebirthItems.RUBY
            )
        }),

    // Define your "Magic" armor material here
    MAGIC("magic", 0, intArrayOf(0, 0, 0, 0), 0,
        SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0f, 0.0f, Supplier<Ingredient> {Ingredient.ofItems(RebirthItems.RUBY)}),

    DARK_MAGIC("dark_magic", 0, intArrayOf(0, 0, 0, 0), 0,
        SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0f, 0.0f, Supplier<Ingredient> {Ingredient.ofItems(RebirthItems.RUBY)});



    override fun getDurability(type: ArmorItem.Type): Int {
        return BASE_DURABILITY[type.ordinal] * durabilityMultiplier
    }

    override fun getProtection(type: ArmorItem.Type): Int {
        return protectionAmounts[type.ordinal]
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

    override fun getName(): String {
        return RebirthMod.MOD_ID + ":" + armorName
    }

    override fun getToughness(): Float {
        return toughness
    }

    override fun getKnockbackResistance(): Float {
        return knockbackResistance
    }

    companion object {
        private val BASE_DURABILITY = intArrayOf(11, 16, 15, 13)
    }
}