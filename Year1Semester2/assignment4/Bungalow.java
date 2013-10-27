public class Bungalow extends Housingunit{

    public Bungalow(String size,String color,String identifier,String restriction,double monthlyrentalrate){
        super(size,color,identifier,restriction,monthlyrentalrate);
    }
    
    public void computemonthlypay(){
	System.out.println("THIS MONTH'S RENT FOR BUNGALOW "+this.identifier+" IS "+this.monthlyrentalrate+" UGX.");
    }

}
