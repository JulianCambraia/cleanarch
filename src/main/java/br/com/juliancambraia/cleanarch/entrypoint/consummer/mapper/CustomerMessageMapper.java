package br.com.juliancambraia.cleanarch.entrypoint.consummer.mapper;

import br.com.juliancambraia.cleanarch.core.domain.Customer;
import br.com.juliancambraia.cleanarch.entrypoint.consummer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
  
  @Mapping(target = "address", ignore = true)
  Customer toCustomer(CustomerMessage customerMessage);
}
