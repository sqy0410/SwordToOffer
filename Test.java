package eclipse_test;

public class Test{  
	   public static void main(String [] args){  
		 //���常������
	        A[] wines = new A[2];
	        //������������
	        B jnc = new C();
	        C sqyy = new C();
	        
	        //���������������
	        wines[0] = jnc;
	        sqyy.sqy = 9;
	        for(int i = 0 ; i < 1 ; i++){
	            System.out.println(wines[i].toString() + "--" + wines[i].drink());
	        }
	        System.out.println("-------------------------------");

	        
	    	int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

	    	Solution ss=new Solution();
	    	if(ss.Find(7, array)){
	    		 System.out.println("--true" );
	    	}else{
	    		System.out.println("--false" );
	    	}
	    	
	   }  
	}