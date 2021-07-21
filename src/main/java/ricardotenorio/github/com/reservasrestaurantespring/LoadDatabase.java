package ricardotenorio.github.com.reservasrestaurantespring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Menu;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Reservation;
import ricardotenorio.github.com.reservasrestaurantespring.entity.Restaurant;
import ricardotenorio.github.com.reservasrestaurantespring.repository.RestaurantRepository;

import java.util.ArrayList;

@Configuration
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(RestaurantRepository restaurantRepository) {
    Menu menu1 = new Menu(1l, "Pastel", 1100l, null);
    Menu menu2 = new Menu(2l, "Pizza", 4200l, null);
    Menu menu3 = new Menu(3l, "Coxinha", 550l, null);


    Restaurant restaurant1 = new Restaurant(1l, "Jéssica e Nicole Doces & Salgados",
        "8728837868", menu1, new ArrayList<Reservation>());
    Restaurant restaurant2 = new Restaurant(2l, "Benedito e Lucas Pizzaria",
        "81988361546", menu2, new ArrayList<Reservation>());
    Restaurant restaurant3 = new Restaurant(3l, "Renato e Mariane",
        "81995884737", menu3, new ArrayList<Reservation>());

    return args -> {
      restaurantRepository.save(restaurant1);
      restaurantRepository.save(restaurant2);
      restaurantRepository.save(restaurant3);
    };
  }
}
