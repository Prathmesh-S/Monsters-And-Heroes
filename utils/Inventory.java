package utils;

import java.util.ArrayList;
import java.util.List;

import models.Item;

//This class serves as the inventory for a given hero
public class Inventory {
    private List<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<Item>();
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        this.inventory.remove(item);
    }

    public List<Item> getItemsByType(Class<?> itemType) {
        List<Item> items = new ArrayList<>();
        for (Item item : inventory) {
            if (itemType.isInstance(item)) {
                items.add(item);
            }
        }
        return items;
    }


}
