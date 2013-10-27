public abstract class Housingunit{
    String size;
    String color;
    String identifier;
    String restriction;
    double monthlyrentalrate;

    public Housingunit(String size,String color,String identifier,String restriction,double monthlyrentalrate){
	this.size=size;
	this.color=color;
	this.identifier=identifier;
	this.restriction=restriction;
	this.monthlyrentalrate=monthlyrentalrate;
    }

    public abstract void computemonthlypay();
    
}
