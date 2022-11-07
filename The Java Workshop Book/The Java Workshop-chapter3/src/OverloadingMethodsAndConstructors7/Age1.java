package OverloadingMethodsAndConstructors7;

 class Age1 {
    public double a = 0;

     Age1(double _a) {
         a = _a;
     }

     Age1( int year, int month ) {
         a = year + (double) month / 12;
     }

    public double getAge1 () {
        return a;
    }
}

class Example10 {
    public static void main(String[] args) {
        Age1 age1 = new Age1(12.5);
        Age1 age2 = new Age1(9,3);
        System.out.println(age1.getAge1());
        System.out.println(age2.getAge1());
    }
}
