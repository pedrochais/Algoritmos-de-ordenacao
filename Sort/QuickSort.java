package Sort;

import Generic.Generic;

public class QuickSort extends Algoritmo implements Operacoes{
    private int tipoOrdenacao;
    private long atr = 0;
    private long co = 0;

    public Generic<?, ?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao){
        return quickSort(vetor, 0, vetor.length - 1, tipoOrdenacao);
    }

    public Generic<?, ?>[] quickSort(Generic<?,?>[] vetor, int inicio, int fim, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;

        if(inicio < fim){
            int posicaoPivo = particiona(vetor, inicio, fim);

            quickSort(vetor, inicio, posicaoPivo - 1, tipoOrdenacao);
            quickSort(vetor, posicaoPivo + 1, fim, tipoOrdenacao);

            this.co++;
            this.atr++;
        }

        return vetor;
    }

    private int particiona(Generic<?,?>[] vetor, int inicio, int fim){
        Generic<?,?> pivo = vetor[inicio];
        int i = inicio + 1, f = fim;

        while(i <= f){
            this.co++;
            if(this.tipoOrdenacao == 1){
                if(vetor[i].comparator(pivo) <= 0){// vetor[i] <= pivo
                    i++;

                    this.co++;
                    this.atr++;
                }else if(pivo.comparator(vetor[f]) < 0){ //  pivo < vetor[f]
                    f--;

                    this.co++;
                    this.atr++;
                }else{
                    Generic<?,?> troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;

                    this.atr += 5;
                }
            }else{
                if(vetor[i].comparator(pivo) >= 0){// vetor[i] <= pivo
                    i++;

                    this.co++;
                    this.atr++;
                }else if(pivo.comparator(vetor[f]) > 0){ //  pivo < vetor[f]
                    f--;

                    this.co++;
                    this.atr++;
                }else{
                    Generic<?,?> troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;

                    this.atr += 5;
                }
            }

        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;

        this.atr += 5;
        return f;
    }

    @Override
    public long getAtr() {
        return this.atr;
    }

    @Override
    public long getComp() {
        return this.co;
    }

    @Override
    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
