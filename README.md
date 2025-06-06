# Gerenciador de Senhas  para Serviços

Funcionalidades:

- Autenticação em dois fatores com Google Authenticator
- Criptografia de senhas com BCrypt
- Verificação de vazamentos de senhas com HaveIBeenPwned
- Geração de senhas

## Estrutura

- auth/TwoFactorAuth - Autenticação de dois fatores do Google Authenticator
- generator/PasswordGenerator - Geração de senhas
- leak/PasswordLeakChecker - Mostra no console se a senha foi vazada
- leak/PwnedPassword - Verifica se a senha foi vazada
- PasswordService - Salva as senhas criptografadas, o usuario e os serviços dentro de um arquivo JSON
- PasswordStorage - Carrega um arquivo JSON caso haja um armazenado, se não ele cria um novo
- Main - Executa todo o código

## Requisitos

- Java 11 ou superior
- Maven
- Recomendado usar o IntelliJ

## Como Executar o Projeto

1. Clone o repositório:
   - git clone https://github.com/evemqs/gerenciadorSenhas.git
   - cd gerenciadorSenhas

2. Execute (Use o terminal do Command Prompt ou do Git Bash):
   - Abra o terminal e rode:
     - mvn clean install
     - mvn dependency:resolve

   - Depois de instalar o Maven e suas dependências rode:
     - mvn exec:java -Dexec.mainClass="Main"
     - Ou, se estiver no IntelliJ, selecione a classe Main e rode (Shift+F10)

## Possíveis erros

'javac' n�o � reconhecido como um comando interno
ou externo, um programa oper�vel ou um arquivo em lotes.

1. Instale o JDK 21 (Java Development Kit) se ainda não tiver instalado.
2. Adicione o caminho da pasta bin do JDK (por exemplo, C:\Program Files\Java\jdk-XX\bin) à variável de ambiente PATH do Windows.
3. Abra o terminal e digite: javac -version, se aparecer a versão, está funcionando.
4. Caso não funcione, reinicie a IDE.