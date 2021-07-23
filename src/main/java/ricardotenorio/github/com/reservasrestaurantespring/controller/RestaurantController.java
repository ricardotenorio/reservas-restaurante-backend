package ricardotenorio.github.com.reservasrestaurantespring.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ricardotenorio.github.com.reservasrestaurantespring.dto.RestaurantDTO;
import ricardotenorio.github.com.reservasrestaurantespring.exception.RestaurantNotFoundException;
import ricardotenorio.github.com.reservasrestaurantespring.service.RestaurantService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RestaurantController {

  private RestaurantService restaurantService;

  @GetMapping
  public List<RestaurantDTO> listAll() {
    return restaurantService.listAll();
  }

  @GetMapping("/{id}")
  public RestaurantDTO findById(@PathVariable Long id) throws RestaurantNotFoundException {
    return restaurantService.findById(id);
  }

}
