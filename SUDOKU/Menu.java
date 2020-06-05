import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Menu implements ActionListener, ItemListener {
    JTextArea output;
    JScrollPane scrollPane;
    Sudoku s;
    
    public Menu (Sudoku s)
    {
    	this.s = s;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;

        //Criando Barra de Menus
        menuBar = new JMenuBar();

        //Criando Menu Arquivo
        menu = new JMenu("Arquivo");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
        
        //Sub Menu Novo Jogo
        submenu = new JMenu("Novo jogo");
        submenu.setMnemonic(KeyEvent.VK_N);

        menuItem = new JMenuItem("Facil");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Medio");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Dificil");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Livre");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        submenu.add(menuItem);       
        
        menu.add(submenu);
        
        //Opção Limpar
        menuItem = new JMenuItem("Limpar",KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Reiniciar",KeyEvent.VK_R);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu.addSeparator();

        //Opção Resultado
        menuItem = new JMenuItem("Resultado",KeyEvent.VK_K);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu.addSeparator();
        
        //Opção Sair
        menuItem = new JMenuItem("Sair",KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
             
        //Contruindo o Menu Ajuda
        menu = new JMenu("Ajuda");
        menu.setMnemonic(KeyEvent.VK_H);
        menuItem.addActionListener(this);
        menuBar.add(menu);
        
        //Opção Conteudo
        menuItem = new JMenuItem("Conteudo",KeyEvent.VK_F1);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu.addSeparator();
        
        //Opção Sobre
        menuItem = new JMenuItem("Sobre",KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        return menuBar;
    }

	public void itemStateChanged(ItemEvent e) 
	{
		// aplicavel no futuro
	}

	public void actionPerformed(ActionEvent e) 
	{
		JMenuItem source = (JMenuItem)(e.getSource());
		String act = source.getActionCommand();
		
		if(act.equalsIgnoreCase("Facil"))
		{
			s.newGame(1);
		} 
		else if(act.equalsIgnoreCase("Medio"))
		{
			s.newGame(2);
		}
		else if(act.equalsIgnoreCase("Dificil"))
		{
			s.newGame(3);
		}
		else if(act.equalsIgnoreCase("Livre"))
		{
			s.newCustom();
		}
		else if(act.equalsIgnoreCase("Reiniciar"))
		{
			s.reset();
		}
		else if(act.equalsIgnoreCase("Limpar"))
		{
			s.clear();
		}
		else if(act.equalsIgnoreCase("Resultado"))
		{
			s.verifySudoku();
		}
		else if(act.equalsIgnoreCase("Sair"))
		{
			s.quit();
		}
		else if(act.equalsIgnoreCase("Conteudo"))
		{
			s.help();
		}
		else if(act.equalsIgnoreCase("Sobre"))
		{
			s.about();
		}
	}
}
