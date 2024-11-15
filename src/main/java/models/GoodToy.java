package models;

public class GoodToy extends Toy {
    private String brand;
    private int targetAge;
    private String category;

    public GoodToy(String title, String brand, int targetAge, String category) {
        super(title, true);
        this.brand = brand;
        this.targetAge = targetAge;
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public int getTargetAge() {
        return targetAge;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Título: %s, Marca: %s, Edad Recomendada: %d, Categoría: %s",
                title, brand, targetAge, category);
    }
}