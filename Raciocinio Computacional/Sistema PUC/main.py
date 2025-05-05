#NOME: Diogo José Varaschin de Oliveira
#CURSO: ADS
#FACULDADE: PUCPR

import json
import os

# json p/ os estudantes
def salvarEstudantes(nomesEstudantes):
     with open('estudantes.json', 'w', encoding='utf-8') as f:
          json.dump(nomesEstudantes, f, ensure_ascii=False, indent=4)

def carregarEstudantes():
    if os.path.exists('estudantes.json'):
          with open('estudantes.json', 'r', encoding='utf-8') as f:
               return json.load(f)
    else:
         return[]
    
#json p/ os profs
def salvarProfessores(professores):
    with open('professores.json', 'w', encoding='utf-8') as f:
        json.dump(professores, f, ensure_ascii=False, indent=4)

def carregarProfessores():
    if os.path.exists('professores.json'):
        with open('professores.json', 'r', encoding='utf-8') as f:
            return json.load(f)
    else:
        return []

#json p/ as disciplinas
def salvarDisciplinas(disciplinas):
    with open('disciplinas.json', 'w', encoding='utf-8') as f:
        json.dump(disciplinas, f, ensure_ascii=False, indent=4)

def carregarDisciplinas():
    if os.path.exists('disciplinas.json'):
        with open('disciplinas.json', 'r', encoding='utf-8') as f:
            return json.load(f)
    else:
        return []

#json p/ as turmas
def salvarTurmas(turmas):
    with open('turmas.json', 'w', encoding='utf-8') as f:
        json.dump(turmas, f, ensure_ascii=False, indent=4)

def carregarTurmas():
    if os.path.exists('turmas.json'):
        with open('turmas.json', 'r', encoding='utf-8') as f:
            return json.load(f)
    else:
        return []
    
#json p/ as matriculas
def salvarMatriculas(matriculas):
    with open('matriculas.json', 'w', encoding='utf-8') as f:
        json.dump(matriculas, f, ensure_ascii=False, indent=4)

def carregarMatriculas():
    if os.path.exists('matriculas.json'):
        with open('matriculas.json', 'r', encoding='utf-8') as f:
            return json.load(f)
    else:
        return []

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

#funcionalidades p/ estudantes
def incluirEstudante(nomesEstudantes):
    print("OPÇÃO 1 - INCLUIR ESTUDANTES")
    codigo = int(input("digite o codigo do estudante: "))
    nome = input("Digite o nome do Estudante: ")
    cpf = input("digite o cpf do estudante: ")

    estudante = {"codigo": codigo, "nome": nome, "cpf": cpf}

    nomesEstudantes = carregarEstudantes()
    nomesEstudantes.append(estudante)
    salvarEstudantes(nomesEstudantes)

def listarEstudantes(nomesEstudantes):
    print("OPÇÃO 2 - LISTAR ESTUDANTES")
    nomesEstudantes = carregarEstudantes()
    if not nomesEstudantes:
            print("Não há estudantes cadastrados")
    else:
        for estudante in nomesEstudantes:
            print(f"codigo: {estudante['codigo']}, nome: {estudante['nome']}, CPF: {estudante['cpf']}")

def atualizarEstudante(nomesEstudantes):
    print("OPÇÃO 3 - ATUALIZAR ESTUDANTE")
    nomesEstudantes = carregarEstudantes()
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
    if estEncontrado:
        salvarEstudantes(nomesEstudantes)
    else:
        print("estudante nao encontrado!")

def excluirEstudante(nomesEstudantes):
    print("OPÇÃO 4 - EXCLUIR ESTUDANTE")
    nomesEstudantes = carregarEstudantes()
    excluir = int(input("digite o código do estudante que deseja excluir: "))
    estEncontrado = False

    for estudante in nomesEstudantes:
            if estudante["codigo"] == excluir:
                nomesEstudantes.remove(estudante)
                print("estudante removido com sucesso!")
                estEncontrado = True
                break
    if estEncontrado:
        salvarEstudantes(nomesEstudantes)
    else:
        print("estudante nao encontrado")

#funcionalidades p/ opção profs
def incluirProfessor(professores):
    print("OPÇÃO 1 - INCLUIR PROFESSOR")
    codigo = int(input("Digite o código do professor: "))
    nome = input("Digite o nome do professor: ")
    cpf = input("Digite o CPF do professor: ")

    professor = {"codigo": codigo, "nome": nome, "cpf": cpf}

    professores = carregarProfessores()
    professores.append(professor)
    salvarProfessores(professores)

def listarProfessores(professores):
    print("OPÇÃO 2 - LISTAR PROFESSORES")
    professores = carregarProfessores()
    if not professores:
        print("Não há professores cadastrados")
    else:
        for professor in professores:
            print(f"Código: {professor['codigo']}, Nome: {professor['nome']}, CPF: {professor['cpf']}")

def atualizarProfessor(professores):
    print("OPÇÃO 3 - ATUALIZAR PROFESSOR")
    professores = carregarProfessores()
    editar = int(input("Digite o código do professor que deseja atualizar: "))
    profEncontrado = False
    
    for professor in professores:
        if professor["codigo"] == editar:
            novoCodigo = int(input("Digite um novo código: "))
            novoNome = input("Digite o novo nome: ")
            novoCpf = input("Digite o novo CPF: ")

            professor["codigo"] = novoCodigo
            professor["nome"] = novoNome
            professor["cpf"] = novoCpf

            print("Professor atualizado com sucesso!")
            profEncontrado = True
            break
    
    if profEncontrado:
        salvarProfessores(professores)
    else:
        print("Professor não encontrado!")

def excluirProfessor(professores):
    print("OPÇÃO 4 - EXCLUIR PROFESSOR")
    professores = carregarProfessores()
    excluir = int(input("Digite o código do professor que deseja excluir: "))
    profEncontrado = False

    for professor in professores:
        if professor["codigo"] == excluir:
            professores.remove(professor)
            print("Professor removido com sucesso!")
            profEncontrado = True
            break
    
    if profEncontrado:
        salvarProfessores(professores)
    else:
        print("Professor não encontrado")

#funcionalidades p/ opcao disciplinas
def incluirDisciplina(disciplinas):
    print("OPÇÃO 1 - INCLUIR DISCIPLINA")
    codigo = int(input("Digite o código da disciplina: "))
    nome = input("Digite o nome da disciplina: ")

    disciplina = {"codigo": codigo, "nome": nome}

    disciplinas = carregarDisciplinas()
    disciplinas.append(disciplina)
    salvarDisciplinas(disciplinas)

def listarDisciplinas(disciplinas):
    print("OPÇÃO 2 - LISTAR DISCIPLINAS")
    disciplinas = carregarDisciplinas()
    if not disciplinas:
        print("Não há disciplinas cadastradas")
    else:
        for disciplina in disciplinas:
            print(f"Código: {disciplina['codigo']}, Nome: {disciplina['nome']}")

def atualizarDisciplina(disciplinas):
    print("OPÇÃO 3 - ATUALIZAR DISCIPLINA")
    disciplinas = carregarDisciplinas()
    editar = int(input("Digite o código da disciplina que deseja atualizar: "))
    discEncontrada = False
    
    for disciplina in disciplinas:
        if disciplina["codigo"] == editar:
            novoCodigo = int(input("Digite um novo código: "))
            novoNome = input("Digite o novo nome: ")

            disciplina["codigo"] = novoCodigo
            disciplina["nome"] = novoNome

            print("Disciplina atualizada com sucesso!")
            discEncontrada = True
            break
    
    if discEncontrada:
        salvarDisciplinas(disciplinas)
    else:
        print("Disciplina não encontrada!")

def excluirDisciplina(disciplinas):
    print("OPÇÃO 4 - EXCLUIR DISCIPLINA")
    disciplinas = carregarDisciplinas()
    excluir = int(input("Digite o código da disciplina que deseja excluir: "))
    discEncontrada = False

    for disciplina in disciplinas:
        if disciplina["codigo"] == excluir:
            disciplinas.remove(disciplina)
            print("Disciplina removida com sucesso!")
            discEncontrada = True
            break
    
    if discEncontrada:
        salvarDisciplinas(disciplinas)
    else:
        print("Disciplina não encontrada")


nomesEstudantes = carregarEstudantes()

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
