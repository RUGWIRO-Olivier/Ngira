package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    List<Item> getItem();
    Item getItem(String id);
    Item updateItem(Item item);
    void deleteItem(String id);
}
