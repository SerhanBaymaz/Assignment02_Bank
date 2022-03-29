import java.util.Random;

/*
            Missing implementations :
              --
              --
              --

 */

class Account {
/*
    --balance must be non-negative
    --following modifications should be done.
        i. deposit(amount: double): None
             1. raises InvalidAmountException if amount is negative
        ii. withdrawal(amount: double): None – decrease balance by amount
                1. raises InvalidAmountException if amount is
                negative or remaining balance is not enough
 */

    // ATTRIBUTES
    private String accountNumber;
    private double balance;

    //METHODS
    // i. Constructor that takes the account number as parameter
    //  and defaults the balance to 0.
    public Account(String accountNumber) {
        this.balance=0;
        this.accountNumber=accountNumber;
    }

    //ii. Constructor that takes the account number and starting balance as parameter
    // if the balance is negative,set the balance to 0
    public Account(String accountNumber, double balance) {
        if(balance<0){
            this.balance =0;
        }else{
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
    }

    //iii. getAcctNum(): String
    public String getAcctNum() {
        return this.accountNumber;
    }
    //iv. getBalance(): double
    public double getBalance() {
        return this.balance;
    }

    //v. deposit(amount: double): None – increase balance by amount,
    // if amount is negative, do not change the balance.
    void deposit(double amount){
        if(amount>=0){
            this.balance+=amount;
        }
    }

    //vi. withdrawal(amount: double): None – decrease balance by amount,
    // if amount is negative, do not change the balance.
    void withdrawal(double amount){
        if (amount>=0){
            this.balance-=amount;
        }
    }

    //vii. toString(): String – “Account {account number} has {balance}”
    public String toString(){
        return "Account "+this.accountNumber+ " has "+ this.balance;
    }
}//Account class (3)

class PersonalAccount extends Account {

    //ATTRIBUTES
    private String name;
    private String surname;
    private String PIN;

    //METHODS
    //i. Constructor that takes the account number, name, and surname as parameters
    //and sets the PIN to four (4) random digits
    public PersonalAccount(String accountNumber, String name, String surname) {
        super(accountNumber);
        this.name = name;
        this.surname = surname;

        Random rand = new Random();
        int randomPIN = rand.nextInt(9999);
        //String randomPinString = Integer.toString(randomPIN);
        this.PIN=Integer.toString(randomPIN);
    }


    //ii. Constructor that takes the account number, name, surname, and balance as parameters
    //and sets the PIN to four (4) random digits
    public PersonalAccount(String accountNumber,  String name, String surname,double balance) {
        super(accountNumber, balance);
        this.name = name;
        this.surname = surname;

        int a = (int)((Math.random() * (9999 - 1000)) + 1000);
        this.PIN=Integer.toString(a);
        //return (int) ((Math.random() * (max - min)) + min);
    }


    //iii. getName() and setName(name: String)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    //iv. getSurname() and setSurname(surname: String)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }


    //v. getPIN() and setPIN(PIN: String)
    public String getPIN() {
        return PIN;
    }
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }


    //vi. toString(): String – “Account {account number} belonging to {name} {surname all capital letters} has {balance}”
    public String toString(){
        return "Account " + getAcctNum()+ " belonging to " +getName()  + " "+ getSurname().toUpperCase()+ " has "+getBalance();
    }

}//PersonalAccount class has done.

class BusinessAccount extends Account{
        /*
        (rate must be positive)
        set methodunda mı       if(interestRate>0){this.}    yapılacak?
         */
    private double interestRate;

    //i. Constructor that takes the account number and rate as parameters
    public BusinessAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }


    //ii. Constructor that takes the account number, balance, and rate as parameters
    public BusinessAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }


    //iii. getRate() and setRate(rate: double)
    public double getRate() {
        return this.interestRate;
    }
    public void setRate(double interestRate) {
        this.interestRate = interestRate;
    }


    //iv. calculateInterest(): double – return amount of interest earned for the balance and rate.
    //NOTE: does not change value of balance
    public double calculateInterest(){
        return interestRate/100*getBalance();
    }

}//BusinessAccount class (1)

public class Assignment02_20200808006 {

    public static void main(String[] args) {
	// write your code here

    }
}
