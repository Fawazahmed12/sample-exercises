package Annotations9;

 class Computer1 {
     @Deprecated
    public void whatIsIt() {
        System.out.println("it is a pc");
    }
    public void getDeviceType() {
        System.out.println("it is a pc");
    }
}

class Tablet1 extends Computer1 {
     @Override
    public void whatIsIt(){
        System.out.println("it is a table");
    }
}

class Example13 {
    public static void main(String[] args) {
        Tablet1 myTab1 = new Tablet1();
        myTab1.whatIsIt();  //output:it is a tablet
    }
}
