package org.java17recipes.chapter12.recipe12_05;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.java17recipes.chapter12.recipe12_02.CreateConnection; 

public class CrudOperations {

   static CreateConnection createConn;

   public static void main(String[] args) {

       createConn = new CreateConnection();
       performCreate();
       performRead();
       performUpdate();
       performDelete();
       System.out.println("-- Final State --");
       performRead();

   }

   private static void performCreate() {
       String sql = "INSERT INTO RECIPES VALUES("
               + "null, "
               + "'12-5', "
               + "'Performing CRUD Operations', "
               + "'How to perform create, read, update, delete functions')";

       try (Connection conn = createConn.getConnection();
               Statement stmt = conn.createStatement();) {
           // Returns row-count or 0 if not successful
           int result = stmt.executeUpdate(sql);
           if (result == 1) {
               System.out.println("-- Record created --");
           } else {
               System.err.println("!! Record NOT Created !!");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }

   private static void performRead() {
       String qry = "select recipe_number, recipe_name, description from recipes";

       try (Connection conn = createConn.getConnection();
               Statement stmt = conn.createStatement();) {
           ResultSet rs = stmt.executeQuery(qry);
           while (rs.next()) {
               String recipe = rs.getString("RECIPE_NUMBER");
               String name = rs.getString("RECIPE_NAME");
               String desc = rs.getString("DESCRIPTION");

               System.out.println(recipe + "\t" + name + "\t" + desc);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }

   private static void performUpdate() {
       String sql = "UPDATE RECIPES "
               + "SET RECIPE_NUMBER = '12-5' "
               + "WHERE RECIPE_NUMBER = '12-4'";

       try (Connection conn = createConn.getConnection();
               Statement stmt = conn.createStatement();) {
           int result = stmt.executeUpdate(sql);
           if (result == 1) {
               System.out.println("-- Record Updated --");
           } else {
               System.err.println("!! Record NOT Updated !!");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }

   private static void performDelete() {
       String sql = "DELETE FROM RECIPES WHERE RECIPE_NUMBER = '12-5'";

       try (Connection conn = createConn.getConnection();
               Statement stmt = conn.createStatement();) {
           int result = stmt.executeUpdate(sql);
           System.out.println(result);
           if (result >0) {
               System.out.println("-- Record Deleted --");
           } else {
               System.err.println("!! Record NOT Deleted!!");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

}

