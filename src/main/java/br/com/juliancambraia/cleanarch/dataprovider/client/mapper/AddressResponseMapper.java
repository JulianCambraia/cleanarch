package br.com.juliancambraia.cleanarch.dataprovider.client.mapper;

import br.com.juliancambraia.cleanarch.core.domain.Address;
import br.com.juliancambraia.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
  Address toAddress(AddressResponse addressResponse);
}
