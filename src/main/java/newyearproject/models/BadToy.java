package newyearproject.models;


class BadToy extends Toy {

    private String content;

    public BadToy(String title, boolean isGoodToy, String content) {
        super(title, isGoodToy);
        this.content = content;
    }

    @Override
    public String toString() {
        return "BadToy{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
