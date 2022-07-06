package Payment.components.test.repositories;


import Payment.components.test.entities.PersonalContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepo extends JpaRepository<PersonalContact, Integer> {
    PersonalContact findById(int id);

}
