import Generic.Generic;
import Sort.*;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Generic<String, Integer>[] vetor = new Generic[20];

        System.out.println("Vetor não ordenado");
        for (int i = 0; i < 20; i++){
            vetor[i] = new Generic<>(GeradorString.getRandomString(3), random.nextInt(100));
            System.out.println("Chave: "+vetor[i].getChave()+" / Valor: "+vetor[i].getValor());
        }


//        InsertionSort.ordenar(vetor, vetor.length);
//        System.out.println("Vetor ordenado: ");
//        for(int i=0; i < vetor.length; i++){
//            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
//        }

//        SelectionSort.ordenar(vetor);
//        System.out.println("Vetor ordenado: ");
//        for(int i=0; i < vetor.length; i++){
//            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
//        }

//        QuickSort.ordenar(vetor, 0, 19);
//        System.out.println("Vetor ordenado: ");
//        for(int i=0; i < vetor.length; i++){
//            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
//        }

//        MergeSort.ordenar(vetor);
//        System.out.println("Vetor ordenado: ");
//        for(int i=0; i < vetor.length; i++){
//            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
//        }

        MergeSortOtimizado.ordenar(vetor);
        System.out.println("Vetor ordenado: ");
        for(int i=0; i < vetor.length; i++){
            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
        }

//        HeapSort.ordenar(vetor, vetor.length);
//        System.out.println("Vetor ordenado: ");
//        for(int i=0; i < vetor.length; i++){
//            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
//        }

//        SelectionSortOtimizado.ordenar(vetor);
//        System.out.println("Vetor ordenado: ");
//        for(int i=0; i < vetor.length; i++){
//            System.out.println("Chave: " + vetor[i].getChave() + " Valor: " + vetor[i].getValor());
//        }
    }
}