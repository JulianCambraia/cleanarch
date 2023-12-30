package br.com.juliancambraia.cleanarch.dataprovider;

import br.com.juliancambraia.cleanarch.core.dataprovider.InsertCustomer;
import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.dataprovider.repository.CustomerRepository;
import br.com.juliancambraia.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {
  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;
  
  public InsertCustomerImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
    this.customerRepository = customerRepository;
    this.customerEntityMapper = customerEntityMapper;
  }
  
  @Override
  public void insert(Customer customer) {
    var customerEntity = customerEntityMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}
