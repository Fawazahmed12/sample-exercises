package OverridingAndHidingMethods5;

public class Computer1 {
    public static void whatIsIt() {
        System.out.println("it is a pc");
    }
}

class Tablet1 extends Computer1{
    public static  void whatIsIt(){
        System.out.println("it is a tablet");
    }
}

class Example07 {
//    public static void main(String[] args) {
//        Computer1 myTab = new Tablet1();
//        myTab.whatIsIt();  //output:it is a pc
//    }

    public static void main(String[] args) {
//        Computer1 myTab = new Tablet1();
        Computer1.whatIsIt(); //it is a pc
        Tablet1.whatIsIt();  //output:it is a tablet
    }
}