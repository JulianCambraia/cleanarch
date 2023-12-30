# Clean Architecture

## PoC com ênfase nos princípios da Arquitetura Limpa descritas por Robert C. Martin 
proposta em seu livro ```Clean Architecture: A Craftsman’s Guide to Software Structure```
![alt text](https://github.com/juliancambraia/cleanarch/blob/main/images/cleanarq.jpeg?raw=true)
### Tecnologias usadas

1. Java 21 LTS
2. Maven 3.3.6
3. Spring boot versão 3.2.1
   ##### 3.0 - Dependências ``POM.xml``
   ###### 3.1 - Spring Web
   ###### 3.2 - Validation
   ###### 3.3 - Spring Core Apache Kafka
   ###### 3.4 - Spring Data MongoDB
   ###### 3.5 - Lombok
   ###### 3.6 - Devtools
   ###### 3.7 - Spring Cloud Starter Open Feign
   ###### 3.8 - Spring Cloud
   ###### 3.8 - Mapstruct

4. Kafka Template 
   ##### 2.1 ``producer``
   ##### 2.2. ``consumer``
5. MongoDB
6. Docker
7. WireMock para simular a busca por CEP

## Fluxo da estrutura do projeto

![alt text](https://github.com/juliancambraia/cleanarch/blob/main/images/fluxo.png?raw=true)
