# Controle de Estoque com Hibernate JPA

Este projeto demonstra como implementar um sistema básico de controle de estoque utilizando o Hibernate JPA para a persistência de dados em um banco de dados MySQL. O projeto utiliza um DAO (Data Access Object) genérico para encapsular as operações CRUD (Create, Read, Update, Delete) em entidades, facilitando a reutilização de código e a manutenção do sistema.

  

### Funcionalidades  

-   Cadastro de produtos com nome, descrição e preço.    
-   Busca de produtos por ID.    
-   Busca de todos os produtos cadastrados.    
-   Atualização de informações de produtos existentes.    
-   Exclusão de produtos do sistema.
    

### Tecnologias Utilizadas  

-   Java    
-   Hibernate JPA    
-   MySQL    
-   Lombok (opcional, para geração automática de código)    
-   Maven (para gerenciamento de dependências)

  
### Como Executar  

#### Configurar o banco de dados:  

1.  Crie um banco de dados MySQL chamado hibernate_controle_estoque.    
2.  Configure as credenciais de acesso ao banco de dados no arquivo persistence.xml (localizado em src/main/resources/META-INF).
    

#### Compilar e executar:  

#### Utilize o Maven para compilar e executar o projeto:  

mvn clean install

mvn exec:java -Dexec.mainClass="br.com.estudos.hibernate.TesteProdutoCRUD" 
  

### Estrutura do Projeto  

-   br.com.estudos.hibernate.model: Contém a entidade Produto, que representa os produtos no sistema.    
-   br.com.estudos.hibernate.dao: Contém o DAO genérico DAO e o DAO específico para produtos ProdutoDAO (se você decidir implementá-lo).    
-   br.com.estudos.hibernate: Contém a classe principal TesteProdutoCRUD, que demonstra o uso do DAO para realizar operações CRUD em produtos.    
-   src/main/resources/META-INF/persistence.xml: Arquivo de configuração do JPA, contendo informações sobre a conexão com o banco de dados e outras propriedades do Hibernate.    

### Observações  

-   Este é um projeto de exemplo para fins de estudo e demonstração. Em um ambiente de produção, você provavelmente teria mais entidades, relacionamentos entre elas, validações mais complexas, tratamento de erros mais robusto e uma interface de usuário para interagir com o sistema.
-   O projeto utiliza injeção manual do EntityManager no DAO, pois não está utilizando um framework de injeção de dependências. Se você estiver usando um framework como o Spring, pode usar a anotação @PersistenceContext para injetar o EntityManager automaticamente.
-   O Lombok é opcional e pode ser usado para gerar automaticamente getters, setters, construtores e outros métodos comuns, tornando o código mais conciso.
    
### Contribuições  

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para sugerir melhorias, corrigir bugs ou adicionar novas funcionalidades ao projeto.

  

### Licença 

Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para obter mais informações.

Espero que este README seja útil para entender e utilizar este projeto de controle de estoque com Hibernate JPA. Se tiver alguma dúvida, não hesite em perguntar
