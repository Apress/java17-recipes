package org.java17recipes.chapter12.recipe12_07;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.java17recipes.chapter12.recipe12_02.CreateConnection; 

public class PreparedStatementExample {

   public static Connection conn = null;

   public static void main(String[] args) {
       try {
           CreateConnection createConn = new CreateConnection();
           conn = createConn.getConnection();
           String[] recipeArr = new String[1];
           recipeArr[0] ="12-1";
           queryDbRecipe(recipeArr);
           insertRecord(
                   "12-6",
                   "Simplifying and Adding Security with Prepared Statements",
                   "Working with Prepared Statements");
           recipeArr[0] ="12-6";
           queryDbRecipe(recipeArr);
           deleteRecord("12-6");
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

   private static void queryDbRecipe(String[] recipeNumbers) {
       String sql = "SELECT ID, RECIPE_NUMBER, RECIPE_NAME, DESCRIPTION "
               + "FROM RECIPES "
               + "WHERE RECIPE_NUMBER = ?";

       try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
           for (String recipeNumber : recipeNumbers) {
               pstmt.setString(1, recipeNumber);
               ResultSet rs = pstmt.executeQuery();
               while (rs.next()) {
                   System.out.println(rs.getString(2) + ": " + rs.getString(3)
                           + " - " + rs.getString(4));
               }
           }
       } catch (SQLException ex) {
           ex.printStackTrace();
       }

   }

   private static void insertRecord(String recipeNumber,
           String title,
           String description) {
       String sql = "INSERT INTO RECIPES VALUES("
               + "null, ?,?,?)";
       try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
           pstmt.setString(1, recipeNumber);
           pstmt.setString(2, title);
           pstmt.setString(3, description);
           pstmt.executeUpdate();
           System.out.println("Record successfully inserted.");
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   }

   private static void deleteRecord(String recipeNumber) {
       String sql = "DELETE FROM RECIPES WHERE "
               + "RECIPE_NUMBER = ?";
       try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
           pstmt.setString(1, recipeNumber);
           pstmt.executeUpdate();
           System.out.println("Recipe " + recipeNumber + " successfully deleted.");
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   }

}
