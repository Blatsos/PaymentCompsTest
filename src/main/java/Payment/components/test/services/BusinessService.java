package Payment.components.test.services;


import Payment.components.test.entities.BusinessContact;
import Payment.components.test.repositories.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService implements BusinessServiceInterface {

    @Autowired
    BusinessRepo businessRepo;

    @Override
    public void save(BusinessContact businessContact) {
        businessRepo.save(businessContact);
    }

    @Override
    public BusinessContact getById(int id) {
        return businessRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        businessRepo.deleteById(id);
    }
}
