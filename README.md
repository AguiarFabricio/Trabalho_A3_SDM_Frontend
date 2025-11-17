# Trabalho_A3_SDM_Backend

## 👨‍💻 Alunos

| Nome Completo                         | GitHub                               | RA          |
| ------------------------------------- |--------------------------------------| ----------- |
| Fabrício Valdemar de Aguiar Filho     | @AguiarFabricio                      | 10725115451 |
| Luiz Gustavo Pereira                  | @guvdev                              | 10725120743 |
| Mario Gabriel Imperator dos Santos    | @mariooimp                           | 10725115250 |


## ✅ Requisitos Funcionais (RF)

* *RF001* – O sistema deve permitir o *cadastro, consulta, edição e exclusão de produtos*, contendo as seguintes informações: nome, preço unitário, unidade de medida, quantidade em estoque, quantidade mínima e máxima permitida e categoria associada.
* *RF002* – O sistema deve possibilitar o *cadastro, consulta, edição e exclusão de categorias*, incluindo as informações de nome, tamanho (Pequeno, Médio, Grande) e tipo de embalagem (Lata, Vidro, Plástico).
* *RF003* – O sistema deve permitir *registrar e visualizar movimentações de entrada e saída de produtos*, atualizando automaticamente a quantidade em estoque conforme a operação realizada.
* *RF004* – O sistema deve permitir *reajustar os preços de todos os produtos* cadastrados com base em um percentual informado pelo usuário, de forma automática.
* *RF005* – O sistema deve emitir *avisos automáticos* nos seguintes casos:
  
  * Quando uma saída de produto fizer a quantidade em estoque ficar *abaixo da quantidade mínima*.
  * Quando uma entrada de produto fizer a quantidade em estoque *ultrapassar a quantidade máxima*.
* *RF006* – O sistema deve gerar *relatórios gerenciais* com as seguintes funcionalidades:
  
  * *Lista de preços*: produtos ordenados alfabeticamente, com nome, preço unitário, unidade e categoria.
  * *Balanço físico e financeiro*: produtos ordenados alfabeticamente, com quantidade atual, valor total por produto e valor total do estoque.
  * *Produtos fora da faixa de quantidade*: dois relatórios, um para produtos abaixo da quantidade mínima e outro para produtos acima da máxima.
  * *Produtos por categoria*: quantidade de produtos distintos agrupados por categoria.

---

## ❌ Requisitos Não Funcionais (RNF)

* *RNF001* – A interface gráfica do sistema deve ser *intuitiva e de fácil utilização, implementada com **Swing*, permitindo navegação simples entre as funcionalidades principais.
* *RNF002* – O sistema deve adotar o *padrão de projeto DAO (Data Access Object)*, separando a lógica de acesso a dados da lógica de negócio e da interface.
* *RNF003* – Toda a persistência dos dados deve ser garantida por meio de um *banco de dados relacional MySQL*, acessado via JDBC.
* *RNF004* – O código-fonte do sistema deve seguir uma *estrutura modular*, com boas práticas de organização, legibilidade e documentação adequada nas classes e métodos.
* *RNF005* – O projeto deve utilizar *controle de versão com Git, mantendo o repositório no **GitHub*, com contribuições registradas de forma colaborativa por todos os membros da equipe.

## 💻 Tecnologias Utilizadas

Ambiente de Desenvolvimento:
O projeto foi desenvolvido em ambiente local utilizando as seguintes ferramentas e tecnologias:
*  IDE: Apache NetBeans 27
*  Banco de Dados: MySQL Server 9.4.0
*  Versão do Java: Java 25
*  Sistema Operacional: Windows 10/11
*  Controle de Versão: Git 2.44.0, com repositório hospedado no GitHub
*  Arquitetura: Estrutura distribuída em duas camadas (serviços e consumo de serviços), com comunicação via Sockets.
*  Banco de Dados: Usuário: root, Senha: 1234.

## Repositório Backend
https://github.com/AguiarFabricio/Trabalho_A3_SDM_Backend
