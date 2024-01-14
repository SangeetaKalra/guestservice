package co.learning.guestbookservice2024.repositories;

import co.learning.guestbookservice2024.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Integer> {

     Optional<Guest> findGuestsByFirstName(String firstName);
}
