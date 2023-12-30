package br.com.juliancambraia.cleanarch.config;

import br.com.juliancambraia.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.juliancambraia.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
  
  @Bean
  public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(FindCustomerByIdImpl findCustomerById) {
    return new FindCustomerByIdUseCaseImpl(findCustomerById);
  }
}
