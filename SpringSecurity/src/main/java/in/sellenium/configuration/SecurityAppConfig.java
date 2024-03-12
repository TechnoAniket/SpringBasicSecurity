
package in.sellenium.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityAppConfig {
	@Autowired
    private HttpSecurity http;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails andyUser = User.withUsername("andy")
                .password("$2a$10$gpi42SdzgOX0/boChfTM5OcUV4H5eg6a5l59ohZSZhHnFiWcG9t0y")
                .roles("admin", "user")
                .build();
        UserDetails rajUser = User.withUsername("raj")
                .password("$2a$10$immLp/ZZ5FCXP/0RHUguse8j8mymtCo40lC05D4r87qV4AOKQxL4G")
                .roles("user")
                .build(); 
        return new InMemoryUserDetailsManager(andyUser, rajUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain() throws Exception {
        http.authorizeHttpRequests(customizer ->{
        	customizer.requestMatchers("/hi").permitAll();
        });
        return http.build();
    }
}



//package in.sellenium.configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityAppConfig {
//	
////	@Autowired
////	HttpSecurity httpSecurity;
//	
//	@Bean
//	public InMemoryUserDetailsManager setUpUser()
//	{
//		UserDetails andyUser = User.withUsername("andy")
////				.password("{bcrypt}$2a$10$gpi42SdzgOX0/boChfTM5OcUV4H5eg6a5l59ohZSZhHnFiWcG9t0y")
//				.password("$2a$10$gpi42SdzgOX0/boChfTM5OcUV4H5eg6a5l59ohZSZhHnFiWcG9t0y")
//				.roles("admin","user")
//				.build();
//		UserDetails rajUser = User.withUsername("raj")
////				.password("{bcrypt}$2a$10$immLp/ZZ5FCXP/0RHUguse8j8mymtCo40lC05D4r87qV4AOKQxL4G")
//				.password("$2a$10$immLp/ZZ5FCXP/0RHUguse8j8mymtCo40lC05D4r87qV4AOKQxL4G")
//				.roles("user")
//				.build();
//		
//		return new InMemoryUserDetailsManager(andyUser , rajUser); 
//	}
//	
//	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
////	========================================================================
////	@Bean
////	public InMemoryUserDetailsManager setUpUser()
////	{
////		UserDetails andyUser = User.withUsername("andy").password("andy").roles("admin","user").build();
////		UserDetails rajUser = User.withUsername("raj").password("raj").roles("admin").build();
////		
////		return new InMemoryUserDetailsManager(andyUser , rajUser); 
////	}
////	
////	@Bean
////	PasswordEncoder passwordEncoder() {
////		return NoOpPasswordEncoder.getInstance();
////	}
////	=======================================================================
////	@Bean
////	public InMemoryUserDetailsManager setUpUser() {
////		List<GrantedAuthority> authorityList = new ArrayList<>();
////		authorityList.add(new SimpleGrantedAuthority("Admin"));
////		authorityList.add(new SimpleGrantedAuthority("User"));
////		
////		UserDetails userDetails = new User("andy", "andy", authorityList);
////		
////		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
////		inMemoryUserDetailsManager.createUser(userDetails);
////		return inMemoryUserDetailsManager;
////	}
////	
////	@Bean
////	public PasswordEncoder passwordEncoder() {
////		return NoOpPasswordEncoder.getInstance();
////	}
//}
