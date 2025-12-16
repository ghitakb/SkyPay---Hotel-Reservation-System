package src;

public class User {
    private final int   id;
    private long        balance;

    public User (int id, int balance) {
        this.id = id;
        if (balance < 0)
            throw new IllegalArgumentException("Error: Balance can not be negative.");
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Error: Balance can not be negative.");
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User:" + this.id + ", balance => " + this.balance + '.';
    }
}