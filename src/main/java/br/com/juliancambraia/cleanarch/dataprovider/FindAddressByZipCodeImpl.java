package br.com.juliancambraia.cleanarch.dataprovider;

import br.com.juliancambraia.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.juliancambraia.cleanarch.core.domain.Address;
import br.com.juliancambraia.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import br.com.juliancambraia.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {
  
  @Autowired
  private FindAddressByZipCodeClient client;
  
  @Autowired
  private AddressResponseMapper addressResponseMapper;
  
  @Override
  public Address find(String zipCode) {
    var addressResponse = client.find(zipCode);
    return addressResponseMapper.toAddress(addressResponse);
  }
}
