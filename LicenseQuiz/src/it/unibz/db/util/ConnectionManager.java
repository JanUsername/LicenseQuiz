package it.unibz.db.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
   public static Connection getConnection(){
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/quiz",
            "postgres", "masterkey");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      return c;
   }
}