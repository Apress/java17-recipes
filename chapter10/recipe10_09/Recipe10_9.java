package org.java17recipes.chapter10.recipe10_09;


import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


public class Recipe10_9 {
   public static void main(String[] args) {
       Recipe10_9 recipe = new Recipe10_9();
       recipe.start();
   }

   List<Order> orders= Collections.synchronizedList(new ArrayList<Order>());

   private void start() {
       for (int i =0;i < 10;i++) {
           Thread orderCreationThread = new Thread(() -> {
               for (int i1 = 0; i1 < 10; i1++) {
                   createOrder(Thread.currentThread().getName());
               }
           });
           orderCreationThread.setName("Order Creation Thread "+i);
           orderCreationThread.start();
       }

       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       // check if there are any gaps in the orders.
       Set<Long> orderIds = new HashSet<>();
       orders.stream().map((order) -> {
           if (orderIds.contains(order.getOrderId())) {
               System.out.println("The horror! an orderID has been reused!");
           }
           return order;
       }).map((order) -> {
           orderIds.add(order.getOrderId());
           return order;
       }).forEach((order) -> {
           System.out.println("Order id:"+order.getOrderId());
       });
   }

   AtomicLong orderIdGenerator = new AtomicLong(0);
   private void createOrder(String name) {
       long orderId = orderIdGenerator.incrementAndGet();
       Order order = new Order(name, orderId);
       orders.add(order);
   }

 public  class Order {
       String orderName;
       long orderId;

       Order(String orderName, long orderId) {
           this.orderName = orderName;
           this.orderId = orderId;
       }

       public String getOrderName() {
           return orderName;
       }

       public long getOrderId() {
           return orderId;
       }
   }
}

