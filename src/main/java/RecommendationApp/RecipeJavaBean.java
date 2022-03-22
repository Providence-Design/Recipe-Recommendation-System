package RecommendationApp;

public class RecipeJavaBean {
    private String cuisine;
    private String ingredient;

    public RecipeJavaBean(String cuisine, String ingredient) {
        this.cuisine = cuisine;
        this.ingredient = ingredient;
    }

    public RecipeJavaBean() {

    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
