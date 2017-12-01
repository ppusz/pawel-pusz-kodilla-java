package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsRetriever {

    public static List<SupplierProduct> retrieve() {

        List<SupplierProduct> productList = new ArrayList<>();
        SupplierProductBuilder productBuilder = SupplierProductBuilder.aSupplierProduct();

        productBuilder.withSupplierCode("e123");
        productBuilder.withDescription("some extra food product");
        productBuilder.withUnit("PC");
        productBuilder.withBundleSize(12);
        productBuilder.withPrice(new BigDecimal("10"));
        productBuilder.withBundlePrice(new BigDecimal("120"));
        productBuilder.withDiscount(new BigDecimal("20"));

        productList.add(productBuilder.build());

        productBuilder.withSupplierCode("f321");
        productBuilder.withDescription("some other extra food product");
        productBuilder.withUnit("PC");
        productBuilder.withBundleSize(6);
        productBuilder.withPrice(new BigDecimal("8"));
        productBuilder.withBundlePrice(new BigDecimal("48"));
        productBuilder.withDiscount(BigDecimal.ZERO);

        productList.add(productBuilder.build());

        return productList;
    }
}
