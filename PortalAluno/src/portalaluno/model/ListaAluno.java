/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portalaluno.model;

// importação dos pacotes necessarios para usarmos o List e arrayList
import java.util.ArrayList;
import java.util.List;
public class ListaAluno {
    //Declaração de variaveis
    private static final List<Aluno> Lista = new ArrayList<>();
    //metodos para acessarmos a lista e adicionarmos novos itens
    public static List<Aluno> Listar(){
        return Lista;
    }
    
    public static void adicionar(Aluno aluno) {
        Lista.add(aluno);
    }
}
