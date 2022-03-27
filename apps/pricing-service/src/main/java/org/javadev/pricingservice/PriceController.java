package org.javadev.pricingservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PriceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	List<Price> priceList = new ArrayList<Price>();
	
	@GetMapping("/price/{productid}")
	public Price getPriceDetails(@PathVariable Long productid) {
		Price price= getPriceInfo(productid);
		Integer exgVal = restTemplate.getForObject("http://localhost:8004/currexg/from/USD/to/YEN", ExgVal.class).getExgVal();
		return new Price(price.getPriceId(), price.getProductId(), price.getOriginalPrice(), Math.multiplyExact(exgVal, price.getDiscountedPrice()));
	}

	private Price getPriceInfo(Long productid) {
		pupulatePriceList();
		
		for(Price p: priceList) {
			if(productid.equals(p.getProductId())) {
				return p;
			}
		}
		return null;
	}

	private void pupulatePriceList() {
		priceList.add(new Price(201L, 101L, 1999, 999));
		priceList.add(new Price(202L, 102L, 199, 19));
		priceList.add(new Price(203L, 103L, 1222, 600));
	}
}
