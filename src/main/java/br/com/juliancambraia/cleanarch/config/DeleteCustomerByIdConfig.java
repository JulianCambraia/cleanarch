package br.com.juliancambraia.cleanarch.config;

import br.com.juliancambraia.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import br.com.juliancambraia.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.juliancambraia.cleanarch.dataprovider.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
  
  @Bean
  public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
                                                                 DeleteCustomerByIdImpl deleteCustomerById) {
    return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCase, deleteCustomerById);
  }
}
