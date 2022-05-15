package Sort;

import Generic.Generic;

public class QuickSort extends Algoritmo implements Operacoes{
    private int tipoOrdenacao; //Crescente ou decrescente
    private long atr = 0; //Quantidade de atribuições
    private long co = 0; //Quantidade de comparações

    public Generic<?, ?>[] ordenar(Generic<?,?>[] vetor, int tipoOrdenacao){
        return quickSort(vetor, 0, vetor.length - 1, tipoOrdenacao);
    }

    public Generic<?, ?>[] quickSort(Generic<?,?>[] vetor, int inicio, int fim, int tipoOrdenacao){
        this.tipoOrdenacao = tipoOrdenacao;

        if(inicio < fim){
            int posicaoPivo = particiona(vetor, inicio, fim); // Calcula posição do pivô e faz a ordenação

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
            if(this.tipoOrdenacao == 1){ //Condição para ordenação crescente
                if(vetor[i].comparator(pivo) <= 0){ //Compara valor na posição i com o pivô
                    i++;

                    this.co++;
                    this.atr++;
                }else if(pivo.comparator(vetor[f]) < 0){ //Compara valor na posição f com o pivô
                    f--;

                    this.co++;
                    this.atr++;
                }else{
                    //Realiza a troca dos valores
                    Generic<?,?> troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;

                    this.atr += 5;
                }
            }else{ //Condição para ordenação decrescente
                if(vetor[i].comparator(pivo) >= 0){ //Compara valor na posição i com o pivô
                    i++;

                    this.co++;
                    this.atr++;
                }else if(pivo.comparator(vetor[f]) > 0){ //Compara valor na posição f com o pivô
                    f--;

                    this.co++;
                    this.atr++;
                }else{
                    //Realiza a troca dos valores
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

    //Reinicia a quantidade de atribuições e de comparações
    @Override
    public void reiniciar(){
        this.atr = 0;
        this.co = 0;
    }
}
