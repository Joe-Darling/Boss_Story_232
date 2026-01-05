# item/2430218.py - Storm Growth Potion

LEVEL_TO_GIVE = 1

if sm.sendAskYesNo("Would you like to gain " + str(LEVEL_TO_GIVE) + " levels?"):
    currentLevel = chr.getLevel()  # 'chr' is the Char object bound to scripts
    sm.addLevel(LEVEL_TO_GIVE)
    sm.sendSayOkay("You've been leveled up from " + str(currentLevel) + " to " + str(chr.getLevel()) + "!")
else:
    sm.sendSayOkay("Come back if you change your mind.")