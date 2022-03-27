package org.javadev.productservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Long productId;
	private String productName;
	private String productDesc;
	private Integer productPrice;
	private Boolean productStock;
}
