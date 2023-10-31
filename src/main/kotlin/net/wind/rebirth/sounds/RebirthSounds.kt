package net.wind.rebirth.sounds

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.wind.rebirth.RebirthMod

class RebirthSounds {
    companion object {

        val UNREAL_BOW_SHOOT: SoundEvent = registerSoundEvent("unreal_bow_shoot")

        val USE_ICE_WAND: SoundEvent = registerSoundEvent("use_ice_wand")


        fun registerSoundEvent(name: String): SoundEvent {
            val id : Identifier = Identifier(RebirthMod.MOD_ID, name)
            return Registry.register(Registries.SOUND_EVENT,id,SoundEvent.of(id))
        }
        fun registerSounds() {
            RebirthMod.logger.info("Registering sounds for ${RebirthMod.MOD_ID}")
        }
    }

}
