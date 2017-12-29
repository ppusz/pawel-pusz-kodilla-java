package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        List<Product> products = new ArrayList<>();
        for(int i = 1; i <= 4; i++) {
            products.add(new Product("Product " + i));
        }
        productDao.save(products);

        List<Invoice> invoices = new ArrayList<>();
        for(int i = 1; i <= 2; i++) {
            invoices.add(new Invoice("AAAA00" + i));
        }

        List<Item> items = new ArrayList<>();
        items.add(new Item(invoices.get(0),products.get(0),new BigDecimal(100),1));
        items.add(new Item(invoices.get(0),products.get(1),new BigDecimal(50),1));
        items.add(new Item(invoices.get(0),products.get(2),new BigDecimal(75),2));
        items.add(new Item(invoices.get(1),products.get(0),new BigDecimal(100),2));
        items.add(new Item(invoices.get(1),products.get(1),new BigDecimal(50),2));
        items.add(new Item(invoices.get(1),products.get(2),new BigDecimal(75),4));
        items.add(new Item(invoices.get(1),products.get(3),new BigDecimal(45),2));
        for (int i = 0; i < 7; i++) {
            invoices.get((i < 3) ? 0 : 1).getItems().add(items.get(i));
        }
        products.get(0).getItems().add(items.get(0));
        products.get(0).getItems().add(items.get(3));
        products.get(1).getItems().add(items.get(1));
        products.get(1).getItems().add(items.get(4));
        products.get(2).getItems().add(items.get(2));
        products.get(2).getItems().add(items.get(5));
        products.get(3).getItems().add(items.get(6));

        //When
        List<Invoice> savedInvoices = (List<Invoice>) invoiceDao.save(invoices);

        int invoice1Id = savedInvoices.get(0).getId();
        int invoice2Id = savedInvoices.get(1).getId();

        //Then
        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, invoice2Id);

    }
}
