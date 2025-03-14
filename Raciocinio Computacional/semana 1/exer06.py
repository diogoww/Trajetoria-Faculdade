# 6. Crie um algoritmo que solicita ao usuário que insira a sua altura em metros e o seu peso em quilogramas e exibe na tela o seu índice de massa corporal (IMC).

altura = float(input("digite sua altura em metros: "))
peso = float(input("digite seu peso em kg: "))

imc = peso / altura ** 2

print(f"seu imc eh: {imc}")