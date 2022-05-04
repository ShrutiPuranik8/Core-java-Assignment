class AccountUnsafe {
    static int current_unsafe_balance = 1000;

    static void withdrawUnsafe(String name, int amount) {
        if (current_unsafe_balance >= amount) {
            System.out.println(name + " withdrawn " + amount);
            current_unsafe_balance = current_unsafe_balance - amount;
            System.out.println("Current_unsafe_balance: " + current_unsafe_balance);

        } else {
            System.out.println(name + " you can not withdraw " + amount);
            System.out.println("Current_unsafe_balance is: " + current_unsafe_balance);

        }

    }

}

class Account {

    static int current_balance = 1000;

    static synchronized void withdraw(String name, int amount) {

        if (current_balance >= amount) {
            System.out.println(name + " withdrawn " + amount);
            current_balance = current_balance - amount;
            System.out.println("Current_balance: " + current_balance);

        } else {
            System.out.println(name + " you can not withdraw " + amount);
            System.out.println("Current_balance is: " + current_balance);

        }
    }

}

class AccountOverdrawSafeDemo extends Thread {
    Account object;
    String name;
    int balance;

    AccountOverdrawSafeDemo(Account ob, String name, int amount) {
        this.object = ob;
        this.name = name;
        this.balance = amount;
    }

    public void run() {
        object.withdraw(name, balance);
    }
}

class AccountOverdrawDemo extends Thread {
    AccountUnsafe object1;
    String name;
    int balance;

    AccountOverdrawDemo(AccountUnsafe ob, String name, int amount) {
        this.object1 = ob;
        this.name = name;
        this.balance = amount;
    }

    public void run() {
        object1.withdrawUnsafe(name, balance);
    }
}

class Withdraw {

    public static void main(String[] args) {
        Account account = new Account();

        AccountUnsafe account1 = new AccountUnsafe();

        AccountOverdrawDemo thread1 = new AccountOverdrawDemo(account1, "Pravin", 200);
        AccountOverdrawDemo thread2 = new AccountOverdrawDemo(account1, "Prgati", 200);
        AccountOverdrawDemo thread3 = new AccountOverdrawDemo(account1, "Pravin", 600);
        AccountOverdrawDemo thread4 = new AccountOverdrawDemo(account1, "Pragati", 600);

        AccountOverdrawSafeDemo thread5 = new AccountOverdrawSafeDemo(account, "Shruti", 500);
        AccountOverdrawSafeDemo thread6 = new AccountOverdrawSafeDemo(account, "Shreya", 100);
        AccountOverdrawSafeDemo thread7 = new AccountOverdrawSafeDemo(account, "Shruti", 600);
        AccountOverdrawSafeDemo thread8 = new AccountOverdrawSafeDemo(account, "Shreya", 200);

        // Unsafe Thread

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Safe Thread

        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
    }
}
