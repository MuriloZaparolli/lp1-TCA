public class Personagem {
    int vida;
    int dano;
    int defesa;    
    boolean[] arma = new boolean[3];
    boolean[] classe = new boolean[3];

    boolean[][] mochila = new boolean[4][4];

    Personagem(int vida, int dano, int defesa, int numC) {
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;

        arma[numC] = true;
        
    }
}