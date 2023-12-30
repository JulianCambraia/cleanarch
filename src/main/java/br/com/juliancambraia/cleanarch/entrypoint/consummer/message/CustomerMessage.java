package br.com.juliancambraia.cleanarch.entrypoint.consummer.message;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CustomerMessage {
  private String id;
  private String name;
  private String zipCode;
  private String cpf;
  private Boolean isValidCpf;
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getZipCode() {
    return zipCode;
  }
  
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  
  public String getCpf() {
    return cpf;
  }
  
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  
  public Boolean getIsValidCpf() {
    return isValidCpf;
  }
  
  public void setIsValidCpf(Boolean isValidCpf) {
    this.isValidCpf = isValidCpf;
  }
}
