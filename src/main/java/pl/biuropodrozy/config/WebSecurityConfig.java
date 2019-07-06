package pl.biuropodrozy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurityConfig(DataSource dataSource, PasswordEncoder bCryptPasswordEncoder) {
        this.dataSource = dataSource;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //cokolwiek sie wpisze po "/" zadziala dzieki antMatchers
//                .antMatchers("/").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
//                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
//                .antMatchers("/products/**").hasAnyAuthority( "ROLE_USER")
//                .antMatchers("/h2/**").permitAll()
                // jakiekolwiek zapytanie zostanie dopuszczone
                .anyRequest().permitAll()
                .and()
                // zabezpieczenie przed nieautoryzowanymi linkami na naszej stronie
                .csrf().disable()
                // krzaczy sie z bd wiec wylaczamy (disable)
                .headers().frameOptions().disable();
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginProcessingUrl("/login-process")
//                .failureUrl("/login?error")
//                .defaultSuccessUrl("/").and()
//                .logout().logoutSuccessUrl("/login");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin@admin.pl")
                .password(bCryptPasswordEncoder.encode("admin12345"))
                .roles("ADMIN");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.username, u.password_hash,1 FROM user u WHERE u.username=?")
                .authoritiesByUsernameQuery("SELECT u.username, r.role_name, 1 " +
                        "FROM user u " +
                        "INNER JOIN user_role ur ON ur.user_id = u.id " +
                        "INNER JOIN role r ON r.id = ur.roles_id " +
                        "WHERE u.username=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
