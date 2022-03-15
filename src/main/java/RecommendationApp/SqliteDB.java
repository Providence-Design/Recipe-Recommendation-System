
package RecommendationApp;

import java.sql.*;

public class SqliteDB {
  public  static  void main(String[] args){
    String jdbcUrl = "jdbc:sqlite:/C:\\Users\\USER\\Documents\\SQLiteDB\\sqlite-tools-win32-x86-3380100\\recipedb.db";
    try{
      Connection connection = DriverManager.getConnection(jdbcUrl);
      String sql = "SELECT * FROM recipe";
      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while(result.next()){
        String cuisine = result.getString("cuisine");
        String ingredient = result.getString("ingredient");

        System.out.println(cuisine + " | " + ingredient);
      }

    }catch (SQLException e){
      System.out.println("Error connecting to the SQLite database");
      e.printStackTrace();
    }
  }



}
