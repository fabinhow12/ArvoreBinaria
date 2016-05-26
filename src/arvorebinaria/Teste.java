/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author alunofavip
 */
public class Teste {
   
    public static void main(String[] args) {
        
        Arvore arvore = new Arvore();
        arvore.adicionar("raiz", 10);
        arvore.adicionar("segundo elemento", 5);
        arvore.adicionar("terceiro elemento", 15);
        arvore.adicionar("quarto elemento", 20);
        arvore.adicionar("quinto elemento", 12);
        arvore.adicionar("sexto elemento", 13);
        arvore.adicionar("setimo elemento", 14);
        
        No parente = arvore.pegarParente(15);
        System.out.println(parente.getValor());
        
        No excluir = arvore.pesquisar(15);
        No sucessor = arvore.pegarSucessor(excluir);
        System.out.println("valor: " + sucessor.getValor() + ", id: " + sucessor.getId() );
        
       
    }
}
