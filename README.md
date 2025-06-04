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

- Clone o repositório:
git clone https://github.com/evemqs/gerenciadorSenhas.git
cd gerenciadorSenhas

- Execute:
Vá para classe 'Main' e segure Shift + F10

*Obs: Baixar as dependências caso ainda não estejam baixadas