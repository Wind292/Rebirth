package net.wind.rebirth.item.custom

import com.google.common.collect.ImmutableMap
import net.wind.rebirth.item.material.ModArmorMaterials
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.wind.rebirth.item.RebirthItems

class  MagicCrownItem(material: ArmorMaterial?, type: Type?, settings: Settings?) :
    ArmorItem(material, type, settings) {
    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {

        InventoryTickUpdates.eachTick(entity)

        if (!world.isClient()) {
            if (entity is PlayerEntity) {
                if (hasHelmOn(entity)) {
                    if (entity.experienceLevel >= 1) {
                        evaluateArmorEffects(entity)
                        if (entity.hurtTime > 0) {
                            entity.addExperience(-(entity.hurtTime))
                        }
                    }
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected)
    }

    private fun evaluateArmorEffects(player: PlayerEntity) {
        for ((mapArmorMaterial, mapStatusEffect) in MATERIAL_TO_EFFECT_MAP) {
            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                for (effect in mapStatusEffect){
                    addStatusEffectForMaterial(player, mapArmorMaterial, effect)
                }
            }
        }
    }

    private fun addStatusEffectForMaterial(
        player: PlayerEntity,
        mapArmorMaterial: ArmorMaterial,
        mapStatusEffect: StatusEffectInstance
    ) {
        if (hasCorrectArmorOn(mapArmorMaterial, player)) {
            player.addStatusEffect(StatusEffectInstance(mapStatusEffect))
        }
    }

    private fun hasHelmOn(player: PlayerEntity): Boolean {

        val helmet = player.inventory.getArmorStack(3)
        return helmet.item == RebirthItems.MAGIC_CROWN
    }

    private fun hasCorrectArmorOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        val helmet = player.inventory.getArmorStack(3).item as ArmorItem
        return helmet.material === material
    }

    companion object {
        private val MATERIAL_TO_EFFECT_MAP: Map<ArmorMaterial, List<StatusEffectInstance>> =
            ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>()
                .put(
                    ModArmorMaterials.MAGIC, listOf(
                        StatusEffectInstance(
                            StatusEffects.RESISTANCE, 15, 5,
                            false, false, false
                        )
                    )
                ).build()
    }

}

