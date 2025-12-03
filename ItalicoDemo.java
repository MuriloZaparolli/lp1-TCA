public class ItalicoDemo {
    public static void main(String[] args) {
        // Código de escape ANSI para itálico
        String ITALIC_START = "\033[3m";
        // Código de escape ANSI para resetar a formatação
        String ITALIC_END = "\033[0m";

        System.out.println(ITALIC_START + "Este texto está em itálico." + ITALIC_END);
        System.out.println("Este texto está normal.");
    }
}