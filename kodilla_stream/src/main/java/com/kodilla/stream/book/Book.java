package com.kodilla.stream.book;

public class Book {

    private final String author;
    private final String title;
    private final int yearOfPublication;

    private final String id;

    public Book( final String  author,final String title,final int yearOfPublication, final String id) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.id=id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}
