package Annotations9;

 class Computer2 {
     @Deprecated
    public void whatIsIt() {
        System.out.println("it is a pc");
    }
    public void getDeviceType() {
        System.out.println("it is a pc");
    }
}

@SuppressWarnings("deprecation")
class Tablet2 extends Computer2 {
     @Override
    public void whatIsIt(){
        System.out.println("it is a tablets");
    }
}

class Example14 {
    public static void main(String[] args) {
        Tablet2 myTab2 = new Tablet2();
        myTab2.whatIsIt();  //output:it is a tablet
    }
}
