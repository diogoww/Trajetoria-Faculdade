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

#funcionalidades p/ opcao gerenciar estudantes
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

#funcionalidades p/ opção gerenciar profs
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
            novoCodigo = int(input("Digite um novo codigo: "))
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
    excluir = int(input("Digite o codigo do professor que deseja excluir: "))
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

#funcionalidades p/ opcao gerenciar disciplinas
def incluirDisciplina(disciplinas):
    print("OPÇÃO 1 - INCLUIR DISCIPLINA")
    codigo = int(input("Digite o codigo da disciplina: "))
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

#funcionalidade p/ opcaoo gerenciar turmas
def incluirTurma(turmas):
    print("OPÇÃO 1 - INCLUIR TURMA")
    codigo = int(input("Digite o código da turma: "))
    cod_professor = int(input("Digite o código do professor: "))
    cod_disciplina = int(input("Digite o código da disciplina: "))

    professores = carregarProfessores()
    prof_existe = any(prof['codigo'] == cod_professor for prof in professores)
    
    disciplinas = carregarDisciplinas()
    disc_existe = any(disc['codigo'] == cod_disciplina for disc in disciplinas)
    
    if not prof_existe:
        print("Erro: Professor não encontrado!")
        return
    if not disc_existe:
        print("Erro: Disciplina não encontrada!")
        return

    turma = {"codigo": codigo, "cod_professor": cod_professor, "cod_disciplina": cod_disciplina}

    turmas = carregarTurmas()
    if any(t['codigo'] == codigo for t in turmas):
        print("Erro: Já existe uma turma com este código!")
        return
    
    turmas.append(turma)
    salvarTurmas(turmas)
    print("Turma cadastrada com sucesso!")

def listarTurmas(turmas):
    print("OPÇÃO 2 - LISTAR TURMAS")
    turmas = carregarTurmas()
    if not turmas:
        print("Não há turmas cadastradas")
    else:
        for turma in turmas:
            print(f"Código: {turma['codigo']}, Cód. Professor: {turma['cod_professor']}, Cód. Disciplina: {turma['cod_disciplina']}")

def atualizarTurma(turmas):
    print("OPÇÃO 3 - ATUALIZAR TURMA")
    turmas = carregarTurmas()
    editar = int(input("Digite o código da turma que deseja atualizar: "))
    turmaEncontrada = False
    
    for turma in turmas:
        if turma["codigo"] == editar:
            novoCodigo = int(input("Digite um novo código: "))
            novoCodProf = int(input("Digite o novo código do professor: "))
            novoCodDisc = int(input("Digite o novo código da disciplina: "))

            professores = carregarProfessores()
            prof_existe = any(prof['codigo'] == novoCodProf for prof in professores)
            
            disciplinas = carregarDisciplinas()
            disc_existe = any(disc['codigo'] == novoCodDisc for disc in disciplinas)
            
            if not prof_existe:
                print("Erro: Professor não encontrado!")
                return
            if not disc_existe:
                print("Erro: Disciplina não encontrada!")
                return

            turma["codigo"] = novoCodigo
            turma["cod_professor"] = novoCodProf
            turma["cod_disciplina"] = novoCodDisc

            print("Turma atualizada com sucesso!")
            turmaEncontrada = True
            break
    
    if turmaEncontrada:
        salvarTurmas(turmas)
    else:
        print("Turma não encontrada!")

def excluirTurma(turmas):
    print("OPÇÃO 4 - EXCLUIR TURMA")
    turmas = carregarTurmas()
    excluir = int(input("Digite o código da turma que deseja excluir: "))
    turmaEncontrada = False

    for turma in turmas:
        if turma["codigo"] == excluir:
            turmas.remove(turma)
            print("Turma removida com sucesso!")
            turmaEncontrada = True
            break
    
    if turmaEncontrada:
        salvarTurmas(turmas)
    else:
        print("Turma não encontrada")

#funcionalidade p/ opcao gferenciar matricuals
def incluirMatricula(matriculas):
    print("OPÇÃO 1 - INCLUIR MATRÍCULA")
    cod_turma = int(input("Digite o código da turma: "))
    cod_estudante = int(input("Digite o código do estudante: "))

    turmas = carregarTurmas()
    turma_existe = any(turma['codigo'] == cod_turma for turma in turmas)
    
    estudantes = carregarEstudantes()
    estudante_existe = any(est['codigo'] == cod_estudante for est in estudantes)
    
    if not turma_existe:
        print("Erro: Turma não encontrada!")
        return
    if not estudante_existe:
        print("Erro: Estudante não encontrado!")
        return

    matricula = {"cod_turma": cod_turma, "cod_estudante": cod_estudante}

    matriculas = carregarMatriculas()
    if any(m['cod_turma'] == cod_turma and m['cod_estudante'] == cod_estudante for m in matriculas):
        print("Erro: Esta matrícula já existe!")
        return
    
    matriculas.append(matricula)
    salvarMatriculas(matriculas)
    print("Matrícula cadastrada com sucesso!")

def listarMatriculas(matriculas):
    print("OPÇÃO 2 - LISTAR MATRÍCULAS")
    matriculas = carregarMatriculas()
    if not matriculas:
        print("Não há matrículas cadastradas")
    else:
        for matricula in matriculas:
            print(f"Cód. Turma: {matricula['cod_turma']}, Cód. Estudante: {matricula['cod_estudante']}")

def atualizarMatricula(matriculas):
    print("OPÇÃO 3 - ATUALIZAR MATRÍCULA")
    matriculas = carregarMatriculas()
    cod_turma = int(input("Digite o código da turma da matrícula que deseja atualizar: "))
    cod_estudante = int(input("Digite o código do estudante da matrícula que deseja atualizar: "))
    matriculaEncontrada = False
    
    for matricula in matriculas:
        if matricula["cod_turma"] == cod_turma and matricula["cod_estudante"] == cod_estudante:
            novoCodTurma = int(input("Digite o novo código da turma: "))
            novoCodEst = int(input("Digite o novo código do estudante: "))

            turmas = carregarTurmas()
            turma_existe = any(turma['codigo'] == novoCodTurma for turma in turmas)
            
            estudantes = carregarEstudantes()
            estudante_existe = any(est['codigo'] == novoCodEst for est in estudantes)
            
            if not turma_existe:
                print("Erro: Turma não encontrada!")
                return
            if not estudante_existe:
                print("Erro: Estudante não encontrado!")
                return

            matricula["cod_turma"] = novoCodTurma
            matricula["cod_estudante"] = novoCodEst

            print("Matrícula atualizada com sucesso!")
            matriculaEncontrada = True
            break
    
    if matriculaEncontrada:
        salvarMatriculas(matriculas)
    else:
        print("Matrícula não encontrada!")

def excluirMatricula(matriculas):
    print("OPÇÃO 4 - EXCLUIR MATRÍCULA")
    matriculas = carregarMatriculas()
    cod_turma = int(input("Digite o código da turma da matrícula que deseja excluir: "))
    cod_estudante = int(input("Digite o código do estudante da matrícula que deseja excluir: "))
    matriculaEncontrada = False

    for matricula in matriculas:
        if matricula["cod_turma"] == cod_turma and matricula["cod_estudante"] == cod_estudante:
            matriculas.remove(matricula)
            print("Matrícula removida com sucesso!")
            matriculaEncontrada = True
            break
    
    if matriculaEncontrada:
        salvarMatriculas(matriculas)
    else:
        print("Matrícula não encontrada")
        
nomesEstudantes = carregarEstudantes()
professores = carregarProfessores()
disciplinas = carregarDisciplinas()
turmas = carregarTurmas()
matriculas = carregarMatriculas()

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

    elif opcao == 2:
        while True:
            opcaoSec = menuOperacoes(opcao)
            print(f"Você escolheu a opção {opcaoSec}.")

            if opcaoSec == 1:
                incluirProfessor(professores)
            elif opcaoSec == 2:
                listarProfessores(professores)
            elif opcaoSec == 3:
                atualizarProfessor(professores)
            elif opcaoSec == 4:
                excluirProfessor(professores)
            elif opcaoSec == 0:
                print("\n")
                print("Voltando ao menu principal...")
                break
            else:
                print("Escolha uma opção VÁLIDA")
            print("\n")

    elif opcao == 3:
        while True:
            opcaoSec = menuOperacoes(opcao)
            print(f"Você escolheu a opção {opcaoSec}.")

            if opcaoSec == 1:
                incluirDisciplina(disciplinas)
            elif opcaoSec == 2:
                listarDisciplinas(disciplinas)
            elif opcaoSec == 3:
                atualizarDisciplina(disciplinas)
            elif opcaoSec == 4:
                excluirDisciplina(disciplinas)
            elif opcaoSec == 0:
                print("\n")
                print("Voltando ao menu principal...")
                break
            else:
                print("Escolha uma opção VÁLIDA")
            print("\n")

    elif opcao == 4:
        while True:
            opcaoSec = menuOperacoes(opcao)
            print(f"Você escolheu a opção {opcaoSec}.")

            if opcaoSec == 1:
                incluirTurma(turmas)
            elif opcaoSec == 2:
                listarTurmas(turmas)
            elif opcaoSec == 3:
                atualizarTurma(turmas)
            elif opcaoSec == 4:
                excluirTurma(turmas)
            elif opcaoSec == 0:
                print("\n")
                print("Voltando ao menu principal...")
                break
            else:
                print("Escolha uma opção VÁLIDA")
            print("\n")

    elif opcao == 5:
        while True:
            opcaoSec = menuOperacoes(opcao)
            print(f"Você escolheu a opção {opcaoSec}.")

            if opcaoSec == 1:
                incluirMatricula(matriculas)
            elif opcaoSec == 2:
                listarMatriculas(matriculas)
            elif opcaoSec == 3:
                atualizarMatricula(matriculas)
            elif opcaoSec == 4:
                excluirMatricula(matriculas)
            elif opcaoSec == 0:
                print("\n")
                print("Voltando ao menu principal...")
                break
            else:
                print("Escolha uma opção VÁLIDA")
            print("\n")

    elif opcao == 0:
                print("\n")
                print("Saindo...")
                print("Finalizando aplicação...")
                break
    else:
                print("Escolha uma opção **VÁLIDA**")