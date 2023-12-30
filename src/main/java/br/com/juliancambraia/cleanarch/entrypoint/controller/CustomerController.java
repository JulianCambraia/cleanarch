package br.com.juliancambraia.cleanarch.entrypoint.controller;

import br.com.juliancambraia.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import br.com.juliancambraia.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.juliancambraia.cleanarch.core.usecase.InsertCustomerUseCase;
import br.com.juliancambraia.cleanarch.core.usecase.UpdateCustomerUseCase;
import br.com.juliancambraia.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import br.com.juliancambraia.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.juliancambraia.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
  
  private final InsertCustomerUseCase insertCustomerUseCase;
  private final CustomerMapper customerMapper;
  private final FindCustomerByIdUseCase findCustomerByIdUseCase;
  private final UpdateCustomerUseCase updateCustomerUseCase;
  
  private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
  
  public CustomerController(InsertCustomerUseCase insertCustomerUseCase, CustomerMapper customerMapper, FindCustomerByIdUseCase findCustomerByIdUseCase, UpdateCustomerUseCase updateCustomerUseCase, DeleteCustomerByIdUseCase deleteCustomerByIdUseCase) {
    this.insertCustomerUseCase = insertCustomerUseCase;
    this.customerMapper = customerMapper;
    this.findCustomerByIdUseCase = findCustomerByIdUseCase;
    this.updateCustomerUseCase = updateCustomerUseCase;
    this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
  }
  
  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
    var customer = customerMapper.toCustomer(customerRequest);
    insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
    
    return ResponseEntity.ok().build();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
    var customer = findCustomerByIdUseCase.find(id);
    var customerResponse = customerMapper.toCustomerResponse(customer);
    
    return ResponseEntity.ok().body(customerResponse);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
    var customer = customerMapper.toCustomer(customerRequest);
    customer.setId(id);
    updateCustomerUseCase.update(customer, customerRequest.getZipCode());
    
    return ResponseEntity.noContent().build();
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    deleteCustomerByIdUseCase.delete(id);
    
    return ResponseEntity.noContent().build();
  }
}
