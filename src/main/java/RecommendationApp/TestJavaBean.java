package RecommendationApp;

public class TestJavaBean {
    public static void main(String[] args){
        Recipe recipe = new Recipe();
        recipe.setCuisine("chinese");
        recipe.setIngredient("low sodium soy sauce\",\n" +
                "      \"fresh ginger\",\n" +
                "      \"dry mustard\",\n" +
                "      \"green beans\",\n" +
                "      \"white pepper\",\n" +
                "      \"sesame oil\",\n" +
                "      \"scallions\",\n" +
                "      \"canola oil\",\n" +
                "      \"sugar\",\n" +
                "      \"Shaoxing wine\",\n" +
                "      \"garlic\",\n" +
                "      \"ground turkey\",\n" +
                "      \"water\",\n" +
                "      \"crushed red pepper flakes\",\n" +
                "      \"corn starch\"");
        System.out.println(recipe.getCuisine()+ " " + recipe.getIngredient());
    }
}
