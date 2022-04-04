import java.util.ArrayList;
import java.util.Random;

/*
            Missing implementations and questions :
              --customer ve company classlarının içinde obje oluşturmaya gerek var mı
              --Bank içindeki getClass methodları yapılacak.
              --Bank'ın kalan methodları bitirilecek.
              --Exceptionlar doldurulacak.......

 */
class Bank{
    //Attributes
    private String name;
    private String address;
    ArrayList<Customer> customers=new ArrayList<Customer>();
    ArrayList<Company> companies=new ArrayList<Company>();
    ArrayList<Account> accounts=new ArrayList<Account>();

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //Methods
    public void addCustomer(int id,String name,String surname){
        Customer customerX = new Customer(name,surname);
        customerX.setId(id);
        customers.add(customerX);
    }

    public void addCompany(int id,String name){
        Company companyX = new Company(name);
        companyX.setId(id);
        companies.add(companyX);
    }

    public void addAccount(Account account){
        accounts.add(account);
    }


}//Bank class

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
    public Account() {
    }

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
    //private String accountNumber; from Account Class
    //private double balance; from Account Class

    //METHODS
    //i. Constructor that takes the account number, name, and surname as parameters
    //and sets the PIN to four (4) random digits
    public PersonalAccount(){}

    public PersonalAccount(String accountNumber) {
        super(accountNumber);
    }

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
    //private String accountNumber; from Account Class
    //private double balance; from Account Class

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

class Customer {
    /*
1) id: int – must be positive
2)personalAccounts arrayList'i public mi , private mi olacak?
     */
        //ATTRIBUTES
    private int id;
    private String name;
    private String surname;
    ArrayList<PersonalAccount> personalAccounts = new ArrayList<PersonalAccount>();
    private PersonalAccount personalAccountObject;

        //Getter and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PersonalAccount getPersonalAccountObject() {
        return personalAccountObject;
    }
    public void setPersonalAccountObject(PersonalAccount personalAccountObject) {
        this.personalAccountObject = personalAccountObject;
    }


        //Constructors
    public Customer(){}
    public Customer(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        //METHODS
    public void openAccount(String acctNum){
        this.personalAccountObject = new PersonalAccount(acctNum);
        personalAccounts.add(this.personalAccountObject);
    }

    public PersonalAccount getAccount(String accountNum) throws RuntimeException{
        if (accountNum.equals(personalAccountObject.getAcctNum()))
            return personalAccountObject;
        else{
            throw new AccountNotFoundException(accountNum);
        }
    }

    public void closeAccount(String accountNum) throws RuntimeException{
        if (accountNum.equals(personalAccountObject.getAcctNum()))
            personalAccounts.remove(personalAccountObject);
        else{
            throw new AccountNotFoundException(accountNum);
        }

        if (personalAccountObject.getBalance()>0){
            throw new BalanceRemainingException(personalAccountObject.getBalance());
        }
    }

    // toString(): String – “{name} {surname all capital letters}”
    public String toString(){
        return getName()  + " "+ getSurname().toUpperCase();

    }

}//Customer class (2)

class Company{
    /*
    1) id: int – must be positive
    2)BussinesAccount arrayList'i public mi , private mi olacak?
     */

    //ATTRIBUTES
    private int id;
    private String name;
    ArrayList<BusinessAccount> businessAccounts = new ArrayList<BusinessAccount>();
    private BusinessAccount businessAccountObject;

    //Getter and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BusinessAccount getBusinessAccountObject() {
        return businessAccountObject;
    }
    public void setBusinessAccountObject(BusinessAccount businessAccountObject) {
        this.businessAccountObject = businessAccountObject;
    }

    //Constructors
    public Company(){}
    public Company(String name) {
        this.name = name;
    }

    //Methods
    public void openAccount(String acctNum,double rate){
        this.businessAccountObject=new BusinessAccount(acctNum,rate);
        businessAccounts.add(businessAccountObject);
    }

    public BusinessAccount getAccount(String acctNum) throws RuntimeException{
        if (acctNum.equals(businessAccountObject.getAcctNum()))
            return businessAccountObject;
        else{
            throw new AccountNotFoundException(acctNum);
        }
    }

    public void closeAccount(String accountNum) throws RuntimeException{
        if (accountNum.equals(businessAccountObject.getAcctNum()))
            businessAccounts.remove(businessAccountObject);
        else{
            throw new AccountNotFoundException(accountNum);
        }

        if (businessAccountObject.getBalance()>0){
            throw new BalanceRemainingException(businessAccountObject.getBalance());
        }
    }

    // toString(): String – “{name}”
    public String toString() {
        return getName();
    }
}//Company class (2)


class AccountNotFoundException extends RuntimeException{
    String acctNum;
    public AccountNotFoundException(String acctNum){
        this.acctNum=acctNum;
    }

    @Override
    public String toString() {
        return "AccountNotFoundException: " + acctNum;
    }
}//AccountNotFoundException class

class BalanceRemainingException extends RuntimeException{
    double balance;

    public BalanceRemainingException(double balance){
        this.balance=balance;
    }

    @Override
    public String toString() {
        return "BalanceRemainingException:"+balance;
    }

    public double getBalance(){
        return balance;
    }
}//BalanceRemainingException

public class Assignment02_20200808006 {

    public static void main(String[] args) throws Exception {
        // write your code here

        Customer c1  =new Customer();
        c1.openAccount("987");
        c1.getAccount("987").setName("Serhan");
        c1.getAccount("987").setSurname("Baymaz");
        try {
            c1.getAccount("84564");
        } catch (AccountNotFoundException e) {
            System.out.println("Sorun oluştu : "+e);
        }

        c1.getAccount("987").deposit(468);
        String infos = c1.getAccount("987").toString();
        System.out.println(infos+c1.personalAccounts);
        try {
            c1.closeAccount("987");
        }catch (BalanceRemainingException e){
            System.out.println("sorun şu : "+e);
        }

        System.out.println(infos+c1.personalAccounts);


    }
}
