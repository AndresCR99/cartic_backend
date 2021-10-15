package com.backend.carticback;

import com.backend.carticback.utils.AppPropiedades;
import com.backend.carticback.utils.AppContexto;
import com.backend.carticback.shared.UsuarioDto;
import com.backend.carticback.entities.responses.UsuarioRestModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
public class CarticBackApplication {

	public static void main(String[] args) {
		Config config = new Config();
		config.dbProperties();

		// System.out.println(UUID.randomUUID().toString());
		SpringApplication.run(CarticBackApplication.class, args);
		
	}

	@Bean
	public ModelMapper modelmapper(){

		ModelMapper modelmapper=new ModelMapper();

		modelmapper.typeMap(UsuarioDto.class, UsuarioRestModel.class);

		return modelmapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean(name="AppProperties")
	public AppPropiedades getAppProperties(){
		return new AppPropiedades();
	}

	@Bean
	public AppContexto springApplicationContext(){
		return new AppContexto();
	}
}
