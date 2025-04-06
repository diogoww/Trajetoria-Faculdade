# Elabore um programa que solicite ao usuário cinco números, armazene-os em uma lista e exiba como resultado os dados obtidos.
nums = [] 
for i in range(5):
    num = int(input("digite um numero: ")) 
    nums.append(num)
print(nums)