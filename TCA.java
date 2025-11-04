import java.util.Random;
import java.util.Scanner;

public class TCA {
    final static Scanner SC = new Scanner(System.in);

    static int cmdDoPlayer;
    static boolean ctrl;
    static Personagem player;
    static Random rng = new Random();
    static int chanceItem;

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

        ctrl = true;
    }

    static void bemVindos() {
        limparTela();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Bem vindos!!");
        System.out.println("Para fazer um comando, digite o numero no colchetes.");
        System.out.printf("\n\n");
        System.out.printf("Começo da aventura!\t[1]\n");
        System.out.printf("Créditos\t\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void creditos() {
        limparTela();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Produtor: Murilo de Lima Zaparolli");
        System.out.printf("\n\n");
        System.out.printf("Começo da aventura!\t[1]\n");
        System.out.printf("Créditos\t\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void inicio1() {
        limparTela();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você acorda numa floresta, sem saber nem quem é você ou como veio parar nesse lugar.");
        System.out.printf("Você percebe apenas uma trilha um pouco apagada, parece que esse é o unico caminho a seguir.\n\n");
        System.out.printf( "Seguir a trilha\t[1]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void inicio2() {
        limparTela();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você segue a trilha, ainda sem encontrar nada.");
        System.out.printf("\n\n");
        System.out.printf( "Seguir a trilha\t[1]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void baus() {
        limparTela();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Derrepente você chega numa estrutura de pedra, como se fosse um templo antigo.");
        System.out.println("Na entrada do templo, tem três baus com escrituras em cada.");
        System.out.printf("\n\n");
        System.out.printf("Ir em frente ao bau da esquerda\t[1]\n");
        System.out.printf("Ir em frente ao bau do meio\t[2]\n");
        System.out.printf("Ir em frente ao bau da direita\t[3]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void bauGuerreiro() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você vai em frente a um bau com uma gravura de um escudo e uma espada.");
        System.out.println("Junto tem algumas escrituras.");
        System.out.printf("\n\n");
        System.out.printf("Ler escrituras do bau\t\t[1]\n");
        System.out.printf("Voltar e olhar outro bau.\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");

        receberComando(2);

        switch (cmdDoPlayer) {
            case 1:
                limparTela();
                escrituraGuerreiro();
                break;
            case 2:
                break;
        }
    }

    static void escrituraGuerreiro() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("As escrituras dizem:");
        System.out.println("Guerreiro.");
        System.out.println("Focado em defesa e ataque.");
        System.out.println("Vida: 25");
        System.out.println("Dano: 1 ~ 5");
        System.out.println("Defesa: 2");
        System.out.println("Arma: espada e escudo - +1 atk, +1 def");
        System.out.println("Passiva: fortificação - chance de causar dano adicional.");
        System.out.println("Abilidade: espada-escudo - escolhe entre não receber dano [1] ou causar muito dano [2] nessa rodada.");
        System.out.printf("\n\n");
        System.out.printf("Abrir o bau e pegar os equipamentos\t[1]\n");
        System.out.printf("Voltar e olhar outro bau.\t\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");

        receberComando(2);

        switch (cmdDoPlayer) {
            case 1:
                player = new Personagem(25, 5, 2, 1);
                ctrl = false;
                break;
        
            case 2:
                break;
        }
    }

    static void bauAssassino() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você vai em frente a um bau com uma gravura de duas laminas afiadas.");
        System.out.println("Junto tem algumas escrituras.");
        System.out.printf("\n\n");
        System.out.printf("Ler escrituras do bau\t\t[1]\n");
        System.out.printf("Voltar e olhar outro bau.\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");

        receberComando(2);

        switch (cmdDoPlayer) {
            case 1:
                limparTela();
                escrituraAssassino();
                break;
            case 2:
                break;
        }
    }

    static void escrituraAssassino() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("As escrituras dizem:");
        System.out.println("Assassino.");
        System.out.println("Focado em ser rapido e resistente.");
        System.out.println("Vida: 20.");
        System.out.println("Dano: 1 ~ 6.");
        System.out.println("Defesa: 2.");
        System.out.println("Arma: adaga dupla - +2 atk, -1 def");
        System.out.println("Passiva: esquiva - chance muito baixa de não receber dano.");
        System.out.println("Abilidade: lamina de sange - seu proximo ataque te cura metade do dano causado no inimigo.");
        System.out.printf("\n\n");
        System.out.printf("Abrir o bau e pegar os equipamentos\t[1]\n");
        System.out.printf("Voltar e olhar outro bau.\t\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");

        receberComando(2);

        switch (cmdDoPlayer) {
            case 1:
                player = new Personagem(20, 6, 2, 2);
                ctrl = false;
                break;
        
            case 2:
                break;
        }
    }

    static void bauArqueiro() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você vai em frente a um bau com uma gravura de um arco comuma flecha.");
        System.out.println("Junto tem algumas escrituras.");
        System.out.printf("\n\n");
        System.out.printf("Ler escrituras do bau\t\t[1]\n");
        System.out.printf("Voltar e olhar outro bau.\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");

        receberComando(2);

        switch (cmdDoPlayer) {
            case 1:
                limparTela();
                escrituraArqueiro();
                break;
            case 2:
                break;
        }
    }

    static void escrituraArqueiro() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("As escrituras dizem:");
        System.out.println("Arqueiro.");
        System.out.println("Focado em ser rapido e letal.");
        System.out.println("Vida: 15.");
        System.out.println("Dano: 1 ~ 8.");
        System.out.println("Defesa: 0.");
        System.out.println("Arma: arco e flecha - +3 atk, -1 def");
        System.out.println("Passiva: esquiva - chance muito baixa de não receber dano.");
        System.out.println("Abilidade: lamina de sange - seu proximo ataque te cura metade do dano causado no inimigo.");
        System.out.printf("\n\n");
        System.out.printf("Abrir o bau e pegar os equipamentos\t[1]\n");
        System.out.printf("Voltar e olhar outro bau.\t\t[2]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");

        receberComando(2);

        switch (cmdDoPlayer) {
            case 1:
                player = new Personagem(15, 8, 0, 3);
                ctrl = false;
                break;
        
            case 2:
                break;
        }
    }

    static void entradaNoTemplo() {
        limparTela();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Você se equipa com os equipamentos do bau e adentra o templo em ruinas.");
        System.out.println("Parece que esse lugar não é visto a eras, é impressionante as estruturas ainda estarem de pé");
        System.out.println("Tem alguns pontos que chamam sua atenção.");
        System.out.printf("\n\n");

        chanceItem = rng.nextInt(100);

        comandosDoTemplo();
    }

    static void comandosDoTemplo() {
        System.out.printf("Ver a estatua\t\t\t[1]\n");
        System.out.printf("Subir a escada\t\t\t[2]\n");
        System.out.printf("Vasculhar casinha de madeira\t[3]\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    static void estatua() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Chegando mais perto, você vê uma placa de madeira com escritas de uma lingua desconhecida.");
        System.out.println("Estranhamente, essa lingua é legivel para você, revelando o seguinte texto");
    }

    public static void main(String[] args) {
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

        ctrl = true;

        while (ctrl) {
            baus();

            receberComando(3);

            limparTela();
            switch (cmdDoPlayer) {
                case 1:
                    bauGuerreiro();
                    break;
            
                case 2:
                    bauAssassino();
                    break;
                
                case 3:
                    bauArqueiro();
                    break;
            }
        }

        entradaNoTemplo();

        receberComando(3);

        switch (cmdDoPlayer) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }
}

// javac TCA.java; java TCA
// javac TCA.java && java TCA