package InheritanceInClass4;

public class Computer { //parent class

   private double cpuSpeed;

    Computer(){
        cpuSpeed = 0;
    }

    void setCpuSpeed (double _cpuSpeed) {
        cpuSpeed = _cpuSpeed;
    }
    double getCpuSpeed() {
        return cpuSpeed;
    }
}
