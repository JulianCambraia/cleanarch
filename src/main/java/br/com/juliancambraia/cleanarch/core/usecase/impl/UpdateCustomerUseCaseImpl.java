package br.com.juliancambraia.cleanarch.core.usecase.impl;

import br.com.juliancambraia.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.juliancambraia.cleanarch.core.dataprovider.UpdateCustomer;
import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.juliancambraia.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {
  
  private final FindCustomerByIdUseCase findCustomerByIdUseCase;
  private final FindAddressByZipCode findAddressByZipCode;
  private final UpdateCustomer updateCustomer;
  
  public UpdateCustomerUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCode findAddressByZipCode, UpdateCustomer updateCustomer) {
    this.findCustomerByIdUseCase = findCustomerByIdUseCase;
    this.findAddressByZipCode = findAddressByZipCode;
    this.updateCustomer = updateCustomer;
  }
  
  @Override
  public void update(Customer customer, String zipCode) {
    findCustomerByIdUseCase.find(customer.getId());
    var address = findAddressByZipCode.find(zipCode);
    customer.setAddress(address);
    
    updateCustomer.update(customer);
  }
}
