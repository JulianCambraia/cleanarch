package br.com.juliancambraia.cleanarch.dataprovider.repository.mapper;

import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
  CustomerEntity toCustomerEntity(Customer customer);
  
  Customer toCustomer(CustomerEntity customerEntity);
}
