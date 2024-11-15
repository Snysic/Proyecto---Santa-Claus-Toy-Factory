package models;

public class BadToy extends Toy {
    private String content;

    public BadToy(String title, String content) {
        super(title, false);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return String.format("Título: %s, Contenido: %s", title, content);
    }
}
