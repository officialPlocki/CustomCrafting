package xyz.plocki.customcrafting.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public ItemStack buildItem(Material material, short modelId, String name, String... lore) {
        ItemStack item;
        if(modelId != 0) {
            item = new ItemStack(material, 0, modelId);
        } else {
            item = new ItemStack(material);
        }
        List<String> loreList = new ArrayList<>(List.of(lore));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(loreList);
        item.setItemMeta(meta);
        return item;
    }

}
