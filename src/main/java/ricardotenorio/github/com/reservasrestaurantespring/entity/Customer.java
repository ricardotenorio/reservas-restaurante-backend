package ricardotenorio.github.com.reservasrestaurantespring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstname;

  @Column(nullable = false)
  private String lastname;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String cpf;

  @OneToMany(fetch = FetchType.LAZY,
    mappedBy = "customer")
  private List<Reservation> reservations;

}
