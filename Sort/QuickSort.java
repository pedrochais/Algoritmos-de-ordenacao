package Sort;

import Generic.Generic;

public class QuickSort implements Operacoes{
    private int tipoOrdenacao;
    private int atr = 0;
    private int co = 0;

    public void ordenar(Generic<?,?>[] vetor, int inicio, int fim, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;
        if(inicio < fim){
            int posicaoPivo = particiona(vetor, inicio, fim);

            ordenar(vetor, inicio, posicaoPivo - 1, tipoOrdenacao);
            ordenar(vetor, posicaoPivo + 1, fim, tipoOrdenacao);

            this.co++;
            this.atr++;
        }
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
    public int getAtr() {
        return this.atr;
    }

    @Override
    public int getComp() {
        return this.co;
    }

    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
