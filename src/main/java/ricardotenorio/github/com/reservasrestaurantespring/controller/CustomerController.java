package ricardotenorio.github.com.reservasrestaurantespring.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ricardotenorio.github.com.reservasrestaurantespring.dto.CustomerDTO;
import ricardotenorio.github.com.reservasrestaurantespring.exception.CustomerNotFoundException;
import ricardotenorio.github.com.reservasrestaurantespring.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {


  private CustomerService customerService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
    return customerService.createCustomer(customerDTO);
  }

  @GetMapping
  public List<CustomerDTO> listAll() {
    return customerService.listAll();
  }

  @GetMapping("/{id}")
  public CustomerDTO findById(@PathVariable Long id) throws CustomerNotFoundException {
    return customerService.findById(id);
  }

}