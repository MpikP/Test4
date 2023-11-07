package pl.kurs.zadanie1;


public class MinMax<T extends Comparable> {
    private T min;
    private T max;



    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }
}
