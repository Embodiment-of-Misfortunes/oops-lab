import java.util.Scanner;

class Account {
  private int accountNumber;
  protected double balance;

  public Account(int accountNumber) {
    this.accountNumber = accountNumber;
    this.balance = 0;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println("$" + amount + " deposited. New balance is $" + balance);
  }

  public boolean withdraw(double amount) {
    if (amount > balance) {
      System.out.println("Insufficient funds. Transaction cancelled.");
      return false;
    } else {
      balance -= amount;
      System.out.println("$" + amount + " withdrawn. New balance is $" + balance);
      return true;
    }
  }

  public boolean transfer(Account destinationAccount, double amount) {
    if (withdraw(amount)) {
      destinationAccount.deposit(amount);
      return true;
    } else {
      System.out.println("Transfer cancelled.");
      return false;
    }
  }

  public void checkBalance() {
    System.out.println("Current balance: $" + balance);
  }

  public String toString() {
    return "Account " + accountNumber + ", balance $" + balance;
  }
}

public class Bank {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Account[] accounts = new Account[0];

    while (true) {
      System.out.println("Please select an option:");
      System.out.println("1. Create a new account");
      System.out.println("2. Access an existing account");
      System.out.println("3. Exit");
      int choice = scanner.nextInt();
      scanner.nextLine();

      if (choice == 1) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Is this a checking account? (Y/N)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
          accounts = addAccount(accounts, new Account(accountNumber) {
            private double overdraftLimit = 1000;

            public boolean withdraw(double amount) {
              if (amount <= balance + overdraftLimit) {
                balance -= amount;
                System.out.println("$" + amount + " withdrawn. New balance is $" + balance);
                return true;
              } else {
                System.out.println("Insufficient funds. Transaction cancelled.");
                return false;
              }
            }

            public String toString() {
              return "Checking " + super.toString() + ", overdraft limit $" + overdraftLimit;
            }
          });
        } else {
          accounts = addAccount(accounts, new Account(accountNumber));
        }
      } else if (choice == 2) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        Account selectedAccount = null;
        for (Account account : accounts) {
          if (account.getAccountNumber() == accountNumber) {
            selectedAccount = account;
            break;
          }
        }

        if (selectedAccount != null) {
          while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Transfer");
            System.out.println("5. Close account");
            System.out.println("6. Exit");
            int choice2 = scanner.nextInt();
            scanner.nextLine();


        if (choice2 == 1) {
          System.out.print("Enter amount to deposit: ");
          double amount = scanner.nextDouble();
          scanner.nextLine();
          selectedAccount.deposit(amount);
        } else if (choice2 == 2) {
          System.out.print("Enter amount to withdraw: ");
          double amount = scanner.nextDouble();
          scanner.nextLine();
          selectedAccount.withdraw(amount);
        } else if (choice2 == 3) {
          selectedAccount.checkBalance();
        } else if (choice2 == 4) {
          System.out.print("Enter destination account number: ");
          int destinationAccountNumber = scanner.nextInt();
          scanner.nextLine();

          Account destinationAccount = null;
          for (Account account : accounts) {
            if (account.getAccountNumber() == destinationAccountNumber) {
              destinationAccount = account;
              break;
            }
          }

          if (destinationAccount != null) {
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            selectedAccount.transfer(destinationAccount, amount);
          } else {
            System.out.println("Account not found.");
          }
        } else if (choice2 == 5) {
          accounts = removeAccount(accounts, selectedAccount);
          System.out.println("Account " + selectedAccount.getAccountNumber() + " closed.");
          break;
        } else if (choice2 == 6) {
          break;
        } else {
          System.out.println("Invalid choice.");
        }
      }
    } else {
      System.out.println("Account not found.");
    }
  } else if (choice == 3) {
    break;
  } else {
    System.out.println("Invalid choice.");
  }
}

}

public static Account[] addAccount(Account[] accounts, Account newAccount) {
Account[] newAccounts = new Account[accounts.length + 1];
for (int i = 0; i < accounts.length; i++) {
newAccounts[i] = accounts[i];
}
newAccounts[accounts.length] = newAccount;
System.out.println(newAccount.toString() + " created.");
return newAccounts;
}

public static Account[] removeAccount(Account[] accounts, Account accountToRemove) {
Account[] newAccounts = new Account[accounts.length - 1];
int j = 0;
for (int i = 0; i < accounts.length; i++) {
if (accounts[i] != accountToRemove) {
newAccounts[j] = accounts[i];
j++;
}
}
return newAccounts;
}
}
