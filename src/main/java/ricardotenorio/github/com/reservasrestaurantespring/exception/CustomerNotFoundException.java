package ricardotenorio.github.com.reservasrestaurantespring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

  public CustomerNotFoundException(Long id) {
    super("Customer with ID " + id + " doesn't exist");
  }

}
