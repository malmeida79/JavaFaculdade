package util;

import java.io.IOException;
import java.lang.StringBuffer;
import java.lang.NumberFormatException;

/**
 * Classe que fornece métodos abstratos para leitura do teclado
 */
public class Keyboard {

	private static String keyboardReadInt () {
		int in = 0;
		char chr;
		boolean sinal = false;
		StringBuffer Valor = new StringBuffer("");
		do {
			try {
				in = System.in.read();
				chr = (char) in;
				if ((in != 10) & (in != 13)) {
					if (in >= 48 && in <= 57 || ( in == 45 && !sinal ) ) {
						Valor.append(chr);
						sinal = true;
					}
				}
			} catch (IOException e) {}
		} while (in != 10);
		return Valor.toString();
	}

	private static String keyboardReadFloat () {
		int in = 0;
		char chr;
		boolean ponto = false;
		boolean sinal = false;
		StringBuffer Valor = new StringBuffer("");

		do {
			try {
				in = System.in.read();
				chr = (char) in;
				if ((in != 10) & (in != 13)) {
					if (in >= 48 && in <= 57 || in == 46 || ( in == 45 && !sinal )) {
						if ( in == 46 ) {
							if ( ! ponto ) {
								Valor.append(chr);
								ponto = true;
							}
						} else {
							Valor.append(chr);
						}
						sinal = true;
					}
				}
			} catch (IOException e) {}
		} while (in != 10);
		return Valor.toString();
	}

	/**
	 * Lêr um int do teclado
	 * @result int lido
	 */
	public static int readInt () {
		int retorno;

		try {
			retorno = Integer.parseInt(keyboardReadInt());
		} catch (NumberFormatException e) {
			retorno = 0;
		}

		return retorno;
    }

	/**
	 * Lêr um float do teclado
	 * @result float lido
	 */
	public static float readFloat () {
		float retorno;
		try {
			retorno = Float.parseFloat(keyboardReadFloat());
		} catch (NumberFormatException e) {
			retorno = 0;
		}
		return retorno;
	}

	/**
	 * Lêr um char do teclado
	 * @result char lido
	 */
	public static char readChar () {
		int in = 0;
		char chr;
		int cont = 0;
		StringBuffer Valor = new StringBuffer("");
		do {
			try {
				in = System.in.read();
				chr = (char) in;
				if ((in != 10) & (in != 13)) {
					if ( cont == 0 ) {
						Valor.append(chr);
					}
					cont++;
				}
			} catch (IOException e) {}
		} while (in != 10);
		return Valor.charAt(0);
	}

	/**
	 * Lêr um String do teclado
	 * @result String lido
	 */
	public static String readString () {
		int in = 0;
		char chr;
		StringBuffer Valor = new StringBuffer("");
		do {
			try {
				in = System.in.read();
				chr = (char) in;
				if ((in != 10) & (in != 13)) {
					Valor.append(chr);
				}
			} catch (IOException e) {}
		} while (in != 10);
		return Valor.toString();
	}
}