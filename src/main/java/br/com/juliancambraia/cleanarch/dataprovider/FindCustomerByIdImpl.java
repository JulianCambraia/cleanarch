package br.com.juliancambraia.cleanarch.dataprovider;

import br.com.juliancambraia.cleanarch.core.dataprovider.FindCustomerById;
import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.dataprovider.repository.CustomerRepository;
import br.com.juliancambraia.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {
  
  private final CustomerRepository customerRepository;
  
  private final CustomerEntityMapper customerEntityMapper;
  
  public FindCustomerByIdImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
    this.customerRepository = customerRepository;
    this.customerEntityMapper = customerEntityMapper;
  }
  
  @Override
  public Optional<Customer> find(String id) {
    var customerEntity = customerRepository.findById(id);
    return customerEntity.map(customerEntityMapper::toCustomer);
  }
}
