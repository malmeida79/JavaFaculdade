//"Conhecereis a verdade e a verdade vos libertará!!! 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora3 extends JFrame implements ActionListener{ 
    
    private static final long serialVersionUID = 1L;
	JPanel base = new JPanel(); 
    String text[] = {"M+","MS","MR","MC","CE","7","8","9","/","sqrt","4","5","6","X","%", 
                  "1","2","3","-","1/x","0","+/-",".","+","="}; 
    int cont; 
    JTextField janelinha = new JTextField(); 
    double temp = 0; 
    char oper = '+'; 
    int opdid = 0; 
    int opdid1 = 0; 
    double memoria = 0; 
    double Memory = 0; 
    double temp2; 
    
    public Calculadora3(){ 
        
        setTitle("Calculadora"); 
        GridLayout gr = new GridLayout(5,5); 
        base.setLayout(gr); 
        base.setBackground(new Color(56,164,199)); 
        setSize(300,270); 
        getContentPane().add(base, BorderLayout.CENTER); 
        janelinha.setText("0"); 
        janelinha.setHorizontalAlignment(JTextField.RIGHT); 
        janelinha.setBackground(new Color(215,215,255)); 
        getContentPane().add(janelinha,BorderLayout.NORTH); 
        
        for (cont=0; cont<text.length;cont++) 
        { 
            makeButton(text[cont]); 
        } 
    } 
    
    public void makeButton(String texto) 
    { 
        JButton botao = new JButton(texto); 
        botao.setBackground(Color.WHITE); 
        //botao.setBorderPainted(false); 
        base.add(botao); 
        botao.setActionCommand(texto); 
        botao.addActionListener(this); 
        
    } 

    public void actionPerformed(ActionEvent e) { 
              String selection = e.getActionCommand(); 
              String conteudoj = new String(); 
              
              if ("0123456789".indexOf(selection) != -1) { 
                  limpacampo(); 
                  conteudoj = janelinha.getText(); 
                  if (opdid1 == 1){ 
                       memoria = 0; 
                       opdid1 = 0; 
                  } 
                  if (opdid == 1){                      
                      janelinha.setText(selection); 
                      opdid = 0;                      
                      
                  } 
                  else 
                  { 
                      janelinha.setText(conteudoj+selection); 
                  }                                
               } 
              
              if (selection.equals(".")){ 
                  if (janelinha.getText().indexOf(".")<1) 
                  { 
                      conteudoj = janelinha.getText(); 
                      janelinha.setText(conteudoj+"."); 
                  } 
              } 
              if (selection.equals("+/-")) 
              { 
                  if (!janelinha.getText().equals("0")) 
                  { 
                      if (janelinha.getText().indexOf("-")==-1) 
                      {                    
                          conteudoj = janelinha.getText(); 
                          janelinha.setText("-"+conteudoj); 
                      } 
                      else 
                      {                                  
                          double num = Double.parseDouble(janelinha.getText()); 
                          num *= -1; 
                          String newvalue = String.valueOf(num);                  
                          janelinha.setText(newvalue); 
                      } 
                  } 
              } 
              if (selection.equals("sqrt")){ 
                  limpacampo(); 
                  conteudoj = janelinha.getText(); 
                  double rad = Double.parseDouble(conteudoj); 
                  janelinha.setText(String.valueOf(Math.sqrt(rad))); 
              } 
              
              if (selection.equals("=")){ 
                  igual(); 
              } 
              
              if (selection.equals("CE")){ 
                  memoria = 0; 
                  janelinha.setText("0"); 
              } 
              
              if (selection.equals("1/x")){ 
                  temp = Double.parseDouble(janelinha.getText()); 
                  testanegativo(temp); 
                  janelinha.setText(String.valueOf(1/temp)); 
              } 
              
              if (selection.equals("+")){ 
                  temp = Double.parseDouble(janelinha.getText()); 
                  testanegativo(temp); 
                  if (opdid1 == 1){ 
                     opdid1 = 0; 
                     memoria = 0; 
                  } 
                  else 
                  { 
                      if (oper!='+'){ 
                          if (memoria!=0){ 
                              igual(); 
                              opdid1 = 0; 
                          } 
                      } 
                  } 
                  if (memoria == 0){                    
                         memoria += temp; 
                         janelinha.setText("0");                          
                  } 
                  else{ 
                      if (opdid != 1){  
                          memoria += temp; 
                          opdid = 1; 
                          janelinha.setText(String.valueOf(memoria)); 
                          limpamemoria(); 
                      } 
                  } 
                  oper = '+'; 
              } 
              
              if (selection.equals("-")){                
                  temp = Double.parseDouble(janelinha.getText()); 
                  testanegativo(temp); 
                  if (opdid1 == 1){ 
                     opdid1 = 0; 
                     memoria = 0; 
                  } 
                  else 
                  { 
                      if (oper!='-'){ 
                          if (memoria!=0){ 
                              igual(); 
                              opdid1 = 0; 
                          } 
                      } 
                  } 
                  if (memoria == 0){                    
                         memoria += temp; 
                         janelinha.setText("0");                          
                  } 
                  else{ 
                      if (opdid != 1){  
                          memoria -= temp; 
                          opdid = 1; 
                          janelinha.setText(String.valueOf(memoria)); 
                          limpamemoria(); 
                      } 
                  } 
                  oper = '-'; 
              } 
                          
              if (selection.equals("/")){ 
                  
                  temp = Double.parseDouble(janelinha.getText()); 
                  testanegativo(temp); 
                  if (opdid1 == 1){ 
                     opdid1 = 0; 
                     memoria = 0; 
                  } 
                  else 
                  { 
                      if (oper!='/'){ 
                          if (memoria!=0){ 
                            igual(); 
                            opdid1 = 0; 
                          } 
                      } 
                  } 
                  if (temp == 0){ 
                      JOptionPane.showMessageDialog(null,"Erro \nDivisão por zero!!!"); 
                      janelinha.setText("0"); 
                      memoria = 0; 
                      opdid = 0; 
                  } 
                  if (memoria == 0){                    
                         memoria = temp; 
                         janelinha.setText("0");                          
                  } 
                  else{ 
                      if (opdid != 1){                            
                          if (temp == 0){ 
                              JOptionPane.showMessageDialog(null,"Erro \nDivisão por zero!!!"); 
                              janelinha.setText("0"); 
                              memoria = 0; 
                              opdid = 0; 
                          } 
                          memoria /= temp; 
                    opdid = 1; 
                          janelinha.setText(String.valueOf(memoria)); 
                      } 
                  } 
                  oper = '/'; 
              } 
              
              if (selection.equals("X")){ 
                              
                  temp = Double.parseDouble(janelinha.getText()); 
                  testanegativo(temp); 
                  if (opdid1 == 1){ 
                     opdid1 = 0; 
                     memoria = 0; 
                  } 
                  else 
                  { 
                      if (oper!='X'){ 
                          if (memoria!=0) 
                          { 
                              igual(); 
                              opdid1 = 0; 
                          } 
                      }  
                  } 
                  if (memoria == 0){                    
                         memoria = temp; 
                         janelinha.setText("0");                          
                  } 
                  else{ 
                      if (opdid != 1){                        
                          memoria *= temp; 
                          opdid = 1; 
                          janelinha.setText(String.valueOf(memoria)); 
                      } 
                  } 
                  oper = 'X'; 
              }              
    }    
  
    
    public void igual(){ 
        
        if (oper == '+'){ 
            if (opdid == 0) 
            { 
                double temp1 = Double.parseDouble(janelinha.getText()); 
                //testanegativo(temp1); 
                memoria += temp1; 
                janelinha.setText(String.valueOf(memoria)); 
                opdid = 1; 
                temp2 = temp1; 
                limpamemoria(); 
            } 
            else 
            { 
                memoria += temp2; 
                janelinha.setText(String.valueOf(memoria)); 
                limpamemoria(); 
            } 
            opdid1 = 1; 
        } 
        
        
        if (oper == '-'){ 
            if (opdid == 0) 
            { 
                double temp1 = Double.parseDouble(janelinha.getText()); 
                //   testanegativo(temp1); 
                memoria -= temp1; 
                janelinha.setText(String.valueOf(memoria)); 
                opdid = 1; 
                temp2 = temp1;                              
            } 
            else 
            { 
                memoria -= temp2; 
                janelinha.setText(String.valueOf(memoria)); 
            } 
            opdid1 = 1; 
        } 
        
        if (oper == 'X'){ 
            if (opdid == 0) 
            {                  
                double temp1 = Double.parseDouble(janelinha.getText()); 
                testanegativo(temp1); 
                memoria *= temp1; 
                janelinha.setText(String.valueOf(memoria)); 
                opdid = 1; 
                temp2 = temp1; 
            } 
            else 
            { 
                memoria *= temp2; 
                janelinha.setText(String.valueOf(memoria)); 
            } 
            opdid1 = 1; 
        } 
        
        if (oper == '/'){ 
            if (opdid == 0) 
            { 
                double temp1 = Double.parseDouble(janelinha.getText()); 
                testanegativo(temp1); 
                if (temp1 == 0){ 
                    JOptionPane.showMessageDialog(null,"Erro \nDivisão por zero!!!"); 
                    janelinha.setText("0");              
                } 
                else 
                { 
                memoria /= temp1; 
                janelinha.setText(String.valueOf(memoria)); 
                opdid = 1; 
                temp2 = temp1; 
                } 
            } 
            else 
            {                
                if (temp2 == 0){ 
                    JOptionPane.showMessageDialog(null,"Erro \nDivisão por zero!!!"); 
                    janelinha.setText("0"); 
                } 
                else 
                { 
                memoria /= temp2; 
                janelinha.setText(String.valueOf(memoria)); 
                } 
            } 
            opdid1 = 1; 
        } 
    } 
                            
    public void testanegativo(double temp){ 
        if (janelinha.getText().indexOf('-')>-1){ 
            temp *= -1; 
        } 
    } 
    
    public void limpacampo(){ 
        if(janelinha.getText().equals("0")){ 
            janelinha.setText(""); 
        } 
    } 
    
    public void limpamemoria(){ 
          double testmemory = Double.parseDouble(janelinha.getText()); 
          if (memoria != testmemory){ 
             memoria = 0; 
          } 
       } 
    
    public static void main(String[] args) { 
        Calculadora3 calc = new Calculadora3(); 
        calc.setVisible(true); 
        calc.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    } 
}
