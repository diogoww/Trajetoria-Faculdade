# Solicite ao usuário que digite três coordenadas (x, y), armazenando-as em uma matriz bidimensional.
coordenadas = []
for i in range(3):
    x = int(input("insira um valor de x: "))
    y = int(input("insira um valor de y: "))
    coordenadas.append([x, y])
print(coordenadas)