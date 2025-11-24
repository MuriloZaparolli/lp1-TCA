public class Personagem {

    String[] mochila = new String[16];
    

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

    int pegarID_item(String item) {
        for (int i = 0; i < mochila.length; i++) {
            if (mochila[i].equals(item)) {
                return i;
            }
        }

        return mochila.length - 1;
    }

    void retirar_item(String item) {
        int id_item = pegarID_item(item);

        for (int i = 0; i < mochila.length; i++) {
            if (i == id_item) {
                mochila[id_item] = mochila[i];
            } else if (i > id_item) {
                mochila[i] = mochila[i+1];
            }
        }
    }
}