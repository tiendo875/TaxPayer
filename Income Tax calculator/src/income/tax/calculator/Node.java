/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package income.tax.calculator;

/**
 *
 * @author Bat Bao
 */
public class Node {
    //a node contains info and a pointer to the next node
    TaxPayer info;
    Node next;
    //this constructor is for the tail because you dont need to point to the next node
    public Node(TaxPayer info) {
        this.info = info;
        this.next = null;
    }
    //this one is for all the other node
    public Node(TaxPayer info, Node next) {
        this.info = info;
        this.next = next;
    }
    
}
