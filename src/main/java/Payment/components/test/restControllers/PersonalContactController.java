package Payment.components.test.restControllers;


import Payment.components.test.entities.PersonalContact;
import Payment.components.test.repositories.PersonalRepo;
import Payment.components.test.services.PersonalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@Api(tags = {"Personal Contact"})
@RequestMapping("/PersonalContact")
public class PersonalContactController {

    @Autowired
    PersonalService personalService;

    @Autowired
    PersonalRepo personalRepo;

    @GetMapping("/")
    public List<PersonalContact> getAllPersonalContacts() {
        return personalRepo.findAll();
    }

    @GetMapping("/getAllPersonalContactsByLastName/{order}")
    @ApiOperation(value = "The default is by descending order", notes = "You can type asc to change to ascending order")
    public List<PersonalContact> getPersonalContactAscOrDes(@PathVariable String order) {
        List<PersonalContact> personalContacts = personalRepo.findAll(Sort.by(Sort.Direction.DESC, "lastName"));
        if (Objects.equals(order, "asc")) {
            personalContacts = personalRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
        }
        return personalContacts;
    }

    @PostMapping("/addPersonalContact")
    @ApiOperation(
            value = "Add a new personal contact")
    public void addPersonalContact(@RequestBody PersonalContact person) {
        person.setCreateDate(new Date());
        personalService.save(person);
    }

    @DeleteMapping("/deletePersonalContact/{id}")
    @ApiOperation(
            value = "Delete personal contact")
    public void deletePersonalContact(@PathVariable int id) {
        PersonalContact person = personalService.getById(id);
        personalService.deleteById(id);
    }

    @PutMapping("/updatePersonalContact/{id}")
    @ApiOperation(value = "Update personal contact", response = PersonalContact.class)
    public void updatePersonalContact(@RequestBody PersonalContact updatePersonalContact, @PathVariable int id) {
        PersonalContact personalContact = personalService.getById(id);

        if (updatePersonalContact.getFirstName() != null) {
            personalContact.setFirstName(updatePersonalContact.getFirstName());
        }
        if (updatePersonalContact.getLastName() != null) {
            personalContact.setLastName(updatePersonalContact.getLastName());
        }
        if (updatePersonalContact.getEmail() != null) {
            personalContact.setEmail(updatePersonalContact.getEmail());
        }
        if (updatePersonalContact.getPhone() != null) {
            personalContact.setPhone(updatePersonalContact.getPhone());
        }
//        personalContact.setCreateDate(updatePersonalContact.getCreateDate());
        personalService.save(personalContact);
    }
}
