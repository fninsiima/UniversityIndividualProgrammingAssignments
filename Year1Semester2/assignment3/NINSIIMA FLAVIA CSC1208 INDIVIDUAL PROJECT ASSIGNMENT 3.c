                              /*             MAKERERE UNIVERSITY
                               COLLEGE OF COMPUTING AND INFORMATICS TECHNOLOGY
                                       DEPARTMENT OF COMPUTER SCIENCE
                                              CSC1208 ASSIGNMENT 3     
                                          LECTURER:DR. JOHN NGUBIRI      */

//NAME:NINSIIMA FLAVIA DELMIRA
//REGISTRATION NUMBER:10/U/1382
//STUDENT NUMBER:210000613

//A PROGRAM THAT COMPUTES THE ROOT OT A TEN ORDER POLYNOMIAL USING NEWTON RAPHSON METHOD

#include<stdio.h>
#include<math.h>
#define ORDER 10               //DEFINING THE NECESSARY CONSTANTS FOR MAXIMUM ITERATIONS AND ACCEPTABLE ERROR MARGIN
#define It 70
#define Ea 0.00000001

int I,coeff_a[ORDER+1];        
float x0;
double E,x1, fx0, fdx0;

void get_coeffs(void);         //FUNTION PROTOTYPES FOR THE NEEDED FUNCTIONS
void get_festimate(void);
void output_data(void);
void compute_root(void);

void main()                    //THE MAIN FUNCTION    
{
  printf("\nTHIS PROGRAM COMPUTES THE ROOT OF A %d ORDER POLYNOMIAL USING NEWTON RAPHSON METHOD:",ORDER);
  printf("\nIT IS OF THE FORM:\t");
  printf("f(x)=a0+a1x+a2x^2+a3x^3.....................................+a10x^10.");
  printf("\nTHE NRM FORMULA FOR FINDING THE ROOT OF AN EQUATION IS:");
  printf("\n\t\tx1=x0-(f(x0)/f'(x0)): where f'(x) is the first derivative of f(x)");
  printf("\nIT TERMINATES IF THE NUMBER OF ITERATIONS,I,EXCEED A MAXIMUM OF 70 ITERATIONS:");
  printf("\nIT SHOULD TERMINATE IF THE ABSOLUTE RELATIVE ERROR,E IS LESS THAN THE ACCEPTABLE ERROR MARGIN 0.00000001:" );
  printf("\nYOU ARE REQUIRED TO INPUT THE COEFFICIENTS AND FIRST ESTIMATE,x0:");
  
  get_coeffs();              //INVOKING THE NEEDED FUNCTIONS
  get_festimate();
  output_data();
  compute_root();
}

void get_coeffs(void)
{
  printf("\n\nYOU CAN ENTER ONLY %d INTEGER COEFFICIENTS:",ORDER+1);
  printf("\nTHE 1ST,2ND AND LAST COEFFICIENTS(a0,a1 and a10) MUST NOT BE ZERO:\n");
 
  int count;
  for(count=0;count<=1;count++)
    {
      coeff_a[count]=0;
      while(coeff_a[count]==0)                                  //WHILE LOOP TO ENSURE A NON ZERO COEFFICIENT
	{
  printf("ENTER THE COEFFICIENT FOR x^%d: ",count);
  scanf("%d",&coeff_a[count]);
	}
    }

 for(count=2;count<ORDER;count++)
    { 
  printf("ENTER THE COEFFICIENT FOR x^%d: ",count);
  scanf("%d",&coeff_a[count]);
    }

 
      coeff_a[ORDER]=0;
      while(coeff_a[ORDER]==0)                                   //WHILE LOOP TO ENSURE A NON ZERO COEFFICIENT
	{
  printf("ENTER THE COEFFICIENT FOR x^%d: ",ORDER);
  scanf("%d",&coeff_a[ORDER]);
	}
}

void get_festimate(void)
{
 do{                                                              //DO WHILE LOOP TO ENSURE A NON ZERO COEFFICIENT
   printf("\nENTER FIRST ESTIMATE,x0(IT SHOULD BE 1.5): ");
   scanf("%f",&x0);
   }while(x0!=1.5);
}

void output_data(void)
{
  int count;
  printf("\nTHE POLYNOMIAL IS: f(x)=");
  for(count=0;count<ORDER;count++)
    {
      printf("%dx^%d+",coeff_a[count],count);
    }
  printf("%dx^10",coeff_a[ORDER]);
  printf("\nINITIAL ESTIMATE x0:    %f",x0);
  printf("\n*****************************************************************************************************");
  printf("\nITERATION\t\tx0\t\tf(x0)\t\t\tf'(x0)");
  printf("\n*****************************************************************************************************");
}

void compute_root(void)
{
  int count;
  I=0;
  E=1;
  while(1)
  {
    if(I==It)                                                   //BREAK STATEMENT TO ENSURE A MAX. OF 70 ITERATIONS
      break;
    fx0=fdx0=0;
    for(count=ORDER;count>=0;count--)
      {
	fx0+=coeff_a[count]*pow(x0,count);
      }
    for(count=ORDER;count>=1;count--)
      {
	fdx0+=coeff_a[count]*count*pow(x0,(count-1));
      }
    x1=x0-(fx0/fdx0);
    E=(x1-x0)/x1;
    E=fabs(E);
    x0=x1;
    I++;
    printf("\n%d\t\t%.5f\t\t%.5f\t\t%.5f",I,x0,fx0,fdx0);
    if(E<=Ea)                                                   //BREAK STATEMENT TO ENSURE AN ACCEPTABLE ERROR MARGIN OF 0.00000001 
      break;
  }
  printf("\nTHE ROOT OF THE POLYNOMIAL IS %f\n",x1);
}
 
/*REFERENCES*/
/*[1]William Bouchard. (2011,Mar.). General Newton Raphson Method. [Online]. Available:
     http://www.syntax-example.com/Code/general-newton-raphson-method-2405.aspx */
