public class Personagem {

    // define a mochila do player
    String[] mochila = new String[16];
    
    // metodo para verificar se tem um item na mochila
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

    // metodo para achar o index do item especificado
    int pegarID_item(String item) {
        for (int i = 0; i < mochila.length; i++) {
            if (mochila[i].equals(item)) {
                return i;
            }
        }

        return mochila.length - 1;
    }

    // retira o item especificado da mochila
    void retirar_item(String item) {
        int id_item = pegarID_item(item);

        mochila[id_item] = " ";

        String aux;

        // muda as posições da mochila para não ficar espaços sem nada aparecendo
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