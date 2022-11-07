package InheritanceInClass4;

 class Tablet extends Computer {   //child class
     private double screenSize;

     Tablet(){
         screenSize = 0;
     }

     void setScreenSize (double _screenSize) {
         screenSize = _screenSize;
     }
     double getScreenSize() {
         return screenSize;
     }
}
