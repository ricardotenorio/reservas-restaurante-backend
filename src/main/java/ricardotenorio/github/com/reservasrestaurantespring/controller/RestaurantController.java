package ricardotenorio.github.com.reservasrestaurantespring.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ricardotenorio.github.com.reservasrestaurantespring.dto.RestaurantDTO;
import ricardotenorio.github.com.reservasrestaurantespring.exception.RestaurantNotFoundException;
import ricardotenorio.github.com.reservasrestaurantespring.service.RestaurantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RestaurantController {

  private RestaurantService restaurantService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String createRestaurant(@RequestBody @Valid RestaurantDTO restaurantDTO) {
    return restaurantService.createRestaurant(restaurantDTO);
  }

  @GetMapping
  public List<RestaurantDTO> listAll() {
    return restaurantService.listAll();
  }

  @GetMapping("/{id}")
  public RestaurantDTO findById(@PathVariable Long id) throws RestaurantNotFoundException {
    return restaurantService.findById(id);
  }

  @PutMapping("/{id}")
  public String updateById(@PathVariable Long id, @RequestBody RestaurantDTO restaurantDTO) throws RestaurantNotFoundException {
    return restaurantService.updateById(id, restaurantDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws RestaurantNotFoundException {
    restaurantService.deleteById(id);
  }

}
