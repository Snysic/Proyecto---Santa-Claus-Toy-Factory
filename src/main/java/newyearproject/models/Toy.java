package newyearproject.models;

public class Toy {
    protected String id;
    protected String title;
    protected boolean isGoodToy;

    public Toy(String title, boolean isGoodToy) {
        this.title = title;
        this.isGoodToy = isGoodToy;
    }

    public Toy(String id, String title, boolean isGoodToy) {
        this.id = id;
        this.title = title;
        this.isGoodToy = isGoodToy;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (isGoodToy ? "B" : "M") + id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGoodToy() {
        return isGoodToy;
    }

    public void setGoodToy(boolean goodToy) {
        isGoodToy = goodToy;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", isGoodToy=" + isGoodToy +
                '}';
    }
}