package ricardotenorio.github.com.reservasrestaurantespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

  private Long id;

  @NotEmpty
  @Size(min = 3, max = 64)
  private String name;

  @NotEmpty
  @Size(min = 11, max = 12)
  private String phoneNumber;

  @Valid
  private MenuDTO menu;

  @Valid
  private List<ReservationDTO> reservations;

}
