# Sistematizacao-POO
Trabalho da faculdade 

Uma empresa de entregas Dianome está precisando de um software simples para gerenciar algumas de suas operações. Seu principal problemal é:
1. Controlar os entregadores (cpf, nome, capacidade do veículo)

Para resolver isso, foi preciso desenvolver uma API REST usando o framework Spring Boot e o banco de dados MySQL. Minha API deveria tratar as seguintes requisições:
1. Uma URI para listar todos os itens;
2. Uma URI que recebe o formulário com as informações e efetua a gravação no banco de dados;
3. Uma URI para apresentar os detalhes de um item específico a partir da sua identificação;
4. Uma URI que recebe o identificador de um item e o remove do banco de dados.

Orientações para colocá-lo em operação:
1. Abra o terminal no seu ambiente de desenvolvimento.
2. Execute o seguinte comando para clonar o repositório: git clone https://github.com/Gabrielgh06/Sistematizacao-POO
3. Sugiro usar o VSCode como IDE, onde você deve baixar a extensão "Spring Boot Extension Pack". Essa extensão adicionará o spring boot dashboard, que será responsável por subir o localhost.
4. Quando o localhost estiver no ar, você pode usar O postman para fazer as requisisções para testar a API.

As URIs para cumprir cada um dos objetivos são as seguintes:
1. GET - http://localhost:8080/entregador -> Para LISTAR todos os itens.
2. POST - http://localhost:8080/entregador -> EFETUAR a gravação no banco de dados. <br>
    No método POST, o modelo deve ser o seguinte: <br>
    { "nome": "Nome do Funcionário", "cpf": 12345678901, "capacidadeveiculo": 1000.0 }
3. GET - http://localhost:8080/entregador/1 -> Apresentar DETALHES de um item específico, onde o numero no final da URI será o ID do funcionário especificado.
4. PUT - http://localhost:8080/entregador/1 -> Recebe um formulário com ALTERAÇÕES e efetua a gravação no banco no banco, onde o numero no final da URI será o ID do funcionário especificado..
