package home.practice.spring.service;

import home.practice.spring.domain.Book;
import home.practice.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long id){
        Book book = null;
        try{
            book = bookRepository.getById(id);
        }catch(Exception entityNotFoundException){
            book = null;
        }
        System.out.println("BookService.getBookById() - book from database : " + book);
        return book;
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book  updateBook( Book  book){
         return  bookRepository.saveAndFlush(book);
    }

    public Book getBookByBookName(String bookName){
        return bookRepository.findByBookName(bookName);
    }

    public Book getBookByAuther(String autherName){
       return bookRepository.findByAutherName(autherName);
    }

    public Book getBookByBookNameAutherName(String bookName,String autherName){
        return bookRepository.findByBookNameAndAutherName(bookName,autherName);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id)   ;
    }

    @Transactional
     public Long deleteBookByBookName(String bookName){
        return bookRepository.deleteByBookName(bookName);
     }
}
