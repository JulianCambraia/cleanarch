package br.com.juliancambraia.cleanarch.core.usecase.impl;

import br.com.juliancambraia.cleanarch.core.dataprovider.DeleteCustomerById;
import br.com.juliancambraia.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import br.com.juliancambraia.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {
  
  private final FindCustomerByIdUseCase findCustomerByIdUseCase;
  
  private final DeleteCustomerById deleteCustomerById;
  
  public DeleteCustomerByIdUseCaseImpl(FindCustomerByIdUseCase findCustomerByIdUseCase, DeleteCustomerById deleteCustomerById) {
    this.findCustomerByIdUseCase = findCustomerByIdUseCase;
    this.deleteCustomerById = deleteCustomerById;
  }
  
  @Override
  public void delete(String id) {
    findCustomerByIdUseCase.find(id);
    deleteCustomerById.delete(id);
  }
}
