package co.learning.guestbookservice2024.services;

import co.learning.guestbookservice2024.entities.Address;
import co.learning.guestbookservice2024.entities.Guest;
import co.learning.guestbookservice2024.repositories.AddressRepo;
import co.learning.guestbookservice2024.repositories.GuestRepo;
import co.learning.guestbookservice2024.repositories.ReviewRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class GuestBookService {

    private final GuestRepo repo;
    private final AddressRepo addressRepo;
    private final ReviewRepo reviewRepo;
    public List<Guest> getAllGuests(){
        return repo.findAll();
    }

    public Optional<Guest> getGuestById(Integer id){
        return repo.findById(id);
    }

    public Optional<Guest> getByFirstName(String firstName){
        return repo.findGuestsByFirstName(firstName);
    }

    public Guest addOrUpdateGuest(Guest guest){
        return repo.save(guest);
    }

    public Optional<Guest> deleteGuestById(Integer id){
        Optional<Guest> guestById=getGuestById(id);
        if(guestById.isPresent()){
            repo.deleteById(id);
            return guestById;
        }
        return Optional.empty();
    }

    public Optional<Guest> updateGuest(Guest guest){
        Optional<Guest> guestById=getGuestById(guest.getGuestId());
        if(guestById.isPresent()){
            addOrUpdateGuest(guest);
            return Optional.of(addOrUpdateGuest(guest));
        }
        return Optional.empty();
    }
}
