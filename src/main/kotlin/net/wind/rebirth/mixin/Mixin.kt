package net.wind.rebirth.mixin

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.screen.slot.CraftingResultSlot
import net.minecraft.server.MinecraftServer
import net.wind.rebirth.RebirthMod
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(MinecraftServer::class)
class Mixin {
    @Inject(at = [At("HEAD")], method = ["loadWorld"])
    private fun init(info: CallbackInfo) {
        // This code is injected into the start of MinecraftServer.loadWorld()V
        RebirthMod.logger.info("INNIT MIXING STUF=========================================")
    }



}