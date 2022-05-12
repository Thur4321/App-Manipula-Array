package classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

public class ArrayDeNumeros {

    private int numeros[], cont, contDivididos, divididos[], indice[], contPar, pares[], contIndice;

    public ArrayDeNumeros() {
        numeros = new int[10];
        cont = 0;
        contDivididos = 0;
        divididos = new int[10];
        indice = new int[10];
        contPar = 0;
        pares = new int[10];
        contIndice = 0;
    }

    public ArrayDeNumeros(int tamanhos) {
        numeros = new int[tamanhos];
        cont = 0;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public int getTotalAdicionados() {
        return cont;
    }

    public boolean adiciona(int novoNumero) {
        if (cont < numeros.length) {
            numeros[cont] = novoNumero;
            cont++;
            return true;
        }
        return false;
    }

    public void preenche() {
        Random aleatorio = new Random();

        while (cont < numeros.length) {
            numeros[cont++] = aleatorio.nextInt(10);
        }
    }

    public int soma() {
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        return soma;
    }

    public void ordenar() { //void
        int temp;
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < cont; j++) {
                if (numeros[i] < numeros[j]) {
                    temp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temp;
                }

            }
        }
    }

    public int numerosDivididos(int divisor) {
        int numeroDividido = 0;
        for (int i = 0; i < cont; i++) {
            if (numeros[i] % divisor == 0) {
                numeroDividido++;
            }
        }
        return numeroDividido;
    }

    public int[] dividir(int divisor) {
        int qteDivididos = numerosDivididos(divisor);
        int j = 0;
        int resultadoDivididos[] = null;
        if (qteDivididos > 0) {
            resultadoDivididos = new int[qteDivididos];
            for (int i = 0; i < cont; i++) {
                if (numeros[i] % divisor == 0) {
                    resultadoDivididos[j] = numeros[i];
                    j++;
                }
            }

        }
        return resultadoDivididos;
    }

    public boolean seDivide(int divisor) {
        boolean divide = false;
        for (int i = 0; i < cont; i++) {
            if (numeros[i] % divisor == 0) {
                divide = true;
            }
        }
        return divide;
    }

    public String divididosToString(int vet[], String msg) {
        StringBuilder saida = new StringBuilder(msg + "\n");
        for (int i = 0; i < vet.length; i++) {

            saida.append(vet[i]).append(" ");
        }

        return saida.toString();
    }

    public int numerosPares() {
        int numeroPar = 0;
        for (int i = 0; i < cont; i++) {
            if (numeros[i] % 2 == 0) {
                numeroPar++;
            }
        }
        return numeroPar;
    }

    public int[] par() {
        int qtde = numerosPares();
        int k = 0;
        int resultado[] = null;
        if (qtde > 0) {
            resultado = new int[qtde];
            for (int i = 0; i < cont; i++) {
                if (numeros[i] % 2 == 0) {
                    resultado[k] = numeros[i];
                    k++;
                }
            }
        }
        return resultado;
    }

    public String parToString(int vet[], String msg) {
        StringBuilder saida = new StringBuilder(msg + "\n");
        for (int i = 0; i < vet.length; i++) {

            saida.append(vet[i]).append(" ");
        }

        return saida.toString();
    }

    public boolean sePar() {
        boolean epar = false;
        for (int i = 0; i < cont; i++) {
            if (numeros[i] % 2 == 0) {
                epar = true;
            }
        }
        return epar;
    }

    public void substituir(int localiza, int substituto) {
        for (int i = 0; i < cont; i++) {
            if (numeros[i] == localiza) {
                numeros[i] = substituto;
            }
        }
    }

    public boolean substitui(int localiza) {
        boolean substitui = false;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == localiza) {
                substitui = true;
            }
        }
        return substitui;
    }

    public int buscaBinaria(int x) {

        int meio;
        int inicio = 0; // porque começa no indice 0
        int fim = numeros.length - 1; // -1 porq começa do fim e numero.lenght para ver o tamanho do array
        while (inicio <= fim) {
            meio = (inicio + fim) / 2; // para decobrir o meio do array soma inicio + final divido por 2 = meio
            if (numeros[meio] == x) {
                return meio;
            } else if (numeros[meio] < x) {//descartando os elementos menores
                inicio = meio + 1;
            } else if (numeros[meio] > x) {//descartando os elemtentos maiores
                fim = meio - 1;
            }
        }
        return -1;

    }

    public boolean existe(int numero) {
        boolean achou = false;
        for (int i = 0; i < cont; i++) {
            if (numeros[i] == numero) {
                achou = true;
            }

        }
        return achou;
    }

    public void inverte() {
        int j, aux;
        int i = 0;
        j = cont - 1;
        while (i < j) {
            aux = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = aux;
            j--;
            i++;
        }
    }

    public String histograma() {
        String output = "\nElemento\tValor\tHistograma";
        for (int cont = 0; cont < numeros.length; cont++) {
            output += "\n      " + cont + "     \t" + numeros[cont] + "     \t";
            for (int sinal = 0; sinal < numeros[cont]; sinal++) {
                output += "=";
            }
        }
        return output;
    }

    public int totIguais(int numero) {
        int total = 0;
        for (int i = 0; i < cont; i++) {
            if (numeros[i] == numero) {
                total++;
            }

        }
        return total;
    }

    public int[] posicao(int numero) {
        int qtde = totIguais(numero);
        int k = 0;
        int resultado[] = null;
        if (qtde > 0) {
            resultado = new int[qtde];
            for (int i = 0; i < cont; i++) {
                if (numeros[i] == numero) {
                    resultado[k] = i;
                    k++;
                }
            }
        }
        return resultado;
    }

    public String vetorToString(int vet[], String msg) {
        StringBuilder saida = new StringBuilder(msg + "\n");
        for (int i = 0; i < vet.length; i++) {
            saida.append(vet[i]).append(" ");
        }

        return saida.toString();
    }

    public boolean seRepete() {
        int aux = 1;
        boolean repete = false;
        for (int i = 0; i < numeros.length; i++) {
            cont = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                     cont++;
                }
            }
            if (cont > aux) {
                repete = true;
            }

        }
        return repete;
    }

    public int valorRepetente() {
        int repetido = 0;
        int aux = 0;
        for (int i = 0; i < numeros.length; i++) {
            cont = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    cont++;
                }
            }
            if (cont > aux) {
                repetido = numeros[i];
            }
        }
        return repetido;
    }

    public int qtdeRepete() {
        int aux = 0;
        for (int i = 0; i < numeros.length; i++) {
            cont = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    cont++;
                }
            }
            if (cont > aux) {
                aux = cont;
            }
        }
        return aux;
    }

    public String valorRepete() {
        String repetente = "";
        if(seRepete() == true){
            repetente = "Valor repetido: " + valorRepetente() + ". Vezes: " + qtdeRepete();
        } else if(seRepete() == false){
            repetente = "Não há números repetidos";
        }
        return repetente;
    }

    public String dados() {
        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < cont; i++) {
            saida.append(numeros[i]).append(" ");
        }
        return saida.toString();
    }
}
