package com.backend.carticback.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.backend.carticback.services.UsuarioService;
import com.backend.carticback.services.IUsuarioService;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter{

	private final IUsuarioService iUsuarioServicio;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(IUsuarioService iUsuarioServicio, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.iUsuarioServicio = iUsuarioServicio;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
			// .antMatchers(HttpMethod.GET, "/api/usuarios").permitAll()
			.anyRequest().authenticated()
			.and().addFilter(getFiltroAutenticacion())
   			.addFilter(new FiltroAutorizacion(authenticationManager()))
   			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(iUsuarioServicio).passwordEncoder(bCryptPasswordEncoder);
	}

	public FiltroAutenticacion getFiltroAutenticacion() throws Exception{

        final FiltroAutenticacion filtroAutenticacion = new FiltroAutenticacion(authenticationManager());

        filtroAutenticacion.setFilterProcessesUrl("/api/usuarios/login");
        return filtroAutenticacion;
    }
}
