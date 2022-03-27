package org.javadev.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/product/details/{productid}")
	public Product getProductDetails(@PathVariable Long productid) {
		ProductInfo productInfo = getProductInfo(productid);
		
		Price price = restTemplate.getForObject("http://localhost:8002/price/" + productid, Price.class);
		
		Inventory inventory = restTemplate.getForObject("http://localhost:8003/inventory/" + productid, Inventory.class);
		
		return new Product(
				productInfo.getProductId(), 
				productInfo.getProductName(), 
				productInfo.getProductDesc(), 
				price.getDiscountedPrice(), 
				inventory.getInStock()
				);
	}

	private ProductInfo getProductInfo(Long productid) {
		pupulateProductList();
		
		for(ProductInfo p: productList) {
			if(productid.equals(p.getProductId())) {
				return p;
			}
		}
		return null;
	}



	private void pupulateProductList() {
		productList.add(new ProductInfo(101L, "iPhone", "iPhone is damn expensive!"));
		productList.add(new ProductInfo(102L, "Book", "Book is great!"));
		productList.add(new ProductInfo(103L, "Washing MC", "Washing MC is necessary!"));
		
	}
	
	
}
