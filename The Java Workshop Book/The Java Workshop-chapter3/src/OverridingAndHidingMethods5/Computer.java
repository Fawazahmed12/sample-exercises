package OverridingAndHidingMethods5;

 class Computer {
     public void whatIsIt() {
         System.out.println("it is a pc");
     }
}

class Tablet extends Computer{
    public void whatIsIt(){
        System.out.println("it is a tablet");
    }
}

class Example06 {
    public static void main(String[] args) {
        Tablet myTab = new Tablet();
        Computer myCom = new Computer();

        myTab.whatIsIt();  //output:it is a tablet
        myCom.whatIsIt(); // output : it is a pc
    }

    //the method is non-static so we can use Tablet or Computer

//    public static void main(String[] args) {
//        Computer myTab = new Tablet();
//        myTab.whatIsIt();  //output:it is a tablet
//    }
}
