# Solicite ao usuário que entre com diversos nomes, informando de forma separada nome e último sobrenome. Ao final, mostre uma lista de nomes no formato: sobrenome, nome. Para encerrar a entrada de dados, basta o usuário inserir no nome o texto “sair”
nomes = []
while True:
    nome = input("digite um nome: ")
    if nome == "sair":
        break
    sobrenome = input("digite o sobrenome: ")
    nome_completo = [nome, sobrenome]
    nomes.append(nome_completo)

for nome in nomes:
    print(nome[1] + ", " + nome[0])