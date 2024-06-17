# Sistema de Gerenciamento Hospitalar

Este é um sistema de gerenciamento hospitalar desenvolvido em Java utilizando Spring Boot. O sistema permite a criação, edição e exclusão de usuários e consultas médicas, além de atribuição de perfis aos usuários (paciente, médico e administrador).

## Configuração do Banco de Dados

Certifique-se de ter o MySQL em funcionamento, e crie um database chamada 'hospital'.

### Configuração do `application.properties`

Edite o arquivo `src/main/resources/application.properties` para incluir as credenciais do seu banco de dados MySQL:

<code>properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect</code>


