import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.wind.rebirth.RebirthMod
import net.wind.rebirth.block.RebirthBlocks
import net.wind.rebirth.commands.RebirthCommands
import net.wind.rebirth.item.custom.InventoryTickUpdates
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImplKt
import net.minecraft.util.math.MathHelper
class GroundWandItem(settings: Settings?) : Item(settings) {
    private val executor: ScheduledExecutorService = Executors.newScheduledThreadPool(1)
    override fun use(world: World?, playerEntity: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack> {
        val Position = playerEntity.blockPos // Set the coordinates where you want to place the block
        val BlockToReplaceWith = Blocks.MOSSY_COBBLESTONE.defaultState
        var BlockArray = emptyArray<BlockPos>()
        val dir = getCardinalDirection(playerEntity)


        RebirthMod.logger.info(playerEntity.yaw.toString())

        // -75 - 45 north


        if (world != null) {
            if (dir == "North") {
                BlockArray += Position.north(2).up(1)
                BlockArray += Position.down(1).north(2).up(1)
                BlockArray += Position.up(1).north(2).up(1)
                BlockArray += Position.east(1).north(2).up(1)
                BlockArray += Position.west(1).north(2).up(1)
                BlockArray += Position.west(1).up(1).north(2).up(1)
                BlockArray += Position.west(1).down(1).north(2).up(1)
                BlockArray += Position.east(1).up(1).north(2).up(1)
                BlockArray += Position.east(1).down(1).north(2).up(1)
            }
            if (dir == "South") {
                BlockArray += Position.south(2).up(1)
                BlockArray += Position.down(1).south(2).up(1)
                BlockArray += Position.up(1).south(2).up(1)
                BlockArray += Position.east(1).south(2).up(1)
                BlockArray += Position.west(1).south(2).up(1)
                BlockArray += Position.west(1).up(1).south(2).up(1)
                BlockArray += Position.west(1).down(1).south(2).up(1)
                BlockArray += Position.east(1).up(1).south(2).up(1)
                BlockArray += Position.east(1).down(1).south(2).up(1)

            }
            if (dir == "East") {
                BlockArray += Position.up().east(2).north()
                BlockArray += Position.up().east(2).north().up(1)
                BlockArray += Position.up().east(2).north().down(1)
                BlockArray += Position.up().east(2).south()
                BlockArray += Position.up().east(2).south().up(1)
                BlockArray += Position.up().east(2).south().down(1)
                BlockArray += Position.up().east(2).up()
                BlockArray += Position.up().east(2).down()
                BlockArray += Position.up().east(2)

            }
            if (dir == "West") {
                BlockArray += Position.up().east(-2).north()
                BlockArray += Position.up().east(-2).north().up(1)
                BlockArray += Position.up().east(-2).north().down(1)
                BlockArray += Position.up().east(-2).south()
                BlockArray += Position.up().east(-2).south().up(1)
                BlockArray += Position.up().east(-2).south().down(1)
                BlockArray += Position.up().east(-2).up()
                BlockArray += Position.up().east(-2).down()
                BlockArray += Position.up().east(-2)

            }
            for (blockpos in BlockArray) {
                world.setBlockState(blockpos,BlockToReplaceWith)
            }

            executor.schedule({
                // Your task code here
                for (BlockPos in BlockArray){
                    if (world.getBlockState(BlockPos) == BlockToReplaceWith){
                        world.setBlockState(BlockPos, Blocks.AIR.defaultState)
                    }
                }

            }, 10, TimeUnit.SECONDS)


        }


        return TypedActionResult.success(playerEntity.getStackInHand(hand))
    }
    fun getCardinalDirection(player: PlayerEntity): String {
        val yaw = player.yaw
        val index = MathHelper.floor(yaw * 4.0 / 360.0 + 0.5) and 3
        val directions = arrayOf("South", "West", "North", "East")
        return directions[index]
    }
}