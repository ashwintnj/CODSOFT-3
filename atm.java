import java.util.*;

public class atm{
private ArrayList<bankaccount> acc;
    
public atm(){   
acc = new ArrayList<>();
}

public void addaccount(bankaccount account){
acc.add(account);
}

private bankaccount findacc(String accno){
for(bankaccount account:acc){
if(account.getaccno().equals(accno))
return account;
}
return null;
}
Scanner sc=new Scanner(System.in);
public void menu(){
System.out.print("Enter Card No: ");
String accno=sc.next();

bankaccount account=findacc(accno);	
if(account==null){
System.out.println("Invalid Card Number/Account not found. Try Again");
return;
}

System.out.print("Enter PIN: ");
String inputpin=sc.next();

if(account.verifypin(inputpin)==false){
System.out.println("Invalid pin Try Again");
return;
}
int ch;
do{
System.out.println("\nATM Menu\n1.Cash Withdrawl\n2.Cash Deposit\n3.Balance Enquiry\n4.Exit");
System.out.print("Choose an option: ");
ch=sc.nextInt();
switch(ch){

case 1:
System.out.print("Enter Amount to Withdraw: ");
double amount=sc.nextDouble();
if(account.withdraw(amount))
System.out.print("Amount Withdraw Successfully");
else
System.out.println("Insufficient Balance");
break;

case 2:
System.out.print("Enter Amount to Deposit: ");
double amo=sc.nextDouble();
account.deposit(amo);
System.out.println("Amount Deposited Successfully");
break;

case 3:
System.out.println("Available Balance is Rs. "+account.checkbalance());
break;

case 4:
System.out.println("Transcation Completed");
break;
}
}while(ch!=4);
}



public static void main(String args[]){
atm a=new atm();

a.addaccount(new bankaccount("123456","1234",500));
a.addaccount(new bankaccount("654321","4321",1000));
a.addaccount(new bankaccount("987654","9876",1500));

a.menu();
}
}