import java.util.ArrayList;
import java.util.List;

public class Recipe implements RecipeOperations, RecipeUtilities, Comparable<Recipe>, Cloneable {
    private String name;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private boolean isVegetarian;
    private boolean isSuitableForDiet;
    private String cuisine;
    private Nutrient nutrients;

    public Recipe(String name, String description, boolean isVegetarian, boolean isSuitableForDiet, String cuisine) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
        this.isVegetarian = isVegetarian;
        this.isSuitableForDiet = isSuitableForDiet;
        this.cuisine = cuisine;
        this.nutrients = new Nutrient(0, 0, 0, 0); // Default nutrients
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void scaleRecipe(double factor) {
        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            double newQuantity = ingredient.getQuantity() * factor;
            ingredients.set(i, new Ingredient(ingredient.getName(), newQuantity, ingredient.getUnit()));
        }
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    @Override
    public int getTotalIngredients() {
        return ingredients.size();
    }

    public String getCuisine() {
        return cuisine;
    }

    public Nutrient getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrient nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public Recipe clone() {
        try {
            Recipe cloned = (Recipe) super.clone();
            cloned.ingredients = new ArrayList<>(this.ingredients); // Deep copy of ingredients
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported for this object", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recipe Name: ").append(name).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Ingredients:\n");
        for (Ingredient ingredient : ingredients) {
            sb.append(ingredient.toString()).append("\n");
        }
        sb.append("The cuisine is from: ").append(cuisine).append("\n");
        sb.append("Nutrients: ").append(nutrients.toString()).append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Recipe other) {
        return this.name.compareTo(other.name);
    }
}
