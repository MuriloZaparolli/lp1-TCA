import java.util.Random;
import java.util.Scanner;

public class TCA {
    final static Scanner SC = new Scanner(System.in);

    static int cmdDoPlayer;
    static boolean ctrl;
    static Personagem player = new Personagem();
    static Random rng = new Random();
    static int chanceItem;
    static int id_mochila = 0;

    static {
        for (int i = 0; i < player.mochila.length; i++) {
            player.mochila[i] = " ";
        }
    }

    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }

        System.out.print("\033\143");
    }

    static void receberComando(int max) {
        ctrl = true;

        do {
            cmdDoPlayer = SC.nextInt();

            if (cmdDoPlayer < 1 || cmdDoPlayer > max) {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("Comando não reconhecido");
                System.out.println("-------------------------------------------------------------------------------------------------");
                continue;
            }

            ctrl = false;
        } while (ctrl);

        limparTela();

        ctrl = true;
    }

    static void bemVindos() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Bem vindos!!");
        System.out.println("Para fazer um comando, digite o numero no colchetes.");
        System.out.print("\n\n");
        System.out.println("Começo da aventura!\t[1]");
        System.out.println("Créditos\t\t[2]");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void creditos() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Produtor: Murilo de Lima Zaparolli");
        System.out.print("\n\n");
        System.out.println("Começo da aventura!\t[1]");
        System.out.println("Créditos\t\t[2]");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

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

    static void inicio2() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você segue a trilha, ainda sem encontrar nada.");
        System.out.printf("\n\n");
        System.out.printf("Seguir a trilha\t[1]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void entradaNoTemplo() {
        
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você chega no fim da trilha, se deparando com a entrada de um templo.");
        System.out.println("Parece que esse lugar não é visto a eras, é impressionante as estruturas ainda estarem de pé");
        System.out.println("Tem alguns pontos que chamam sua atenção.");
        System.out.printf("\n\n");

        chanceItem = rng.nextInt(100);

        System.out.printf("%d", chanceItem);
    }

    static void comandos(int[] esc_est_cas_por, String[] opcoes) {

        int id = 1;

        for (int i = 0; i < esc_est_cas_por.length; i++) {

            if (esc_est_cas_por[i] == cmdDoPlayer) {
                esc_est_cas_por[i] = 0;
                continue;
            } else {
                esc_est_cas_por[i] = id;
            }

            System.out.printf("%s[%d]\n", opcoes[i], id);

            id++;
        }

        if (cmdDoPlayer == m) {
            m = 0;
        } else {
            m = id;

            if (!player.mochila[0].equals(" ")) {
                System.out.printf("Olhar mochila\t\t\t[%d]\n", id);
            }
        }

        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void estatua() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Chegando mais perto, você vê uma placa de madeira com escritas de uma lingua desconhecida.");
        System.out.println("Estranhamente, essa lingua é legivel para você, revelando o seguinte texto\n");
        System.out.println("Isso  é estranho, nunca vi o ancião assim.");
        System.out.println("Talvez seja por causa daquela estranha qeu chegou no templo.");
        System.out.println("Preciso procurar a chave da sala do ancião, ele conseguiu perde-las,");
        System.out.println("é até impressionante a capacidade dele de perder elas, talvez ele...");
        System.out.println("Tenha sido roubado..?\n");

        if (!player.verificarItem("triangulo.1")) {
            System.out.println("Junto, tem um pequeno triangulo grudado no quadro.");
            player.mochila[id_mochila] = "triangulo.1";
            id_mochila++;

            if (chanceItem > 70 && player.mochila[0].equals(" ")) {
                System.out.println("Alem disso, tem um machado escondido de baixo do chão de madeira.");
                player.mochila[id_mochila] = "machado";
                id_mochila++;
                mochila = true;
            }

            System.out.println("Voce pega uma mochila que estava jogada ao lado e coloca o que achou dentro dela.\n\n");
        }
    }

    static void escada() {
        while (true) {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Ao subir a escada, se depara com duas portas\n");
            System.out.println("ir a porta da esquerda\t[1]");
            System.out.println("ir a porta da direita\t[2]");
            System.out.println("Decer as escadas\t[3]");
            System.out.println("-------------------------------------------------------------------------------------------------");

            receberComando(3);

            switch (cmdDoPlayer) {
                case 1:
                    portaEsquerda();
                    break;

                case 2:
                    System.out.println("aliado");
                    break;

            }

            if (cmdDoPlayer == 3) {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("Voce desce as escadas");
                break;
            }
        }
    }

    static void portaEsquerda() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Voce abre a porta, dentro tem tres pontos de interesse\n\n");
        //newCtrl = true;

        String[] comandosPortaEsq = {"Ir ao bau\t\t\t",
                                     "Ver o armario\t\t\t",
                                     "Olhar a cama\t\t\t",
                                     "Retornar\t\t\t"
        };

        int[] pontosQuartoEsq = new int[comandosPortaEsq.length];

        quantMaxCmds = pontosQuartoEsq.length;

        while (true) {
            if (cmdDoPlayer == pontosQuartoEsq[0]) {
                System.out.println(1);
            } else if (cmdDoPlayer == pontosQuartoEsq[1]) {
                System.out.println(2);
            } else if (cmdDoPlayer == pontosQuartoEsq[2]) {
                System.out.println(3);
            } else if (cmdDoPlayer == pontosQuartoEsq[3]) {
                break;
            } else if (cmdDoPlayer == m) {
                mostrarMochila();
            }

            if (mochila) {
                quantMaxCmds = pontosQuartoEsq.length;
            }

            comandos(pontosQuartoEsq, comandosPortaEsq);

            receberComando(quantMaxCmds);
        }

        
    }

    static void bauDoQuartoEsq() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Vendo o bau de perto, tem um grande triangulo, com quatro encaixes de triangulos menores");
        System.out.println("Ja tem encaixado um triangulo, faltando três");

        if (player.verificarItem("triangulo.3")) {
            player.mochila[player.pegarID_item("triangulo.3")] = " ";
        }

    }

    static void casinha() {
        if (player.verificarItem("bandagem")) {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("A casinha está quebrada.\n\n");

            return;
        }

        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Observando a casinha, ela parece trancada");

        if (!player.verificarItem("triangulo.2")) {
            System.out.println("Tem um pequeno triangulo grudado na porta, que você guarda contigo");

            player.mochila[id_mochila] = "triangulo.2";
            id_mochila++;
        }

        if (player.verificarItem("machado")) {
            System.out.println("Voce pode tentar abrir a porta com o machadoDeseja tentar?\n");
            System.out.println("Quebrar a porta\t\t[1]");
            System.out.println("Deixar para la\t\t[2]");
            System.out.println("-------------------------------------------------------------------------------------------------");

            receberComando(2);

            switch (cmdDoPlayer) {
                case 1:
                    dentroDaCasinha();
                    break;
            
                case 2:
                    System.out.println("ok");
                    break;
            }

            return;
        }

        System.out.println();
    }

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

    static void portaoDoTemplo() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você vai a frente de um grande portão, ele esta trancado.");
        System.out.println("Pelo visto tera que encontrar uma chave para abrir ele e avançar em frente.\n");
    }

    static int m = -1;
    private static boolean mochila = false;
    static int quantMaxCmds;

    static void mostrarMochila() {
        System.out.println("Itens da mochila atualmente:\n");

        for (int i = 0; true || i < player.mochila.length; i++) {
            if (player.mochila[i].equals(" ")) {
                break;
            }

            System.out.println(player.mochila[i]);
        }

        System.out.println("\n");
    }

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
            comandos(pontosDoTemplo, opcoes_do_templo);

            if (mochila) {
                quantMaxCmds = pontosDoTemplo.length+1;
            }

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
            } else if (cmdDoPlayer == m) {
                mostrarMochila();
            }
        }
    }
}

// javac TCA.java; java TCA
// javac TCA.java && java TCA