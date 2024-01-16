package co.learning.guestbookservice2024.controller;

import co.learning.guestbookservice2024.entities.Guest;
import co.learning.guestbookservice2024.services.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    GuestBookService service;

    @GetMapping("/all")
    public List<Guest> getAll(){
        return service.getAllGuests();
    }

    @GetMapping("/all/{id}")
    public Optional<Guest> getById(@PathVariable("id")Integer id){
        return service.getGuestById(id);
    }

    @GetMapping("/allByName/{firstName}")
    public Optional<Guest> getByFirstName(@PathVariable("firstName")String firstName){
        return service.getGuestByFirstName(firstName);
    }

    @PostMapping("/add")
    public Guest addGuest(@RequestBody Guest guest){
        return service.addOrUpdateGuest(guest);
    }

    @PostMapping("/update")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){
        ResponseEntity<Guest> guestResponseEntity;
        Optional<Guest> optionalGuest = service.updateGuest(guest);
        if(optionalGuest.isPresent()){
            guestResponseEntity = ResponseEntity.ok(guest);
        }
        else{
            guestResponseEntity = ResponseEntity.noContent().header("error message","Guest didn't found for id: "+guest.getGuestId()).build();
        }

        return guestResponseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public Optional<Guest> deleteById(@PathVariable("id")Integer id){
        return service.deleteGuestById(id);
    }

}
