package adris.altoclef.multiversion;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;

import java.util.List;

public class CraftingRecipeVer {


    @Pattern
    private static ItemStack getOutput(CraftingRecipe craftingRecipe) {
        //#if MC >= 12111
        //$$ return craftingRecipe.getDisplays().isEmpty() ? ItemStack.EMPTY
        //$$         : craftingRecipe.getDisplays().get(0).result().getFirst(net.minecraft.recipe.display.SlotDisplayContexts.createParameters(MinecraftClient.getInstance().world));
        //#elseif MC >= 11904
        return craftingRecipe.getResult(null);
        //#else
        //$$ return craftingRecipe.getOutput();
        //#endif
    }

    public static ItemStack getOutputPublic(CraftingRecipe craftingRecipe) {
        return getOutput(craftingRecipe);
    }

    public static List<Ingredient> getIngredients(CraftingRecipe craftingRecipe) {
        //#if MC >= 12111
        //$$ return craftingRecipe.getIngredientPlacement().getIngredients();
        //#else
        return craftingRecipe.getIngredients();
        //#endif
    }

}
