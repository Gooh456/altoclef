package adris.altoclef.util;

//#if MC>=12111
//$$ import adris.altoclef.multiversion.recipemanager.WrappedRecipeEntry;
//$$ import net.minecraft.client.network.ClientPlayerEntity;
//$$ import net.minecraft.item.Item;
//$$ import net.minecraft.recipe.Ingredient;
//$$ import net.minecraft.recipe.NetworkRecipeId;
//$$ import net.minecraft.recipe.RecipeDisplayEntry;
//$$ import net.minecraft.recipe.display.SlotDisplayContexts;
//$$
//$$ import java.util.HashSet;
//$$ import java.util.Optional;
//$$ import java.util.Set;
//#endif

/**
 * Maps a server-side recipe (used for ingredient matching) to the ephemeral
 * per-connection NetworkRecipeId the client was assigned for the equivalent
 * recipe book entry, since 1.21.11 no longer lets clickRecipe reference recipes directly.
 */
public class NetworkRecipeIdHelper {

    //#if MC>=12111
    //$$ public static Optional<NetworkRecipeId> findMatching(ClientPlayerEntity player, WrappedRecipeEntry target) {
    //$$     if (!(target.value() instanceof net.minecraft.recipe.CraftingRecipe targetRecipe)) return Optional.empty();
    //$$
    //$$     Set<Item> targetIngredientItems = toItemSet(adris.altoclef.multiversion.CraftingRecipeVer.getIngredients(targetRecipe));
    //$$     Item targetResultItem = adris.altoclef.multiversion.CraftingRecipeVer.getOutputPublic(targetRecipe).getItem();
    //$$
    //$$     for (var collection : player.getRecipeBook().getOrderedResults()) {
    //$$         for (RecipeDisplayEntry entry : collection.getAllRecipes()) {
    //$$             if (entry.craftingRequirements().isEmpty()) continue;
    //$$             Set<Item> entryIngredientItems = toItemSet(entry.craftingRequirements().get());
    //$$             if (!entryIngredientItems.equals(targetIngredientItems)) continue;
    //$$
    //$$             var resultStacks = entry.display().result().getStacks(SlotDisplayContexts.createParameters(player.getEntityWorld()));
    //$$             if (resultStacks.stream().anyMatch(stack -> stack.getItem() == targetResultItem)) {
    //$$                 return Optional.of(entry.id());
    //$$             }
    //$$         }
    //$$     }
    //$$
    //$$     return Optional.empty();
    //$$ }
    //$$
    //$$ private static Set<Item> toItemSet(java.util.List<Ingredient> ingredients) {
    //$$     Set<Item> items = new HashSet<>();
    //$$     for (Ingredient ingredient : ingredients) {
    //$$         ingredient.getMatchingItems().forEach(entry -> items.add(entry.value()));
    //$$     }
    //$$     return items;
    //$$ }
    //#endif

}
