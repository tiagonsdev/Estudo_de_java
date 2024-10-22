package estudo_de.janela;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Estudo_deJanela {

    public static void main(String[] args) {
       JFrame janela = new JFrame(); //Cria na memoria a janela ou seja o 
       janela.setSize(300,200); //ajustar o tamanho da janela
       janela.setTitle("Minha 1° Janela"); //aqui é o titulo da janela
       janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Define como o programa deverar ser fechado
       janela.setLayout(new FlowLayout());
       
         
       //Criando uma label
       
       JLabel rotulo = new JLabel();
       rotulo.setText("DIgite seu nome: ");
       janela.add(rotulo);
       
       //Criando campo de entrada
       JTextField campo = new JTextField(20);
       janela.add(campo);
       
       //criando botão
       
       JButton botao = new JButton();
       botao.setText("Clique aqui!");
       janela.add(botao);
       
       //criando evento ao clicar no botão
       botao.addActionListener(new ActionListener() { // Corrigido
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(janela, "Boas Vindas " + campo.getText() + "!");
            }
        });
       
       //Tornando a janela visivel
       janela.setVisible(true); //cria a visibilidade da janela
       
    }
    
}
