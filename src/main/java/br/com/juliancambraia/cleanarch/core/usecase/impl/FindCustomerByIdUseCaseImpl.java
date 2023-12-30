package br.com.juliancambraia.cleanarch.core.usecase.impl;

import br.com.juliancambraia.cleanarch.core.dataprovider.FindCustomerById;
import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {
  
  private final FindCustomerById findCustomerById;
  
  public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
    this.findCustomerById = findCustomerById;
  }
  
  @Override
  public Customer find(String id) {
    return findCustomerById.find(id)
        .orElseThrow(() -> new RuntimeException("Customer not found."));
  }
}
