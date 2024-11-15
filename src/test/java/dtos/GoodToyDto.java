package dtos;

public class GoodToyDto {
    private final String title;
    private final String brand;
    private final int recommendedAge;
    private final String category;

    public GoodToyDto(String title, String brand, int recommendedAge, String category) {
        this.title = title;
        this.brand = brand;
        this.recommendedAge = recommendedAge;
        this.category = category;
    }

    public String title() {
        return title;
    }

    public String brand() {
        return brand;
    }

    public int recommendedAge() {
        return recommendedAge;
    }

    public String category() {
        return category;
    }
}