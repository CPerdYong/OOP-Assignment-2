public class Nutrient {
    private double calories;
    private double protein;
    private double fats;
    private double carbs;

    public Nutrient(double calories, double protein, double fats, double carbs) {
        this.calories = calories;
        this.protein = protein;
        this.fats = fats;
        this.carbs = carbs;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbs() {
        return carbs;
    }

    public void add(Nutrient other) {
        this.calories += other.calories;
        this.protein += other.protein;
        this.fats += other.fats;
        this.carbs += other.carbs;
    }

    public String toString() {
        return Main.CYAN + "Calories: " + calories + " kcal, Protein: " + protein + " g, Fats: " + fats + " g, Carbs: " + carbs + " g" + Main.RESET;
    }

    public Nutrient difference(Nutrient other) {
        return new Nutrient(
                Math.abs(this.calories - other.calories),
                Math.abs(this.protein - other.protein),
                Math.abs(this.fats - other.fats),
                Math.abs(this.carbs - other.carbs)
        );
    }
}
