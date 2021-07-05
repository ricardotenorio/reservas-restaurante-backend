package ricardotenorio.github.com.reservasrestaurantespring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends Exception {

  public RestaurantNotFoundException(Long id) {
    super("Restaurant with ID " + id + " doesn't exist");
  }
}
