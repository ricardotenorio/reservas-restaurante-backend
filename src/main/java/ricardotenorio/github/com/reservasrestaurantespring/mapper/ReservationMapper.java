package ricardotenorio.github.com.reservasrestaurantespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ricardotenorio.github.com.reservasrestaurantespring.dto.ReservationDTO;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Reservation;

@Mapper
public interface ReservationMapper {

  ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);
  
  Reservation toModel(ReservationDTO reservationDTO);

  ReservationDTO toDTO(Reservation reservation);

}
