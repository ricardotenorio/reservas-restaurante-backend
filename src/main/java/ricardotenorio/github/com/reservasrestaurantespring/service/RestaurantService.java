package ricardotenorio.github.com.reservasrestaurantespring.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricardotenorio.github.com.reservasrestaurantespring.dto.RestaurantDTO;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Restaurant;
import ricardotenorio.github.com.reservasrestaurantespring.exception.RestaurantNotFoundException;
import ricardotenorio.github.com.reservasrestaurantespring.mapper.RestaurantMapper;
import ricardotenorio.github.com.reservasrestaurantespring.repository.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RestaurantService {

  private RestaurantRepository restaurantRepository;

  private final RestaurantMapper restaurantMapper = RestaurantMapper.INSTANCE;

  public String createRestaurant(RestaurantDTO restaurantDTO) {
    Restaurant restaurantToSave = restaurantMapper.toModel(restaurantDTO);

    Restaurant savedRestaurant = restaurantRepository.save(restaurantToSave);

    return "Created restaurant with ID " + savedRestaurant.getId();
  }

  public List<RestaurantDTO> listAll() {
    List<Restaurant> restaurants = restaurantRepository.findAll();

    return restaurants.stream()
        .map(restaurantMapper::toDTO)
        .collect(Collectors.toList());
  }

  public RestaurantDTO findById(Long id) throws RestaurantNotFoundException {
    Restaurant restaurant = verifyIfExists(id);

    return restaurantMapper.toDTO(restaurant);
  }

  public void deleteById(Long id) throws RestaurantNotFoundException {
    verifyIfExists(id);

    restaurantRepository.deleteById(id);
  }

  public String updateById(Long id, RestaurantDTO restaurantDTO) throws RestaurantNotFoundException {
    Restaurant oldrestaurant = verifyIfExists(id);

    restaurantDTO.setId(id);
    restaurantDTO.getMenu().setId(oldrestaurant.getMenu().getId());

    Restaurant restaurantToUpdate = restaurantMapper.toModel(restaurantDTO);

    Restaurant updatedRestaurant = restaurantRepository.save(restaurantToUpdate);

    return "Updated restaurant with ID " + updatedRestaurant.getId();
  }

  private Restaurant verifyIfExists(Long id) throws RestaurantNotFoundException {
    return restaurantRepository.findById(id)
        .orElseThrow(() -> new RestaurantNotFoundException(id));
  }

}
