# Elabore um programa que solicite ao usuário cinco números e exiba duas listas separadas: uma contendo somente números pares e outra contendo somente números ímpares.
par = []
impar = []

for i in range(5):
    num = int(input("digite um numero: "))
    if num % 2 == 0:
        par.append(num)
    else:
        impar.append(num)
print("pares: ", par, "- impar: ", impar)