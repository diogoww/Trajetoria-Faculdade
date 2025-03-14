# Lista de times
times = ['Astralis', 'Na`Vi', 'G2', 'Vitality', 'Liquid', 'FURIA']

# Lista de resultados [time1, time2, resultado_time1, resultado_time2]
resultados = [
    ['Astralis', 'G2', 16, 10],
    ['Na`Vi', 'Vitality', 16, 8],
    ['Liquid', 'FURIA', 16, 14],
    ['Astralis', 'Liquid', 16, 13],
    ['G2', 'FURIA', 16, 12],
    ['Vitality', 'Astralis', 16, 14],
    ['Na`Vi', 'Liquid', 16, 11],
    ['FURIA', 'Vitality', 16, 13],
    ['Astralis', 'Na`Vi', 16, 12],
    ['G2', 'Vitality', 16, 14],
    ['Liquid', 'Astralis', 16, 12],
    ['FURIA', 'Na`Vi', 16, 14],
]

# Dicionário para armazenar a pontuação de cada time
pontuacao = {time: {'pontos': 0, 'jogos': 0, 'vitorias': 0} for time in times}

# Loop para atualizar a pontuação de cada time
for jogo in resultados:
    time1, time2, resultado1, resultado2 = jogo
    if resultado1 > resultado2:
        pontuacao[time1]['pontos'] += 3
        pontuacao[time1]['vitorias'] += 1
    elif resultado1 < resultado2:
        pontuacao[time2]['pontos'] += 3
        pontuacao[time2]['vitorias'] += 1
    else:
        pontuacao[time1]['pontos'] += 1
        pontuacao[time2]['pontos'] += 1
    pontuacao[time1]['jogos'] += 1
    pontuacao[time2]['jogos'] += 1

# Classificar os times por pontos e exibir a tabela
classificacao = sorted(pontuacao.items(), key=lambda x: (-x[1]['pontos'], -x[1]['vitorias']))
print('Tabela de classificação:')
print('{:<15} {:<10} {:<10} {:<10}'.format('Time', 'Pontos', 'Vitórias', 'Jogos'))
for time, pontos in classificacao:
    print('{:<15} {:<10} {:<10} {:<10}'.format(time, pontos['pontos'], pontos['vitorias'], pontos['jogos']))