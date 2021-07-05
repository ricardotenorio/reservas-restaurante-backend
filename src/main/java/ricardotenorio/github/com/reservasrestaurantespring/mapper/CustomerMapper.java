package ricardotenorio.github.com.reservasrestaurantespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ricardotenorio.github.com.reservasrestaurantespring.dto.CustomerDTO;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Customer;

@Mapper
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  Customer toModel(CustomerDTO customerDTO);

  CustomerDTO toDTO(Customer customer);

}
