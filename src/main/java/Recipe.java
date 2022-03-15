import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Recipe {
    public static void main(String[] args){
        String filePath = "DataFolder/recipes.csv";
        System.out.println(usingBufferedReader(filePath));
    }

    private static String usingBufferedReader(String filePath) {
        StringBuilder recipeBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
           String recipeCurrentLine;
           while((recipeCurrentLine = br.readLine()) != null){
               recipeBuilder.append(recipeCurrentLine).append("\n");
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipeBuilder.toString();
    }


}
