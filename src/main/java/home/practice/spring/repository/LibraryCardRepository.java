package home.practice.spring.repository;

import home.practice.spring.domain.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard,Long> {
}
