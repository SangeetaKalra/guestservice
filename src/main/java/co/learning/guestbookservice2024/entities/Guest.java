package co.learning.guestbookservice2024.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int guestId;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name="addressId")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Transient
    @Builder.Default
    private Instant createDateTime = Instant.now();

}
