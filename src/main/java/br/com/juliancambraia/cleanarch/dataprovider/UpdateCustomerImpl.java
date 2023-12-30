package br.com.juliancambraia.cleanarch.dataprovider;

import br.com.juliancambraia.cleanarch.core.dataprovider.UpdateCustomer;
import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.dataprovider.repository.CustomerRepository;
import br.com.juliancambraia.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {
  
  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;
  
  public UpdateCustomerImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
    this.customerRepository = customerRepository;
    this.customerEntityMapper = customerEntityMapper;
  }
  
  @Override
  public void update(Customer customer) {
    var customerEntity = customerEntityMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}
