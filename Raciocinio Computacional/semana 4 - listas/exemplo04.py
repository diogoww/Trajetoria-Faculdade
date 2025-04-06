# Dada a lista de dados nums = [17, 33, 23, 11, 8, 15, 9], percorra a lista e identifique o maior e o menor número.
nums = [17, 33, 23, 11, 8, 15, 9]
maior = nums[0]
menor = nums[0]

for num in nums:
    if num > maior:
        maior = num
    if num < menor:
        menor = num
print("o maior numero da lista eh: ", maior, " e o menor eh: ", menor)