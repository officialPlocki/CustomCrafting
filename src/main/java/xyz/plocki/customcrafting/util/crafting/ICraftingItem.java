package xyz.plocki.customcrafting.util.crafting;

import org.bukkit.inventory.ItemStack;

public interface ICraftingItem {

    ItemStack getItem();

    String getNameSpacedKey();

    CraftCategory getItemCategory();

    ICraftingRecipe getRecipe();

    Integer getMinLevel();

}
