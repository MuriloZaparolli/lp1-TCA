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

        mochila[id_item] = " ";

        String aux;

        for (int i = id_item; i < mochila.length - 1; i++) {
            if (mochila[i + 1] == " ") {
                break;
            }
            
            aux = mochila[i];
            mochila[i] = mochila[i+1];
            mochila[i+1] = aux;
        }
    }
}