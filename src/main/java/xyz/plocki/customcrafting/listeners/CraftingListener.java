package xyz.plocki.customcrafting.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import xyz.plocki.customcrafting.util.LevelAdapter;
import xyz.plocki.customcrafting.util.crafting.CraftingManager;

import java.util.concurrent.atomic.AtomicInteger;

public class CraftingListener implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        AtomicInteger level = new AtomicInteger(0);
        CraftingManager.items.values().forEach(iCraftingItem -> {
            if(event.getRecipe().getResult().equals(iCraftingItem.getItem())) {
                level.set(iCraftingItem.getMinLevel());
            }
        });
        if(!(new LevelAdapter().getLevel((Player) event.getWhoClicked()) >= level.get())) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage("§a§lRPG §8» §7Dein Level ist leider zu niedrig.");
        }
    }

}
