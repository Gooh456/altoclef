package adris.altoclef.multiversion;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//#if MC >= 12111
//$$ // (no extra imports needed)
//#else
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
//#endif

public class ToolMaterialVer {

    public static int getMiningLevel(Item item) {
        //#if MC >= 12111
        //$$ return getMiningLevel(item.getDefaultStack());
        //#else
        if (item instanceof ToolItem tool) {
            return getMiningLevel(tool.getMaterial());
        }
        throw new IllegalStateException("Not a tool: " + item);
        //#endif
    }

    //#if MC >= 12111
    //$$ public static int getMiningLevel(ItemStack stack) {
    //$$     // The WOODEN_TOOL_MATERIALS/STONE_TOOL_MATERIALS/etc. tags are on the CRAFTING INGREDIENT
    //$$     // (e.g. #minecraft:planks), not on the tool item itself, so they can't be used here.
    //$$     // Tool tier isn't otherwise exposed as data since ToolMaterial/ToolItem were removed, so
    //$$     // derive it from the item's own registry id instead.
    //$$     String path = net.minecraft.registry.Registries.ITEM.getId(stack.getItem()).getPath();
    //$$     if (path.startsWith("wooden_") || path.startsWith("golden_")) {
    //$$         return 0;
    //$$     } else if (path.startsWith("stone_") || path.startsWith("copper_")) {
    //$$         return 1;
    //$$     } else if (path.startsWith("iron_")) {
    //$$         return 2;
    //$$     } else if (path.startsWith("diamond_")) {
    //$$         return 3;
    //$$     } else if (path.startsWith("netherite_")) {
    //$$         return 4;
    //$$     }
    //$$     throw new IllegalStateException("Unexpected value: " + stack);
    //$$ }
    //#else
    public static int getMiningLevel(ToolMaterial material) {
        if (material.equals(ToolMaterials.WOOD) || material.equals(ToolMaterials.GOLD)) {
            return 0;
        } else if (material.equals(ToolMaterials.STONE)) {
            return 1;
        } else if (material.equals(ToolMaterials.IRON)) {
            return 2;
        } else if (material.equals(ToolMaterials.DIAMOND)) {
            return 3;
        } else if (material.equals(ToolMaterials.NETHERITE)) {
            return 4;
        }
        throw new IllegalStateException("Unexpected value: " + material);
    }
    //#endif

}
