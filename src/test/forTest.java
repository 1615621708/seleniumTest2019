package test;

public class forTest {
//	public static void main(String []args){
//		int i=1;
//		if(i<5){
//			for(int j=0;j<5;j++){
//				System.out.println("j"+j);
//			}System.out.println("i"+i);
//		}
//	}

		public static void main(String[] args){
			for(int i=0;i<10;i++){
				if(i%2==0){
					continue;
				}
				System.out.println(i);
			}
		}

	
	
}
