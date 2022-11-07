package Annotations9;

 class Computer {
    public void whatIsIt() {
        System.out.println("it is a c");
    }
}

class Tablet extends Computer {
     @Override
    public void whatIsIt(){
        System.out.println("it is a tabl");
    }
}

class Example12 {
    public static void main(String[] args) {
        Tablet myTab = new Tablet();
        myTab.whatIsIt();  //output:it is a tabl
    }
}
