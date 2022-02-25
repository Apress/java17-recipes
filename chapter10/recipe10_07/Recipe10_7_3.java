package org.java17recipes.chapter10.recipe10_07;


import java.util.*;

public class Recipe10_7_3 {

   Random random = new Random();
   List<String> itemList = new ArrayList<>();
   Map<String,Integer> inventoryMap = new HashMap<>();
   Collection<Order> orderList = new ArrayList<>();


   public static void main(String[] args) {
       Recipe10_7_3 recipe = new Recipe10_7_3();
       recipe.start();
   }

   private void start() {
       loadItems();

       Thread inventoryThread = new Thread(() -> {
           System.out.println("Loading Inventory from Database...");
           loadInventory();
       });

       inventoryThread.start();
       try {
           inventoryThread.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       Thread ordersThread = new Thread(() -> {
           System.out.println("Loading Orders from XML Web service...");
           loadOrders();
       });

       ordersThread.start();
       try {
           ordersThread.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       processOrders();
   }

   private void processOrders() {
       orderList.stream().forEach((order) -> {
           boolean fulfillable = canFulfill(order);
           if (fulfillable) {
               doFulfill (order);
               System.out.println("Order # " + String.valueOf(order.getOrderId()) + " has been fulfilled");
           } else {
               System.out.println("Order # "+String.valueOf(order.getOrderId())+" CANNOT be fulfilled");
           }
       });
   }

   private void doFulfill(Order order) {
       order.getOrderedItems().keySet().stream().forEach((item) -> {
           int quantity = order.getOrderedItems().get(item);
           int currentInventory = inventoryMap.get(item);
           inventoryMap.put(item, currentInventory-quantity);
       });
   }

   private boolean canFulfill(Order order) {
       for (String item : order.getOrderedItems().keySet()) {
           int quantity = order.getOrderedItems().get(item);
           int currentInventory = inventoryMap.get(item);
           if (quantity > currentInventory) {
               return false;
           }
       }
       return true;
   }

   private void loadOrders() {
       for (int i= 0;i < 1000;i++) {
           Order order = new Order(i);
           for (int j =0;j < 10;j++) {
               String randomItem = itemList.get(random.nextInt(itemList.size()));
               order.addItem(randomItem,random.nextInt(2)+1);
           }
           orderList.add(order);
       }
   }

   private void loadItems() {
       for (int i= 0;i < 100;i++) {
           itemList.add("Item #"+i);
       }
   }


   private void loadInventory() {
       itemList.stream().forEach((item) -> {
           inventoryMap.put(item,random.nextInt(500));
       });
   }

   class Order {
       long orderId;
       private Map<String,Integer> orderedItems = new HashMap<>();

       Order(long orderId) {
           this.orderId = orderId;
       }
       public void addItem (String itemName, int quantity) {
           Integer currentQuantity = orderedItems.get(itemName);
           if (currentQuantity == null) {
               currentQuantity =0;
           }
           orderedItems.put(itemName,currentQuantity+quantity);
       }

       public Map<String, Integer> getOrderedItems() {
           return orderedItems;
       }

       public long getOrderId() {
           return orderId;
       }
   }
}

