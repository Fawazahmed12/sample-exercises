package OverloadingMethodsAndConstructors7;

 class Age {
    public double a = 0;

    public void setAge(double _a) {
        a = _a;
    }
// we can use same method name but different parameters or type
    public void setAge (int year, int month) {
        a = year + (double) month / 12;
    }

    public double getAge() {
        return a;
    }
}

class Example09 {
    public static void main(String[] args) {
        Age age = new Age();
        age.setAge(12.5);
        System.out.println(age.getAge());
        age.setAge(9,3);
        System.out.println(age.getAge());
    }
}
