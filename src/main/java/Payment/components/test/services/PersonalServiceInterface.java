package Payment.components.test.services;


import Payment.components.test.entities.PersonalContact;

public interface PersonalServiceInterface {

    void save(PersonalContact personal);

    PersonalContact getById(int id);

    void deleteById(Integer id);
}
