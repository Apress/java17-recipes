package org.java17recipes.chapter10.recipe10_05;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class Recipe10_5_2 {

    Set<Thread> orderingThreads = new HashSet<>();
    Lock inventoryLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Recipe10_5_2 recipe = new Recipe10_5_2();
        recipe.start();
    }

    final Map<String, Integer> inventoryMap = new LinkedHashMap<>();
    List<CustomerOrder> customerOrders = new ArrayList<>();
    Random random = new Random();

    private void start() throws InterruptedException {
        // let's populate our inventory with items.
        // at most, we have 20 books
        for (int i = 0; i < 100; i++) {
            inventoryMap.put("Apress Book #" + i, 1000);
        }

        // now, let's create ordering threads.
        for (int i = 0; i < 20; i++) {
            createOrderingThread();
        }

        //wait a little
        Thread.sleep(100);

        // Check on inventory right now
        checkInventoryLevels();

        // Wait little longer
        Thread.sleep(100);


        orderingThreads.stream().forEach((thread) -> {
            thread.interrupt();
        });

        Thread.sleep(1000);

        // Check inventory levels again
        checkInventoryLevels();
        // Print the orders.
        displayOrders();

    }

    private void displayOrders() {
        try {
            inventoryLock.lock();
            customerOrders.stream().forEach((order) -> {
                System.out.println(order.getQuantityOrdered() + " " + order.getItemOrdered() + " for " + order.getCustomerName());
            });
        } finally {
            inventoryLock.unlock();
        }
    }

    private void createOrderingThread() {
        Thread orderingThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                createRandomOrder();
            }
        });
        orderingThread.start();
        orderingThreads.add(orderingThread);


    }

    private void createRandomOrder() {
        String itemOrdered = "Apress Book #" + random.nextInt(100);
        int quantityOrdered = random.nextInt(2) + 1;
        String customerName = "Customer :" + UUID.randomUUID().toString();
        fulfillOrder(itemOrdered, quantityOrdered, customerName);
    }

    private boolean fulfillOrder(String itemOrdered, int quantityOrdered, String customerName) {
        try {
            inventoryLock.lock();
            int currentInventory = inventoryMap.get(itemOrdered);
            if (currentInventory < quantityOrdered) {
                System.out.println("Couldn't fulfill order for " + customerName + " not enough " + itemOrdered + " (" + quantityOrdered + ")");
                return false; // sorry, we sold out
            }
            inventoryMap.put(itemOrdered, currentInventory - quantityOrdered);
            CustomerOrder order = new CustomerOrder(itemOrdered, quantityOrdered, customerName);
            customerOrders.add(order);
            System.out.println("Order fulfilled for " + customerName + " of " + itemOrdered + " (" + quantityOrdered + ")");
            return true;
        } finally {
            inventoryLock.unlock();
        }
    }

    private void checkInventoryLevels() {
        try {
            inventoryLock.lock();
            System.out.println("------------------------------------");
            inventoryMap.entrySet().stream().forEach((inventoryEntry) -> {
                System.out.println("Inventory Level :" + inventoryEntry.getKey() + " " + inventoryEntry.getValue());
            });
            System.out.println("------------------------------------");
        } finally {
            inventoryLock.unlock();
        }
    }

    class CustomerOrder {
        String itemOrdered;
        int quantityOrdered;
        String customerName;

        CustomerOrder(String itemOrdered, int quantityOrdered, String customerName) {
            this.itemOrdered = itemOrdered;
            this.quantityOrdered = quantityOrdered;
            this.customerName = customerName;
        }

        public String getItemOrdered() {
            return itemOrdered;
        }

        public int getQuantityOrdered() {
            return quantityOrdered;
        }

        public String getCustomerName() {
            return customerName;
        }
    }
}

