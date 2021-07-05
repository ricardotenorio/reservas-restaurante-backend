package ricardotenorio.github.com.reservasrestaurantespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
