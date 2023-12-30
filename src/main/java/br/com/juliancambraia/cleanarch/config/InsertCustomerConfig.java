package br.com.juliancambraia.cleanarch.config;

import br.com.juliancambraia.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import br.com.juliancambraia.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.juliancambraia.cleanarch.dataprovider.InsertCustomerImpl;
import br.com.juliancambraia.cleanarch.dataprovider.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
  
  @Bean
  public InsertCustomerUseCaseImpl insertCustomerUseCase(FindAddressByZipCodeImpl findAddressByZipCode,
                                                         InsertCustomerImpl insertCustomer,
                                                         SendCpfForValidationImpl sendCpfForValidation) {
    return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer, sendCpfForValidation);
  }
}
