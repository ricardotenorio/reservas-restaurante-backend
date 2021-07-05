package ricardotenorio.github.com.reservasrestaurantespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
