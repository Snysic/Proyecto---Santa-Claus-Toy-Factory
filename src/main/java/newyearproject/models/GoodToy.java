package newyearproject.models;

public class GoodToy extends Toy {

    private String brand;
    private int targetAge;
    private String category;

    
    public GoodToy(String title, boolean isGoodToy, String brand, int targetAge, String category) {
        super(title, isGoodToy);
        this.brand = brand;
        this.targetAge = targetAge;
        this.category = category;
    }

    @Override
    public String toString() {
        return "GoodToy{" +
                "title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", targetAge=" + targetAge +
                ", category='" + category + '\'' +
                '}';
    }
}