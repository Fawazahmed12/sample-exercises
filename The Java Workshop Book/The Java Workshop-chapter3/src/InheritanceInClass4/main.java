package InheritanceInClass4;

public class main {
    public static void main(String[] args) {
        Tablet myTab = new Tablet();
        myTab.setCpuSpeed(2.5);
        myTab.setScreenSize(10);
        System.out.println(myTab.getCpuSpeed());
        System.out.println(myTab.getScreenSize());
    }
}
