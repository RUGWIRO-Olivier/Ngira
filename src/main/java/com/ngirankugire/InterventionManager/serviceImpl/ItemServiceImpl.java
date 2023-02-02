package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.Item;
import com.ngirankugire.InterventionManager.repository.InterventionRepo;
import com.ngirankugire.InterventionManager.repository.ItemRepo;
import com.ngirankugire.InterventionManager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo repo;

//    @Value("${componentId}")
//    private String componentId;

    @Override
    public Item createItem(Item item) {
        return repo.save(item);
    }

    @Override
    public List<Item> getItem() {
        return repo.findAll();
    }

    @Override
    public Item getItem(String id) {
        Item item = repo.findById(id).orElseThrow(()->new ApiRequestException("Item with ID "+id+" is not found"));

        item.getItemTypeId();
        return item;
    }

    @Override
    public Item updateItem(Item item) {
        repo.findById(item.getItemTypeId()).orElseThrow(()->new ApiRequestException("Item doesn't exist"));
        Item resultItem = repo.save(item);
//        resultTariff.setTariffItem(TariffItem.REFACTOR(tariffItemService.getTariffItemByTariffId(tariff.getId())));
        return resultItem;
    }

    @Override
    public void deleteItem(String id) {
        repo.deleteById(id);
    }

}
