/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package income.tax.calculator;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Bat Bao
 */
//this class is only works with TaxPayer and its node
public class LinkedList {

    Node head, tail;

    //creating a new linkedlist
    LinkedList() {
        head = tail = null;
    }

    //this function checks for an empty LinkedList
    public boolean isEmpty() {
        return (head == null);
    }

    //this funtion clears the list
    public void clear() {
        head = tail = null;
    }

    //this function adds a node(to the tail)
    public void addToEnd(TaxPayer x) {
        if (head == null) {
            head = tail = new Node(x, null);
        } else {
            Node temp = new Node(x, null);
            tail.next = temp;
            tail = temp;
        }

    }

    //this function adds a node(to the head)
    public void addToHead(TaxPayer x) {
        if (head == null) {
            head = tail = new Node(x, null);
        } else {
            Node temp = new Node(x, this.head);
            head = temp;
        }

    }

    //this function return size 
    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    Node get(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }
    // function 1: load from text file

    void loadFile(String fname) throws IOException {
        
        File file = new File(fname);
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
            }
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s;
        String[] a;
        String code, name;
        double income, deduct;
        
        TaxPayer T;       
            while (true) {
            s = f.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            a = s.split("\\|");
            code = a[0].trim();
            name = a[1].trim();
            income = Double.parseDouble(a[2].trim());
            deduct = Double.parseDouble(a[3].trim());
            T = new TaxPayer(code, name, income, deduct);
            addToEnd(T);
        }
        System.out.println("Load file succesfully!!!\n");
        f.close();
    }

    //function 2: input and add to end 
    public void inputInfoEnd() {
        TaxPayer Tp;
        Validate validate = new Validate();
        String code = validate.checkStringInput("Code                      : ");
        String name = validate.checkStringInput("Name                      : ");
        double income = validate.inputDouble("Income                    : ");
        double deduct = validate.inputDouble("Deduction amount          : ");
        Tp = new TaxPayer(code, name, income, deduct);
        addToEnd(Tp);
        System.out.println("Add succesfully!!!\n");
    }

    //function 3: displays all the node in the list
    public void traverse() {
        Node x = head;
        while (x != null) {
            System.out.println("" + x.info.toString() + "");
            x = x.next;
        }
    }

    //function 4: save data 
    void saveTaxPayerToFile(String fname) throws IOException {
        if (isEmpty()) {
            return;
        }
        File f = new File(fname);
        if (f.exists()) {
            f.delete();
        }
        RandomAccessFile g = new RandomAccessFile(fname, "rw");
        int n, i;
        Node tax ;
        n = size();
        for (i = 0; i < n; i++) {
            tax = get(i);
            g.writeBytes(tax.info.code + " | " + tax.info.name + " | "
                    + tax.info.income + " | " + tax.info.deduct + " | " + tax.info.tax + "\n");
        }
        g.close();
        System.out.println("Save succesfully!!!\n");
    }

    //function 5: search then display the value in the node(include duplicate)
    public void searchByCode() {
        Validate validate = new Validate();
        String srchval = validate.checkStringInput("Enter code: ");
        Node x = head;
        boolean found = false;
        while (x != null) {
            if (x.info.code.equals(srchval)) {
                System.out.println("" + x.info.toString() + "");
                found = true;
            }
            x = x.next;
        }
        if (found == false) {
            System.out.println("Can't found the search requirements.\n");
        }
    }

    //function 6: search by code then delete the node 
    public void deleteByCode() {
        Validate validate = new Validate();
        String srchval = validate.checkStringInput("Enter code: ");
        Node x = head, y = head;
        boolean found = false;

        while (x != null) {
            if (x.info.code.equalsIgnoreCase(srchval.trim())) {
                if (x == head) {
                    head = x.next;
                    x = null;
                } else {
                    y.next = x.next;
                    x.next = null;
                    x = y.next;
                }
                found = true;
            } else {
                y = x;
                x = x.next;
            }
        }
        if (found == false) {
            System.out.println("Can't found the search requirements.\n");
        } else {
            System.out.println("Successfully delete the node!!!\n");
        }
    }

    //function 7: sort by code
    void sortByTcode() {
        Node pi, pj;
        TaxPayer x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.code.compareTo(pi.info.code) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    //function 8: input a new person to top of the list
    public void inputInfoHead() {
        TaxPayer Tp;
        Validate validate = new Validate();
        String code = validate.checkStringInput("Code                      : ");
        String name = validate.checkStringInput("Name                      : ");
        double income = validate.inputDouble("Income                    : ");
        double deduct = validate.inputDouble("Deduction amount          : ");
        Tp = new TaxPayer(code, name, income, deduct);
        addToHead(Tp);
        System.out.println("Add succesfully!!!\n");
    }

    //function 9: add after the input position
    public void addAfterK() {
        Validate validate = new Validate();
        int k = validate.inputInt("Enter k: ");
        TaxPayer x;
        String code = validate.checkStringInput("Code                      : ");
        String name = validate.checkStringInput("Name                      : ");
        double income = validate.inputDouble("Income                    : ");
        double deduct = validate.inputDouble("Deduction amount          : ");
        x = new TaxPayer(code, name, income, deduct);
        Node temp = new Node(x, null);
        Node iter = head;
        int i = 0;
        while (iter != null) {
            if (i == k) {
                temp.next = iter.next;
                iter.next = temp;
                break;
            } else {
                iter = iter.next;
                i++;
            }
        }
    }
    // function 10: delete a person 
    public void deletePositionK() {
        Validate validate = new Validate();
        int k = validate.inputInt("Enter k: ");
        Node x = head, y = head;
        int i = 0;
        while (x != null) {
            if (i == k) {
                y.next = x.next;
                x.next = null;
                x = y.next;
                return;
            } else {
                y = x;
                x = x.next;
                i++;
            }
        }
    }

}
