package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("CPU");
        Product product2 = new Product("Mainboard");
        Product product3 = new Product("DDR4 8GB");
        Product product4 = new Product("ATX case");
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        productDao.save(product4);
        int product1Id = product1.getId();
        int product2Id = product2.getId();
        int product3Id = product3.getId();
        int product4Id = product4.getId();

        Invoice invoice1 = new Invoice("AAAA001");
        Invoice invoice2 = new Invoice("AAAA002");
        Item item1 = new Item(invoice1,product1,new BigDecimal(100),1);
        Item item2 = new Item(invoice1,product2,new BigDecimal(50),1);
        Item item3 = new Item(invoice1,product3,new BigDecimal(75),2);
        Item item4 = new Item(invoice2,product1,new BigDecimal(100),2);
        Item item5 = new Item(invoice2,product2,new BigDecimal(50),2);
        Item item6 = new Item(invoice2,product3,new BigDecimal(75),4);
        Item item7 = new Item(invoice2,product4,new BigDecimal(45),2);
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);
        invoice2.getItems().add(item4);
        invoice2.getItems().add(item5);
        invoice2.getItems().add(item6);
        invoice2.getItems().add(item7);

        product1.getItems().add(item1);
        product1.getItems().add(item4);
        product2.getItems().add(item2);
        product2.getItems().add(item5);
        product3.getItems().add(item3);
        product3.getItems().add(item6);
        product4.getItems().add(item7);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        int invoice1Id = invoice1.getId();
        int invoice2Id = invoice2.getId();

        //Then
        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, invoice2Id);

        //CleanUP
        try {
            invoiceDao.delete(invoice1Id);
            invoiceDao.delete(invoice2Id);
            productDao.delete(product1Id);
            productDao.delete(product2Id);
            productDao.delete(product3Id);
            productDao.delete(product4Id);
        } catch (Exception e) {
        }

    }
}
