package xyz.plocki.customcrafting.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import xyz.plocki.customcrafting.util.ItemBuilder;

public class RecipesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Inventory inventory = Bukkit.createInventory(null, 3*9, "§a§lRezepte");
            ItemStack pane = new ItemBuilder().buildItem(Material.BLACK_STAINED_GLASS_PANE, (short) 0, "§f", "");
            for(int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, pane);
            }
            ItemStack blocks = new ItemBuilder().buildItem(Material.GRASS_BLOCK, (short) 0, "§aBlöcke", "", "", "§aZeigt dir Rezepte für Blöcke an", "", "");
            ItemStack weapons = new ItemBuilder().buildItem(Material.DIAMOND_SWORD, (short) 0,"§bWaffen", "", "", "§aZeigt dir alle Rezepte für Waffen an", "", "");
            ItemStack tools = new ItemBuilder().buildItem(Material.DIAMOND_PICKAXE, (short) 0, "§eWerkzeuge", "", "", "§aZeigt dir alle Rezepte für Werkzeuge an", "", "");
            ItemStack armors = new ItemBuilder().buildItem(Material.DIAMOND_CHESTPLATE, (short) 0, "§bRüstungen", "", "", "§aZeigt dir alle Rezepte für Rüstungen an", "", "");
            ItemStack other = new ItemBuilder().buildItem(Material.STICK, (short) 0, "§7Anderes", "", "", "§aZeigt dir alle anderen Rezepte an", "", "");
            inventory.setItem(10, blocks);
            inventory.setItem(12, weapons);
            inventory.setItem(13, tools);
            inventory.setItem(14, armors);
            inventory.setItem(16, other);
            ((Player) sender).openInventory(inventory);
        }
        return false;
    }
}
