package br.com.juliancambraia.cleanarch.entrypoint.consummer;

import br.com.juliancambraia.cleanarch.core.usecase.UpdateCustomerUseCase;
import br.com.juliancambraia.cleanarch.entrypoint.consummer.mapper.CustomerMessageMapper;
import br.com.juliancambraia.cleanarch.entrypoint.consummer.message.CustomerMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {
  
  private final UpdateCustomerUseCase updateCustomerUseCase;
  
  private final CustomerMessageMapper customerMessageMapper;
  
  public ReceiveValidatedCpfConsumer(UpdateCustomerUseCase updateCustomerUseCase, CustomerMessageMapper customerMessageMapper) {
    this.updateCustomerUseCase = updateCustomerUseCase;
    this.customerMessageMapper = customerMessageMapper;
  }
  
  /**
   * Listener do Cpf já validado
   */
  @KafkaListener(topics = "tp-cpf-validated", groupId = "cambraia")
  public void receive(CustomerMessage customerMessage) {
    var customer = customerMessageMapper.toCustomer(customerMessage);
    updateCustomerUseCase.update(customer, customerMessage.getZipCode());
  }
}
