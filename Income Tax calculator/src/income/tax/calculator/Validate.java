/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package income.tax.calculator;

import java.util.Scanner;

/**
 *
 * @author khanh
 */
public class Validate {
    Scanner in = new Scanner(System.in);
    public int inputInt(String msg){
        System.out.print(msg);
        while(true){
            try{
                int input = Integer.valueOf(in.nextLine());
                if(input < 1){
                    throw new Exception();
                }
                return input;
            }catch(NumberFormatException ex){
                System.out.println("Please enter a number");
                
            }catch(Exception ex){
                System.out.println("Number must greater than 0");
            }
        }
    }
    
    public int inputOption(String msg){
        System.out.print(msg);
        while(true){
            try{
                int input = Integer.valueOf(in.nextLine());
                if(input < 0){
                    throw new Exception();
                }
                return input;
            }catch(NumberFormatException ex){
                System.out.println("Please enter a number");
                
            }catch(Exception ex){
                System.out.println("Number must greater than 0");
            }
        }
    }
    
    public String checkStringInput(String msg){
        System.out.print(msg);
        String input = in.nextLine().trim();
        while(true){
        if(input.isEmpty()){
            System.err.println("Empty string");
            System.out.print("Enter again: ");
        }else{
            return input;
        }
        }
    }
    
    public double inputDouble(String msg){
        System.out.print(msg);
        while(true){
            try{
                double input = Double.valueOf(in.nextLine());
                if(input < 1){
                    throw new Exception();
                }
                return input;
            }catch(NumberFormatException ex){
                System.out.println("Please enter a number");
                
            }catch(Exception ex){
                System.out.println("Number must greater than 0");
            }
        }
    }
}
