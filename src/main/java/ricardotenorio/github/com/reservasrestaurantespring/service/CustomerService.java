package ricardotenorio.github.com.reservasrestaurantespring.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricardotenorio.github.com.reservasrestaurantespring.dto.CustomerDTO;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Customer;
import ricardotenorio.github.com.reservasrestaurantespring.exception.CustomerNotFoundException;
import ricardotenorio.github.com.reservasrestaurantespring.mapper.CustomerMapper;
import ricardotenorio.github.com.reservasrestaurantespring.repository.CustomerRepository;
import ricardotenorio.github.com.reservasrestaurantespring.repository.ReservationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

  private CustomerRepository customerRepository;
  private ReservationRepository reservationRepository;

  private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

  public String createCustomer(CustomerDTO customerDTO) {
    Customer customerToSave = customerMapper.toModel(customerDTO);

    Customer savedCustomer = customerRepository.save(customerToSave);

    return "Created customer with ID " + savedCustomer.getId();
  }

  public List<CustomerDTO> listAll() {
    List<Customer> customers = customerRepository.findAll();

    return customers.stream()
        .map(customerMapper::toDTO)
        .collect(Collectors.toList());
  }

  public CustomerDTO findById(Long id) throws CustomerNotFoundException {
    Customer customer = verifyIfExists(id);

    return customerMapper.toDTO(customer);
  }

  public void deleteById(Long id) throws CustomerNotFoundException {
    verifyIfExists(id);

    customerRepository.deleteById(id);
  }

  public String updateById(Long id, CustomerDTO customerDTO) throws CustomerNotFoundException {
    verifyIfExists(id);

    customerDTO.setId(id);

    Customer customerToUpdate = customerMapper.toModel(customerDTO);

    Customer updatedCustomer = customerRepository.save(customerToUpdate);

    return "Updated customer with ID " + updatedCustomer.getId();

  }



  private Customer verifyIfExists(Long id) throws CustomerNotFoundException {
    return customerRepository.findById(id)
        .orElseThrow(() -> new CustomerNotFoundException(id));
  }

}
