package estduo_de_interface_registro_de_notas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Estduo_de_interface_registro_de_notas {

    public static void main(String[] args) {
    
       JFrame frame = new JFrame(); //Cria na memoria a janela ou seja o 
       frame.setSize(300,200); //ajustar o tamanho da janela
       frame.setTitle("Registro de Notas"); //aqui é o titulo da janela
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Define como o programa deverar ser fechado
       frame.setLayout(new FlowLayout());
    
       JLabel rotulo = new JLabel();
       rotulo.setText("Primeira nota: ");
       frame.add(rotulo);
       
       //Criação do campo de entrada da primeira nota
       JTextField notaField = new JTextField(10);
       notaField.setBounds(50,20,250,25);
       frame.add(notaField);
       
       //Campo da Segunda nota
       JLabel rotulo2 = new JLabel();
       rotulo2.setText("Segunda nota: ");
       frame.add(rotulo2);
       
       //Criação do campo de entrada da primeira nota
       JTextField notaField2 = new JTextField(10);
       notaField2.setBounds(50,20,250,25);
       frame.add(notaField2);
       
       //Botão de calcular
       
       JButton CalcularButton = new JButton("Calcular a media");
       CalcularButton.setBounds(100,100,150,50);
       frame.add(CalcularButton);
       
       
       //criando evento ao clicar no botão
       CalcularButton.addActionListener(new ActionListener() { // Corrigido
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    
                    double nota1 = Double.parseDouble(notaField.getText());
                    double nota2 = Double.parseDouble(notaField2.getText());
                    double media = (nota1 + nota2)/2;
                    
                        if(media>=7){
                        
                            JOptionPane.showMessageDialog(frame, "Aluno nMédia das notas: "+ String.format("%.2f",media) + " aprovado");   
                        }else{
                        
                            JOptionPane.showMessageDialog(frame, "Aluno nMédia das notas: "+ String.format("%.2f",media) + " Reprovado");   
                        }
                    
                }catch(NumberFormatException ex){
                        
                    JOptionPane.showMessageDialog(frame, "Insira Valores Numericos");
                }
            }
        });
       
       //Tornando a janela visivel
       frame.setVisible(true); //cria a visibilidade da janela
       
    }
        
}
