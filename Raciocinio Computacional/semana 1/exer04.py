# 4. Crie um algoritmo que solicita ao usuário que insira um número e exibe na tela se ele é positivo, negativo ou zero.

num = float(input("digite um numero: "))
if num > 0:
    print("positivo")
elif num == 0:
    print("neutro")
elif num < 0:
    print("negativo")