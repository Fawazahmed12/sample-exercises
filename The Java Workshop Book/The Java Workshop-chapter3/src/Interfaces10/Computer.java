package Interfaces10;

 interface Computer {
     public String getDeviceTye();
     public String getSpeed();
}

class Tablet implements Computer {
    @Override
    public String getDeviceTye() {
        return "it is a phone";
    }
    @Override
    public String getSpeed() {
        return "1GHz";
    }

}

class Example15 {
    public static void main(String[] args) {
        Tablet myTab  = new Tablet();
        System.out.println(myTab.getDeviceTye());
        System.out.println(myTab.getSpeed());
    }
}
