package domain;

import java.util.UUID;

public class Book {

    private final UUID id;
    private final String title;
    private final String author;
    private final String isbn;
    private final int publishedYear;
    private final int totalCopies;
    private int availableCopies;

    public Book(UUID id, String title, String author, String isbn, int publishedYear, int totalCopies) {
        this.id = id;
        validate(title, author, isbn, publishedYear, totalCopies);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getPublishedYear() {
        return publishedYear;
    }
    public int getTotalCopies() {
        return totalCopies;
    }
    public int getAvailableCopies() {
        return availableCopies;
    }

    public void validate(String title, String author, String isbn, int publishedYear, int totalCopies) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Autor não pode ser vazio.");
        }
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN não pode ser vazio.");
        }
        if (publishedYear <= 0) {
            throw new IllegalArgumentException("Ano de publicação inválido.");
        }
        if (totalCopies < 0) {
            throw new IllegalArgumentException("Número total de cópias não pode ser negativo.");
        }
    }

    public void borrowOne() {
        if (availableCopies <= 0) {
            throw new IllegalStateException("Não há cópias disponíveis para empréstimo.");
        }
        availableCopies--;
    }

    public void returnOne() {
        if (availableCopies >= totalCopies) {
            throw new IllegalStateException("Todas as cópias já estão na biblioteca.");
        }
        availableCopies++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Título='" + title + '\'' +
                ", Autor='" + author + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", Ano de publicação=" + publishedYear +
                ", Total de cópias=" + totalCopies +
                ", Cópias disponíveis=" + availableCopies +
                '}';
    }

}
