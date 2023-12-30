package br.com.juliancambraia.cleanarch.core.usecase;

import br.com.juliancambraia.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
  Customer find(final String id);
}
