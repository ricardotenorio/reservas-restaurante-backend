package ricardotenorio.github.com.reservasrestaurantespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ricardotenorio.github.com.reservasrestaurantespring.dto.RestaurantDTO;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Restaurant;

@Mapper
public interface RestaurantMapper {

  RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

  Restaurant toModel(RestaurantDTO restaurantDTO);

  RestaurantDTO toDTO(Restaurant restaurant);

}
