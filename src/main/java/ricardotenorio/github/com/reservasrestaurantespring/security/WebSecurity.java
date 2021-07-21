package ricardotenorio.github.com.reservasrestaurantespring.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurity extends WebSecurityConfigurerAdapter {


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

  }


}
