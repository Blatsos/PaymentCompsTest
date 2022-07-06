package Payment.components.test.services;

import Payment.components.test.entities.BusinessContact;

public interface BusinessServiceInterface {

    void save(BusinessContact businessContact);

    BusinessContact getById(int id);

    void deleteById(Integer id);

}
