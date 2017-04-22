public class Plane {
    /************ Variables ********/
    int seatCapacity;
    int firstClassCap;
    int normalClassCap;

    /*********** Method ***********/

    public Plane(int setCap, int firstCCap, int normCCap){
        seatCapacity = setCap;
        firstClassCap = firstCCap;
        normalClassCap = normCCap;
    }
    public void set_Plane_inform(int setCap, int firstCCap, int normCCap){
        seatCapacity = setCap;
        firstClassCap = firstCCap;
        normalClassCap = normCCap;
    }
    public void get_Plane_inform(){
        System.out.printf("Seat capacity: %n",seatCapacity);
    }
}
