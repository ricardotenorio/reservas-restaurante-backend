package ricardotenorio.github.com.reservasrestaurantespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

  private Long id;

  @NotEmpty
  private String time;

  @Valid
  @NotEmpty
  private CustomerDTO customer;

  @Valid
  @NotEmpty
  private RestaurantDTO restaurant;

}
