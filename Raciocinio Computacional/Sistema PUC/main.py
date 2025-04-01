while True:
    print("---- MENU PRINCIPAL ----")
    print("(1) Gerenciar Estudantes.")
    print("(2) Gerenciar Professores.")
    print("(3) Gerenciar Disciplinas.")
    print("(4) Gerenciar Turmas.")
    print("(5) Gerenciar Matrículas.")
    print("(0) Sair.")
    opcao = int(input("Informe a opção desejada: "))

    if opcao >= 1 and opcao <= 5:
        while True:
            print(f"Você escolheu a opção {opcao}.")
            print("\n")

            print(f"Menu de Operações - Opção {opcao}")
            print("(1) Incluir.")
            print("(2) Listar.")
            print("(3) Atualizar.")
            print("(4) Excluir.")
            print("(0) Voltar ao Menu Principal.")

            opcaoSec = int(input("Informe a opção desejada: "))
            print(f"Você escolheu a opção {opcaoSec}.")
            if opcaoSec >= 1 and opcaoSec <= 4:
                print(f"Você escolheu a opção {opcaoSec}.")
            elif opcaoSec == 0:
                print("\n")
                print("Voltando ao menu principal...")
                break
            else:
                print("Escolha uma opção VÁLIDA")

            print("\n")
            print("==== ATUALIZAÇÃO ====")
            print("Finalizando aplicação...")
    elif opcao == 0:
        print("\n")
        print("Saindo...")
        break
    else:
        print("Escolha uma opção **VÁLIDA**")