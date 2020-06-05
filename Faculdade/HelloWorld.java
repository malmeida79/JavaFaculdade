import javax.swing.*;
import java.awt.Dimension; 

// define a classe HelloWorld
public class HelloWorld {

    private static void createAndShowGUI() {

        // atribui uma decoração mais bonita a janela
        JFrame.setDefaultLookAndFeelDecorated(true);

        // cria e define o tamanho da janela
        JFrame frame = new JFrame("Plugmasters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(230, 140));

        // adiciona um label com a frase "Plugando webmasters de todo o Brasil"
        JLabel label = new JLabel("Plugando webmasters de todo o Brasil");
        frame.getContentPane().add(label);

        // mostra a janela
        frame.setVisible(true);

    }
    public static void main(String[] args) {

        // mostra a aplicação gráfica como uma thread
        // normalmente a forma mais segura de executar
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
