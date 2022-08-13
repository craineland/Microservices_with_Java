public class Item {
    private String index;
    private String name;
    private double cost;
    private double tax;
    private double total;


    public Item(String index, String name, double cost, double tax, double total) {
        this.index = index;
        this.name = name;
        this.cost = cost;
        this.tax = tax;
        this.total = total;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Item [index =" + index + ", name=" + name + ", cost=" + cost + ", tax=" + tax + ", total=" + total + "]\n";
    }
}
