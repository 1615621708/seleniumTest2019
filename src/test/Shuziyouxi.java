package test;

import java.util.Random;
import java.util.Scanner;
public class Shuziyouxi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
        Random r=new Random();
        int j=r.nextInt(100);
        while(true){
        	int i=s.nextInt();
        	if(i==j){
            	System.out.println("����");
            	break;
            }else if(i<j){
            	System.out.println("С��");
            }else{
            	System.out.println("����");
            }
        	
        }
           
	}

}
