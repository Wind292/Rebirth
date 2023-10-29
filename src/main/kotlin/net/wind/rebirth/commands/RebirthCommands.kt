package net.wind.rebirth.commands

import HealCommand

class RebirthCommands {
    companion object{
        public fun registerCommands(){
            HealCommand.InnitHealCommand()
        }
    }
}