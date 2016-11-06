package ben.com;

import ben.com.interfaces.BeanDao;
import ben.com.source.List_Bean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("Start_JPA.xml");
        BeanDao authorDao = context.getBean("authorDao", BeanDao.class);
        BeanDao bookDao = context.getBean("bookDao", BeanDao.class);


        //new List_Bean().listAuthor(authorDao.findAll());
        new List_Bean().listBook(bookDao.findAll());

        //new List_Bean().listAuthorWithBook(authorDao.findListWith());
        //new List_Bean().listBookWithAuthor(bookDao.findListWith());

        /*Books books = (Books) bookDao.findBeanById(new Scanner(System.in).nextInt());
        System.out.println(books);*/

        /*Books books = (Books) bookDao.findBeanByName("Java 2");
        System.out.println(books);*/

        /*Books book = new Books();
        book.setName_book("Mirror");
        book.setYear_publishing("2006");
        bookDao.save(book);*/

        /*List books = bookDao.findAll();
        bookDao.delete((Books) bookDao.findBeanById(books.size()));*/

    }
}
