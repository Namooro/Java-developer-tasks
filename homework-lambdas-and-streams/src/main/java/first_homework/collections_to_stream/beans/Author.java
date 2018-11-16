package first_homework.collections_to_stream.beans;

import java.util.List;

public class Author {

    private String name;
    private short age;
    private List<Book> books;

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
