public class Apartment extends Housingunit{
    
    public static int noOfUnits=6;

    public Apartment(String size,String color,String identifier,String restriction,double monthlyrentalrate){
        super(size,color,identifier,restriction,monthlyrentalrate);
    }
    

    public void computemonthlypay(){
	double rent;
	rent=(this.monthlyrentalrate)*(noOfUnits);
	System.out.println("THE RENT FOR APARTMENT "+this.identifier+" IS "+rent+" UGX.");
    }

}
