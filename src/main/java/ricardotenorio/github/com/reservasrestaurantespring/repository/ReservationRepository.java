package ricardotenorio.github.com.reservasrestaurantespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
