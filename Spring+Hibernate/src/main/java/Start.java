import ben.com.entity.Author;
import ben.com.entity.Books;
import ben.com.entity.dao.BookDao;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Start {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("Start.xml");
        /*ctx.load("Start.xml");
        ctx.refresh();*/

        BookDao bookDao = ctx.getBean("bookDao", BookDao.class);

        //listBooks(bookDao.findBooks());

        listBooksWithAuthors(bookDao.findBookWithAuthors());

        /*Books book = bookDao.findBookWithAuthorById(1);
        System.out.println();
        System.out.println("Book list :");
        System.out.println();
        System.out.println(book.toString());*/

        /*Books book = bookDao.findBookWithAuthorByName("Spring 4 for professionals");
        book.setName_book("Spring 4 for professionals.4 Edition");
        bookDao.save(book);*/

        /*Books book = new Books();
        book.setName_book("Spring 4 for professionals");
        book.setYear_publishing("2014");
        Author author = new Author();
        author.setName("Chris");
        author.setSurname("Schaefer");
        author.setDate_birth(new Date(1965, 6, 7));
        book.addAuthor(author);
        bookDao.save(book);*/

        /*Books book = bookDao.findBookWithAuthorById(15);
        bookDao.delete(book);*/
    }

    private static void listBooks(List<Books> book_list) {
        System.out.println();
        System.out.println("Book list :");
        System.out.println();
        for (Books books : book_list) {
            System.out.println(books);
            System.out.println();
        }
    }

    private static void listBooksWithAuthors(List<Books> book_list) {
        System.out.println();
        System.out.println("Book list :");
        System.out.println();
        for (Books books : book_list) {
            System.out.println(books);
            if (books.getAuthorSet() != null) {
                for (Author author : books.getAuthorSet()) {
                    System.out.println(author);
                }
                System.out.println();
            }
        }
    }
}
