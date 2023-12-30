package br.com.juliancambraia.cleanarch.core.usecase;

import br.com.juliancambraia.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {
  
  void update(Customer customer, String zipCode);
}
