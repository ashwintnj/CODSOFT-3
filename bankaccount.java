public class bankaccount {
    double balance;
    String accno;
    String pin;

    public bankaccount(String accno, String pin,double bal) {
        this.accno = accno;
        this.pin = pin;
        this.balance = bal;
    }

    public double checkbalance() {
        return balance;
    }

    public String getaccno() {
        return accno;
    }

    public boolean verifypin(String inputpin) {
        return pin.equals(inputpin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
