package first_homework.collections_to_stream;

import first_homework.collections_to_stream.beans.Author;
import first_homework.collections_to_stream.beans.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Comparator.comparing;

public class Fifth_Task {
    public static void main(String[] args) {
        collectionsToStream();
    }

    /**
     * This task shows functional of streams
     */
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
        secondAuthor.setBooks(asList(secondBook, thirdBook));
        thirdAuthor.setBooks(asList(secondBook, thirdBook));
        fourthAuthor.setBooks(Collections.singletonList(fourthBook));
        Author[] authors = {firstAuthor, secondAuthor, thirdAuthor, fourthAuthor};

        firstBook.setAuthors(Collections.singletonList(firstAuthor));
        secondBook.setAuthors(asList(secondAuthor, thirdAuthor));
        thirdBook.setAuthors(asList(secondAuthor, thirdAuthor));
        fourthBook.setAuthors(Collections.singletonList(fourthAuthor));
        Book[] books = {firstBook, secondBook, thirdBook, fourthBook};

        //5.2.1
        System.out.println("5.2.1 Print some/all books with more than 200 pages:");
        System.out.println(stream(books)
                .allMatch(book -> book.getNumberOfPages() > 200)); // or anyMatch
        //5.2.2
        System.out.println("5.2.2 Find books with min(max) number of pages:");
        System.out.println(stream(books)
                .min(comparing(Book::getNumberOfPages)) //or max
                .get().getTitle());
        //5.2.3
        System.out.println("5.2.3 Print books with only single author");
        stream(books)
                .filter(book -> book.getAuthors().size() == 1)
                .forEach(System.out::println);
        //5.2.4
        System.out.println("5.2.4 Sort book by Title(number of pages)");
        stream(books)
                .sorted(comparing(Book::getTitle)) //or Book::getNumberOfPages
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //5.2.5
        System.out.println("5.2.5 Getting list of titles");
        stream(books)
                .map(Book::getTitle) //getting list of titles
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //5.2.6
        System.out.println("5.2.6 Print all books titles");
        stream(books)
                .map(Book::getTitle)
                .forEach(System.out::println);
        //5.2.7
        System.out.println("5.2.7 Retrieve distinct list of all authors");
        stream(books)
                .map(Book::getAuthors)
                .distinct()
                .collect(ArrayList::new, List::addAll, List::addAll)
                .forEach(System.out::println);
        //5.3
        System.out.println("5.3 Peek into stream while printing authors names");
        stream(books)
                .map(Book::getAuthors)
                .peek(System.out::println)
                .collect(Collectors.toList());
        //5.4
        System.out.println("5.4 Usage of parallel stream");
        stream(books).parallel()
                .filter(book -> book.getAuthors().size() == 1)
                .forEach(System.out::println);
        //5.6
        System.out.println("5.6 Usage of optional type");
        stream(authors)
                .filter(author -> ("Petrov").equals(author.getName()))
                .map(Author::getBooks)
                .map(bookList -> bookList.stream()
                        .max(comparing(Book::getNumberOfPages)))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Streaming with parallel: ");
        //5.2.1
        System.out.println("5.2.1 Print some/all books with more than 200 pages:");
        System.out.println(stream(books).parallel()
                .allMatch(book -> book.getNumberOfPages() > 200)); // or anyMatch
        //5.2.2
        System.out.println("5.2.2 Find books with min(max) number of pages:");
        System.out.println(stream(books).parallel()
                .min(comparing(Book::getNumberOfPages)) //or max
                .get().getTitle());
        System.out.println("May not working right in parallel");
        //5.2.3
        System.out.println("5.2.3 Print books with only single author");
        stream(books).parallel()
                .filter(book -> book.getAuthors().size() == 1)
                .forEach(System.out::println);
        //5.2.4
        System.out.println("5.2.4. Sort book by Title(number of pages)");
        stream(books).parallel()
                .sorted(comparing(Book::getTitle)) //or Book::getNumberOfPages
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //5.2.5
        System.out.println("5.2.5. Getting list of titles");
        stream(books).parallel()
                .map(Book::getTitle) //getting list of titles
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //5.2.6
        System.out.println("5.2.6 Print all books titles");
        stream(books).parallel()
                .map(Book::getTitle)
                .forEach(System.out::println);
        //5.2.7
        System.out.println("5.2.7 Retrieve distinct list of all authors");
        stream(books).parallel()
                .map(Book::getAuthors)
                .distinct()
                .collect(ArrayList::new, List::addAll, List::addAll)
                .forEach(System.out::println);

    }
}
