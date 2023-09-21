public class Toy {
    private String name;
    private int amount;

    public Toy(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", amount=" + amount +
                '}' + "\n";
    }

    public String getName() {
        return name;
    }
}

