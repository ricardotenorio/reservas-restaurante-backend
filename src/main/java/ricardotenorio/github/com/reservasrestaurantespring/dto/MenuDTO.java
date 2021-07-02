package ricardotenorio.github.com.reservasrestaurantespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

  private Long id;

  @NotEmpty
  @Size(min = 2, max = 32)
  private String product;

  @NotEmpty
  private Long price;

}
