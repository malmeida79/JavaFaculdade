// Marcos Dias de Almeida - Sistemas de Informação N2 3ºsem. - RA: 0611293
// Tecnicas de programação 1 (na verdade TP3)
import java.util.Scanner;

	public class Fibonacci {

		// declaração de variaveis de escopo global
		static int n, i;
		static int vet[];

		public static void main (String [] arqs) {

            // cria objeto Scanner para obter entradas do teclado
            Scanner input = new Scanner( System.in );

			// entrada de dados
			System.out.print( "Digite um numero para sequencia fibonacci: " ); // prompt
	        n = input.nextInt(); // lê o numero
			
			// atribuição da qtde de vetores ao Array;
			if(n >1) {
				vet=new int[n];
			} else {
				// caso "N" seja igual a um, necessário duas posições no vetor para 
				// armazenar posições 1 e 2
				vet=new int[2];
			}

			// chamada da função
			Fibonacci.montaSequencia();

		}

		// função para numeros de Fibonacci
		static void montaSequencia() {

			if (n <= 0) {
				// teste caso numero menor que zero ou nulo, escrever mensagem abaixo caso 
				// não prosseguir
				System.out.println("Sem sentido calcular este numero de Fibonacci");
			} else {

				// imprime o Zero na tela
				System.out.print("0");
	
				// imprime numeros de fibonacci até "N"
				for (i=0; i < n; i++) {			
					if (i==0 || i==1) {
						// se i menor que ou igual a 1, posições 1 e 2 do vetor recebem 
						// o numero um.
						vet[0] = 1;
						vet[1] = 1;
					} else {
						// se i maior que 1, posição atual será anterior somada a sua 
						// anterior.
						vet[i] = vet[i-1] + vet[i-2];
					}

					System.out.print(" "+vet[i]);
				}

				System.out.println(" ");
				System.out.print(" Para posicao:" + n + " temos o numero:" + vet[n-1]);
			}
		}


	}