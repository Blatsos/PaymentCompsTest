package Payment.components.test.restControllers;

import Payment.components.test.entities.BusinessContact;
import Payment.components.test.repositories.BusinessRepo;
import Payment.components.test.services.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = {"Business Contact"})
@RequestMapping("/BusinessContact")
public class BusinessContactController {

    @Autowired
    BusinessService businessService;

    @Autowired
    BusinessRepo businessRepo;

    @GetMapping("/")
    public List<BusinessContact> getAllBusinessContacts(){
        return businessRepo.findAll();
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
