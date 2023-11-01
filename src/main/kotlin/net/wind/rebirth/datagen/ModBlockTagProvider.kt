package net.wind.rebirth.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.wind.rebirth.block.RebirthBlocks
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(
    output: FabricDataOutput?,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup?>?
) : BlockTagProvider(output, registriesFuture) {

    companion object{

    }
    override fun configure(arg: RegistryWrapper.WrapperLookup?) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(RebirthBlocks.RUBY_ORE)
            .add(RebirthBlocks.DEEPSLATE_RUBY_ORE)
            .add(RebirthBlocks.RUBY_BLOCK)
            .add(RebirthBlocks.RAW_RUBY_BLOCK)

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(RebirthBlocks.RUBY_ORE)
            .add(RebirthBlocks.DEEPSLATE_RUBY_ORE)
            .add(RebirthBlocks.RUBY_BLOCK)
            .add(RebirthBlocks.RAW_RUBY_BLOCK)

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier("fabric", "needs_tool_level_4")))//Netherite tools
    }

}