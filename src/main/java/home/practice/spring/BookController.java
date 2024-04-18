package home.practice.spring;


import home.practice.spring.domain.Book;
import home.practice.spring.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class BookController {
    private  static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/api/v1/book" , method = RequestMethod.GET)
    public   Book getBookById(@RequestParam("id") Long id) {
        System.out.println("BookController.getBookById - id : " + id);
        Book response = bookService.getBookById(id);
        return response;
    }

    @RequestMapping(value = "/api/v1/book/book-name" , method = RequestMethod.GET)
    public   Book getBookByBookName(@RequestParam("book-name") String bookName) {
        System.out.println("BookController.getBookByBookName - bookName : " + bookName);
        LOGGER.info("Book-name: {}",bookName);
        Book response = bookService.getBookByBookName(bookName);
        return response;
    }

            @RequestMapping(value = "/api/v1/book/book-author" , method = RequestMethod.GET)
         public  Book findByAutherName(@RequestParam("auther-name") String autherName) {
        System.out.println("BookController.getBookByBookName - auther-name : " + autherName);
        LOGGER.info(" auther-name: {}" ,autherName);
        Book response = bookService.getBookByAuther(autherName);
        return response;
    }

    @RequestMapping(value = "/api/v1/book/book-author-name" , method = RequestMethod.GET)
    public  Book findByBookNameAndAutherName(@RequestParam("book-name") String bookName , @RequestParam("auther-name") String autherName) {
        System.out.println("BookController.getBookByBookName - auther-name : "  +bookName + autherName);
        LOGGER.info(" bookName: {} auther-name: {}",bookName,autherName);
        Book response = bookService.getBookByBookNameAutherName(bookName,autherName);
        return response;
    }

    @RequestMapping(value = "/api/v1/book" , method = RequestMethod.PUT)
    public @ResponseBody  Book saveBook(@RequestBody Book book) {
        System.out.println("BookController.saveBook - book : " + book);
        LOGGER.info("book: {}",book);
        Book response = bookService.saveBook(book);
        System.out.println("Book is saved : " + response);
        LOGGER.info("Book is saved :{} ",response);
        return response;
    }

        @RequestMapping(value = "/api/v1/book" , method = RequestMethod.DELETE)
         public String deleteBookById(@RequestParam("id") Long id){
        bookService.deleteBookById(id);
        return "Book has been deleted successfully";
    }


    @RequestMapping(value = "/api/v1/book/book-name" , method = RequestMethod.DELETE)
    public String deleteByBookName(@RequestParam("book-name") String bookName){
        System.out.println( "deleteByBookName : "  +bookName);
        LOGGER.info("Delete Book -name:",bookName);
        bookService.deleteBookByBookName(bookName);
        return "Book has been deleted successfully";
    }

    @RequestMapping(value = "/api/v1/book" , method = RequestMethod.POST)
    public @ResponseBody  Book updateBook(@RequestBody Book autherName) {
        System.out.println("BookController.saveBook - book : " + autherName);
        Book   response = bookService.updateBook(autherName);
        System.out.println("Book is saved : " + response);
        LOGGER.info("Book is saved :",response);
        return response;
    }

    public static void main(String[] args) {
            SpringApplication.run(BookController.class,args);
    }
}
