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
//object that we used in this assignment
public class TaxPayer {
    String code,name;
    double income,deduct,tax;

    public TaxPayer(String code, String name, double income, double deduct) {
        this.code = code;
        this.name = name;
        this.income = income;
        this.deduct = deduct;
        double taxable = income - deduct;
        if (taxable<=5000) {
            this.tax=taxable*5/100;
        }
        else if (taxable>10000) {
            this.tax=taxable*15/100;
        }
        else
        {
            this.tax=taxable*10/100;
        }
        
    }

    @Override
    public String toString() {
        return "TaxPayer{" + "Code=" + code + ", name=" + name + ", income=" + income + ", deduct=" + deduct + ", tax=" + tax + '}';
    }

    
    
}
