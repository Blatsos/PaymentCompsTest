package Payment.components.test.restControllers;

import Payment.components.test.entities.BusinessContact;
import Payment.components.test.repositories.BusinessRepo;
import Payment.components.test.services.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api(tags = {"Business Contact"})
@RequestMapping("/BusinessContact")
public class BusinessContactController {

    @Autowired
    BusinessService businessService;

    @Autowired
    BusinessRepo businessRepo;

    @GetMapping("/")
    public List<BusinessContact> getAllBusinessContacts() {
        return businessRepo.findAll();
    }

    @GetMapping("/getAllBusinessContactsByLastName/{order}")
    @ApiOperation(value = "Get all business contacts by their Last Name", notes = "The default is by descending order. You can type asc to change to ascending order")
    public List<BusinessContact> getBusinessContactAscOrDes(@PathVariable String order) {
        List<BusinessContact> businessContacts = businessRepo.findAll(Sort.by(Sort.Direction.DESC, "lastName"));
        if (Objects.equals(order, "asc")) {
            businessContacts = businessRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
        }
        return businessContacts;
    }

    @GetMapping("/getAllBusinessContactsByCreateDate/{order}")
    @ApiOperation(value = "Get all business contacts by their creation date", notes = "The default is by descending order. You can type asc to change to ascending order")
    public List<BusinessContact> getBusinessContactsByCreateDate(@PathVariable String order) {
        List<BusinessContact> businessContacts = businessRepo.findAll(Sort.by(Sort.Direction.DESC, "createDate"));
        if (Objects.equals(order, "asc")) {
            businessContacts = businessRepo.findAll(Sort.by(Sort.Direction.ASC, "createDate"));
        }
        return businessContacts;
    }

    @GetMapping("/getResultsBySearch/{search}")
    @ApiOperation(
            value = "Get results by searching")

    public List<BusinessContact> getBySearch(@PathVariable String search) {
        List<BusinessContact> matches = new ArrayList<>();
        List<BusinessContact> list = businessRepo.findAll();
        for (BusinessContact person : list) {
            if (person.getLastName().toLowerCase(Locale.ROOT).equals(search.toLowerCase(Locale.ROOT))
                    || person.getFirstName().toLowerCase(Locale.ROOT).equals(search.toLowerCase(Locale.ROOT))) {
                matches.add(person);
            }
        }
        Comparator<BusinessContact> compareLastName = (person1, person2) -> person1.getLastName().compareTo(person2.getLastName());
        Collections.sort(matches, compareLastName);
        return matches;
    }


    @PostMapping("/addBusinessContact")
    @ApiOperation(value = "Add a new business contact")
    public void addBusinessContact(@RequestBody BusinessContact person) {
        person.setCreateDate(new Date());
        businessService.save(person);
    }

    @DeleteMapping("/deleteBusinessContact/{id}")
    @ApiOperation(value = "Delete business contact")
    public void deleteBusinessContact(@PathVariable int id) {
        businessService.deleteById(id);
    }

    @PutMapping("/updateBusinessContact/{id}")
    @ApiOperation(value = "Update business contact", response = BusinessContact.class)
    public void updateBusinessContact(@RequestBody BusinessContact updateBusinessContact, @PathVariable int id) {
        BusinessContact businessContact = businessService.getById(id);

        if (updateBusinessContact.getFirstName() != null) {
            businessContact.setFirstName(updateBusinessContact.getFirstName());
        }
        if (updateBusinessContact.getLastName() != null) {
            businessContact.setLastName(updateBusinessContact.getLastName());
        }
        if (updateBusinessContact.getEmail() != null) {
            businessContact.setEmail(updateBusinessContact.getEmail());
        }
        if (updateBusinessContact.getPhone() != null) {
            businessContact.setPhone(updateBusinessContact.getPhone());
        }
        if (updateBusinessContact.getCompany() != null) {
            businessContact.setCompany(updateBusinessContact.getCompany());
        }
        if (updateBusinessContact.getBusinessTitle() != null) {
            businessContact.setBusinessTitle(updateBusinessContact.getBusinessTitle());
        }
        if (updateBusinessContact.getWebsiteUrl() != null) {
            businessContact.setWebsiteUrl(updateBusinessContact.getWebsiteUrl());
        }
//        businessContact.setCreateDate(updateBusinessContact.getCreateDate());
        businessService.save(businessContact);
    }
}
