package winter2020.DSAs;

public class Counter {
    public static int s;
    public static int m;
    public static int count;

    public Counter(){
        s = 0;
        m = 0;
        count = 0;
    }

    public String incS(){
        return "sort(" + ++s + ")";
    }

    public String incM(){
        return "merge(" + ++m + ")";
    }

    public int count(){
        return ++count;
    }
}
