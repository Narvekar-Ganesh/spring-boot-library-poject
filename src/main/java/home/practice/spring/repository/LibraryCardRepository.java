package home.practice.spring.repository;

import home.practice.spring.domain.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard,Long> {

    LibraryCard findByCardName(String cardName);

    @Transactional
    int  deleteByCardNumber(int cardNumber);
}
