package first_homework.сollections_to_stream;

import first_homework.сollections_to_stream.beans.Author;
import first_homework.сollections_to_stream.beans.Book;

import java.util.*;
import java.util.stream.Collectors;

public class Fifth_Task {
    public static void main(String... args) {
        collectionsToStream();
    }

    //1.5 task
    private static void collectionsToStream() {
        Author firstAuthor = new Author("Tolstoy", (short) 50);
        Author secondAuthor = new Author("Ilf", (short) 30);
        Author thirdAuthor = new Author("Petrov", (short) 33);
        Author fourthAuthor = new Author("Bulgakov", (short) 40);

        Book firstBook = new Book("War and Peace", 2000);
        Book secondBook = new Book("Golden calf", 600);
        Book thirdBook = new Book("The Twelve Chairs", 500);
        Book fourthBook = new Book("Dog's heart", 400);

        firstAuthor.setBooks(Collections.singletonList(firstBook));
        secondAuthor.setBooks(Arrays.asList(secondBook, thirdBook));
        thirdAuthor.setBooks(Arrays.asList(secondBook, thirdBook));
        fourthAuthor.setBooks(Collections.singletonList(fourthBook));
        Author[] authors = {firstAuthor, secondAuthor, thirdAuthor, fourthAuthor};

        firstBook.setAuthors(Collections.singletonList(firstAuthor));
        secondBook.setAuthors(Arrays.asList(secondAuthor, thirdAuthor));
        thirdBook.setAuthors(Arrays.asList(secondAuthor, thirdAuthor));
        fourthBook.setAuthors(Collections.singletonList(fourthAuthor));
        Book[] books = {firstBook, secondBook, thirdBook, fourthBook};

        //5.2.1
        System.out.println(Arrays.stream(books)
                .allMatch(book -> book.getNumberOfPages() > 200)); // or anyMatch
        //5.2.2
        System.out.println(Arrays.stream(books)
                .min(Comparator.comparing(Book::getNumberOfPages)) //or max
                .get().getTitle());
        //5.2.3
        Arrays.stream(books)
                .filter(book -> book.getAuthors().size() == 1)
                .forEach(System.out::println);
        //5.2.4
        Arrays.stream(books)
                .sorted(Comparator.comparing(Book::getTitle)) //or Book::getNumberOfPages
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //5.2.5
        Arrays.stream(books)
                .map(Book::getTitle) //getting list of titles
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //5.2.6
        Arrays.stream(books)
                .forEach(System.out::println);
        //5.2.7
        Arrays.stream(books)
                .map(Book::getAuthors)
                .distinct()
                .collect(ArrayList::new, List::addAll, List::addAll)
                .forEach(System.out::println);
        //5.3
        Arrays.stream(books)
                .map(Book::getAuthors)
                .peek(System.out::println)
                .collect(Collectors.toList());
       //5.4
        Arrays.stream(books).parallel()
                .filter(book -> book.getAuthors().size() == 1)
                .forEach(System.out::println);
        //5.6
        Arrays.stream(authors)
                .filter(author -> ("Petrov").equals(author.getName()))
                .map(Author::getBooks)
                .map(bookList -> bookList.stream()
                        .max(Comparator.comparing(Book::getNumberOfPages)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
