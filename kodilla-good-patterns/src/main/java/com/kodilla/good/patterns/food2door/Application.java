package com.kodilla.good.patterns.food2door;

public class Application {

    public static void main(String[] args) {

        System.out.println("Updating products catalog.");
        SupplierProductCatalogReceiver supplierProductCatalogReceiver
                = new SupplierProductCatalogReceiver(new DbRepository(), new ExtraFoodShopConnector());
        boolean receiveStatus = supplierProductCatalogReceiver.receive();
        if (receiveStatus) {
            System.out.println("Product catalog updated.");
        } else {
            System.out.println("Update failed.");
        }

        System.out.println("Ordering products.");
        SupplierOrderRetriever supplierOrderRetriever = new SupplierOrderRetriever();
        SupplierOrder supplierOrder = supplierOrderRetriever.retrieve();
        SupplierOrderProcessor supplierOrderProcessor = new SupplierOrderProcessor(
                new DbRepository(), new ExtraFoodShopConnector());
        boolean orderStatus = supplierOrderProcessor.process(supplierOrder);
        if (orderStatus) {
            System.out.println("Order placed.");
        } else {
            System.out.println("Order rejected or could not be sent.");
        }
    }
}
