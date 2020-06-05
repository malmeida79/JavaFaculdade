	public class Fibonacci {

		// declaração de variaveis de escopo global
		static int n, i;
		static int vet[];

		public static void main (String [] arqs) {

			// entrada de dados
			n=1;
			
			// atribuição da qtde de vetores ao Array;
			if(n >1) {
				vet=new int[n];
			} else {
				// caso "N" seja igual a um, necessário duas posições no vetor para armazenar posições 1 e 2
				vet=new int[2];
			}

			// chamada da função
			Fibonacci.montaSequencia();

		}

		// função para numeros de Fibonacci
		static void montaSequencia() {

			if (n <= 0) {
				// teste caso numero menor que zero ou nulo, escrever mensagem abaixo caso naum prosseguir
				System.out.println("Sem sentido calcular numero de Fibonacci para valores menores iguais a zero !");
			} else {

				// imprime o Zero na tela
				System.out.print("0");
	
				// imprime numeros de fibonacci até "N"
				for (i=0; i < n; i++) {			
					if (i==0 || i==1) {
						// se i menor que ou igual a 1, posições 1 e 2 do vetor recebem o numero um.
						vet[0] = 1;
						vet[1] = 1;
					} else {
						// se i maior que 1, posição atual será anterior somada a sua anterior.
						vet[i] = vet[i-1] + vet[i-2];
					}

					System.out.print(" "+vet[i]);
				}
			}
		}
	}

