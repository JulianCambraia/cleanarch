package br.com.juliancambraia.cleanarch.entrypoint.controller.mapper;

import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.juliancambraia.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "address", ignore = true)
  @Mapping(target = "isValidCpf", ignore = true)
  Customer toCustomer(CustomerRequest customerRequest);
  
  CustomerResponse toCustomerResponse(Customer customer);
}
