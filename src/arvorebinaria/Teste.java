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
        arvore.adicionar("primeiro", 10);
        arvore.adicionar("segundo", 5);
        arvore.adicionar("terceiro", 15);

        arvore.imprimirEspecial();
    }
}
