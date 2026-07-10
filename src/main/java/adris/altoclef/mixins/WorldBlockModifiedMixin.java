package adris.altoclef.mixins;

import adris.altoclef.eventbus.EventBus;
import adris.altoclef.eventbus.events.BlockPlaceEvent;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
//#if MC >= 12111
import net.minecraft.client.world.ClientWorld;
//#else
//$$ import net.minecraft.world.World;
//#endif
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//#if MC >= 12111
@Mixin(ClientWorld.class)
//#else
//$$ @Mixin(World.class)
//#endif
public class WorldBlockModifiedMixin {

    @Unique
    private static boolean hasBlock(BlockState state, BlockPos pos) {
        return !state.isAir() && state.isSolidBlock(MinecraftClient.getInstance().world, pos);
    }

    //#if MC >= 12111
    @Inject(
            method = "updateListeners",
            at = @At("HEAD")
    )
    public void onBlockWasChanged(BlockPos pos, BlockState oldBlock, BlockState newBlock, int flags, CallbackInfo ci) {
        if (!hasBlock(oldBlock, pos) && hasBlock(newBlock, pos)) {
            BlockPlaceEvent evt = new BlockPlaceEvent(pos, newBlock);
            EventBus.publish(evt);
        }
    }
    //#else
    //$$ @Inject(
    //$$         method = "onBlockChanged",
    //$$         at = @At("HEAD")
    //$$ )
    //$$ public void onBlockWasChanged(BlockPos pos, BlockState oldBlock, BlockState newBlock, CallbackInfo ci) {
    //$$     if (!hasBlock(oldBlock, pos) && hasBlock(newBlock, pos)) {
    //$$         BlockPlaceEvent evt = new BlockPlaceEvent(pos, newBlock);
    //$$         EventBus.publish(evt);
    //$$     }
    //$$ }
    //#endif

}
