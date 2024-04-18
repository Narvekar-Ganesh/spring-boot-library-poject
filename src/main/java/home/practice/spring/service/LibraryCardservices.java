package home.practice.spring.service;

import home.practice.spring.domain.LibraryCard;
import home.practice.spring.repository.LibraryCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryCardservices {
    private  static final Logger LOGGER= LoggerFactory.getLogger(LibraryCardservices.class);

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public LibraryCard getLibraryCardById(Long id){
        LibraryCard libraryCard = null;
        try {
            libraryCard = libraryCardRepository.getById(id);
        }catch (Exception entityNotFoundException){
            libraryCard =null;
        }
            System.out.println("LibraryCardservices.getLibraryCardById - librarycard from database:" + libraryCard);
        LOGGER.info("Library from database:{}",libraryCard);

        return libraryCard;
    }



    public LibraryCard saveLibraryCard(LibraryCard libraryCard){
        return libraryCardRepository.save(libraryCard);
    }

    public void deleteLibraryCard(Long id){
        libraryCardRepository.deleteById(id);
    }

    public LibraryCard findLibraryCardByCardname(String cardName){
        return libraryCardRepository.findByCardName(cardName);
    }

    public int deleteByCardNumber(int cardNumber){
        return libraryCardRepository.deleteByCardNumber(cardNumber);
    }
}
