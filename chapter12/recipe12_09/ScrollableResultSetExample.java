package org.java17recipes.chapter12.recipe12_09;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.java17recipes.chapter12.recipe12_02.CreateConnection; 

public class ScrollableResultSetExample {
   public static Connection conn = null;

   public static void main(String[] args) {
       boolean successFlag = false;
       try {
           CreateConnection createConn = new CreateConnection();
           conn = createConn.getConnection(); 
           // Perform Scrollable Query
           queryDbRecipes();
           
           
       } catch (java.sql.SQLException ex) {
           System.out.println(ex);
       } finally {
           if (conn != null) {
               try {
                   conn.close();
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
           }
       }

   }

   private static void queryDbRecipes(){
       String sql = "SELECT ID, RECIPE_NUMBER, RECIPE_NAME, DESCRIPTION " +
                    "FROM RECIPES";

       try(PreparedStatement pstmt =conn.prepareStatement(sql, 
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs = pstmt.executeQuery()) {

           rs.first();
           System.out.println(rs.getString(2) + ": " + rs.getString(3) + 
                           " - " + rs.getString(4));
           rs.next();
           System.out.println(rs.getString(2) + ": " + rs.getString(3) + 
                           " - " + rs.getString(4));
           rs.previous();
           System.out.println(rs.getString(2) + ": " + rs.getString(3) + 
                           " - " + rs.getString(4));
           rs.last();
           System.out.println(rs.getString(2) + ": " + rs.getString(3) + 
                           " - " + rs.getString(4));
       } catch (SQLException ex) {
           ex.printStackTrace();
       } 

   }
   

}
