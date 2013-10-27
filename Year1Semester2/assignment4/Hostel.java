public class Hostel extends Housingunit{
    public static int noOfRooms=50;
    public static int roomCapacity=4;
    public static double  utilities=150000;

    public Hostel(String size,String color,String identifier,String restriction,double monthlyrentalrate){
        super(size,color,identifier,restriction,monthlyrentalrate);
    }

    public void computemonthlypay(){
	double rent,totalcapacity;
	totalcapacity=(noOfRooms)*(roomCapacity);
	rent=(totalcapacity*this.monthlyrentalrate)+(totalcapacity*utilities);
	System.out.println("THE MONTH'S RENT FOR HOSTEL "+this.identifier+" IS "+rent+" UGX.");
    }

}