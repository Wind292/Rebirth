import net.minecraft.block.Blocks
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import net.wind.rebirth.block.RebirthBlocks
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class IceWandItem(settings: Settings?) : Item(settings) {
    private val executor: ScheduledExecutorService = Executors.newScheduledThreadPool(1)

    override fun use(world: World?, playerEntity: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack> {
        val Position = playerEntity.blockPos.down(1) // Set the coordinates where you want to place the block
        val BlockToReplaceWith = Blocks.BLUE_ICE.defaultState

        if (world != null) {
            val originalBlock = world.getBlockState(Position)
            world.setBlockState(Position, BlockToReplaceWith)

            executor.schedule({
                // Your task code here
                if (world.getBlockState(Position) == BlockToReplaceWith){
                    world.setBlockState(Position, originalBlock)
                }
            }, 3, TimeUnit.SECONDS)
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand))
    }
}