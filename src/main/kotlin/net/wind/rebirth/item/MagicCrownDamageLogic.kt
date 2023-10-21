package net.mcreator.rebirth.procedures

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents.AllowDamage
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource

/* imports omitted */
class DmgeevtnProcedure {
    init {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register(AllowDamage { entity: LivingEntity, damageSource: DamageSource, amount: Float ->

            true
        })
    }


}