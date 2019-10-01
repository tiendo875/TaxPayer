/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package income.tax.calculator;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    
    
    
    public static void menu() throws IOException{
        int option;
        Validate validate = new Validate();
        LinkedList l = new LinkedList();
        Scanner s = new Scanner(System.in);

        do {   
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to end");
            System.out.println("3. Display data");
            System.out.println("4. Save data to file");
            System.out.println("5. Search by code");
            System.out.println("6. Delete by code");
            System.out.println("7. Sort by code");
            System.out.println("8. Input & add to beginning");
            System.out.println("9. Add after position k");
            System.out.println("10. Delete position k");
            System.out.println("0. Exit");
            option = validate.inputOption("Enter your choice ( 0 - 10 ) : ");
        switch (option) {
                case 1:
                    l.loadFile("tax.txt");
                    break;
                case 2:
                    l.inputInfoEnd();
                    break;
                case 3:
                    l.traverse();
                    break;
                case 4:
                    l.saveTaxPayerToFile("tax.txt");
                    break;
                case 5:
                    l.searchByCode();
                    break;
                case 6:
                    l.deleteByCode();
                    break;
                case 7:
                    l.sortByTcode();
                    break;
                case 8:
                    l.inputInfoHead();
                    break;
                case 9:
                    l.addAfterK();
                    break;
                case 10:
                    l.deletePositionK();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please enter 0-10");
            }
        } while (true);     
    }
    public static void main(String[] args) throws IOException {
        menu();
    }
}
    

    
