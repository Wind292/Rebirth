import com.mojang.brigadier.context.CommandContext
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

import net.minecraft.server.command.CommandManager.*
import javax.naming.Context

object HealCommand{
    public fun InnitHealCommand() {
        CommandRegistrationCallback.EVENT.register { dispatcher, registryAccess, environment ->
            val Healcommand = dispatcher.register(CommandManager.literal("heal")
                .executes { context: CommandContext<ServerCommandSource> ->
                    val source = context.source
                    execute(context)
                    1
                })
        }
    }


    private fun execute(context: CommandContext<ServerCommandSource>): Int {
        val player = context.source.player

        // Heal the player
        if (player != null) {

            player.health = player.maxHealth
            player.hungerManager.foodLevel = 20

            player.sendMessage(Text.literal("You have been healed!"))
        }
        return 1
    }
}