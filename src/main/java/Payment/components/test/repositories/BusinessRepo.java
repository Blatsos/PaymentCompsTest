package Payment.components.test.repositories;

import Payment.components.test.entities.BusinessContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepo extends JpaRepository<BusinessContact, Integer> {
    BusinessContact findById(int id);
}