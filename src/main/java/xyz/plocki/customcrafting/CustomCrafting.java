package xyz.plocki.customcrafting;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.plocki.customcrafting.commands.RecipesCommand;
import xyz.plocki.customcrafting.listeners.CraftingListener;
import xyz.plocki.customcrafting.listeners.InventoryClickListener;
import xyz.plocki.customcrafting.util.crafting.CraftingManager;

public final class CustomCrafting extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        CraftingManager.init();
        this.getCommand("recipes").setExecutor(new RecipesCommand());
        this.getCommand("rezepte").setExecutor(new RecipesCommand());
        this.getCommand("recipe").setExecutor(new RecipesCommand());
        this.getCommand("rezept").setExecutor(new RecipesCommand());
        Bukkit.getPluginManager().registerEvents(new CraftingListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
