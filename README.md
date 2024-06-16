<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>README</title>
</head>
<body>
    <h1>Hospital Management System</h1>
    <p>Este é um sistema de gerenciamento hospitalar desenvolvido em Java utilizando Spring Boot. O sistema permite a criação, edição e exclusão de usuários e consultas médicas, além de atribuição de perfis aos usuários (paciente, médico e administrador).</p>

    <h2>Pré-requisitos</h2>
    <ul>
        <li>Java 8 ou superior</li>
        <li>Maven</li>
        <li>Banco de Dados MySQL</li>
    </ul>

    <h2>Configuração do Banco de Dados</h2>
    <p>Certifique-se de ter o MySQL instalado e em execução. Crie um banco de dados chamado <code>hospital</code>.</p>

    <h3>Configuração do <code>application.properties</code></h3>
    <p>Edite o arquivo <code>src/main/resources/application.properties</code> para incluir as credenciais do seu banco de dados MySQL:</p>
    <pre>
        <code>
spring.datasource.url=jdbc:mysql://localhost:3306/hospital
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
        </code>
    </pre>

    <h2>Inserir Dados Iniciais</h2>
    <p>Para que o projeto funcione corretamente, é necessário inserir os perfis de usuários no banco de dados. Execute a seguinte query no seu banco de dados MySQL:</p>
    <pre>
        <code>
INSERT INTO `hospital`.`perfil` (`id`, `perfil`) VALUES (1, 'ADMIN');
INSERT INTO `hospital`.`perfil` (`id`, `perfil`) VALUES (2, 'PACIENTE');
INSERT INTO `hospital`.`perfil` (`id`, `perfil`) VALUES (3, 'MÉDICO');
        </code>
    </pre>

    <h2>Construção e Execução</h2>

    <h3>Passos para Construção</h3>
    <ol>
        <li>Clone o repositório:
            <pre><code>git clone https://github.com/seu_usuario/hospital-management-system.git</code></pre>
        </li>
        <li>Navegue até o diretório do projeto:
            <pre><code>cd hospital-management-system</code></pre>
        </li>
        <li>Compile o projeto usando Maven:
            <pre><code>mvn clean install</code></pre>
        </li>
    </ol>

    <h3>Executar o Projeto</h3>
    <ol>
        <li>Execute o projeto usando Maven:
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
        <li>Acesse a aplicação em:
            <pre><code>http://localhost:8080</code></pre>
        </li>
    </ol>

    <h2>Funcionalidades</h2>

    <h3>Usuários</h3>
    <ul>
        <li>Cadastro de usuários com diferentes perfis (paciente, médico, administrador).</li>
        <li>Login e autenticação.</li>
        <li>Gerenciamento de perfis de usuários.</li>
    </ul>

    <h3>Consultas</h3>
    <ul>
        <li>Criação, edição e exclusão de consultas médicas.</li>
        <li>Visualização de consultas por pacientes e médicos.</li>
    </ul>

    <h2>Estrutura do Projeto</h2>
    <pre>
        <code>
src/main/java
├── com/grupo7/hospital
│   ├── config
│   │   ├── CustomSuccessHandler.java
│   │   ├── SpringSecurityConfig.java
│   ├── controller
│   │   ├── AdminController.java
│   │   ├── ConsultaController.java
│   │   ├── LoginController.java
│   │   ├── MedicoController.java
│   │   ├── PacienteController.java
│   │   ├── RegistroController.java
│   ├── DTO
│   │   ├── UserLoginDTO.java
│   │   ├── UserRegisteredDTO.java
│   ├── model
│   │   ├── Consulta.java
│   │   ├── Perfil.java
│   │   ├── User.java
│   ├── model/enums
│   │   ├── Permissao.java
│   ├── repository
│   │   ├── ConsultaRepository.java
│   │   ├── PerfilRepository.java
│   │   ├── UserRepository.java
│   ├── service
│   │   ├── ConsultaService.java
│   │   ├── UserService.java
│   │   ├── UserServiceImpl.java
└── resources
    ├── static
    │   ├── css
    │   ├── js
    ├── templates
    │   ├── CadastroUsuario.html
    │   ├── CriarConsulta.html
    │   ├── EditarConsulta.html
    │   ├── GerenciarConsultas.html
    │   ├── GerenciarUsuarios.html
    │   ├── login.html
    │   ├── PacienteConsultas.html
    └── application.properties
        </code>
    </pre>

    <h2>Contribuição</h2>
    <p>Se você quiser contribuir para o projeto, sinta-se à vontade para fazer um fork do repositório, criar um branch e abrir um pull request com suas melhorias.</p>

    <h2>Licença</h2>
    <p>Este projeto está licenciado sob a Licença MIT. Veja o arquivo <a href="LICENSE">LICENSE</a> para mais detalhes.</p>

    <p>Certifique-se de executar a query SQL no banco de dados <code>hospital</code> antes de iniciar a aplicação para garantir que os perfis de usuário estejam corretamente configurados.</p>
    <pre>
        <code>
INSERT INTO `hospital`.`perfil` (`id`, `perfil`) VALUES (3, 'MÉDICO');
        </code>
    </pre>
</body>
</html>
