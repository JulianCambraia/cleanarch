package br.com.juliancambraia.cleanarch.core.dataprovider;

import br.com.juliancambraia.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {
  
  Optional<Customer> find(final String id);
}
