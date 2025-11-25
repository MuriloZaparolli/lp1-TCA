import java.util.Random;
import java.util.Scanner;

public class TCA {
    final static Scanner SC = new Scanner(System.in);

    // define as variaveis globais utilizadas
    static int cmdDoPlayer;
    static boolean ctrl;
    static Random rng = new Random();
    static int chanceItem;
    static int id_mochila = 0;
    static boolean[] triangulos = new boolean[3];
    static int cmdMochila = -1;
    private static boolean mochila = false;
    static int quantMaxCmds;

    // utilizado para usar a classe Personagem
    static Personagem player = new Personagem();

    // inicializa o vetor da mochila do player como vazia para não ter problemas
    static {
        for (int i = 0; i < player.mochila.length; i++) {
            player.mochila[i] = " ";
        }
    }

    // inicializa o vetor de triangulos
    static {
        for (int i = 0; i < triangulos.length; i++) {
            triangulos[i] = false;
        }
    }

    // limpa a tela do usuario
    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }

        System.out.print("\033\143");
    }

    // Método utilizado para receber o comando do jogador e impossibilitá-lo de colocar comandos não permitidos
    static void receberComando(int max) {
        // impossibilita a continuação do codigo
        ctrl = true;

        do {
            cmdDoPlayer = SC.nextInt(); // recebe o comando

            //verifica se está dentro do permitido
            if (cmdDoPlayer < 1 || cmdDoPlayer > max) {

                // avisa o usuario que o comando não foi reconhecido
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("Comando não reconhecido");
                System.out.println("-------------------------------------------------------------------------------------------------");

                // re faz os passos anteriores
                continue;
            }

            // permite que o codigo prossiga
            ctrl = false;
        } while (ctrl);

        limparTela();

        ctrl = true;
    }

    // metodo de inicialização
    static void bemVindos() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Bem vindos!!");
        System.out.println("Para fazer um comando, digite o numero no colchetes.");
        System.out.print("\n\n");
        System.out.println("Começo da aventura!\t[1]");
        System.out.println("Créditos\t\t[2]");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    // metodo de creditos
    static void creditos() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Produtor: Murilo de Lima Zaparolli");
        System.out.print("\n\n");
        System.out.println("Começo da aventura!\t[1]");
        System.out.println("Créditos\t\t[2]");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    // 1° metodo utilizado para o inicio do jogo
    static void inicio1() throws InterruptedException{
        System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \r\n" + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  \r\n" + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::@@@@@@@@@::::::::::@@@:::::@@@::::@@@@@@@@@@@@@@@@@@@@@@@@    \r\n" + //
                            " @@@@@@@@@@@@@@@@@@@@@@@@:::::::: ####:::::::::::::::###:::##::::###@@@:::::####   ####       \r\n" + //
                            "  @@@@@@@@@@@@@@@@@@@@@@::::::::  ####::::::::::::::::###:###::######::::::::########         \r\n" + //
                            "::::::::::::#####:::####:::::::    #####:::::::::::::::::#########:::::::::::######           \r\n" + //
                            "::::::::::::####::::####:-----     #####::::::::::::::::::#####::::::::::::::#####            \r\n" + //
                            "::::::::::::####:::####:::-----    #####::::::::::::::::::####:::::::::::::::#####            \r\n" + //
                            ":::::::::::::####::####::::-----    ####::::::::::::::::::###::::::::::::::::#####            \r\n" + //
                            ":::::::::::: #########::::::-----  #####::::::::::::::::::###     :::::::::::#####            \r\n" + //
                            ":::::::::::   ######:::::::::----- ####  :::::::::::::::::###        ---     #####            \r\n" + //
                            ":::::::::     ####::::::::::: -----####      ----     ----###        ----    #####            \r\n" + //
                            "   ---        ####::::::::::   ---####         ----  ---- ###         ---    #####            \r\n" + //
                            "   ---        #### :::::::       -####          --------  ###        ----     #####           \r\n" + //
                            "   ----       ####    ---        -####-          ------   ####      -----      ####           \r\n" + //
                            "   ----       ####   ----        -####-         ------    ####      -----     #####           \r\n" + //
                            "   ----       ####   ----        -####--       ------     #####     -----     #####           \r\n" + //
                            "   ----      ######   ---        ######-       -------    #####    ------    ######           \r\n" + //
                            "  -----     ########  ----      ########       -------   #######   -------   ######           \r\n" + //
                            " -------   ########## ----     ##########      -------  #########   ------  ########          \r\n" + //
                            "--------- ############----    ############    --------  ##########  ------ ##########         \r\n" + //
                            "");

        //Thread.sleep(5000);

        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você acorda numa floresta, sem saber nem quem é você ou como veio parar nesse lugar.");
        System.out.println("Você percebe apenas uma trilha um pouco apagada, parece que esse é o unico caminho a seguir.\n");
        System.out.println("Seguir a trilha\t[1]");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    // 2° metodo utilizado para o inicio do jogo
    static void inicio2() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você segue a trilha, ainda sem encontrar nada.");
        System.out.printf("\n\n");
        System.out.printf("Seguir a trilha\t[1]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    // metodo que mostra a entrada do cenario
    static void entradaNoTemplo() {
        
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você chega no fim da trilha, se deparando com a entrada de um templo.");
        System.out.println("Parece que esse lugar não é visto a eras, é impressionante as estruturas ainda estarem de pé");
        System.out.println("Tem alguns pontos que chamam sua atenção.");
        System.out.printf("\n\n");

        // define o rng do jogo a partir daqui
        chanceItem = rng.nextInt(100);

        // System.out.printf("%d", chanceItem);
    }

    // metodo utilizado para mostrar os comandos possiveis agora
    static void comandos(int[] pontos, String[] opcoes) {

        int id = 1;

        // faz a verificação dos comandos e printa o que for necessario
        for (int i = 0; i < pontos.length; i++) {

            if (pontos[i] == cmdDoPlayer) {
                pontos[i] = 0;
                continue;
            } else {
                pontos[i] = id;
            }

            System.out.printf("%s[%d]\n", opcoes[i], id);

            id++;
        }

        // verifica a mochila do jogador
        if (cmdDoPlayer == cmdMochila) {
            cmdMochila = 0;
        } else {
            cmdMochila = id;

            if (!player.mochila[0].equals(" ")) {
                System.out.printf("Olhar mochila\t\t\t[%d]\n", id);
            }
        }

        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    // area da estatua
    static void estatua() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Chegando mais perto, você vê uma placa de madeira com escritas de uma lingua desconhecida.");
        System.out.println("Estranhamente, essa lingua é legivel para você, revelando o seguinte texto\n");
        System.out.println("Isso é estranho, nunca vi o ancião assim.");
        System.out.println("Talvez seja por causa daquela estranha que chegou no templo.");
        System.out.println("Preciso procurar a chave da sala do ancião, ele conseguiu perde-las,");
        System.out.println("é até impressionante a capacidade dele de perder elas, talvez ele...");
        System.out.println("Tenha sido roubado..?");

        // verifica se tem o triangulo
        if (!triangulos[0]) {
            System.out.println("\nJunto, tem um pequeno triangulo grudado no quadro.");
            player.mochila[id_mochila] = "triangulo 1";
            id_mochila++;
            triangulos[0] = true;

            System.out.println("Voce pega uma mochila que estava jogada ao lado e coloca o que achou dentro dela.");
        }

        // verifica se tem o machado
        if (chanceItem > 70 && !player.verificarItem("machado")) {
            System.out.println("Alem disso, tem um machado escondido de baixo do chão de madeira.");
            player.mochila[id_mochila] = "machado";
            id_mochila++;
        }

        System.out.print("\n\n");
    }

    // metodo de acesso da area superior
    static void escada() {
        while (true) {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Ao subir a escada, se depara com duas portas\n");
            System.out.println("ir a porta da esquerda\t[1]");
            System.out.println("ir a porta da direita\t[2]");
            System.out.println("Decer as escadas\t[3]");
            System.out.println("-------------------------------------------------------------------------------------------------");

            // recepção e execução do comando
            receberComando(3);

            switch (cmdDoPlayer) {
                case 1:
                    portaEsquerda();
                    cmdDoPlayer = 99;
                    break;

                case 2:
                    portaDireita();
                    cmdDoPlayer = 99;
                    break;

            }

            if (cmdDoPlayer == 3) {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("Voce desce as escadas\n\n");
                break;
            }
        }
    }

    // sala esqueda da area superior
    static void portaEsquerda() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Voce abre a porta, dentro tem tres pontos de interesse\n\n");
        //newCtrl = true;

        String[] comandosPortaEsq = {"Ir ao bau\t\t\t",
                                     "Olhar a cama\t\t\t",
                                     "Retornar\t\t\t"
        };

        int[] pontosQuartoEsq = new int[comandosPortaEsq.length];

        quantMaxCmds = pontosQuartoEsq.length;

        // ciclo para funcionamento da sala
        while (true) {
            if (!player.mochila[0].equals(" ")) {
                mochila = true;
            }

            if (mochila) {
                quantMaxCmds = pontosQuartoEsq.length+1;
            }

            comandos(pontosQuartoEsq, comandosPortaEsq);

            receberComando(quantMaxCmds);

            if (cmdDoPlayer == pontosQuartoEsq[0]) {
                bauDoQuartoEsq();
            } else if (cmdDoPlayer == pontosQuartoEsq[1]) {
                cama();
            } else if (cmdDoPlayer == pontosQuartoEsq[2]) {
                // finaliza o ciclo
                break;
            } else if (cmdDoPlayer == cmdMochila) {
                mostrarMochila();
            }
        }
    }

    // define o contador de triangulos
    static int contador = 1;

    // bau da porta esquerda da area superior
    static void bauDoQuartoEsq() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Vendo o bau de perto, tem um grande triangulo, com quatro encaixes de triangulos menores");

        // verificação do contador
        if (contador == 1) {
            System.out.println("Ja tem encaixado um triangulo, faltando três");
        } else if (contador == 2) {
            System.out.println("Dois triangulos foram encaixados");
        } else if (contador == 3) {
            System.out.println("Três triangulos foram encaixados");
        }

        // verificações dos triangulos
        if (player.verificarItem("triangulo 3")) {
            System.out.println("Você coloca triangulo da ponta inferior esquerdo");
            player.retirar_item("triangulo 3");
            contador++;
            id_mochila--;
        }
        if (player.verificarItem("triangulo 2")) {
            System.out.println("Você coloca o triangulo central");
            player.retirar_item("triangulo 2");
            contador++;
            id_mochila--;
        }
        if (player.verificarItem("triangulo 1")) {
            System.out.println("Você coloca o triangulo da ponta superior");
            player.retirar_item("triangulo 1");
            contador++;
            id_mochila--;
        }

        System.out.print("\n");

        // verificação para abertura do bau
        if (contador >= 4) {
            if (contador == 4) {
                System.out.println("Encaixando todos os quatro triangulos, o bau se abre, revelando uma carta:");
                contador++;
            } else {
                System.out.println("A carta do bau diz:\n");
            }

            System.out.println("\"Meu deus, esse monstro é bizarro, a chave se fragmentou para manter a barreira do templo");
            System.out.println("o portão do templo vai continuar selado até a chave ser refeita, os três fragmentos foram");
            System.out.println("espalhados pelo templo, vou trancar a ponta da chave junto dessa carta, espero que alguem");
            System.out.println("destrua seja la o que o padre se tornou, eu acreditei que ele poderia voltar ao normal se");
            System.out.println("aquelas placas se alinhassem corretamente, mas não consegui a tempo, espero que quem seja");
            System.out.println("que ta lendo essa carta, consiga alinhar as placas, talvez seja a unica forma de parar...");
            System.out.println("Aquilo...\"\n");

            if (!player.verificarItem("parte da chave 1")) {
                System.out.println("Junto da carta, tem uma parte de uma chave.");

                player.mochila[id_mochila] = "parte da chave 1";
                id_mochila++;
            }
        }

        System.out.print("\n\n");
    }

    // cama da porta esquerda da area superior
    static void cama() {
        System.out.println("-------------------------------------------------------------------------------------------------");

        // verificação da 3° parte da chave
        if (!player.verificarItem("parte da chave 3")) {
            System.out.println("Vasculhando a cama, você acha uma parte de uma chave");

            player.mochila[id_mochila] = "parte da chave 3";
            id_mochila++;
        } else {
            System.out.println("Não há nada aqui");
        }

        System.out.print("\n");
    }

    // porta direita da area superior
    static void portaDireita() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Entrando no quarto, há dois pontos de interesse:\n");

        String[] comandosPortaDir = {"Escombros\t\t\t",
                                     "Estantes\t\t\t",
                                     "Retornar\t\t\t"
        };

        int[] pontosQuartoDir = new int[comandosPortaDir.length];

        quantMaxCmds = pontosQuartoDir.length;

        // ciclo para funcionamento da sala
        while (true) {
            if (!player.mochila[0].equals(" ")) {
                mochila = true;
            }

            if (mochila) {
                quantMaxCmds = pontosQuartoDir.length+1;
            }

            comandos(pontosQuartoDir, comandosPortaDir);

            receberComando(quantMaxCmds);

            if (cmdDoPlayer == pontosQuartoDir[0]) {
                escombros();
            } else if (cmdDoPlayer == pontosQuartoDir[1]) {
                estante();
            } else if (cmdDoPlayer == pontosQuartoDir[2]) {
                break;
            } else if (cmdDoPlayer == cmdMochila) {
                mostrarMochila();
            }
        }
    }

    // escombros do quarto direito da area superior
    static void escombros() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        // verificação da 2° parte da chave
        if (!player.verificarItem("parte da chave 2")) {
            System.out.println("Nesses escombros, reluz uma pequena peça de metal, o que parece uma parte de uma chave");
            player.mochila[id_mochila] = "parte da chave 2";
            id_mochila++;
        } else {
            System.out.println("Apenas um monte de escombros");
        }
        
        System.out.print("\n");
    }

    // estante do quarto direito da area superior
    static void estante() {
        System.out.println("-------------------------------------------------------------------------------------------------");

        // verificação do 3° triangulo
        if (!triangulos[2]) {
            System.out.println("Tem um triangulo em cima da estante");
            player.mochila[id_mochila] = "triangulo 3";
            id_mochila++;
            triangulos[2] = true;
            
            // verifica o rng para uma liberação de itens
            if (chanceItem > 30) {
                System.out.println("Além de uma bandagem dentro dela");
                player.mochila[id_mochila] = "bandagem";
                id_mochila++;
            }
        } else {
            System.out.println("Uma estante velha e podre");
        }

        System.out.print("\n");
    }

    // casinha de madeira da area inferior
    static void casinha() {
        System.out.println("-------------------------------------------------------------------------------------------------");

        // verifica o item bandagem
        if (player.verificarItem("bandagem")) {
            System.out.println("A casinha está quebrada.\n\n");

            return;
        }

        System.out.println("Observando a casinha, ela parece trancada");

        // verifica o 2° triangulo
        if (!triangulos[1]) {
            System.out.println("Tem um pequeno triangulo grudado na porta, que você guarda contigo");

            player.mochila[id_mochila] = "triangulo 2";
            id_mochila++;
            triangulos[1] = true;
        }

        //verifica se tem o machado para acessar itens
        if (player.verificarItem("machado")) {
            System.out.println("Voce pode tentar abrir a porta com o machadoDeseja tentar?\n");
            System.out.println("Quebrar a porta\t\t[1]");
            System.out.println("Deixar para la\t\t[2]");
            System.out.println("-------------------------------------------------------------------------------------------------");

            receberComando(2);

            switch (cmdDoPlayer) {
                case 1:
                    dentroDaCasinha();
                    cmdDoPlayer = 1;
                    break;
            
                case 2:
                    System.out.println("Ok\n");
                    break;
            }

            return;
        }

        System.out.println();
    }

    // ativado se a verificação do machado for bem sucedida
    static void dentroDaCasinha() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Na casinha tem algumas ferramentas antigas, nada muito utilizavel, mas um kit chama sua atenção");
        System.out.println("esse kit tem duas bandagens que podem te ajudar a se curar.\n\n");

        for (int i = 0; i < 2; i++) {
            player.mochila[id_mochila] = "bandagem";
            id_mochila++;
        }

        cmdDoPlayer = 2;
    }

    // portao para o final do jogo
    static void portaoDoTemplo() throws InterruptedException {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você vai a frente de um grande portão, ele esta trancado.");

        // verifica se o jogador tem a chave
        if (player.verificarItem("parte da chave 1") && player.verificarItem("parte da chave 2") && player.verificarItem("parte da chave 3")) {
            System.out.println("O portão se abre, revelando um grande espaço, onde a aventura pode continuar...");
            System.out.println("-------------------------------------------------------------------------------------------------");
            Thread.sleep(2000);
            ctrl = false;
        } else {
            System.out.println("Pelo visto tera que encontrar uma chave para abrir ele e avançar em frente.");
        }

        System.out.print("\n");
    }

    // mostra a mochila do jogador
    static void mostrarMochila() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Itens da mochila atualmente:\n");

        // mostra os itens até aparecer uma parte vazia da mochila
        for (int i = 0; true || i < player.mochila.length; i++) {
            if (player.mochila[i].equals(" ")) {
                break;
            }

            System.out.println(player.mochila[i]);
        }

        System.out.println("\n");
    }

    // arte de fim
    static String fim = " _________________________         __________         ____________                   ____________        __________\r\n" + //
                        "|                         |       |          |       |            \\                 /            |      |          |\r\n" + //
                        "|                         |       |          |       |             \\               /             |      |          |\r\n" + //
                        "|                         |       |          |       |              \\             /              |      |          |\r\n" + //
                        "|             ____________|       |__________|       |               \\           /               |      |          |\r\n" + //
                        "|            |                                       |                \\         /                |      |          |\r\n" + //
                        "|            |                    ____________       |                 \\       /                 |      |          |\r\n" + //
                        "|            |____________       |            |      |                  \\     /                  |      |          |\r\n" + //
                        "|                         |      |            |      |                   \\   /                   |      |          |\r\n" + //
                        "|                         |      |            |      |            |\\      \\ /      /|            |      |          |\r\n" + //
                        "|                         |      |            |      |            | \\      V      / |            |      |          |\r\n" + //
                        "|             ____________|      |            |      |            |  \\           /  |            |      |__________|\r\n" + //
                        "|            |                   |            |      |            |   \\         /   |            |\r\n" + //
                        "|            |                   |            |      |            |    \\       /    |            |       __________\r\n" + //
                        "|            |                   |            |      |            |     \\     /     |            |      |          |\r\n" + //
                        "|            |                   |            |      |            |      \\   /      |            |      |          |\r\n" + //
                        "|            |                   |            |      |            |       \\ /       |            |      |          |\r\n" + //
                        "|____________|                   |____________|      |____________|        V        |____________|      |__________|";

    // utilização de todos os metodos
    public static void main(String[] args) throws InterruptedException{
        bemVindos();

        receberComando(2);
        ctrl = true;

        while (ctrl) {
            switch (cmdDoPlayer) {
                case 1:
                    ctrl = false;
                    break;

                case 2:
                    creditos();
                    receberComando(2);
                    break;
            }
        }

        inicio1();

        receberComando(1);

        inicio2();

        receberComando(1);

        entradaNoTemplo();

        ctrl = true;

        String[] opcoes_do_templo = { "Ver a estatua\t\t\t",
                                      "Subir a escada\t\t\t",
                                      "Vasculhar casinha de madeira\t",
                                      "Olhar o grande portão\t\t"
        };

        int[] pontosDoTemplo = new int[4];

        quantMaxCmds = pontosDoTemplo.length;

        while (ctrl) {
            if (!player.mochila[0].equals(" ")) {
                mochila = true;
            }

            if (mochila) {
                quantMaxCmds = pontosDoTemplo.length+1;
            }

            comandos(pontosDoTemplo, opcoes_do_templo);

            receberComando(quantMaxCmds);

            if (cmdDoPlayer == pontosDoTemplo[0]) {
                estatua();
            } else if (cmdDoPlayer == pontosDoTemplo[1]) {
                escada();
                cmdDoPlayer = 99;
            } else if (cmdDoPlayer == pontosDoTemplo[2]) {
                casinha();
            } else if (cmdDoPlayer == pontosDoTemplo[3]) {
                portaoDoTemplo();
            } else if (cmdDoPlayer == cmdMochila) {
                mostrarMochila();
            }
        }

        limparTela();
        System.out.println(fim);
    }
}

// javac TCA.java; java TCA
// javac TCA.java && java TCA