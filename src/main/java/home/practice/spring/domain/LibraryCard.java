package home.practice.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int cardNumber;

    @Column
    private String cardName;
}