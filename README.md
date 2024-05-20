# Linguagens Formais, Autômatos e Computabilidade
### Trabalho 1º Bimestre

Faça o download do projeto e salve em alguma pasta em seu sistema. Abra a pasta e navegue até a pasta src, abra a pasta src em seu terminal e execute os códigos abaixo
```console
\src$ javac *.java
\src$ java App
```

#
## Interagir com o Programa

O programa solicitará várias entradas para configurar o AFD. Siga as instruções fornecidas no console:

* Quantidade de Estados: Digite o número total de estados do autômato.
* Estado Inicial: Digite o estado inicial (um número de 1 até a quantidade de estados).
* Quantidade de Símbolos no Alfabeto: Digite o número de símbolos no alfabeto do autômato.
* Símbolos: Para cada símbolo, o programa solicitará que você digite o caractere correspondente.
* Quantidade de Estados Finais: Digite o número de estados finais.
* Estados Finais: Para cada estado, o programa perguntará se ele é um estado final (digite 1 para sim e 0 para não).
* Tabela de Transição: Preencha a tabela de transição, informando para cada combinação de estado e símbolo o estado de destino correspondente.(digite -1 para estados sem transição)

## Testar Palavras

Após configurar o AFD, o programa solicitará que você digite uma palavra a ser testada. O programa verificará se a palavra é aceita pelo autômato e exibirá a mensagem correspondente.