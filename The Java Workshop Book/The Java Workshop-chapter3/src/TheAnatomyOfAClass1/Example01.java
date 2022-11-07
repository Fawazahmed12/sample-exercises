package TheAnatomyOfAClass1;

public class Example01 {
    public static void main(String[] args) {
        Computer myPC = new Computer();
//        myPC.cpuSpeed = 7.9;
        myPC.setCpuSpeed(2.5);
        System.out.println(myPC.getCpuSpeed());
    }
}
