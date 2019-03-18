package com.cast.tarefaarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import antlr.StringUtils;

@SpringBootApplication
public class TarefaArrayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefaArrayApplication.class, args);

		Scanner entradaTeclado = new Scanner(System.in);
		System.out.println("Digite o tamanho do Array: ");
		// Conforme descrito na tarefa o primeiro elemento informado é sempre o tamanho do array
		String tamanhoArray = entradaTeclado.next();
		int tamArray = 0;
		try {
			tamArray = Integer.parseInt(tamanhoArray);
		} catch (NumberFormatException e) {
			System.out.println("Caracter informado não é um número");
		}
		ArrayList<Integer> array = new ArrayList<Integer>(tamArray);
		int tamanho = 0;

		while (tamanho < tamArray) {
			System.out.println("Digite um número: ");
			String entrada = entradaTeclado.next();
			try {
				Integer intEntrada = Integer.parseInt(entrada);
				array.add(intEntrada);
				tamanho ++;				
			} catch (Exception e) {
				System.out.println("Caracter inválido, repita a operação !");
			}
		}

		// Para comparacao de elemento so faz sentido se o array informado conter mais de 1 elemento
		if (array.size() > 1) {
			int diferencaEncontrada = maxDifference(array);

			if (diferencaEncontrada < 0) {
				System.out.println("Número de elementos do Array diferente do informado!");
			}else {
				System.out.println("Resultado => " + diferencaEncontrada);
				System.out.println("  ");

			}
		} else {
			System.out.println("Array informado está vazio ou possui insuficientes elementos para cálculo !");
		}

	}

	private static int maxDifference(ArrayList<Integer> array) {

		// Converte o arraylist para array de inteiros
		Integer[] a = array.toArray(new Integer[array.size()]);

		// Criando o array
		List<Integer> verificaLista = new ArrayList();

		// Realiza a comparação de cada elemento do array
		for (int i = 0; i < a.length ; i++) {

			for (int x = 0 ; x < i ; x++) {
				if (a[x] < a[i]) {
					verificaLista.add(a[i] - a[x]);
				}
			}
		}

		return Collections.max(verificaLista);

	}

}
