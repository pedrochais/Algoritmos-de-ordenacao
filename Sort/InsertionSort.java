package Sort;

import Generic.Generic;

public class InsertionSort {
    private int tipoOrdenacao;

    public void ordenar(Generic<?,?> []vetor, int tamanho, int tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;
        int i, j;
        Generic<?,?> key;

        if(this.tipoOrdenacao == 1){
            for(j = 1; j < tamanho; j++){
                key = vetor[j];
                i = j - 1;
                while(i >= 0 && vetor[i].comparator(key) > 0){ //Ordenação em ordem crescente
                    vetor[i+1] = vetor[i];
                    i--;
                }
                vetor[i+1] = key;
            }
        }else{
            for(j = 1; j < tamanho; j++){
                key = vetor[j];
                i = j - 1;
                while(i >= 0 && vetor[i].comparator(key) < 0){ //Ordenação em ordem decrescente
                    vetor[i+1] = vetor[i];
                    i--;
                }
                vetor[i+1] = key;
            }
        }
    }
}
