package Sort;

import Generic.Generic;

public class SelectionSortOtimizado {
    private int tipoOrdenacao;

    public Generic<?,?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;

        int n = vetor.length;
        for(int i = 0, j = n - 1; i < j; i++, j--){
            Generic<?,?> min = vetor[i];
            Generic<?,?> max = vetor[i];
            int i_min = i, i_max = i;
            for (int k = i; k <= j; k++) {
                if(this.tipoOrdenacao == 1){ //Ordenação em ordem crescente
                    if (vetor[k].comparator(max) > 0) {
                        max = vetor[k];
                        i_max = k;
                    } else if (vetor[k].comparator(min) < 0) {
                        min = vetor[k];
                        i_min = k;
                    }
                }else{ //Ordenação em ordem decrescente
                    if (vetor[k].comparator(max) < 0) {
                        max = vetor[k];
                        i_max = k;
                    } else if (vetor[k].comparator(min) > 0) {
                        min = vetor[k];
                        i_min = k;
                    }
                }

            }
            Generic<?,?> temp; //variavel temporaria
            temp = vetor[i];
            vetor[i] = vetor[i_min];
            vetor[i_min] = temp;

            if (vetor[i_min] == max) {
                temp = vetor[j];
                vetor[j] = vetor[i_min];
                vetor[i_min] = temp;
            }else {
                temp = vetor[j];
                vetor[j] = vetor[i_max];
                vetor[i_max] = temp;
            }
        }
        return vetor;
    }
}
