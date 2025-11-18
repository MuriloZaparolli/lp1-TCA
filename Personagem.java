public class Personagem {
    int vida;
    int dano;
    int defesa;    
    boolean[] arma = new boolean[3];
    boolean[] classe = new boolean[3];

    String[] mochila = new String[16];

    Personagem(int vida, int dano, int defesa, int numC) {
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;

        arma[numC] = true;
        classe[numC] = true;

        for (int i = 0; i < mochila.length; i++) {
            mochila[i] = " ";
        }
    }

    public boolean verificarItem(String item) {
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