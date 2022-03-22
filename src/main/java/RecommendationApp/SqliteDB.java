
package RecommendationApp;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class SqliteDB {
  private static String[] header;

  public  static  void main(String[] args){
    String jdbcUrl = "jdbc:sqlite:/C:\\Users\\USER\\Documents\\SQLiteDB\\sqlite-tools-win32-x86-3380100\\recipedb.db";
    //reading from the CSV file into the database using super csv library
    String csvFilePath = "DataFolder/recipes.csv";
    int batchSize = 20;

    ICsvBeanReader beanReader = null;
    CellProcessor[] processors = new CellProcessor[]{
            new NotNull(),//cuisine
            new NotNull()//ingredient
    };

    try {
      Connection connection = DriverManager.getConnection(jdbcUrl);
      connection.setAutoCommit(false);
      String sql = "INSERT INTO recipe(cuisine, ingredient) VALUES(?,?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      beanReader = new CsvBeanReader(new FileReader(csvFilePath),
              CsvPreference.STANDARD_PREFERENCE);
      beanReader.getHeader(true);
      String[] header = {"cuisine", "ingredient"};
      RecipeJavaBean bean = null;

      int count = 0;

      while ((bean = beanReader.read(RecipeJavaBean.class, header, processors)) != null) {
        String cuisineName = bean.getCuisine();
        String ingredients = bean.getIngredient();

        statement.setString(1, cuisineName);
        statement.setString(2, ingredients);
        statement.addBatch();

        if (count % batchSize == 0) {
          statement.executeBatch();
        }
      }
      beanReader.close();
      String sql2 = "SELECT * FROM recipe";
      Statement statement2 = connection.createStatement();
      ResultSet result = statement2.executeQuery(sql2);
      while(result.next()){
      String cuisine = result.getString("cuisine");
      String ingredient = result.getString("ingredient");

      System.out.println(cuisine + " | " + ingredient);
      }

      statement.executeBatch();
      connection.commit();

     // String sql2 = "SELECT * FROM recipe";
      //Statement statement2 = connection.createStatement();
      //ResultSet result = statement.executeQuery(sql);
      //while(result.next()){
        //String cuisine = result.getString("cuisine");
        //String ingredient = result.getString("ingredient");

        //System.out.println(cuisine + " | " + ingredient);
      //}

    }catch (IOException ex){
      System.out.println(ex);
    }
    catch (SQLException e){
      System.out.println("Error connecting to the SQLite database");
      e.printStackTrace();
    }
  }



}
