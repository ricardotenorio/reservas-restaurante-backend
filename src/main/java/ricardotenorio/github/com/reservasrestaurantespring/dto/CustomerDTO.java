package ricardotenorio.github.com.reservasrestaurantespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

  private Long id;

  @NotEmpty
  @Size(min = 2, max = 32)
  private String firstName;

  @NotEmpty
  @Size(min = 2, max = 64)
  private String lastName;

  @NotEmpty
  @Size(min = 4, max = 100)
  private String password;

  @NotEmpty
  @CPF
  private String cpf;

  @Valid
  private List<ReservationDTO> reservations;

}
