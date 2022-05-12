import Generic.*;
import Sort.*;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static int menuDados(){
        int opcao = 0;
        while (true) {
            System.out.println("""
                Escolha o tipo de dado (chave, valor)
                1. Dado A (String, Double)
                2. Dado B (Double, String)
                3. Dado C (Double, Integer)
                """);

            try {
                opcao = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }

            if(opcao == 1 || opcao == 2 || opcao == 3){
                return opcao;
            }else{
                System.out.println("Opção inválida!");
            }
        }
    }

    public static String menu(){
        System.out.print("""
                
                Algoritmos de ordenação
                1. InsertioSort
                2. SelectionSort
                3. MergeSort
                4. QuickSort
                5. HeapSort
                6. SelectionSort Otimizado
                7. MergeSort Otimizado
                8. JDKMergeSort
                9. JDKQuickSort
                0. Finalizar programa
                
                Digite a opção: """);
        return input.nextLine();
    }

    public static int submenu(){
        int tipoOrdenacao = 0;
        while(true) {
            System.out.print("""
                Tipo de ordenacao
                1. Crescente
                2. Decrescente
                """);

            try {
                tipoOrdenacao = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
            }

            if(tipoOrdenacao == 1 || tipoOrdenacao == 2){
                return tipoOrdenacao;
            }else{
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void printVetor(Generic<?,?>[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Chave: " + vetor[i].getChave() + " / Valor: " + vetor[i].getValor());
        }
    }

    public static void copiarVetor(Generic<?,?>[] vetor1, Generic<?,?>[] vetor2){
        for (int i = 0; i < vetor1.length; i++) {
            vetor2[i] = vetor1[i];
        }
    }

    public static void gerarVetorDadoA(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(GeradorString.getRandomString(10), random.nextDouble());
        }
    }

    public static void gerarVetorDadoB(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(random.nextFloat(), GeradorString.getRandomString(10));
        }
    }

    public static void gerarVetorDadoC(Generic<?,?>[] vetor, int n){
        System.out.println("Gerando vetor...");
        for (int i = 0; i < n; i++) {
            vetor[i] = new Generic<>(random.nextDouble(), random.nextInt(1000));
        }
    }

    public static void main(String[] args) {
        ComparaGeneric cv = new ComparaGeneric();
        List<Generic> aux = new ArrayList<>();

        //Instancia das classes dos algoritmos de ordenação
        InsertionSort is = new InsertionSort();
        SelectionSort ss = new SelectionSort();
        SelectionSortOtimizado sso = new SelectionSortOtimizado();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();
        MergeSort ms = new MergeSort();
        MergeSortOtimizado mso = new MergeSortOtimizado();

        //Quantidade de elementos
        int n = 10;

        int opcaoDado = menuDados();

        Generic<?, ?>[] vetor = new Generic[n];
        Generic<?, ?>[] vetorCp = new Generic[n];

        if(opcaoDado == 1){
            vetor = (Generic<String, Double>[])vetor;
            vetorCp = (Generic<String, Double>[])vetorCp;
            gerarVetorDadoA(vetor, n);
        }else if(opcaoDado == 2){
            vetor = (Generic<Double, String>[])vetor;
            vetorCp = (Generic<Double, String>[])vetorCp;
            gerarVetorDadoB(vetor, n);
        }else if(opcaoDado == 3){
            vetor = (Generic<Double, Integer>[])vetor;
            vetorCp = (Generic<Double, Integer>[])vetorCp;
            gerarVetorDadoC(vetor, n);
        }

        //Menu de navegação
        String opcao;
        while(true){
            opcao = menu();
            if(opcao.equals("0")) break; //Sair do programa

            int tipoOrdenacao = 0;
            long tempoInicial = 0;
            int atribuicoes = 0;
            int comparacoes = 0;
            switch (opcao) {
                case "1": //InsertionSort
                    tipoOrdenacao = submenu();
                    tempoInicial = System.currentTimeMillis();
                    is.ordenar(vetor, vetor.length, tipoOrdenacao);

                    atribuicoes = is.getAtr();
                    comparacoes = is.getComp();
                    break;
                case "2": //SelectionSort
                    tipoOrdenacao = submenu();
                    tempoInicial = System.currentTimeMillis();
                    ss.ordenar(vetor, tipoOrdenacao);

                    atribuicoes = ss.getAtr();
                    comparacoes = ss.getComp();
                    break;
                case "3": //MergeSort
                    tipoOrdenacao = submenu();
                    tempoInicial = System.currentTimeMillis();
                    ms.ordenar(vetor, tipoOrdenacao);

                    atribuicoes = ms.getAtr();
                    comparacoes = ms.getComp();
                    break;
                case "4": //QuickSort
                    tipoOrdenacao = submenu();
                    tempoInicial = System.currentTimeMillis();
                    qs.ordenar(vetor, 0, vetor.length-1, tipoOrdenacao);

                    atribuicoes = qs.getAtr();
                    comparacoes = qs.getComp();
                    break;
                case "5": //HeapSort
                    tipoOrdenacao = submenu();
                    tempoInicial = System.currentTimeMillis();
                    hs.ordenar(vetor, vetor.length, tipoOrdenacao);

                    atribuicoes = hs.getAtr();
                    comparacoes = hs.getComp();
                    break;
                case "6": //SelectionSort Otimizado
                    tipoOrdenacao = submenu();
                    tempoInicial = System.currentTimeMillis();
                    sso.ordenar(vetor, tipoOrdenacao);

                    atribuicoes = sso.getAtr();
                    comparacoes = sso.getComp();
                    break;
                case "7": //MergeSort Otimizado
                    tipoOrdenacao = submenu();
                    tempoInicial = System.currentTimeMillis();
                    mso.ordenar(vetor, tipoOrdenacao);

                    atribuicoes = mso.getAtr();
                    comparacoes = mso.getComp();
                    break;
                case "8": //JDKMergeSort
                    aux = Arrays.asList(vetor);
                    tempoInicial = System.currentTimeMillis();
                    Collections.sort(aux);

                    break;
                case "9": //JDKQuickSort
                    tempoInicial = System.currentTimeMillis();
                    Arrays.sort(vetor, cv);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            //Printa a quantidade de atribuições e comparações
            System.out.println("Atribuições: "+atribuicoes+" / Comparações: "+comparacoes);
            ss.reiniciar();
            sso.reiniciar();

            //Printa o tempo de de execução do algoritmo de ordenação
            System.out.println("Tempo de execução: "+(System.currentTimeMillis() - tempoInicial));
        }
    }
}