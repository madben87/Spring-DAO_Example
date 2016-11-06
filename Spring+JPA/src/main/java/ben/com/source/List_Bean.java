package ben.com.source;

import ben.com.beans.Author;
import ben.com.beans.Books;

import java.util.List;

public class List_Bean {

    public static void listAuthor(List<Author> list) {
        System.out.println();
        System.out.println("List_Bean :");
        for (Author obj : list) {
            System.out.println();
            System.out.println(obj);
        }
    }

    public static void listAuthorWithBook(List<Author> list) {
        System.out.println();
        System.out.println("List Author :");
        for (Author author : list) {
            System.out.println();
            System.out.println(author);

            if (author.getBooksSet() != null) {
                for (Books books : author.getBooksSet()) {
                    System.out.println();
                    System.out.println(books);
                }
            }
        }
    }

    public static void listBook(List<Books> list) {
        System.out.println();
        System.out.println("List_Bean :");
        for (Books obj : list) {
            System.out.println();
            System.out.println(obj);
        }
    }

    public static void listBookWithAuthor(List<Books> list) {
        System.out.println();
        System.out.println("List Book :");
        for (Books books : list) {
            System.out.println();
            System.out.println(books);

            if (books.getAuthorSet() != null) {
                for (Author author : books.getAuthorSet()) {
                    System.out.println();
                    System.out.println(author);
                }
            }
        }
    }
}
