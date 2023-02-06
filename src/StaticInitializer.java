public class StaticInitializer {
    public static int staticField;

    static {
        staticField = 1; // changing static fields
        incrementStaticField(); // calling static method
        System.out.println("static initializer/Constructor called "); // checking if it is called for each new instance
    }
    public static void incrementStaticField() {
        staticField += 1;
    }
    @Override
    public String toString() {
        return staticField + " ";
    }

}
class Main1 {
    public static void main(String[] args) {
        StaticInitializer static1 = new StaticInitializer();
        System.out.println(static1.toString());
        StaticInitializer static2 = new StaticInitializer();
        System.out.println(static2.toString());

    }

}
