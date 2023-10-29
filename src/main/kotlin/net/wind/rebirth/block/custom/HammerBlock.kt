package net.wind.rebirth.block.custom

import  net.wind.rebirth.RebirthMod

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


class SoundBlock(settings: Settings) : Block(settings) {
     override fun onUse(state: BlockState, world: World, pos: BlockPos,
                       player: PlayerEntity, hand: Hand, hit: BlockHitResult): ActionResult {
        world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE.value(), SoundCategory.BLOCKS, 1f, 1f)
         RebirthMod.logger.info("hello world")

         return ActionResult.SUCCESS
    }
}
