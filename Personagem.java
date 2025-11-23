public class Personagem {

    static String[] mochila = new String[16];
    
    static {
        for (int i = 0; i < mochila.length; i++) {
            mochila[i] = " ";
        }
    }
    

    boolean verificarItem(String item) {
        boolean tem = false;

        for (int i = 0; i < mochila.length; i++) {
            if (mochila[i].equals(item)) {
                tem = true;
                break;
            }
        }

        return tem;
    }
}