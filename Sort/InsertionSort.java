package Sort;

import Generic.Generic;

public class InsertionSort extends Algoritmo implements Operacoes{
    private int tipoOrdenacao; //Crescente ou decrescente
    private long atr = 0; //Quantidade de atribuições
    private long co = 0; //Quantidade de comparações

    public Generic<?, ?>[] ordenar(Generic<?, ?> []vetor, int tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;
        int i, j;
        int tamanho = vetor.length;
        Generic<?,?> key;

        if(this.tipoOrdenacao == 1){ //Condição para ordenação crescente
            for(j = 1; j < tamanho; j++){
                key = vetor[j];
                i = j - 1;
                while(i >= 0 && vetor[i].comparator(key) > 0){
                    vetor[i+1] = vetor[i];
                    i--;

                    this.co += 2;
                    this.atr += 2;
                }
                vetor[i+1] = key;

                this.co++;
                this.atr += 5;
            }
        }else{ //Condição para ordenação decrescente
            for(j = 1; j < tamanho; j++){
                key = vetor[j];
                i = j - 1;
                while(i >= 0 && vetor[i].comparator(key) < 0){
                    vetor[i+1] = vetor[i];
                    i--;

                    this.co += 2;
                    this.atr += 2;
                }
                vetor[i+1] = key;

                this.co++;
                this.atr += 5;
            }
        }

        return vetor;
    }

    @Override
    public long getAtr() {
        return this.atr;
    }

    @Override
    public long getComp() {
        return this.co;
    }

    //Reinicia a quantidade de atribuições e de comparações
    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
