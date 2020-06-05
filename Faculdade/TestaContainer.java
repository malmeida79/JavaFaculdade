import javax.swing.*; 
import java.awt.*; 



public class TestaContainer extends Frame {

	// Objetos de janelas
	static JFrame janelaMain = new JFrame("Geração de Orçamentos");
	static JFrame janelaCliente = new JFrame("Manipulação de Clientes");
	static JFrame janelaOrcamento = new JFrame("Manipulação de Orçamentos");

	// Objetos de Telas
	static JButton cliente = new JButton("Clientes");
	static JButton orcamento = new JButton("Orçamentos");
	static JButton servico = new JButton("Serviços");
	static JButton relatorio = new JButton("Relatórios");
	static JButton butOK = new JButton("Gravar"); 
	static JButton butCancel = new JButton("Cancelar"); 
	static TextField campo1 = new TextField(15);
	static TextField campo2 = new TextField(15);
	static TextField campo3 = new TextField(15); 
	static Label texto1 = new Label("Nome:");
	static Label texto2 = new Label("Fone:"); 
	static Label texto3 = new Label("Idadde:"); 

	public static void main (String args[]) { 
		TestaContainer.montaJanelaMain();
		TestaContainer.montaJanelaCliente();
		TestaContainer.montaJanelaOrcamento();
	}  

	public static void montaJanelaMain() {

		// Seta posição e tamanho
		janelaMain.setBounds(200, 200, 400, 70);  

		janelaMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 

		// Define o layout do container
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);    

		// Define o tamanho do container
		Container caixaMain = janelaMain.getContentPane();  

		// Seta layout do container 
		caixaMain.setLayout(flow);   

		// atribuição dos botoes ao corpo da janela
		caixaMain.add(cliente);  
		caixaMain.add(orcamento);
		caixaMain.add(servico); 
		caixaMain.add(relatorio);

		// Exibe a janelaMain
		janelaMain.setVisible(true);   

	}

	public static void montaJanelaCliente() {

		// Seta posição e tamanho
		janelaCliente.setBounds(200, 300, 400, 450);  

		janelaCliente.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 

		// Define o layout do container
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);    

		// Define o tamanho do container
		Container caixaCliente = janelaCliente.getContentPane();  

		// Seta layout do container 
		caixaCliente.setLayout(flow);   

		caixaCliente.setLayout(new GridLayout(4,2)); 
		caixaCliente.add(texto1); 
		caixaCliente.add(campo1); 
		caixaCliente.add(texto2); 
		caixaCliente.add(campo2); 
		caixaCliente.add(texto3);
		caixaCliente.add(campo3);  
		caixaCliente.add(butOK);
		caixaCliente.add(butCancel);



		// Exibe a janelaCliente
		janelaCliente.setVisible(true);   

	}

	public static void montaJanelaOrcamento() {

		// Seta posição e tamanho
		janelaOrcamento.setBounds(200, 300, 400, 450);  

		janelaOrcamento.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 

		// Define o layout do container
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);    

		// Define o tamanho do container
		Container caixaOrcamento = janelaOrcamento.getContentPane();  

		// Seta layout do container 
		caixaOrcamento.setLayout(flow);   

		// Exibe a janelaOrcamento
		janelaOrcamento.setVisible(true);   

	}

}

