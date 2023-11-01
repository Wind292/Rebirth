package net.wind.rebirth

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import net.wind.rebirth.block.RebirthBlocks

class RebirthModClient : ClientModInitializer{
    override fun onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RebirthBlocks.TOMATO_PLANT, RenderLayer.getCutout())
    }
}