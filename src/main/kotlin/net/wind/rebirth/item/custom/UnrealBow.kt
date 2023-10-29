import net.minecraft.entity.EntityType
import net.minecraft.entity.projectile.ArrowEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import net.wind.rebirth.item.RebirthItems

class UnrealBow(settings: Settings?) : Item(settings) {

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {

        if (user != null) {
            shootArrow(user, 7f)
            user.itemCooldownManager.set(RebirthItems.UNREAL_BOW,3)
            user.swingHand(hand)
        }

        return super.use(world, user, hand)
    }

    companion object {
        fun shootArrow(player: PlayerEntity, multiplier: Float) {

//            player.playSound()

            TODO("ADD UNREAL BOW SHOOT SOUND!!!")

            val world: World = player.entityWorld

            // Create an instance of the arrow
            val arrow: ArrowEntity = ArrowEntity(EntityType.ARROW, world)

            // Set the position of the arrow to the player's eye level
            arrow.updatePosition(player.x, player.eyeY, player.z)

            // Set the motion (velocity) of the arrow based on the player's look vector
            val pitch = player.pitch
            val yaw = player.yaw

            val x = multiplier * -Math.sin(Math.toRadians(yaw.toDouble())) * Math.cos(Math.toRadians(pitch.toDouble()))
            val y = multiplier * -Math.sin(Math.toRadians(pitch.toDouble()))
            val z = multiplier * Math.cos(Math.toRadians(yaw.toDouble())) * Math.cos(Math.toRadians(pitch.toDouble()))

            arrow.setVelocity(x, y, z)

            // Spawn the arrow in the world
            world.spawnEntity(arrow)
        }
    }
}