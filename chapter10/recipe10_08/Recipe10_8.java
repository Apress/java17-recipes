package org.java17recipes.chapter10.recipe10_08;


public class Recipe10_8 {
   public static void main(String[] args) {
       Recipe10_8 recipe = new Recipe10_8();
       recipe.startProcess();
   }

   private void startProcess() {

   }

   class CustomerOrder {
       private String itemOrdered;
       private int quantityOrdered;
       private String customerName;

       public CustomerOrder() {

       }

       public double calculateOrderTotal (double price) {
           synchronized (this) {
               return getQuantityOrdered()*price;
           }
       }

       public synchronized String getItemOrdered() {
           return itemOrdered;
       }

       public synchronized int getQuantityOrdered() {
           return quantityOrdered;
       }

       public synchronized String getCustomerName() {
           return customerName;
       }

       public synchronized void setItemOrdered(String itemOrdered) {
           this.itemOrdered = itemOrdered;
       }

       public synchronized void setQuantityOrdered(int quantityOrdered) {
           this.quantityOrdered = quantityOrdered;
       }

       public synchronized void setCustomerName(String customerName) {
           this.customerName = customerName;
       }
   }

   class ImmutableCustomerOrder {
       final private String itemOrdered;
       final private int quantityOrdered;
       final private String customerName;

       ImmutableCustomerOrder(String itemOrdered, int quantityOrdered, String customerName) {
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

       public double calculateOrderTotal (double price) {
           return getQuantityOrdered()*price;
       }
   }
}

