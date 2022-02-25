package org.java17recipes.chapter12.recipe12_12;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import org.java17recipes.chapter12.recipe12_02.CreateConnection; 

public class DatesTimes {

   static CreateConnection createConn = new CreateConnection();

   public static void main(String[] args) {
       insertRecord(
               "Java 17 Recipes",
               "APRESS");
   }

   private static void insertRecord(
           String title,
           String publisher) {
       String sql = "INSERT INTO PUBLICATION VALUES("
               + "null, ?,?,?)";
       LocalDate pubDate = LocalDate.now();
       try (Connection conn = createConn.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql);) {
           pstmt.setString(1, title);
           pstmt.setDate(2,  java.sql.Date.valueOf(pubDate));
           pstmt.setString(3, publisher);
           pstmt.executeUpdate();
           System.out.println("Record successfully inserted.");
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   }
}

