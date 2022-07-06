package Payment.components.test.services;


import Payment.components.test.entities.PersonalContact;
import Payment.components.test.repositories.PersonalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalService implements PersonalServiceInterface {

    @Autowired
    PersonalRepo personalRepo;

    @Override
    public void save(PersonalContact person) {
        personalRepo.save(person);
    }

    @Override
    public PersonalContact getById(int id) {
        return personalRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        personalRepo.deleteById(id);
    }
}
