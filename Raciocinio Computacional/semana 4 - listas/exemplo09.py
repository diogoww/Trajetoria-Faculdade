# Em uma competição de saltos ornamentais, são obtidas dos jurados sete notas, sendo eliminadas a maior e a menor. A nota final do salto é feita pela soma das demais notas. Crie um programa que receba as notas dos juízes, remova a maior e menor nota e some as demais, fazendo uso de métodos de listas e funções built in.
notas = []
for _ in range(7):
    nota = float(input("entre com uma das notas: "))
    notas.append(nota)
menor = min(notas)

if notas.count(menor) == 1:
    notas.remove(menor)
else:
    indice = -1
    for i in range(len(notas)):
        if notas[i] == menor:
            indice = i
            break
    notas.pop(indice)

maior = max(notas)
if notas.count(maior) == 1:
    notas.remove(maior)
else:
    indice = -1
    for i in range(len(notas)):
        if notas[i] == maior:
            indice = i
            break
    notas.pop(indice)

soma = sum(notas)
print(f"a pontuação final foi: {soma:.1f}")