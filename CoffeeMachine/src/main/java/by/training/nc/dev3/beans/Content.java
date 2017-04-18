package by.training.nc.dev3.beans;

/**
 * Created by Win on 18.03.2017.
 */
public class Content extends Entity{
    private String title;
    private double cost;
    private int count;

    public Content(){}
    public Content(int id, String title, double cost, int count) {
        super(id);
        this.title = title;
        this.cost = cost;
        this.count = count;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Content:"
                 + title  +
                " cost=" + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content = (Content) o;

        if (Double.compare(content.cost, cost) != 0) return false;
        return title.equals(content.title);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
