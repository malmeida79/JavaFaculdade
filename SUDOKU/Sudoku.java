import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Sudoku extends JPanel implements ActionListener {

	//Parametros de configuração
	private static final int N = 9;
	private static final int HARD = N, MED = 2 * N, EASY = 4*N;
	private static final long serialVersionUID = 1;
	
	// Campos
	private Move[][] board = new Move[N][N];
	private JFrame f;
	private Container cp;
	private Menu m;
	private int clickCount = 0;
    
	/*
		Disparando novo Objeto Sudoku


	public static void main(String[] args) {
		new Sudoku();
	}
		*/
	/*
		Contruindo novo Jogo Sudoku
	*/

	public Sudoku() {

		init();
		
		f = new JFrame("Sudoku");
		cp = f.getContentPane();
		m = new Menu(this);
		f.setJMenuBar(m.createMenuBar());
		cp.add(this);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 530);
		f.setResizable(false);
		f.setVisible(true);	
		
		GridLayout grid = new GridLayout(N, N); 
		grid.setVgap(2);
		grid.setHgap(2);

		this.setLayout(grid);

	}
	
	public void actionPerformed(ActionEvent e) 	{

		if(e.getSource() instanceof Move) {

			Move temp = (Move)e.getSource();
			String in = JOptionPane.showInputDialog(null);
		
			clickCount++;
		
			try
			{
				if(validMove(temp.getRow(),temp.getCol(),Integer.parseInt(in))) {
					// numero de entrada invalido repetiu linha, coluna ou no Cubo
					temp.setValue(Integer.parseInt(in));
				} else {
					JOptionPane.showMessageDialog(this, "Erro logico: Linha, Coluna ou Cubo possuem numero IGUAL !!!", "", JOptionPane.ERROR_MESSAGE);			
				}
			}
			catch (NumberFormatException err)
			{
			
			}
		}
	}

	public void about()	{

		String str = "Autor 1: Marcos Dias de Almeida - RA:0611293\nAutor 2: Joel Silvio Nunes - RA:0610193";
		String title = "Sobre - Sudoku Vrs: " + serialVersionUID;
		
		JOptionPane.showMessageDialog(this, str, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void clear()	{

		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				board[row][col].clear();
			}
		}
	}
	
	public void help() {

		String str = "Preencha o tabuleiro\n     Todas Linhas,\n" +
				"     Todas Clunas, e\n     Todos Cubos 3 x 3\n Sendo que: " +
				"   Os Digitos devem ser diferentes\n na mesma linha, coluna e Cubo.\n\nPara criar jogo livre:\n    1) " +
				"Limpe o Tabuleiro\n    2) Informe os valores\n    3) Selecione item livre no menu";
		String title = "Sudoku VRs: " + serialVersionUID + " - Ajuda";
		
		JOptionPane.showMessageDialog(this, str, title, JOptionPane.INFORMATION_MESSAGE);		
	}
	
	public void newCustom()	{
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				if(board[row][col].getValue() != 0) {
					board[row][col].setUnMod();
					board[row][col].setForeground(Color.black);
				}
				board[row][col].clear();
			}
		}		
	}
	
	/*
		Cria o Jogo Sendo classificado por dificuldade onde irá criar mais ou menos numeros
	*/

	public void newGame(int diff)
	{
		reset();
		
		ArrayList<Integer> valid = new ArrayList<Integer>(spaceCollection());
		int randRow = 0, randCol = 0, randVal = 0, count = 0;
		
		switch(diff)
		{
			case 1:
				count = EASY;
				break;
			
			case 2:
				count = MED;
				break;
			
			case 3:
				count = HARD;
				break;
		}
		
		while(count > 0) {

			randRow = valid.get((int)(Math.random() * N));
			randCol = valid.get((int)(Math.random() * N));
			randVal = 1 + (int)(Math.random() * N);
			
			if(validMove(randRow, randCol, randVal)) {

				board[randRow][randCol].setForeground(Color.black);
				board[randRow][randCol].setValue(randVal);
				board[randRow][randCol].setUnMod();
				count--;
			}
		}
	}
	
	/*
		Encerrar o Jogo
	*/

	public void quit()
	{
		f.dispose();
	}

	/*
		Limpar todo o jogo
	 */

	public void reset()
	{
		for(int row = 0; row < 9; row++)
		{
			for(int col = 0; col < 9; col++)
			{
				board[row][col].reset();
			}
		}
	}
	
	
	/*
		Verifica Status do Jogo
	 */

	public boolean verifySudoku()
	{
		boolean result = true;
		
		for(int i = 0; i < N; i++)
		{
			if(!validRow(i) || !validCol(i) || !validCube(i))
			{
				result = false;
				break;
			}
		}
		
		if (checkEmpty())
		{
			result = false;
		}
		
		if(result)
		{
			JOptionPane.showMessageDialog(this, "Parabens voce concluiu em  " + clickCount + " movimentos.", "", JOptionPane.INFORMATION_MESSAGE);			
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Ainda nao esta pronto, faltam preencher campos !!", "", JOptionPane.ERROR_MESSAGE);
		}
		
		return result;
	}

	private ArrayList<Integer> spaceCollection () {

		ArrayList<Integer> spaceList = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			spaceList.add(i);
		}
		
		return spaceList;
	}
	
	/*
		Valida o Movimento Completo	
	*/

	private boolean validMove(int row, int col, int move) {

		int orig = 0;
		boolean result = false;
		
		if(board[row][col].isModifiable()) {

			orig = board[row][col].getValue();
			board[row][col].setValue(move);
		
			if(validRow(row) && validCol(col) && validCube(findCube(row, col))) {
				result = true;
			}
		
			board[row][col].setValue(orig);

		}
		
		return result;
	}
	
	/*
		Valida as linhas
	*/

	private boolean validRow(int row) {

		ArrayList<Integer> num = new ArrayList<Integer> (Move.initValid());
		boolean valid = true;
		
		for(int i = 0; i < 9; i++)
		{
			Integer temp = board[row][i].getValue();
			if(num.contains(temp))
			{
				num.remove(temp);
			}
			else if (temp != 0)
			{
				valid = false;
				break;
			}
		}
		
		return valid;
	}

	/*
		Valida a Coluna	
	*/

	private boolean validCol(int col) {
		ArrayList<Integer> num = new ArrayList<Integer> (Move.initValid());
		boolean valid = true;
		
		for(int i = 0; i < 9; i++) {

			Integer temp = board[i][col].getValue();

			if(num.contains(temp)) {
				num.remove(temp);
			} else if (temp != 0) {
				valid = false;
				break;
		    }
		}
		
		return valid;
	}
	
	/*
		Valida o Cubo 3 X 3 (Nao pode repetir o numero.
	*/

	private boolean validCube(int cube)
	{
		ArrayList<Integer> num = new ArrayList<Integer> (Move.initValid());
		int enterRow = 0, enterCol = 0;
		boolean valid = true;
		
		switch(cube)
		{
			case 1:
				enterCol = 3;
				break;
				
			case 2: 
				enterCol = 6;
				break;
				
			case 3:
				enterRow = 3;
				break;
				
			case 4:
				enterRow = 3;
				enterCol = 3;
				break;
				
			case 5:
				enterRow = 3;
				enterCol = 6;
				break;
				
			case 6:
				enterRow = 6;
				break;
				
			case 7: 
				enterRow = 6;
				enterCol = 3;
				break;
				
			case 8:
				enterRow = 6;
				enterCol = 6;
				break;
		}
		
		for(int i = enterRow; i < enterRow + 3 ; i++)
		{
			for(int j = enterCol; j < enterCol + 3 ; j++)
			{
				Integer temp = board[i][j].getValue();
				if(temp != 0)
				{
					if(num.contains(temp))
					{
						num.remove(temp);
					}
					else
					{
						valid = false;
						break;
					}
				}
			}
		}
		
		return valid;
	}
	
	/*
		Varre o Cubo em busca de valores
	*/

	private int findCube(int r, int c) {

		int cube = 0;
		
		if(r < 3 && c < 3)
		{
			cube = 0;
		}
		else if (r < 3 && c < 6)
		{
			cube = 1;
		}
		else if (r < 3)
		{
			cube = 2;
		}
		else if(r < 6 && c < 3)
		{
			cube = 3;
		}
		else if (r < 6 && c < 6)
		{
			cube = 4;
		}
		else if (r < 6)
		{
			cube = 5;
		}
		else if(c < 3)
		{
			cube = 6;
		}
		else if (c < 6)
		{
			cube = 7;
		}
		else
		{
			cube = 8;
		}
		
		return cube;
	}
	
	private boolean checkEmpty()
	{
		boolean result = false;
		int row, col;
		
		for(row = 0; row < 9; row++)
		{
			for(col = 0; col < 9; col++)
			{
				if(board[row][col].getValue() == 0)
				{
					result = true;
					break;
				}
			}
			if(col < 9)
			{
				break;
			}
		}
		
		return result;
	}
	
	private void init()	{

		Font font = new Font("Ariel", Font.PLAIN, 31);
		Move m;
		
		for(int row = 0; row < 9; row++)
		{
			for(int col = 0; col < 9; col++)
			{
				m = new Move(row, col);
					m.setBackground(Color.white);
				
				if (row <= 2 && (col <= 2 || col > 5)){
					m.setBackground (Color.white);
				}
				if (row >2 && row <= 5 &&  col > 2 && col  <= 5){
					m.setBackground (Color.white);
				}
				if (row > 5 && ((col <= 2) || (col > 5))){
					m.setBackground (Color.white);
				}
				
				m.setValue(0);
				m.addActionListener(this);
				m.setFont(font);
				m.setForeground(Color.black);
				m.setFocusable(false);
				
				add(m);
				board[row][col] = m;
			}
		}
	}
}
