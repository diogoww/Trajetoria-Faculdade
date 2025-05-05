#NOME: Diogo José Varaschin de Oliveira
#CURSO: ADS
#FACULDADE: PUCPR
def menuPrincipal():
    print("---- MENU PRINCIPAL ----")
    print("(1) Gerenciar Estudantes.")
    print("(2) Gerenciar Professores.")
    print("(3) Gerenciar Disciplinas.")
    print("(4) Gerenciar Turmas.")
    print("(5) Gerenciar Matrículas.")
    print("(0) Sair.")
    return int(input("Informe a opção desejada: "))

def menuOperacoes(opcao):
    print(f"Você escolheu a opção {opcao}.")
    print("\n")

    print(f"Menu de Operações - Opção {opcao}")
    print("(1) Incluir.")
    print("(2) Listar.")
    print("(3) Atualizar.")
    print("(4) Excluir.")
    print("(0) Voltar ao Menu Principal.")
    return int(input("Informe a opção desejada: "))

def incluirEstudante(nomesEstudantes):
    print("OPÇÃO 1 - INCLUIR ESTUDANTES")
    codigo = int(input("digite o codigo do estudante: "))
    nome = input("Digite o nome do Estudante: ")
    cpf = input("digite o cpf do estudante: ")

    estudante = {"codigo": codigo, "nome": nome, "cpf": cpf}
    nomesEstudantes.append(estudante)

def listarEstudantes(nomesEstudantes):
    print("OPÇÃO 2 - LISTAR ESTUDANTES")
    if not nomesEstudantes:
            print("Não há estudantes cadastrados")
    else:
        for estudante in nomesEstudantes:
            print(f"codigo: {estudante['codigo']}, nome: {estudante['nome']}, CPF: {estudante['cpf']}")

def atualizarEstudante(nomesEstudantes):
    print("OPÇÃO 3 - ATUALIZAR ESTUDANTE")
    editar = int(input("digite o código do estudante que deseja atualizar: "))
    estEncontrado = False
    for estudante in nomesEstudantes:
            if estudante["codigo"] == editar:
                novoCodigo = int(input("digite um novo código: "))
                novoNome = input("digite o novo nome: ")
                novoCpf = input("digite o novo cpf: ")

                estudante["codigo"] = novoCodigo
                estudante["nome"] = novoNome
                estudante["cpf"] = novoCpf

                print("atualizado com sucesso!")
                estEncontrado = True
                break
            if not estEncontrado:
                print("estudante nao encontrado!")

def excluirEstudante(nomesEstudantes):
    print("OPÇÃO 4 - EXCLUIR ESTUDANTE")
    excluir = int(input("digite o código do estudante que deseja excluir: "))
    estEncontrado = False

    for estudante in nomesEstudantes:
            if estudante["codigo"] == excluir:
                nomesEstudantes.remove(estudante)
                print("estudante removido com sucesso!")
                estEncontrado = True
                break
    if not estEncontrado:
        print("estudante nao encontrado")

nomesEstudantes = []
while True:
    opcao = menuPrincipal()

    if opcao == 1:
            while True:
                opcaoSec = menuOperacoes(opcao)
                print(f"Você escolheu a opção {opcaoSec}.")

                if opcaoSec == 1:
                    incluirEstudante(nomesEstudantes)
                elif opcaoSec == 2:
                    listarEstudantes(nomesEstudantes)
                elif opcaoSec == 3:
                    atualizarEstudante(nomesEstudantes)
                elif opcaoSec == 4:
                    excluirEstudante(nomesEstudantes)
                elif opcaoSec == 0:
                    print("\n")
                    print("Voltando ao menu principal...")
                    break
                else:
                    print("Escolha uma opção VÁLIDA")
                print("\n")
                
    elif opcao >= 2 and opcao <=5:
          print("EM DESENVOLVIMENTO...")
          print("Voltando ao menu principal...")
          print("\n")
    elif opcao == 0:
                print("\n")
                print("Saindo...")
                print("Finalizando aplicação...")
                break
    else:
                print("Escolha uma opção **VÁLIDA**")