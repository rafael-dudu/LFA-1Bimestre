import java.io.Console; // Importa a classe Console para entrada de dados
import java.util.Scanner; // Importa a classe Scanner para entrada de dados

public class Main { // Declara a classe Main
    private int qtdEst, qtdEstFin, estIni, qtdSbl, contPalavra, matInf[][];// Declara variáveis inteiras e uma matriz 2D
    private char vetSbl[];// Declara um array de caracteres
    private boolean vetEstFin[];// Declara um array de booleanos
    private String palavraTest;// Declara uma variável String
    private static Scanner scan = new Scanner(System.in);// Cria um objeto Scanner para entrada de dados

    public Main() { // Construtor da classe Main
        System.out.println("Digite a quantidade de estados : ");// Solicita ao usuário a quantidade de estados
        this.qtdEst = scan.nextInt();// Lê a quantidade de estados
        do { // Loop para garantir uma entrada válida do estado inicial
            System.out.println("Digite o estado inicial : ");// Solicita ao usuário o estado inicial
            this.estIni = scan.nextInt();// Lê o estado inicial
            if (estIni > qtdEst) { // Verifica se o estado inicial é maior que a quantidade de estados
                System.out.println("Estado inicial maior que quantidade de estados");// Exibe uma mensagem de erro
            }
        } while (estIni > qtdEst);// Repete se o estado inicial for inválido

        System.out.println("Digite a quantidade de simbolos no alfabeto ");// Solicita ao usuário a quantidade de símbolos
        this.qtdSbl = scan.nextInt();// Lê a quantidade de símbolos
        this.vetSbl = new char[qtdSbl];// Inicializa o array de símbolos

        for (int i = 1; i <= vetSbl.length; i++) {// Loop para ler cada símbolo
            System.out.println("Digite o " + i + "º simbolo: ");// Solicita ao usuário um símbolo
            this.vetSbl[i - 1] = scan.next().charAt(0); // Lê e armazena o símbolo
        }

        do {// Loop para garantir uma entrada válida dos estados finais
            System.out.println("Digite a quantidade de estados finais : ");// Solicita ao usuário a quantidade de estados finais
            qtdEstFin = scan.nextInt();// Lê a quantidade de estados finais
            if (qtdEstFin > qtdEst) {// Verifica se a quantidade de estados finais é maior que a quantidade de estados
                System.out.println("Estado final maior que quantidade de estados");// Exibe uma mensagem de erro
            }
        } while (qtdEstFin > qtdEst);// Repete se a quantidade de estados finais for inválida

        this.vetEstFin = new boolean[qtdEst];// Inicializa o array de estados finais
        for (int i = 1; i <= qtdEst; i++) {// Loop para determinar quais estados são finais
            int tmp;// Variável temporária para armazenar a entrada do usuário
            System.out.println("q" + i + " eh estado final?");// Solicita ao usuário para informar se o estado é final
            tmp = scan.nextInt();// Lê a entrada
            if (tmp == 1) {// Se a entrada for 1, marca o estado como final
                vetEstFin[i - 1] = true;// Define o estado como final
                qtdEstFin--;// Decrementa a quantidade de estados finais a serem definidos
            }
            if (0 == qtdEstFin) {// Se todos os estados finais foram definidos, sai do loop
                break;
            }
        }
        System.out.println("TABELA DE TRANSICAO");// Imprime o cabeçalho da tabela de transição
        System.out.printf("%2s", " ");// Imprime um espaço para formatação
        for (int i = 0; i < qtdSbl; i++) {// Loop para imprimir os símbolos no cabeçalho da tabela de transição
            System.out.printf("%5c", vetSbl[i]);// Imprime cada símbolo
        }
        System.out.println();// Move para a próxima linha

        for (int i = 1; i <= qtdEst; i++) {// Loop para imprimir cada linha de estado na tabela de transição
            System.out.printf("q%d", i);// Imprime o estado
            for (int j = 1; j <= qtdSbl; j++) {// Loop para imprimir valores de transição de espaço reservado
                System.out.printf(" %2d,%d", i, j);// Imprime valores de espaço reservado
            }
            System.out.println(); // Move para a próxima linha
        }
        this.matInf = new int[qtdEst][qtdSbl];// Inicializa a matriz de transição
        for (int i = 1; i <= qtdEst; i++) {// Loop para ler cada transição
            for (int j = 1; j <= qtdSbl; j++) {// Loop para ler cada transição para o estado atual
                System.out.println("Preencha a transicao: " + i + "," + j);// Solicita ao usuário para preencher a transição
                matInf[i - 1][j - 1] = scan.nextInt(); // Lê e armazena a transição
            }
        }
    }

    public void pegarPalavra() {// Método para ler a palavra a ser testada
        Console con = System.console();// Obtém o objeto console
        System.out.println("digite a palavra a ser testada");// Solicita ao usuário para digitar a palavra
        Scanner sc = new Scanner(con.reader());// Cria um novo Scanner para entrada no console
        this.palavraTest = sc.nextLine();// Lê a palavra
        this.contPalavra = 0; // Inicializa o contador de posição da palavra
        sc.close();// Fecha o scanner
        testarPalavra(estIni - 1, palavraTest.charAt(contPalavra));// Inicia o teste da palavra
    }

    private void testarPalavra(int i, char charAt) {// Método recursivo para testar a palavra
        for (int j = 0; j < vetSbl.length; j++) { // Loop para encontrar o caractere atual no array de símbolos
            if (vetSbl[j] == charAt && (matInf[i][j] != -1)) { // Se o caractere corresponder e a transição for válida
                contPalavra++;// Move para o próximo caractere na palavra
                try {
                    testarPalavra(matInf[i][j] - 1, palavraTest.charAt(contPalavra));// Testa recursivamente o próximo caractere
                } catch (Exception e) {// Captura exceção se o fim da palavra for alcançado
                    if (vetEstFin[matInf[i][j] - 1]) {// Se o estado atual for final
                        System.out.println("Palavra aceita!");// Palavra aceita
                    }
                    return;// Sai do método
                }
                return; // Sai do método após processar o caractere atual
            }
        }
        System.out.println("Palavra nao aceita!");// Se nenhuma transição válida for encontrada, a palavra não é aceita
        return;// Sai do método
    }
}