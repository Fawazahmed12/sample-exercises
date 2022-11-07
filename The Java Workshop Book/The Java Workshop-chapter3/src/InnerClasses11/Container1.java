package InnerClasses11;

 class Container1 {
     int c = 17;
     //outer class
     public void print() {
         System.out.println("This is an outer class");
     }
}

class Example17{
    public static void main(String[] args) {
        //inner class
        Container1 myContainer = new Container1() {
            @Override
            public void print() {
                System.out.println("This is an inner class");
            }
        };
        myContainer.print();
        System.out.println( myContainer.c );
    }
}


