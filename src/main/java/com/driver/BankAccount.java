package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
           this.name = name ;
           this.balance = balance ;
           this.minBalance = minBalance;
    }
    

    public String getName() {
        return name;
    }


    public double getBalance() {
        return balance;
    }


    public double getMinBalance() {
        return minBalance;
    }


    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int[] arr = new int[9];
        for(int i = 0 ; i <= 9 ; i++){
            arr[i] = i;
        }
        if(!sumOfDigits(digits, sum, arr, 0)){
            
            throw new Exception("Account Number can not be generated");
        }

        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance = this.balance + amount ;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        this.balance = this.balance - amount;
        
        if(this.balance < minBalance){
            throw new Exception("Insufficient Balance");
        }

    
    }
    public boolean sumOfDigits(int digits, int sum , int[] arr, int i){
        if(digits == 0 && sum == 0){
            return true;
        }
        
        if(digits < 0 || i>=arr.length || sum < 0){
            return false;
        }
       return  sumOfDigits(digits-1 , sum-arr[i], arr, i+1) || sumOfDigits(digits, sum, arr, i+1);
        
        
    }

}