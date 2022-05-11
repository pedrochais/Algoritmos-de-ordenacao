package Sort;

import Generic.Generic;

public class QuickSort {
    private int tipoOrdenacao;

    public void ordenar(Generic<?,?>[] vetor, int inicio, int fim, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;
        if(inicio < fim){
            int posicaoPivo = particiona(vetor, inicio, fim);

            ordenar(vetor, inicio, posicaoPivo - 1, tipoOrdenacao);
            ordenar(vetor, posicaoPivo + 1, fim, tipoOrdenacao);
        }
    }

    private int particiona(Generic<?,?>[] vetor, int inicio, int fim){
        Generic<?,?> pivo = vetor[inicio];
        int i = inicio + 1, f = fim;

        while(i <= f){
            if(this.tipoOrdenacao == 1){
                if(vetor[i].comparator(pivo) <= 0){// vetor[i] <= pivo
                    i++;
                }else if(pivo.comparator(vetor[f]) < 0){ //  pivo < vetor[f]
                    f--;
                }else{
                    Generic<?,?> troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;
                }
            }else{
                if(vetor[i].comparator(pivo) >= 0){// vetor[i] <= pivo
                    i++;
                }else if(pivo.comparator(vetor[f]) > 0){ //  pivo < vetor[f]
                    f--;
                }else{
                    Generic<?,?> troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;
                }
            }

        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}
