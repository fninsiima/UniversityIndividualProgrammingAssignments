public class ClickBoss{
    public void tellsize(Housingunit h){
	System.out.println("THE HOUSING UNIT IS OF SIZE "+h.size+".");
    }

    public void tellcolor(Housingunit h){
	System.out.println("THE HOUSING UNIT IS OF COLOR "+h.color+".");
    }

    public void tellmonthlyrentalrate(Housingunit h){
	System.out.println("THE HOUSING UNIT HAS A MONTHLY RENTAL RATE OF "+h.monthlyrentalrate+".");
    }

    public void tellidentifier(Housingunit h){
	System.out.println("THE HOUSING UNIT'S IDENTIFIER IS "+h.identifier+".");
    }

    public void tellrestriction(Housingunit h){
	System.out.println("THE HOUSING UNIT ACCOMODATES ONLY MAKERERE "+h.restriction+".");
    }

    public void changesize(Housingunit h,String size){
	h.size=size;
    }

    public void changecolor(Housingunit h,String color){
	h.color=color;
    }

    public void changemonthlyrentalrate(Housingunit h,double rate){
	h.monthlyrentalrate=rate;
    }
    
    public void changeidentifier(Housingunit h,String id){
	h.identifier=id;
    }

    public void computepay(Housingunit h){
	System.out.println("COMPUTING PAY FOR THE HOUSING UNIT");
	h.computemonthlypay();
    }

}