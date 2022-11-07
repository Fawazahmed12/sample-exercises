package DocumentingWithJavaDoc12;

/**
 * <H1>Anonymous class example</H1>
 * This example shows the declaration of an <b>inner class</b> extending
 * an existing class and overriding a method. It can be used as a
 * technique to modify an existing method for something more suitable
 * to our purpose
 *
 * @author Joe Smith
 * @version 0.1
 * @since 20190305
 */

 class Container {
     int c = 17;
     //outer class
     public void print() {
         System.out.println("This is an outer class");
     }
}

class Example18 {
    public static void main(String[] args) {
        //inner class
        Container myContainer = new Container() {
            @Override
            public void print() {
                System.out.println("This is an inner class");
            }
        };
        myContainer.print();
        System.out.println( myContainer.c );
    }
}


