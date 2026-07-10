package adris.altoclef.multiversion.entity;

import adris.altoclef.multiversion.Pattern;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class PlayerVer {

    @Pattern
    public static int getSelectedSlot(PlayerInventory inventory) {
        //#if MC >= 12111
        //$$ return inventory.getSelectedSlot();
        //#else
        return inventory.selectedSlot;
        //#endif
    }

    @Pattern
    public static void setSelectedSlot(PlayerInventory inventory, int slot) {
        //#if MC >= 12111
        //$$ inventory.setSelectedSlot(slot);
        //#else
        inventory.selectedSlot = slot;
        //#endif
    }

    @Pattern
    public static DefaultedList<ItemStack> getMainStacks(PlayerInventory inventory) {
        //#if MC >= 12111
        //$$ return inventory.getMainStacks();
        //#else
        return inventory.main;
        //#endif
    }


    public static void sendChatMessage(ClientPlayerEntity player,String content) {
        //#if MC >= 11904
        player.networkHandler.sendChatMessage(content);
        //#else
        //$$ player.sendChatMessage(content);
        //#endif
    }

    public static void sendChatCommand(ClientPlayerEntity player,String content) {
        //#if MC >= 11904
        player.networkHandler.sendChatCommand(content);
        //#else
        //$$ player.sendChatMessage("/"+content);
        //#endif
    }

    @Pattern
    private static ItemStack getCursorStack(PlayerEntity player) {
        //#if MC >= 11701
        return player.currentScreenHandler.getCursorStack();
        //#else
        //$$ return player.inventory.getCursorStack();
        //#endif
    }

    @Pattern
    private static Inventory getInventory(PlayerEntity player) {
        //#if MC >= 11701
        return player.getInventory();
        //#else
        //$$ return player.inventory;
        //#endif
    }

    public static boolean inPowderedSnow(PlayerEntity player) {
        //#if MC >= 11701
        return player.inPowderSnow;
        //#else
        //$$ return false;
        //#endif
    }



}
