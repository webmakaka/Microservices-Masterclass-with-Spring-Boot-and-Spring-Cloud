package org.javadev.inventoryservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	
	List<Inventory> inventoryList = new ArrayList<Inventory>();
	
	@GetMapping("/inventory/{productid}")
	public Inventory getInventoryDetails(@PathVariable Long productid) {
		Inventory inventory = getInventoryInfo(productid);
		return inventory;
	}

	private Inventory getInventoryInfo(Long productid) {
		pupulateInventorytList();
		
		for(Inventory i: inventoryList) {
			if(productid.equals(i.getProductId())) {
				return i;
			}
		}
		return null;
	}

	private void pupulateInventorytList() {
		inventoryList.clear();
		inventoryList.add(new Inventory(301L, 101L, true));
		inventoryList.add(new Inventory(302L, 102L, true));
		inventoryList.add(new Inventory(303L, 103L, false));
	}
}
