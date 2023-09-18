package xyz.plocki.customcrafting.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.plocki.customcrafting.CustomCrafting;
import xyz.plocki.customcrafting.util.ItemBuilder;
import xyz.plocki.customcrafting.util.crafting.CraftCategory;
import xyz.plocki.customcrafting.util.crafting.CraftingManager;
import xyz.plocki.customcrafting.util.crafting.ICraftingItem;
import xyz.plocki.customcrafting.util.crafting.ICraftingRecipe;

import java.util.List;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getCurrentItem() != null) {
            if(event.getCurrentItem().getItemMeta() == null) {
                return;
            }
            String displayName = event.getCurrentItem().getItemMeta().getDisplayName();
            String title = event.getView().getTitle();
            if(title.equalsIgnoreCase("§a§lRezepte")) {
                event.setCancelled(true);
                if (displayName.equalsIgnoreCase("§aBlöcke")) {
                    event.getWhoClicked().closeInventory();
                    Inventory inventory = Bukkit.createInventory(null, 6*9, "§a§lBlöcke");
                    ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                    for(int i = 0; i < inventory.getSize(); i++) {
                        inventory.setItem(i, pane);
                    }
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.BLOCKS);
                    if(blocks.size() >= 1) {
                        for(int i = 0; i < blocks.size(); i++) {
                            inventory.setItem(i, blocks.get(i).getItem());
                        }
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                } else if (displayName.equalsIgnoreCase("§bWaffen")) {
                    event.getWhoClicked().closeInventory();
                    Inventory inventory = Bukkit.createInventory(null, 6*9, "§b§lWaffen");
                    ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                    for(int i = 0; i < inventory.getSize(); i++) {
                        inventory.setItem(i, pane);
                    }
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.WEAPONS);
                    if(blocks.size() >= 1) {
                        for(int i = 0; i < blocks.size(); i++) {
                            inventory.setItem(i, blocks.get(i).getItem());
                        }
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                } else if (displayName.equalsIgnoreCase("§eWerkzeuge")) {
                    event.getWhoClicked().closeInventory();
                    Inventory inventory = Bukkit.createInventory(null, 6*9, "§e§lWerkzeuge");
                    ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                    for(int i = 0; i < inventory.getSize(); i++) {
                        inventory.setItem(i, pane);
                    }
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.TOOLS);
                    if(blocks.size() >= 1) {
                        for(int i = 0; i < blocks.size(); i++) {
                            inventory.setItem(i, blocks.get(i).getItem());
                        }
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                } else if (displayName.equalsIgnoreCase("§bRüstungen")) {
                    event.getWhoClicked().closeInventory();
                    Inventory inventory = Bukkit.createInventory(null, 6*9, "§b§lRüstungen");
                    ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                    for(int i = 0; i < inventory.getSize(); i++) {
                        inventory.setItem(i, pane);
                    }
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.ARMORS);
                    if(blocks.size() >= 1) {
                        for(int i = 0; i < blocks.size(); i++) {
                            inventory.setItem(i, blocks.get(i).getItem());
                        }
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                } else if (displayName.equalsIgnoreCase("§7Anderes")) {
                    event.getWhoClicked().closeInventory();
                    Inventory inventory = Bukkit.createInventory(null, 6*9, "§7§lAnderes");
                    ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                    for(int i = 0; i < inventory.getSize(); i++) {
                        inventory.setItem(i, pane);
                    }
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.OTHER);
                    if(blocks.size() >= 1) {
                        for(int i = 0; i < blocks.size(); i++) {
                            inventory.setItem(i, blocks.get(i).getItem());
                        }
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                }
            } else if(title.equalsIgnoreCase("§a§lBlöcke")) {
                event.setCancelled(true);
                if(!displayName.equalsIgnoreCase("§f")) {
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.BLOCKS);
                    ICraftingItem item = null;
                    if(blocks.size() >= 1) {
                        for (ICraftingItem block : blocks) {
                            if (displayName.equalsIgnoreCase(block.getItem().getItemMeta().getDisplayName())) {
                                item = block;
                            }
                        }
                    }
                    if(item != null) {
                        event.getWhoClicked().closeInventory();
                        Inventory inventory = Bukkit.createInventory(null, 5*9, "§b§lRezept: §e" + item.getItem().getItemMeta().getDisplayName());
                        ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        for(int i = 0; i < inventory.getSize(); i++) {
                            inventory.setItem(i, pane);
                        }
                        ItemStack gray = new ItemBuilder().buildItem(Material.GRAY_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack yellow = new ItemBuilder().buildItem(Material.YELLOW_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack white = new ItemBuilder().buildItem(Material.WHITE_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        inventory.setItem(1, gray);
                        inventory.setItem(2, yellow);
                        inventory.setItem(3, yellow);
                        inventory.setItem(4, yellow);
                        inventory.setItem(5, gray);
                        inventory.setItem(10, yellow);
                        inventory.setItem(11, white);
                        inventory.setItem(12, white);
                        inventory.setItem(13, white);
                        inventory.setItem(14, yellow);
                        inventory.setItem(19, yellow);
                        inventory.setItem(20, white);
                        inventory.setItem(21, white);
                        inventory.setItem(22, white);
                        inventory.setItem(23, yellow);
                        inventory.setItem(25, new ItemBuilder().buildItem(Material.RED_STAINED_GLASS_PANE, (short) 0, "§f", ""));
                        inventory.setItem(28, yellow);
                        inventory.setItem(29, white);
                        inventory.setItem(30, white);
                        inventory.setItem(31, white);
                        inventory.setItem(32, yellow);
                        inventory.setItem(37, gray);
                        inventory.setItem(38, yellow);
                        inventory.setItem(39, yellow);
                        inventory.setItem(40, yellow);
                        inventory.setItem(41, gray);

                        ICraftingRecipe recipe = item.getRecipe();
                        if(recipe.get1st() != null) {
                            inventory.setItem(11, recipe.get1st());
                        }
                        if(recipe.get2nd() != null) {
                            inventory.setItem(12, recipe.get2nd());
                        }
                        if(recipe.get3rd() != null) {
                            inventory.setItem(13, recipe.get3rd());
                        }
                        if(recipe.get4th() != null) {
                            inventory.setItem(20, recipe.get4th());
                        }
                        if(recipe.get5th() != null) {
                            inventory.setItem(21, recipe.get5th());
                        }
                        if(recipe.get6th() != null) {
                            inventory.setItem(22, recipe.get6th());
                        }
                        if(recipe.get7th() != null) {
                            inventory.setItem(29, recipe.get7th());
                        }
                        if(recipe.get8th() != null) {
                            inventory.setItem(30, recipe.get8th());
                        }
                        if(recipe.get9th() != null) {
                            inventory.setItem(31, recipe.get9th());
                        }
                        if(item.getItem() != null) {
                            inventory.setItem(25, item.getItem());
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                    }
                }
            } else if(title.equalsIgnoreCase("§b§lWaffen")) {
                event.setCancelled(true);
                if(!displayName.equalsIgnoreCase("§f")) {
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.WEAPONS);
                    ICraftingItem item = null;
                    if(blocks.size() >= 1) {
                        for (ICraftingItem block : blocks) {
                            if (displayName.equalsIgnoreCase(block.getItem().getItemMeta().getDisplayName())) {
                                item = block;
                            }
                        }
                    }
                    if(item != null) {
                        event.getWhoClicked().closeInventory();
                        Inventory inventory = Bukkit.createInventory(null, 5*9, "§b§lRezept: §e" + item.getItem().getItemMeta().getDisplayName());
                        ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        for(int i = 0; i < inventory.getSize(); i++) {
                            inventory.setItem(i, pane);
                        }
                        ItemStack gray = new ItemBuilder().buildItem(Material.GRAY_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack yellow = new ItemBuilder().buildItem(Material.YELLOW_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack white = new ItemBuilder().buildItem(Material.WHITE_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        inventory.setItem(1, gray);
                        inventory.setItem(2, yellow);
                        inventory.setItem(3, yellow);
                        inventory.setItem(4, yellow);
                        inventory.setItem(5, gray);
                        inventory.setItem(10, yellow);
                        inventory.setItem(11, white);
                        inventory.setItem(12, white);
                        inventory.setItem(13, white);
                        inventory.setItem(14, yellow);
                        inventory.setItem(19, yellow);
                        inventory.setItem(20, white);
                        inventory.setItem(21, white);
                        inventory.setItem(22, white);
                        inventory.setItem(23, yellow);
                        inventory.setItem(25, new ItemBuilder().buildItem(Material.RED_STAINED_GLASS_PANE, (short) 0, "§f", ""));
                        inventory.setItem(28, yellow);
                        inventory.setItem(29, white);
                        inventory.setItem(30, white);
                        inventory.setItem(31, white);
                        inventory.setItem(32, yellow);
                        inventory.setItem(37, gray);
                        inventory.setItem(38, yellow);
                        inventory.setItem(39, yellow);
                        inventory.setItem(40, yellow);
                        inventory.setItem(41, gray);

                        ICraftingRecipe recipe = item.getRecipe();
                        if(recipe.get1st() != null) {
                            inventory.setItem(11, recipe.get1st());
                        }
                        if(recipe.get2nd() != null) {
                            inventory.setItem(12, recipe.get2nd());
                        }
                        if(recipe.get3rd() != null) {
                            inventory.setItem(13, recipe.get3rd());
                        }
                        if(recipe.get4th() != null) {
                            inventory.setItem(20, recipe.get4th());
                        }
                        if(recipe.get5th() != null) {
                            inventory.setItem(21, recipe.get5th());
                        }
                        if(recipe.get6th() != null) {
                            inventory.setItem(22, recipe.get6th());
                        }
                        if(recipe.get7th() != null) {
                            inventory.setItem(29, recipe.get7th());
                        }
                        if(recipe.get8th() != null) {
                            inventory.setItem(30, recipe.get8th());
                        }
                        if(recipe.get9th() != null) {
                            inventory.setItem(31, recipe.get9th());
                        }
                        if(item.getItem() != null) {
                            inventory.setItem(25, item.getItem());
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                    }
                }
            } else if(title.equalsIgnoreCase("§e§lWerkzeuge")) {
                event.setCancelled(true);
                if(!displayName.equalsIgnoreCase("§f")) {
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.TOOLS);
                    ICraftingItem item = null;
                    if(blocks.size() >= 1) {
                        for (ICraftingItem block : blocks) {
                            if (displayName.equalsIgnoreCase(block.getItem().getItemMeta().getDisplayName())) {
                                item = block;
                            }
                        }
                    }
                    if(item != null) {
                        event.getWhoClicked().closeInventory();
                        Inventory inventory = Bukkit.createInventory(null, 5*9, "§b§lRezept: §e" + item.getItem().getItemMeta().getDisplayName());
                        ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        for(int i = 0; i < inventory.getSize(); i++) {
                            inventory.setItem(i, pane);
                        }
                        ItemStack gray = new ItemBuilder().buildItem(Material.GRAY_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack yellow = new ItemBuilder().buildItem(Material.YELLOW_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack white = new ItemBuilder().buildItem(Material.WHITE_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        inventory.setItem(1, gray);
                        inventory.setItem(2, yellow);
                        inventory.setItem(3, yellow);
                        inventory.setItem(4, yellow);
                        inventory.setItem(5, gray);
                        inventory.setItem(10, yellow);
                        inventory.setItem(11, white);
                        inventory.setItem(12, white);
                        inventory.setItem(13, white);
                        inventory.setItem(14, yellow);
                        inventory.setItem(19, yellow);
                        inventory.setItem(20, white);
                        inventory.setItem(21, white);
                        inventory.setItem(22, white);
                        inventory.setItem(23, yellow);
                        inventory.setItem(25, new ItemBuilder().buildItem(Material.RED_STAINED_GLASS_PANE, (short) 0, "§f", ""));
                        inventory.setItem(28, yellow);
                        inventory.setItem(29, white);
                        inventory.setItem(30, white);
                        inventory.setItem(31, white);
                        inventory.setItem(32, yellow);
                        inventory.setItem(37, gray);
                        inventory.setItem(38, yellow);
                        inventory.setItem(39, yellow);
                        inventory.setItem(40, yellow);
                        inventory.setItem(41, gray);

                        ICraftingRecipe recipe = item.getRecipe();
                        if(recipe.get1st() != null) {
                            inventory.setItem(11, recipe.get1st());
                        }
                        if(recipe.get2nd() != null) {
                            inventory.setItem(12, recipe.get2nd());
                        }
                        if(recipe.get3rd() != null) {
                            inventory.setItem(13, recipe.get3rd());
                        }
                        if(recipe.get4th() != null) {
                            inventory.setItem(20, recipe.get4th());
                        }
                        if(recipe.get5th() != null) {
                            inventory.setItem(21, recipe.get5th());
                        }
                        if(recipe.get6th() != null) {
                            inventory.setItem(22, recipe.get6th());
                        }
                        if(recipe.get7th() != null) {
                            inventory.setItem(29, recipe.get7th());
                        }
                        if(recipe.get8th() != null) {
                            inventory.setItem(30, recipe.get8th());
                        }
                        if(recipe.get9th() != null) {
                            inventory.setItem(31, recipe.get9th());
                        }
                        if(item.getItem() != null) {
                            inventory.setItem(25, item.getItem());
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                    }
                }
            } else if(title.equalsIgnoreCase("§b§lRüstungen")) {
                event.setCancelled(true);
                if(!displayName.equalsIgnoreCase("§f")) {
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.ARMORS);
                    ICraftingItem item = null;
                    if(blocks.size() >= 1) {
                        for (ICraftingItem block : blocks) {
                            if (displayName.equalsIgnoreCase(block.getItem().getItemMeta().getDisplayName())) {
                                item = block;
                            }
                        }
                    }
                    if(item != null) {
                        event.getWhoClicked().closeInventory();
                        Inventory inventory = Bukkit.createInventory(null, 5*9, "§b§lRezept: §e" + item.getItem().getItemMeta().getDisplayName());
                        ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        for(int i = 0; i < inventory.getSize(); i++) {
                            inventory.setItem(i, pane);
                        }
                        ItemStack gray = new ItemBuilder().buildItem(Material.GRAY_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack yellow = new ItemBuilder().buildItem(Material.YELLOW_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack white = new ItemBuilder().buildItem(Material.WHITE_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        inventory.setItem(1, gray);
                        inventory.setItem(2, yellow);
                        inventory.setItem(3, yellow);
                        inventory.setItem(4, yellow);
                        inventory.setItem(5, gray);
                        inventory.setItem(10, yellow);
                        inventory.setItem(11, white);
                        inventory.setItem(12, white);
                        inventory.setItem(13, white);
                        inventory.setItem(14, yellow);
                        inventory.setItem(19, yellow);
                        inventory.setItem(20, white);
                        inventory.setItem(21, white);
                        inventory.setItem(22, white);
                        inventory.setItem(23, yellow);
                        inventory.setItem(25, new ItemBuilder().buildItem(Material.RED_STAINED_GLASS_PANE, (short) 0, "§f", ""));
                        inventory.setItem(28, yellow);
                        inventory.setItem(29, white);
                        inventory.setItem(30, white);
                        inventory.setItem(31, white);
                        inventory.setItem(32, yellow);
                        inventory.setItem(37, gray);
                        inventory.setItem(38, yellow);
                        inventory.setItem(39, yellow);
                        inventory.setItem(40, yellow);
                        inventory.setItem(41, gray);

                        ICraftingRecipe recipe = item.getRecipe();
                        if(recipe.get1st() != null) {
                            inventory.setItem(11, recipe.get1st());
                        }
                        if(recipe.get2nd() != null) {
                            inventory.setItem(12, recipe.get2nd());
                        }
                        if(recipe.get3rd() != null) {
                            inventory.setItem(13, recipe.get3rd());
                        }
                        if(recipe.get4th() != null) {
                            inventory.setItem(20, recipe.get4th());
                        }
                        if(recipe.get5th() != null) {
                            inventory.setItem(21, recipe.get5th());
                        }
                        if(recipe.get6th() != null) {
                            inventory.setItem(22, recipe.get6th());
                        }
                        if(recipe.get7th() != null) {
                            inventory.setItem(29, recipe.get7th());
                        }
                        if(recipe.get8th() != null) {
                            inventory.setItem(30, recipe.get8th());
                        }
                        if(recipe.get9th() != null) {
                            inventory.setItem(31, recipe.get9th());
                        }
                        if(item.getItem() != null) {
                            inventory.setItem(25, item.getItem());
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                    }
                }
            } else if(title.equalsIgnoreCase("§7§lAnderes")) {
                event.setCancelled(true);
                if(!displayName.equalsIgnoreCase("§f")) {
                    List<ICraftingItem> blocks = new CraftingManager().getItems(CraftCategory.OTHER);
                    ICraftingItem item = null;
                    if(blocks.size() >= 1) {
                        for (ICraftingItem block : blocks) {
                            if (displayName.equalsIgnoreCase(block.getItem().getItemMeta().getDisplayName())) {
                                item = block;
                            }
                        }
                    }
                    if(item != null) {
                        event.getWhoClicked().closeInventory();
                        Inventory inventory = Bukkit.createInventory(null, 5*9, "§b§lRezept: §e" + item.getItem().getItemMeta().getDisplayName());
                        ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        for(int i = 0; i < inventory.getSize(); i++) {
                            inventory.setItem(i, pane);
                        }
                        ItemStack gray = new ItemBuilder().buildItem(Material.GRAY_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack yellow = new ItemBuilder().buildItem(Material.YELLOW_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack white = new ItemBuilder().buildItem(Material.WHITE_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        inventory.setItem(1, gray);
                        inventory.setItem(2, yellow);
                        inventory.setItem(3, yellow);
                        inventory.setItem(4, yellow);
                        inventory.setItem(5, gray);
                        inventory.setItem(10, yellow);
                        inventory.setItem(11, white);
                        inventory.setItem(12, white);
                        inventory.setItem(13, white);
                        inventory.setItem(14, yellow);
                        inventory.setItem(19, yellow);
                        inventory.setItem(20, white);
                        inventory.setItem(21, white);
                        inventory.setItem(22, white);
                        inventory.setItem(23, yellow);
                        inventory.setItem(25, new ItemBuilder().buildItem(Material.RED_STAINED_GLASS_PANE, (short) 0, "§f", ""));
                        inventory.setItem(28, yellow);
                        inventory.setItem(29, white);
                        inventory.setItem(30, white);
                        inventory.setItem(31, white);
                        inventory.setItem(32, yellow);
                        inventory.setItem(37, gray);
                        inventory.setItem(38, yellow);
                        inventory.setItem(39, yellow);
                        inventory.setItem(40, yellow);
                        inventory.setItem(41, gray);

                        ICraftingRecipe recipe = item.getRecipe();
                        if(recipe.get1st() != null) {
                            inventory.setItem(11, recipe.get1st());
                        }
                        if(recipe.get2nd() != null) {
                            inventory.setItem(12, recipe.get2nd());
                        }
                        if(recipe.get3rd() != null) {
                            inventory.setItem(13, recipe.get3rd());
                        }
                        if(recipe.get4th() != null) {
                            inventory.setItem(20, recipe.get4th());
                        }
                        if(recipe.get5th() != null) {
                            inventory.setItem(21, recipe.get5th());
                        }
                        if(recipe.get6th() != null) {
                            inventory.setItem(22, recipe.get6th());
                        }
                        if(recipe.get7th() != null) {
                            inventory.setItem(29, recipe.get7th());
                        }
                        if(recipe.get8th() != null) {
                            inventory.setItem(30, recipe.get8th());
                        }
                        if(recipe.get9th() != null) {
                            inventory.setItem(31, recipe.get9th());
                        }
                        if(item.getItem() != null) {
                            inventory.setItem(25, item.getItem());
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                    }
                }
            } else if(title.contains("§b§lRezept: §e")) {
                event.setCancelled(true);
                if(!displayName.equalsIgnoreCase("§f")) {
                    if(displayName.equalsIgnoreCase(event.getView().getTopInventory().getItem(25).getItemMeta().getDisplayName())) {
                        return;
                    }
                    if(new CraftingManager().getItem(displayName) != null) {
                        event.getWhoClicked().closeInventory();
                        ICraftingItem item = new CraftingManager().getItem(displayName);
                        Inventory inventory = Bukkit.createInventory(null, 5*9, "§b§lRezept: §e" + item.getItem().getItemMeta().getDisplayName());
                        ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        for(int i = 0; i < inventory.getSize(); i++) {
                            inventory.setItem(i, pane);
                        }
                        ItemStack gray = new ItemBuilder().buildItem(Material.GRAY_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack yellow = new ItemBuilder().buildItem(Material.YELLOW_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        ItemStack white = new ItemBuilder().buildItem(Material.WHITE_STAINED_GLASS_PANE, (short) 0, "§f", "");
                        inventory.setItem(1, gray);
                        inventory.setItem(2, yellow);
                        inventory.setItem(3, yellow);
                        inventory.setItem(4, yellow);
                        inventory.setItem(5, gray);
                        inventory.setItem(10, yellow);
                        inventory.setItem(11, white);
                        inventory.setItem(12, white);
                        inventory.setItem(13, white);
                        inventory.setItem(14, yellow);
                        inventory.setItem(19, yellow);
                        inventory.setItem(20, white);
                        inventory.setItem(21, white);
                        inventory.setItem(22, white);
                        inventory.setItem(23, yellow);
                        inventory.setItem(25, new ItemBuilder().buildItem(Material.RED_STAINED_GLASS_PANE, (short) 0, "§f", ""));
                        inventory.setItem(28, yellow);
                        inventory.setItem(29, white);
                        inventory.setItem(30, white);
                        inventory.setItem(31, white);
                        inventory.setItem(32, yellow);
                        inventory.setItem(37, gray);
                        inventory.setItem(38, yellow);
                        inventory.setItem(39, yellow);
                        inventory.setItem(40, yellow);
                        inventory.setItem(41, gray);

                        ICraftingRecipe recipe = item.getRecipe();
                        if(recipe.get1st() != null) {
                            inventory.setItem(11, recipe.get1st());
                        }
                        if(recipe.get2nd() != null) {
                            inventory.setItem(12, recipe.get2nd());
                        }
                        if(recipe.get3rd() != null) {
                            inventory.setItem(13, recipe.get3rd());
                        }
                        if(recipe.get4th() != null) {
                            inventory.setItem(20, recipe.get4th());
                        }
                        if(recipe.get5th() != null) {
                            inventory.setItem(21, recipe.get5th());
                        }
                        if(recipe.get6th() != null) {
                            inventory.setItem(22, recipe.get6th());
                        }
                        if(recipe.get7th() != null) {
                            inventory.setItem(29, recipe.get7th());
                        }
                        if(recipe.get8th() != null) {
                            inventory.setItem(30, recipe.get8th());
                        }
                        if(recipe.get9th() != null) {
                            inventory.setItem(31, recipe.get9th());
                        }
                        if(item.getItem() != null) {
                            inventory.setItem(25, item.getItem());
                        }
                        Bukkit.getScheduler().scheduleSyncDelayedTask(CustomCrafting.instance, () -> event.getWhoClicked().openInventory(inventory), 3);
                    }
                }
            }
        }
    }

}