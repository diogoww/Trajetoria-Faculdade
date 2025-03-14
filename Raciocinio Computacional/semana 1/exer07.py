# 7. Crie um algoritmo que solicita ao usuário que insira dois números e exibe na tela o resultado da soma, subtração, multiplicação e divisão desses números.

num1 = float(input("digite o primeiro numero: "))
num2 = float(input("digite o segundo numero: "))

soma = num1 + num2
subtracao = num1 - num2
multiplicacao = num1 * num2
divisao = num1 / num2

print(f"soma: {soma}")
print(f"subtracao: {subtracao}")
print(f"multiplicacao: {multiplicacao}")
print(f"divisao: {divisao}")
