package com.epam.homework;

import java.util.List;

public class Author {

    String name;
    short age;
    List<Book> books;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }

    public Author(String name, short age) {
        this.age = age;
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
