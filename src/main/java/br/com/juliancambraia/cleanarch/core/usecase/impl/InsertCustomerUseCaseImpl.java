package br.com.juliancambraia.cleanarch.core.usecase.impl;

import br.com.juliancambraia.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.juliancambraia.cleanarch.core.dataprovider.InsertCustomer;
import br.com.juliancambraia.cleanarch.core.dataprovider.SendCpfForValidation;
import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {
  
  private final FindAddressByZipCode findAddressByZipCode;
  private final InsertCustomer insertCustomer;
  private final SendCpfForValidation sendCpfForValidation;
  
  public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer, SendCpfForValidation sendCpfForValidation) {
    this.findAddressByZipCode = findAddressByZipCode;
    this.insertCustomer = insertCustomer;
    this.sendCpfForValidation = sendCpfForValidation;
  }
  
  @Override
  public void insert(Customer customer, String zipCode) {
    var address = findAddressByZipCode.find(zipCode);
    customer.setAddress(address);
    insertCustomer.insert(customer);
    sendCpfForValidation.send(customer.getCpf());
  }
}
