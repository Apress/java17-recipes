package org.java17recipes.chapter12.recipe12_04;


import java.sql.Statement;

import org.java17recipes.chapter12.recipe12_02.CreateConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException; 

public class QueryDatabase {

private static CreateConnection createConn;

   public static void main(String[] args) {

       createConn = new CreateConnection();

       queryDatabase();

   }

   public static void queryDatabase() {
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
}

