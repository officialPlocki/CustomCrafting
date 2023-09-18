package xyz.plocki.customcrafting.util.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import xyz.plocki.customcrafting.CustomCrafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CraftingManager {

    public static Map<String, ICraftingItem> items;
    public static Map<String, ICraftingItem> itemList;

    public ICraftingRecipe buildRecipe(ItemStack a, ItemStack b, ItemStack c, ItemStack d, ItemStack e, ItemStack f, ItemStack g, ItemStack h, ItemStack i) {
        return new ICraftingRecipe() {
            @Override
            public ItemStack get1st() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return a;
            }

            @Override
            public ItemStack get2nd() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return b;
            }

            @Override
            public ItemStack get3rd() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return c;
            }

            @Override
            public ItemStack get4th() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return d;
            }

            @Override
            public ItemStack get5th() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return e;
            }

            @Override
            public ItemStack get6th() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return f;
            }

            @Override
            public ItemStack get7th() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return g;
            }

            @Override
            public ItemStack get8th() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return h;
            }

            @Override
            public ItemStack get9th() {
                if(a.getType().equals(Material.AIR)) {
                    return null;
                }
                return i;
            }
        };
    }

    public ICraftingItem buildItem(ItemStack item, String nameSpacedKey, CraftCategory category, ICraftingRecipe recipe, int minLevel) {
        return new ICraftingItem() {
            @Override
            public ItemStack getItem() {
                return item;
            }

            @Override
            public String getNameSpacedKey() {
                return nameSpacedKey;
            }

            @Override
            public CraftCategory getItemCategory() {
                return category;
            }

            @Override
            public ICraftingRecipe getRecipe() {
                return recipe;
            }

            @Override
            public Integer getMinLevel() {
                return minLevel;
            }
        };
    }

    public void registerItem(ICraftingItem item) {
        items.put(item.getNameSpacedKey(), item);
        itemList.put(item.getItem().getItemMeta().getDisplayName(), item);
        NamespacedKey key = new NamespacedKey(CustomCrafting.instance, item.getNameSpacedKey());
        ShapedRecipe recipe = new ShapedRecipe(key, item.getItem());
        ICraftingRecipe craftingRecipe = item.getRecipe();
        String shape1;
        String tmpShape1 = "ABC";
        if(craftingRecipe.get1st() == null) {
            shape1 = tmpShape1;
            tmpShape1 = shape1.replaceAll("A", " ");
        }
        if(craftingRecipe.get2nd() == null) {
            shape1 = tmpShape1;
            tmpShape1 = shape1.replaceAll("B", " ");
        }
        if(craftingRecipe.get3rd() == null) {
            shape1 = tmpShape1;
            tmpShape1 = shape1.replaceAll("C", " ");
        }
        shape1 = tmpShape1;
        String shape2;
        String tmpShape2 = "DEF";
        if(craftingRecipe.get4th() == null) {
            shape2 = tmpShape2;
            tmpShape2 = shape2.replaceAll("D", " ");
        }
        if(craftingRecipe.get5th() == null) {
            shape2 = tmpShape2;
            tmpShape2 = shape2.replaceAll("E", " ");
        }
        if(craftingRecipe.get6th() == null) {
            shape2 = tmpShape2;
            tmpShape2 = shape2.replaceAll("F", " ");
        }
        shape2 = tmpShape2;
        String shape3;
        String tmpShape3 = "GHI";
        if(craftingRecipe.get4th() == null) {
            shape3 = tmpShape3;
            tmpShape3 = shape3.replaceAll("G", " ");
        }
        if(craftingRecipe.get5th() == null) {
            shape3 = tmpShape3;
            tmpShape3 = shape3.replaceAll("H", " ");
        }
        if(craftingRecipe.get6th() == null) {
            shape3 = tmpShape3;
            tmpShape3 = shape3.replaceAll("I", " ");
        }
        shape3 = tmpShape3;
        recipe.shape(shape1, shape2, shape3);
        if(craftingRecipe.get1st() != null) {
            recipe.setIngredient('A', craftingRecipe.get1st());
        }
        if(craftingRecipe.get2nd() != null) {
            recipe.setIngredient('B', craftingRecipe.get2nd());
        }
        if(craftingRecipe.get3rd() != null) {
            recipe.setIngredient('C', craftingRecipe.get3rd());
        }
        if(craftingRecipe.get4th() != null) {
            recipe.setIngredient('D', craftingRecipe.get4th());
        }
        if(craftingRecipe.get5th() != null) {
            recipe.setIngredient('E', craftingRecipe.get5th());
        }
        if(craftingRecipe.get6th() != null) {
            recipe.setIngredient('F', craftingRecipe.get6th());
        }
        if(craftingRecipe.get7th() != null) {
            recipe.setIngredient('G', craftingRecipe.get7th());
        }
        if(craftingRecipe.get8th() != null) {
            recipe.setIngredient('H', craftingRecipe.get8th());
        }
        if(craftingRecipe.get9th() != null) {
            recipe.setIngredient('I', craftingRecipe.get9th());
        }
        Bukkit.addRecipe(recipe);
    }

    public List<ICraftingItem> getItems(CraftCategory category) {
        List<ICraftingItem> returnVal = new ArrayList<>();
        items.values().forEach(iCraftingItem -> {
            if(iCraftingItem.getItemCategory().equals(category)) {
                returnVal.add(iCraftingItem);
            }
        });
        return returnVal;
    }

    public ICraftingItem getItem(String name) {
        return itemList.getOrDefault(name, null);
    }

    public void unregisterItem(ICraftingItem item) {
        Bukkit.removeRecipe(new NamespacedKey(CustomCrafting.instance, item.getNameSpacedKey()));
        items.remove(item.getNameSpacedKey());
        itemList.remove(item.getItem().getItemMeta().getDisplayName());
    }

    public static void init() {
        items = new HashMap<>();
        itemList = new HashMap<>();
    }

}
