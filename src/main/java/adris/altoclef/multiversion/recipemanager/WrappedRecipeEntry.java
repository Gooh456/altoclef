package adris.altoclef.multiversion.recipemanager;

import net.minecraft.recipe.Recipe;
//#if MC>12001
import net.minecraft.recipe.RecipeEntry;
//#endif
//#if MC>=12111
//$$ import net.minecraft.registry.RegistryKey;
//#else
import net.minecraft.util.Identifier;
//#endif

//#if MC>=12111
//$$ public record WrappedRecipeEntry(RegistryKey<Recipe<?>> id, Recipe<?> value) {
//#else
public record WrappedRecipeEntry(Identifier id, Recipe<?> value) {
//#endif

    //#if MC>12001
    public RecipeEntry<?> asRecipe() {
        return new RecipeEntry<Recipe<?>>(id, value);
    }
    //#else
    //$$ public Recipe<?> asRecipe(){
    //$$     return value;
    //$$ }
    //#endif

}
