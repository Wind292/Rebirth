package net.kaupenjoe.tutorialmod.item

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.wind.rebirth.item.RebirthItems
import java.util.function.Supplier

enum class ModToolMaterial(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredient: Supplier<Ingredient>
) :
    ToolMaterial {
    RUBY(5, 1200, 4.0f, 0f, 48,
        Supplier<Ingredient> { Ingredient.ofItems(RebirthItems.RUBY) });



    override fun getDurability(): Int {
        return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeed
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }
}
