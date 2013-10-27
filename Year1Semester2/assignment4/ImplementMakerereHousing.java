                              /*             MAKERERE UNIVERSITY
                               COLLEGE OF COMPUTING AND INFORMATICS TECHNOLOGY
                                       DEPARTMENT OF COMPUTER SCIENCE
                                              CSC1208 ASSIGNMENT 4     
                                          LECTURER:DR. JOHN NGUBIRI      */

//NAME:NINSIIMA FLAVIA DELMIRA
//REGISTRATION NUMBER:10/U/1382
//STUDENT NUMBER:210000613

public class ImplementMakerereHousing{
    public static void main(String[] args){
	System.out.println("INSTANTIATING THREE NEW BUNGALOWS");
	Housingunit B1=new Bungalow("BIG","CREAM","1","STAFF",900000);
	Housingunit B2=new Bungalow("SMALL","YELLOW","2","STAFF",800000);
	Housingunit B3=new Bungalow("MEDIUM","SKY BLUE","3","STAFF",850000);
	System.out.println("INSTANTIATING THREE NEW APARTMENT BLOCKS");
	Housingunit A1=new Apartment("3-BEDROOMED","LIME GREEN","UP-TOWN","STAFF",750000);
	Housingunit A2=new Apartment("1-BEDROOMED","WHITE","GO-DOWN","STAFF",550000);
	Housingunit A3=new Apartment("2-BEDROOMED","SUNFLOWER YELLOW","DOWN-TOWN","STAFF",650000);
	System.out.println("INSTANTIATING THREE NEW HOSTELS");
	Housingunit H1=new Hostel("3.5-SUARE FEET","ROSE PINK","PLAZA","STUDENTS",450000);
	Housingunit H2=new Hostel("4-SQUARE FEET","BROWN","METRO","STUDENTS",500000);
	Housingunit H3=new Hostel("3-SQUARE FEET","INDIGO","NSUBUGA","STUDENTS",400000);
	Housingunit[] units=new Housingunit[9];
	units[0]=B1; units[1]=B2; units[2]=B3; units[3]=A1; units[4]=A2; units[5]=A3; units[6]=H1; units[7]=H2; units[8]=H3;
       	ClickBoss boss=new ClickBoss();
	boss.tellrestriction(units[8]);
	boss.tellsize(units[5]);
	boss.changecolor(units[4],"SAPPHIRE BLUE");
	boss.tellcolor(units[4]);
	/*	boss.computepay(units[0]);
       	boss.computepay(units[1]);
	boss.computepay(units[2]);
	boss.computepay(units[3]);
	boss.computepay(units[4]);
	boss.computepay(units[5]);
	boss.computepay(units[6]);
	boss.computepay(units[7]);
	boss.computepay(units[8]);*/
    }
}