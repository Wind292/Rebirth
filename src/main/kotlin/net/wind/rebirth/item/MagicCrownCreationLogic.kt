package net.wind.rebirth.item

import com.google.common.collect.ImmutableMap
import net.kaupenjoe.tutorialmod.item.ModArmorMaterials
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class MagicCrownCreationLogic(material: ArmorMaterial?, type: Type?, settings: Settings?) :
    ArmorItem(material, type, settings) {
    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if (!world.isClient()) {
            if (entity is PlayerEntity && hasHelmOn(entity)) {
                if (entity.experienceLevel >= 1){
                    evaluateArmorEffects(entity)
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
        val hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.effectType)
        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(StatusEffectInstance(mapStatusEffect))
        }
    }

    private fun hasHelmOn(player: PlayerEntity): Boolean {

        val helmet = player.inventory.getArmorStack(3)
        return !helmet.isEmpty
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
