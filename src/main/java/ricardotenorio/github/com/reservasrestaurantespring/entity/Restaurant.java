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
public class Restaurant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = false, unique = true)
  private String cnpj;

  @Column
  private int capacity;

  @OneToOne(mappedBy = "restaurant")
  @JoinColumn(name = "menu_id", referencedColumnName = "id")
  private Menu menu;

  @OneToMany(fetch = FetchType.LAZY,
      mappedBy = "restaurant")
  private List<Reservation> reservations;

}
