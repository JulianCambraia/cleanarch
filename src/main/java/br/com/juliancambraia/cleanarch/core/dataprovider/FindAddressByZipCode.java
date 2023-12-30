package br.com.juliancambraia.cleanarch.core.dataprovider;

import br.com.juliancambraia.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
  
  Address find(final String zipCode);
}
