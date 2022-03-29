package RecommendationApp;

public class Recipe {
    private String cuisine;
    // TODO:// figure out how to change this to a better datastructure for holding a collection of ingredients
    // TODO:// What are the different possible collections types you can use and what is the difference between them
    //  e.g. set, list, map etc
    private String ingredient;

    public Recipe(String cuisine, String ingredient) {
        this.cuisine = cuisine;
        this.ingredient = ingredient;
    }

    public Recipe() {

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
