import java.util.LinkedList;
import java.util.Queue;

public class Solucao{

    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public Integer[] ante;
    public int[] cor;
    public int [] d;
    private LinkedList< LinkedList<Integer> > grafo;
    Queue <Integer> fila = new LinkedList<>();

    public Solucao(LinkedList< LinkedList<Integer> > grafo){

        this.grafo = grafo;

    }

    public void bfs(int s){
        this.ante = new Integer[grafo.size()];
        this.cor = new int[grafo.size()];
        this.d = new int[grafo.size()];
        int [] busca = new int[grafo.size()];
        int cont = 0;

        for(int i  = 0; i < grafo.size(); i++){
            this.ante[i] = null;
            this.cor[i] = BRANCO;
            this.d[i] = -1;
        }

        this.cor[s] = CINZA;
        this.d[s] = 0;
        fila.add(s);

        while(!fila.isEmpty()){
            int u = fila.poll();
            busca[cont] = u;

            LinkedList<Integer> adj = grafo.get(u);

            for(int v: adj){
                if(cor[v] == BRANCO){
                    cor[v] = CINZA;
                    d[v] = d[u] + 1;
                    ante[v] = u;
                    fila.add(v);
                }
            }

            cont++;

            cor[u] = PRETO;
        }

        for(int i = 0; i < grafo.size(); i++){
            System.out.println(busca[i]);
        }

    }

    public static void main(String[] args) {
        
        LinkedList< LinkedList<Integer> > grafo;
        int tamanho_grafo = 6;

        grafo = new LinkedList<>();

        for(int i=0; i < tamanho_grafo; i++){
            grafo.add(new LinkedList<Integer>());
        }

        // grafo.get(1).add(2);
        // grafo.get(1).add(3);
        // grafo.get(1).add(4);

        // grafo.get(2).add(5);

        // grafo.get(5).add(9);

        // grafo.get(3).add(6);
        // grafo.get(3).add(7);

        // grafo.get(6).add(10);

        // grafo.get(4).add(8);

        // Solucao s = new Solucao(grafo);

        // s.bfs(1);

        grafo.get(0).add(1);
        grafo.get(0).add(3);
        grafo.get(0).add(4);

        grafo.get(1).add(2);

        grafo.get(3).add(5);

        grafo.get(4).add(5);

        Solucao s = new Solucao(grafo);

        s.bfs(0);
        


    }


}