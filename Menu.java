// import com.sun.jna.Library;
// import com.sun.jna.Native;
// import java.io.IOException;

// public class Menu {

//     // --- Interface JNA para LibC (Linux/Unix) ---

//     /**
//      * Interface JNA para a LibC do Linux/Unix (para chamar system())
//      */
//     public interface LibC extends Library {
//         LibC INSTANCE = Native.load("c", LibC.class);
//         int system(String command); // Usaremos para chamar 'stty'
//     }

//     // --- Controle do Terminal (Linux) ---

//     /**
//      * Coloca o terminal do Linux em modo "raw" (sem eco, sem buffer).
//      */
//     private static void setTerminalRaw() {
//         try {
//             // Coloca o terminal em modo raw, desabilita eco
//             LibC.INSTANCE.system("stty -echo raw < /dev/tty");
//         } catch (Exception e) {
//             System.err.println("Falha ao configurar modo raw do terminal: " + e.getMessage());
//         }
//     }

//     /**
//      * Restaura o terminal do Linux ao modo "cooked" (normal).
//      */
//     private static void setTerminalCooked() {
//         try {
//             // Restaura o terminal
//             LibC.INSTANCE.system("stty echo cooked < /dev/tty");
//         } catch (Exception e) {
//             System.err.println("Falha ao restaurar modo do terminal: " + e.getMessage());
//         }
//     }

//     // --- Métodos de Leitura de Tecla (Linux/Unix) ---

//     /**
//      * Verifica se uma tecla foi pressionada.
//      */
//     public static boolean pressionouTecla() {
//         try {
//             // No modo raw, System.in.available() diz se há bytes esperando
//             return System.in.available() > 0;
//         } catch (IOException e) {
//             return false;
//         }
//     }

//     /**
//      * Obtém a tecla pressionada sem esperar pelo Enter.
//      */
//     public static int obtemTeclaPressionada() {
//         try {
//             // No modo raw, System.in.read() lê um byte imediatamente
//             return System.in.read();
//         } catch (IOException e) {
//             return -1;
//         }
//     }

//     // --- Funções de Console (Padrão ANSI) ---

//     public static void limparConsole() {
//         System.out.print("\033[H\033[2J");
//         System.out.flush();
//     }

//     public static void gotoXY(int linha, int coluna) {
//         char escCode = 0x1B;
//         System.out.print(String.format("%c[%d;%df", escCode, linha, coluna));
//     }

//     public static void setColor(int cor) {
//         String s = "[0m";
//         switch (cor) {
//             case 0: s = "[30m"; break; // preto
//             case 1: s = "[31m"; break; // vermelho
//             case 2: s = "[32m"; break; // verde
//             case 3: s = "[33m"; break; // amarelo
//             case 4: s = "[34m"; break; // azul
//             case 5: s = "[35m"; break; // magenta
//             case 6: s = "[36m"; break; // ciano
//             case 7: s = "[97m"; break; // branco
//         }
//         System.out.print((char) 27 + s);
//     }

//     public static void atualizarMenu(int opcaoSelecionada, String[] opcoes) {
//         limparConsole();
//         System.out.println();
//         System.out.println("╔═════════════════════╗");
//         System.out.println("║    Menu Principal   ║");
//         System.out.println("╠═════════════════════╣");
//         for (int i = 0; i < opcoes.length; i++) {
//             if (i == opcaoSelecionada) {
//                 System.out.print("║> ");
//                 setColor(2);
//                 System.out.print(opcoes[i]);
//                 setColor(7);
//                 System.out.println("  ║");
//             } else {
//                 System.out.println("║  " + opcoes[i] + "  ║");
//             }
//         }
//         System.out.println("╚═════════════════════╝");
//         System.out.println();
//         System.out.println("Use W/S/Setas para navegar e ENTER para selecionar. ESC para sair.");
//     }

//     public static void executarAcaoMenu(int opcaoSelecionada) {
//         limparConsole();
//         switch (opcaoSelecionada) {
//             case 0: System.out.println("\n\nIniciar jogo selecionado.\n\n"); break;
//             case 1: System.out.println("\n\nCarregar jogo selecionado.\n\n"); break;
//             case 2: System.out.println("\n\nConfigurações selecionado.\n\n"); break;
//             case 3: System.out.println("\n\nAjuda selecionado.\n\n"); break;
//             case 4: System.out.println("\n\nSobre selecionado.\n\n"); break;
//             default: System.out.println("\n\nOpção inválida.\n\n"); break;
//         }
//         System.out.println("Pressione uma tecla para continuar...");
//         obtemTeclaPressionada(); // Fica aguardando até que uma tecla seja pressionada
//         limparConsole();
//     }

//     // --- Método Principal (com try...finally) ---
    
//     public static void main(String[] args) {
        
//         // Configura o terminal para o modo raw
//         setTerminalRaw();

//         // Bloco try...finally para GARANTIR que o terminal seja restaurado
//         try {
//             String[] opcoes = {
//                 "iniciar jogo     ",
//                 "carregar jogo    ",
//                 "configuracoes    ",
//                 "ajuda            ",
//                 "sobre            ",
//             };

//             int opcaoSelecionada = 0;
//             atualizarMenu(opcaoSelecionada, opcoes);

//             while (true) {
//                 if (pressionouTecla()) {
//                     int ch = obtemTeclaPressionada();

//                     // --- Tratamento das Setas no Linux ---
//                     // Setas no Linux enviam 3 bytes: 27 (ESC), 91 ([), 65 (A) / 66 (B)
//                     if (ch == 27) { // 27 = ESC
//                         if (pressionouTecla()) {
//                             int next_ch = obtemTeclaPressionada();
//                             if (next_ch == 91) { // '['
//                                 if (pressionouTecla()) {
//                                     int final_ch = obtemTeclaPressionada();
//                                     switch (final_ch) {
//                                         case 65: ch = 'w'; break; // Seta para Cima -> 'w'
//                                         case 66: ch = 's'; break; // Seta para Baixo -> 's'
//                                     }
//                                 }
//                             } else {
//                                 ch = 27; // Foi só o ESC mesmo
//                             }
//                         }
//                         // Se foi só ESC (ch=27), o switch abaixo vai tratar
//                     }
//                     // --- Fim do Tratamento ---

//                     switch (ch) {
//                         case 'w':
//                         case 'W':
//                             opcaoSelecionada--;
//                             if (opcaoSelecionada < 0) {
//                                 opcaoSelecionada = opcoes.length - 1;
//                             }
//                             atualizarMenu(opcaoSelecionada, opcoes);
//                             break;

//                         case 's':
//                         case 'S':
//                             opcaoSelecionada++;
//                             if (opcaoSelecionada >= opcoes.length) {
//                                 opcaoSelecionada = 0;
//                             }
//                             atualizarMenu(opcaoSelecionada, opcoes);
//                             break;

//                         case 13: // ENTER
//                             executarAcaoMenu(opcaoSelecionada);
//                             atualizarMenu(opcaoSelecionada, opcoes);
//                             break;

//                         case 27: // ESC
//                             return; // Sai do loop e do 'try', executando 'finally'
//                     }
//                 }
                
//                 // Pequena pausa para não consumir 100% da CPU
//                 try { Thread.sleep(20); } catch (InterruptedException e) {}
//             }

//         } finally {
//             // Restaura o terminal ao modo normal
//             setTerminalCooked();
//             System.out.println("\nTerminal restaurado. Saindo.");
//         }
//     }
// }