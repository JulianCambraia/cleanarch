package br.com.juliancambraia.cleanarch.core.usecase;

import br.com.juliancambraia.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {
  
  void insert(Customer customer, String zipCode);
}
