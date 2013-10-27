                              /*             MAKERERE UNIVERSITY
                               FACULTY OF COMPUTING AND INFORMATICS TECHNOLOGY
                                       DEPARTMENT OF COMPUTER SCIENCE
                                              CSC1208 ASSIGNMENT 2     
                                          LECTURER:DR. JOHN NGUBIRI      */

//NAME:NINSIIMA FLAVIA DELMIRA
//REGISTRATION NUMBER:10/U/1382
//STUDENT NUMBER:210000613

/*A C PROGRAM THAT READS AND WRITES DATA TO (DIFFERENT) FILES*/
/*DEFINING THE CONSTANTS NEEDED IN COMPUTATIONS AND DECLARING THE NECESSARY ARRAYS THAT STORE DATA*/
#include<stdlib.h>
#include<stdio.h>
#define SERVICE_FEE 2000 
#define UNIT_COST 2500
#define PAYE 0.18

long cost[15]; 
long array[15][4];

/*FUNCTION PROTOTYPES*/
void compute_balance(void);
void summarize_data(void);
void writes_data(void);



void main()
{
int a,b;
FILE *fp;
fp=fopen("readings.txt","r");//USING THE FOPEN FUNCTION TO OPEN DATA FROM THE FILE readings.txt IN "READ MODE"
if(fp==NULL)                 //AN IF STATEMENT CHECKS WHETHER FILE OPENING WAS A SUCCESS
 {
 puts("COULD NOT OPEN \"readings.txt\"");
 exit(1);
 }

for(a=0;a<15;a++)            //USING A FOR STATEMENT TO STORE DATA READ FROM READINGS.TXT INTO AN ARRAY CALLED array[]
{
 for(b=0;b<4;b++)
 {
 fscanf(fp,"%ld",&array[a][b]); 
 }
}
fclose(fp);

/*CALLING THE APPROPRIATE FUNCTIONS TO WORK ON THE DATA STORED IN array[]*/
compute_balance();
summarize_data();
writes_data();
}



/*A FUNCTION THAT COMPUTES UNITS OF WATER USED,COMPUTES THE CURRENT MONTH'S BALANCE AND STORES IT IN AN ARRAY CALLED cost[]*/
void compute_balance(void)
{
int i;
int units[15];
for(i=0;i<15;i++)
 {
 units[i]=array[i][3]-array[i][2];
 cost[i]=SERVICE_FEE+(units[i]*UNIT_COST);
 }
}

/*A FUNCTION TO SUMMARIZE ACCOUNT STATUS FOR @ CUSTOMER IN A FILE CALLED status.xls*/
void summarize_data(void)
{
long r;
FILE *fs;
fs=fopen("status.xls","w");
for(r=0;r<15;r++)
 {
 fprintf(fs,"%ld\t%ld\t%ld\n",(r+1),array[r][1],cost[r]);
 }
fclose(fs);
}

/*A FUNCTION THAT WILL WRITE ON A WORD FILE bill.doc THE BILL OF @ CUSTOMER*/
void writes_data(void)
{
long q;
float tax;
long total;
FILE *fw;
fw=fopen("bill.doc","w");
for(q=0;q<15;q++)
 {
 tax=PAYE*cost[q];
 total=tax+cost[q]+array[q][1];
 fprintf(fw,"CUST_NO\tPREVIOUSMETERREADING\tCURRENTMETERREADING\tLASTMONTHSBALANCE\tCURRENTMONTHSCOST\tTAX\t\tTOTAL_PAYABLE\n\n");
 fprintf(fw,"%ld\t\t%ld\t\t\t%ld\t\t\t%ld\t\t\t%ld\t\t%.2f\t\t%ld/=\n\n",(q+1),array[q][2],array[q][3],array[q][1],cost[q],tax,total);
 fprintf(fw,"\"Mzee, pay the bills otherwise we shall disconnect you immediately\"\n");
 fprintf(fw,"--------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
 }
fclose(fw);
}
