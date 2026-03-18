# Fredrick - Potential Selector (Final Version)
import traceback
from java.util import ArrayList
from net.swordie.ms.constants import ItemConstants
from net.swordie.ms.enums import InvType
from net.swordie.ms.loaders import ItemData

# ==========================================
# CONFIGURATION
# IDs derived from your itemOptionsDump.txt
# ==========================================
common_potentials = {
    # --- STR ---
    40041: "STR : +12%",       # Legendary STR
    40001: "STR : +12%",       # Alternate Legendary

    # --- DEX ---
    40042: "DEX : +12%",
    40002: "DEX : +12%",

    # --- INT ---
    40043: "INT : +12%",
    40003: "INT : +12%",

    # --- LUK ---
    40044: "LUK : +12%",
    40004: "LUK : +12%",

    # --- ALL STAT ---
    40086: "All Stats : +9%",

    # --- ATTACK / MAGIC ---
    40051: "Attack Power : +12%",
    40052: "Magic Attack : +12%",

    # --- BOSS / IED ---
    40603: "Boss Damage : +30%", # Prime Line
    40602: "Boss Damage : +30%",
    40601: "Boss Damage : +30%",
    40292: "Ignore Enemy Defense : +40%",
    40291: "Ignore Enemy Defense : +35%",

    # --- CRIT / DMG ---
    40055: "Critical Rate : +12%",
    40056: "Critical Damage : +8%",
    40070: "Damage : +12%",

    # --- MISC ---
    40658: "Item Drop Rate : +20%",
    40659: "Meso Drop Rate : +20%",
    40556: "Skill Cooldown : -1 Sec",
    40557: "Skill Cooldown : -2 Sec"
}

def log(msg):
    print("[Fredrick Script] " + str(msg))

try:
    # 1. Select Inventory
    sel = sm.sendNext("I can rewrite the potential on your items.\r\n"
                      "Which inventory is the item in?\r\n#b"
                      "#L0#Equip Inventory#l\r\n"
                      "#L1#Equipped Inventory#l")

    inv_type = InvType.EQUIP if sel == 0 else InvType.EQUIPPED
    inv = chr.getInventoryByType(inv_type)

    # 2. Select Item
    valid_items = []
    prompt = "Select the item you want to edit:\r\n#b"

    for item in inv.getItems():
        if ItemConstants.canEquipHavePotential(item):
            valid_items.append(item)
            prompt += "#L{}##i{}##z{}##l\r\n".format(item.getBagIndex(), item.getItemId(), item.getItemId())

    if not valid_items:
        sm.sendSayOkay("You don't have any editable items in that inventory.")
        sm.dispose()

    selection = sm.sendNext(prompt)
    target_item = inv.getItemBySlot(selection)

    if target_item is None:
        sm.sendSayOkay("Error finding item.")
        sm.dispose()

    # 3. Select Potential Type
    pot_type = sm.sendNext("Which potential do you want to edit?\r\n#b"
                           "#L0#Main Potential#l\r\n"
                           "#L1#Bonus Potential#l")
    is_bonus = (pot_type == 1)

    # 4. Selection Loop
    chosen_ids = []
    for line_num in range(1, 4):
        while True:
            menu = "Select an option for #rLine {}#k:\r\n\r\n".format(line_num)
            menu += "#b#L0#[Manual Input by ID]#l\r\n"

            sorted_keys = sorted(common_potentials.keys())
            for pot_id in sorted_keys:
                menu += "#L{}#{} (ID: {})#l\r\n".format(pot_id, common_potentials[pot_id], pot_id)

            selection = sm.sendNext(menu)

            final_id = 0
            if selection == 0:
                manual_val = sm.sendAskNumber("Enter the Potential ID:", 0, 0, 99999)
                if manual_val == 0: continue

                if ItemData.getItemOptionById(manual_val) is None:
                    sm.sendNext("That Potential ID does not exist in the server data.")
                    continue
                final_id = manual_val
            else:
                final_id = selection

            chosen_ids.append(final_id)
            break

    # 5. Confirmation
    confirm_msg = "Set the following stats?\r\n\r\n"
    for i in range(3):
        p_id = chosen_ids[i]
        name = common_potentials.get(p_id, "Custom ID")
        confirm_msg += "Line {}: {} ({})\r\n".format(i+1, name, p_id)

    if not sm.sendAskYesNo(confirm_msg):
        sm.dispose()

    # 6. Apply Changes
    # We copy the list, modify specific indices, and set it back.
    current_options = target_item.getOptions()
    new_options = ArrayList(current_options)

    # 0-2 for Main, 3-5 for Bonus
    start_index = 3 if is_bonus else 0

    new_options.set(start_index, chosen_ids[0])
    new_options.set(start_index + 1, chosen_ids[1])
    new_options.set(start_index + 2, chosen_ids[2])

    target_item.setOptions(new_options)

    target_item.updateToChar(chr)
    sm.sendSayOkay("Potential updated successfully!")
    sm.dispose()

except Exception as e:
    # Ignore intended script stops
    if "Intended NPE" not in str(e) and "EndScript" not in str(e):
        print("ERROR: " + traceback.format_exc())
        sm.sendSayOkay("An error occurred.")
    sm.dispose()