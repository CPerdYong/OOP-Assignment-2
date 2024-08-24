import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        //----------RECIPE LIST----------//
        // Initialize recipes
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Pasta Primavera", "A delightful mix of pasta and fresh vegetables.", true, true, "ITALIAN"));
        recipes.add(new Recipe("Grilled Salmon", "Perfectly grilled salmon with a hint of herbs.", false, true, "AMERICAN"));
        recipes.add(new Recipe("Veggie Stir-Fry", "A speedy and wholesome stir-fry with veggies.", true, true, "ASIAN"));
        recipes.add(new Recipe("Chicken Curry", "A flavorful and spicy chicken curry.", false, true, "INDIAN"));
        recipes.add(new Recipe("Beef Stroganoff", "A creamy beef dish with mushrooms.", false, false, "RUSSIAN"));
        recipes.add(new Recipe("Caesar Salad", "A classic salad with a tangy dressing.", true, true, "AMERICAN"));

        // Add nutrients to each recipe
        recipes.get(0).setNutrients(new Nutrient(450, 10, 20, 50)); // Example nutrient values
        recipes.get(1).setNutrients(new Nutrient(350, 30, 15, 5));
        recipes.get(2).setNutrients(new Nutrient(400, 20, 10, 60));
        recipes.get(3).setNutrients(new Nutrient(500, 25, 30, 45));
        recipes.get(4).setNutrients(new Nutrient(700, 40, 50, 20));
        recipes.get(5).setNutrients(new Nutrient(250, 5, 10, 15));

        // Add ingredients to each recipe
        recipes.get(0).addIngredient(new Ingredient("Pasta", 200, "grams"));
        recipes.get(0).addIngredient(new Ingredient("Bell Pepper", 1, "unit"));
        recipes.get(0).addIngredient(new Ingredient("Olive Oil", 2, "tablespoons"));

        recipes.get(1).addIngredient(new Ingredient("Salmon", 1, "fillet"));
        recipes.get(1).addIngredient(new Ingredient("Lemon", 1, "slice"));
        recipes.get(1).addIngredient(new Ingredient("Dill", 1, "teaspoon"));

        recipes.get(2).addIngredient(new Ingredient("Tofu", 150, "grams"));
        recipes.get(2).addIngredient(new Ingredient("Bell Pepper", 100, "grams"));
        recipes.get(2).addIngredient(new Ingredient("Soy Sauce", 30, "milliliters"));

        recipes.get(3).addIngredient(new Ingredient("Chicken", 300, "grams"));
        recipes.get(3).addIngredient(new Ingredient("Curry Powder", 2, "tablespoons"));
        recipes.get(3).addIngredient(new Ingredient("Coconut Milk", 200, "milliliters"));

        recipes.get(4).addIngredient(new Ingredient("Beef", 400, "grams"));
        recipes.get(4).addIngredient(new Ingredient("Mushrooms", 150, "grams"));
        recipes.get(4).addIngredient(new Ingredient("Sour Cream", 100, "grams"));

        recipes.get(5).addIngredient(new Ingredient("Romaine Lettuce", 100, "grams"));
        recipes.get(5).addIngredient(new Ingredient("Croutons", 50, "grams"));
        recipes.get(5).addIngredient(new Ingredient("Caesar Dressing", 30, "milliliters"));

        //----------END OF RECIPE LIST----------//

        // Sort recipes by name
        Collections.sort(recipes);

        Scanner scanner = new Scanner(System.in);
        boolean continueChoosing = true;

        while (continueChoosing) {
            // Display the sorted list of recipes
            System.out.println(YELLOW + "\nAvailable Recipe Selections:" + RESET);
            for (int i = 0; i < recipes.size(); i++) {
                System.out.println((i + 1) + ". Recipe Title: " + recipes.get(i).getDescription());
            }

            Recipe selectedRecipe1 = null;
            Recipe selectedRecipe2 = null;

            // User selects first recipe
            while (selectedRecipe1 == null) {
                System.out.print(CYAN + "\nSelect the first recipe number you'd like to compare: " + RESET);
                int choice1 = scanner.nextInt();
                if (choice1 > 0 && choice1 <= recipes.size()) {
                    selectedRecipe1 = recipes.get(choice1 - 1);
                } else {
                    System.out.println(RED + "Invalid choice. Please select a valid recipe number." + RESET);
                }
            }

            // User selects second recipe
            while (selectedRecipe2 == null) {
                System.out.print(CYAN + "Select the second recipe number you'd like to compare: " + RESET);
                int choice2 = scanner.nextInt();
                if (choice2 > 0 && choice2 <= recipes.size()) {
                    selectedRecipe2 = recipes.get(choice2 - 1);
                } else {
                    System.out.println(RED + "Invalid choice. Please select a valid recipe number." + RESET);
                }
            }

            // Display the selected recipes details
            System.out.println(PURPLE + "\nFirst Recipe Selected:\n" + RESET);
            System.out.println(selectedRecipe1);

            System.out.println(PURPLE + "Second Recipe Selected:\n" + RESET);
            System.out.println(selectedRecipe2);

            // Compare cuisines and display the difference
            if (selectedRecipe1.getCuisine().equals(selectedRecipe2.getCuisine())) {
                System.out.println(GREEN + "Both recipes are from the same cuisine: " + selectedRecipe1.getCuisine() + RESET);
            } else {
                System.out.println(RED + "The recipes are from different cuisines:" + RESET);
                System.out.println("First Recipe Cuisine: " + selectedRecipe1.getCuisine());
                System.out.println("Second Recipe Cuisine: " + selectedRecipe2.getCuisine());
            }

            // Compare nutrients and display the difference
            System.out.println(YELLOW + "\nNutrient Comparison:" + RESET);
            Nutrient nutrientDifference = selectedRecipe1.getNutrients().difference(selectedRecipe2.getNutrients());
            System.out.println(BLUE + "Nutrient Differences: " + nutrientDifference + RESET);

            // Ask if the user wants to continue
            System.out.print(CYAN + "\nWould you like to compare more recipes? (yes/no): " + RESET);
            String userResponse = scanner.next().trim().toLowerCase();
            if (!userResponse.equals("yes")) {
                continueChoosing = false;
                System.out.println(GREEN + "💖💖Thank you for using Me!💖💖" + RESET);
            }
        }
    }
}