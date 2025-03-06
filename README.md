# Gestão de Funcionários 🚀

Este é um sistema para gerenciamento de funcionários que facilita o controle e a administração dos dados dos colaboradores de uma empresa. O sistema permite realizar operações de cadastro, listagem e remoção de registros, além de gerar relatórios que auxiliam na análise dos dados. 📊

---

## Sumário 📚

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Utilizar](#como-utilizar)
- [Observações Importantes](#observações-importantes)
- [Contato](#contato)

---

## Visão Geral ✨

O **Gestão de Funcionários** é um sistema pensado para pequenas e médias empresas que buscam uma solução simples e eficiente para manter o controle dos dados dos seus colaboradores. Com uma interface intuitiva, o sistema facilita a organização interna e a tomada de decisões. 🏢

---

## Funcionalidades 🔍

- **Cadastro de Funcionários:**  
  Permite inserir novos colaboradores no sistema, registrando informações como nome, CPF, cargo, tipo de contratação e salário. 📝

- **Cadastro de Cargos:**  
  Permite inserir novos cargos no sistema, registrando informações como nome e nível de experiência. 🏷️

- **Lista de Funcionários:**  
  Mostra uma lista com todos os funcionários e seus respectivos dados. 📋

- **Demição de Funcionários:**  
  Permite excluir do sistema os funcionários que não fazem mais parte da empresa, mantendo o banco de dados organizado. 🗑️

- **Folha de Pagamento:**  
  Geração de relatórios que auxiliam na análise de indicadores, como média salárial. 📈

- **Interface Amigável:**  
  Design simples e intuitivo, que proporciona um aprendizado rápido para os usuários. 😊e

---

## Tecnologias Utilizadas 💻

- **Linguagem de Programação:**  
  Java ☕

- **Persistência de Dados:**  
  JPA e Hibernate para mapeamento objeto-relacional 🔗

- **Banco de Dados:**  
  MySQL 🗄️

- **Interface Gráfica:**  
  JavaFX para o desenvolvimento da interface do usuário 🎨

---

## Pré-requisitos 🚀

Antes de executar o projeto, certifique-se de ter instalado:

- [Java JDK 8 ou superior](https://www.oracle.com/java/technologies/javase-downloads.html) ☕
- [MySQL](https://www.mysql.com/downloads/) 🗄️
- Uma IDE de sua preferência (por exemplo, Eclipse, IntelliJ IDEA ou NetBeans) 💡

---

## Instalação e Configuração ⚙️

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/Joaomos/gestao-funcionarios.git
   cd gestao-funcionarios
   ```

2. **Configuração do Banco de Dados:**

   - Crie um banco de dados no MySQL para o sistema.
   - Atualize o arquivo de configuração (por exemplo, `persistence.xml`) com as credenciais e a URL do banco de dados.  
   **Atenção:** O arquivo `persistence.xml` **não está presente** no repositório, pois foi incluído no `.gitignore` para manter as configurações locais seguras. Por isso, você precisará criar e configurar esse arquivo manualmente na pasta `src/main/resources/META-INF/`.

3. **Importe o Projeto no Eclipse:**

   - Abra o Eclipse e importe o projeto como um projeto Java existente.
   - Se necessário, configure as dependências via Maven ou Gradle conforme a estrutura do projeto.

4. **Compile e Execute:**

   - Compile o projeto utilizando sua IDE.
   - Execute a aplicação a partir da classe principal localizada em `src/main/java`.

---

## Como Utilizar 🌐

Após iniciar a aplicação:

- **Tela Login:**  
  Exibe uma tela de login, com a opção de login e de cadastro de novo usuário. 🔑

- **Tela Inicial:**  
  Exibe um menu, com acesso rápido às funções de cadastro de novo funcionário, cadastro de novo cargo, listagem dos funcionários, demição de funcionário e folha de pagamento. 🏠

- **Cadastro de Funcionários:**  
  Utilize o menu “Cadastrar Novo Funcionário” para inserir novos registros. Preencha os campos obrigatórios e salve as informações. ➕

- **Cadastro de Cargo:**  
  Utilize o menu “Cadastrar Novo Cargo” para inserir novos registros. Preencha os campos obrigatórios e salve as informações. ➕

- **Listagem de Funcionários:**  
  Visualize todos os registros na lista de funcionários. ✨

- **Demitir Funcionário:**  
  Utilize o menu “Demitir Funcionário” para remover funcionários. ➕
  
- **Folha de Pagamento:**  
  Navegue até a seção de folha de pagamento para ver estatísticas. 📊

---

## Observações Importantes ⚠️

- **Arquivo `persistence.xml`:**  
  Para proteger informações sensíveis e configurações locais, o arquivo `persistence.xml` foi adicionado ao `.gitignore` e **não está visível** no repositório do GitHub. Você deverá criar esse arquivo manualmente e configurá-lo de acordo com seu ambiente local.

---

## 📞 Contato

Se tiver dúvidas ou sugestões, entre em contato:

- **Nome:** João Marcos
- **E-mail:** joaomarcos2827@gmail.com
- **GitHub:** [Joaomos](https://github.com/Joaomos)
- **LinkedIn:** [João Marcos](https://www.linkedin.com/in/ojoaomarcosilva/)
