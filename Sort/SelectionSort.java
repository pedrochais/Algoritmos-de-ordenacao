package Sort;
import Generic.Generic;

public class SelectionSort{
    private int tipoOrdenacao;

    public Generic<?,?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;

        for(int i = 0; i < vetor.length - 1; i++){
            int min = i;
            for(int j = i+1; j < vetor.length; j++){
                if(this.tipoOrdenacao == 1){
                    if(vetor[j].comparator(vetor[min]) < 0){ //Ordenação em ordem crescente
                        min = j;
                    }
                }else{
                    if(vetor[j].comparator(vetor[min]) > 0){ //Ordenação em ordem decrescente
                        min = j;
                    }
                }
            }
            Generic<?,?> temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;
        }
        return vetor;
    }
}
