package Payment.components.test.repositories;

import Payment.components.test.entities.BusinessContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepo extends JpaRepository<BusinessContact, Integer> {

    @Override
    Page<BusinessContact> findAll(Pageable pageable);

    BusinessContact findById(int id);
}