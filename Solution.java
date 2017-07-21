package eclipse_test;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;  
import java.util.Arrays;

public class Solution {   
	   public static void main(String [] args){  
	        
	    	int[][] array={{1,2,3,4,5}};//{{1},{2},{3},{4},{5}};

	    	Solution ss=new Solution();
	    	if(ss.Find(7, array)){
	    		 System.out.println("--true" );
	    	}else{
	    		System.out.println("--false" );
	    	}
	    	
	    	StringBuffer str=new StringBuffer("hello world");
	    	System.out.println(ss.replaceSpace(str));

	    	int[] pre= new int[7];
	    	int[] in={3334,3,3333332};
	    	int[] out = new int[3];
	    	//System.arraycopy(in, 2, out, 0, 3);
	    	//for(int i=0;i<out.length;i++)System.out.println(out[i]+"------test system.arraycopy");
	    	for(int i=0;i<7;i++)pre[i]=i+1;
	    	
	    	//System.out.println("------"+ss.GetLeastNumbers_Solution(in, 4));
//	    	for(int re=0;re<in.length;re++){
//	        	System.out.println(in[re]);}
	    	ArrayList<Integer> arr = new ArrayList<Integer>();
	    	arr=ss.printMatrix(array);
	    	ss.push(3);
	    	System.out.println(ss.VerifySquenceOfBST(in));
	    	
//	    	TreeNode tr = new TreeNode(10);
//	    	tr.left =new TreeNode(6);
//	    	tr.right=new TreeNode(14);
//	    	tr.left.left=new TreeNode(4);
//	    	tr.left.right=new TreeNode(8);
//	    	tr.right.left=new TreeNode(12);
//	    	tr.right.right=new TreeNode(16);
//	    	tr.left.left.left=null;
//	    	tr.left.left.right=null;
//	    	tr.left.right.left=null;
//	    	tr.left.right.right=null;
//	    	tr.right.left.left=null;
//	    	tr.right.left.right=null;
//	    	tr.right.right.left=null;
//	    	tr.right.right.right=null;
	    	
	    	TreeNode tr = new TreeNode(5);
	    	tr.left =new TreeNode(4);
	    	tr.right=null;
	    	tr.left.left=new TreeNode(3);
	    	tr.left.right=null;
	    	tr.left.left.left=new TreeNode(2);
	    	tr.left.left.right=null;
	    	tr.left.left.left.left=new TreeNode(1);
	    	tr.left.left.left.right=null;

	    	TreeNode trr = ss.Convert(tr);
	    	while(tr.left!=null){
	    		//System.out.println(tr.val);
	    		tr=tr.left;
	    	}
	    	String strr = new String("aa");
	    	System.out.println("--------final="+ss.PrintMinNumber(in));
	    	
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
//*****************************�������ų���С����**********************************	   
	   public String PrintMinNumber(int [] numbers) {
		   ArrayList<String> arrayNum = new ArrayList<String>();
		   int i=0, total=0, j=0, flag = 0, maxlen=0, loop=0;
		   for(i=0; i<numbers.length;i++){
			   String temp = String.valueOf(numbers[i]);
			   arrayNum.add(temp);
			   total =total+temp.length();
			   if(maxlen<temp.length())maxlen=temp.length();
		   }
		   StringBuilder resultArray = new StringBuilder();
		   while(arrayNum.isEmpty()!=true){
			   char temp = '9';
			   int tempi = arrayNum.size();
			   for(loop =0;loop<maxlen;loop++){
			   for(i=0;i<arrayNum.size();i++){
				   int index = Math.min(loop, arrayNum.get(i).length()-1);
				   if(arrayNum.get(i).charAt(index)<temp){
					   temp = arrayNum.get(i).charAt(index);
					   tempi =i; flag=1;
				   }else if(arrayNum.get(i).charAt(index)==temp){
					   flag=0;tempi =i;
				   }
			   }
			   if (flag==1)break;
			   }
			   resultArray.append(arrayNum.get(tempi));
			   arrayNum.remove(tempi);
		   }		   
		   String str = String.valueOf(resultArray.toString().toCharArray());
		   return str;
	    }
	   
//*************************������1���ֵĴ�������1��n������1���ֵĴ�����*******************************************	  
	   //���ݹ��ɣ�����ֱ��nÿ�μ�һString str = String.valueOf(n);��1�ĸ���
	   public int NumberOf1Between1AndN_Solution(int n) {
		    int total = 0, tempn=n,i=0,tempsum=1,base=1;
		    if(n==0)return 0;
		    if(n<10)return 1;
		    if(n==10)return 2;
		    if(n<20)return(n-10+3);
		    tempn=n;	
		    while(tempn>10){//��String.valueOf(tempn)ֱ��ת��Ϊ�ַ�������ȡn��λ�������һֱ��10���鷳���ң����״�
		    	String str = String.valueOf(tempn);
		    	base=1;tempsum=1;
		    	if(str.charAt(0)=='1'){//�����λΪ1��Ҫ���⿼��
		    		for(i=0;i<str.length()-2;i++){
		    			 base=base*10;
		                tempsum =base+tempsum*10;
		    		}
		    		int a=(int)Math.pow(10, str.length()-1);		    		
		    		tempn=tempn-a;//ȥ�����λ����ʣ������1�ĸ���
		    		total=total+tempsum+tempn+1;
		    	}else{//�����λ��Ϊ1�����ݹ�����2000��3000��������������1�ĸ���
		    		for(i=0;i<str.length()-2;i++){
		    			 base=base*10;
		                tempsum =base+tempsum*10;
		    		}
		    		int a=(int)Math.pow(10, str.length()-1);
		    		tempsum = base*10+tempsum*(tempn/a);		    		
		    		tempn=tempn-a*(tempn/a);//ȥ�����λ����ʣ������1�ĸ���
		    		total=total+tempsum;			    		
		    	}
		    }
		    System.out.println("-----"+tempn);
		    if(tempn==10)total=total+2;
		    if(tempn<10 && tempn>0)total=total+1;
		    return total;
	    }
	   
//*********************���������������***********************************************	   
	    public int FindGreatestSumOfSubArray(int[] array) {
	    	if (array.length==0)return 0;
	        int totalsum=0, localsum=0, tempsum=0, i=0, j=0, max=array[0];
	        for(i=0;i<array.length;i++)
	        	if(array[i]>max)max=array[i];
	        if(max <= 0)return max;
	        for(i=0; i<array.length; i++){
	        	if(array[i]>0){
	        		localsum=0;
	        		tempsum=0;
	        		for(j=i;j<array.length;j++){
	        			if(array[j]>0 && tempsum==0)localsum = localsum+array[j];
	        			else if(tempsum<0 || array[j]<0){
	        				tempsum=tempsum+array[j];
	        				if(tempsum>0){
	        					localsum=localsum+tempsum;
	        					tempsum=0;
	        				}
	        			}
	        		}
	        		if(localsum>totalsum )totalsum=localsum;
	        	}	        	
	        }
	        return totalsum;
	    }
	   
//***********************��С��K����***************************************************	   
	    //�������˼�룬��ֱ����Arrays.sort
	    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
	    	ArrayList<Integer> array = new ArrayList<Integer>();
	    	if(input.length<k ||k==0)return array;
	    	int i=0;
	    	//Arrays.sort(input);
	    	//for(i=0; i<k; i++)array.add(input[i]);
	    	int [] arraytem = new int[k];
	    	for(i=0;i<k;i++)arraytem[i] = input[i];
	    	//max heap
	    	for(i=1;i<k;i++){
	    		int j=i;
	    		while((int)(Math.floor((j-1)/2))>=0){
	    			int father  = (int)(Math.floor((j-1)/2));
	    			if(arraytem[father]<arraytem[j]){
	    				int temp=arraytem[father];
	    				arraytem[father]=arraytem[j];
	    				arraytem[j]=temp;
	    			}
	    			if(father==0)break;
	    			j=father;
	    		}
	    	}
	    	for(i=k;i<input.length;i++){
	    		if(input[i]<arraytem[0])HeapReplace(input[i],arraytem);
	    	}
	    	for(i=0;i<k;i++)array.add(arraytem[i]);
	    	return array;	        
	    }
	    public void HeapReplace(int replace, int [] array) {
	    	//heap sort
	    	array[0]=replace;
	    	int left=0, right=0, i=0;
	    	while(2*i+1<array.length){
	    		System.out.println("---2---");
	    		left=array[2*i+1];
	    		if(2*i+2<array.length)right=array[2*i+2];
	    		else right=array[2*i+1];
	    		if(left>array[i] && left>=right){
	    			int temp=left; 
	    			array[2*i+1] = array[i];
	    			array[i]=temp;
	    			i=2*i+1;
	    		}else if(right > array[i] && right > left){
	    			int temp=right; 
	    			array[2*i+2] = array[i];
	    			array[i]=temp;
	    			i=2*i+2;
	    		} else break;
	    	}
	    }
	   
//*************************�����г��ִ�������һ�������*******************************	
	    //���ֳ���һ��������ܸ���������������Ԫ�صĸ�����
	    public int MoreThanHalfNum_Solution(int [] array) {
	    	if (array.length==0)return 0;
	        int i=0, temp=array[0],num=1;
	        for(i=1;i<array.length;i++){
	        	if(array[i]==temp)num++;
	        	else if(num==0){
	        		temp = array[i];num=1;
	        	}else if(num>0)num--;
	        }
	        if(num==0)return 0;
	        num=0;
	        for(i=0;i<array.length;i++){
	        	if (array[i]==temp)num++;
	        }
	        if(num>(array.length-1)/2)return temp;
	        else return 0;
	    }
	   
//**********************�ַ���������******************************************	   
	    public ArrayList<String> Permutation(String str) {
	    	ArrayList<String> array = new ArrayList<String>();
	    	char[] src = str.toCharArray();
	    	char[] temp = new char[str.length()];
	    	for(int i=0;i<str.length(); i++){
	    		if(i!=0 && src[0]==src[i]){
	    		}else{
	    		char tempp=src[0];
	    		src[0] = src[i];
	    		src[i]=tempp;
	    		Traverse(src, 0, temp, array);
	    		char temppp=src[0];
	    		src[0] = src[i];
	    		src[i]=temppp;
	    		}
	    	}
	        return array;
	    }
	    public void Traverse(char[] src, int srci, char[] dst, ArrayList<String> array) {
	    	System.out.println("--sqy1--dsti="+srci);//+dst[srci]+"srci="+src[srci]
	    	dst[srci]=src[srci];	
	    	srci=srci+1;
	    	if(src.length>srci){	    		
	    		for(int i=srci;i<src.length; i++){
	    			if(srci!=i && src[srci]==src[i]){
	    			}else{
	    			char tempp=src[srci];
		    		src[srci] = src[i];
		    		src[i]=tempp;
		    		Traverse(src, srci, dst, array);
		    		char temppp=src[srci];
		    		src[srci] = src[i];
		    		src[i]=temppp;
	    			}
		    	}
	    	}
	    	else{
	    		String str = new String(dst);
	    		array.add(str);
	    	}	    		    	
	    }
	    
//*******************************������������˫������*******************************	
	   //Ҳ��������ջʵ�����β��֣��������
	   public TreeNode Convert(TreeNode root) {
	    	if (root == null)return null;
	    	if(root.left == null && root.right == null) return root;
	    	TreeNode left=Convert(root.left);
	    	if(left!=null){
	    		while(left.right!=null)left=left.right;
	    		left.right=root;
	    		root.left=left;
	    	}	    	
	    	TreeNode right=Convert(root.right);
	    	if(right!=null){
	    		while(right.left!=null)right=right.left;
	    		right.left=root;
	    		root.right=right;
	    	}   		    	
	    	while(root.left!=null)root=root.left;
	    	return  root;      
	    }
//����2��
//	   public static TreeNode increase= null;
//	   public TreeNode Convert(TreeNode pRootOfTree) {
//	    	if (pRootOfTree == null)return null;
//	    	if(pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
//	    	Reverse(pRootOfTree);	    	
//	    	while(pRootOfTree.left!=null){
//	    		pRootOfTree=pRootOfTree.left;
//	    	}
//	    	
//	    	return  pRootOfTree;
//       
//	    }
//	    public void Reverse(TreeNode pRootOfTree) {
//	    	if (pRootOfTree!=null){
//	    		if(pRootOfTree.left!=null){
//	    			Reverse(pRootOfTree.left);
//	    		}
//	    		if(increase==null){
//	    			increase=pRootOfTree;
//	    		}
//	    		else{
//	    			increase.right =pRootOfTree;
//	    			pRootOfTree.left=increase;
//	    			increase=increase.right;
//	    		}	    		
//	    		if(pRootOfTree.right!=null){
//	    			Reverse(pRootOfTree.right);
//	    		}
//	    	} 
//	    }
	   
//******************************��������ĸ���********************************	
	   //�����������ÿ���ڵ㸴��һ����Ϊ��һ������������ָ�룬�ٰ��������ȡ����
	    public RandomListNode Clone(RandomListNode pHead)
	    {
	    	if (pHead ==null)return null;
	    	RandomListNode newHead = pHead;
	    	RandomListNode newHeadre = pHead;
	    	RandomListNode node = new RandomListNode(newHead.label);
	    	while(newHead!=null){
	    		node=newHead.next;
	    		newHead.next=new RandomListNode(newHead.label);
	    		newHead.next.next=node;
	    		newHead=newHead.next.next;
	    	}
	    	newHead=pHead;
	    	while(newHead!=null){
	    		if(newHead.random!=null&&newHead.random.next!=null)newHead.next.random=newHead.random.next;
	    		newHead=newHead.next.next;
	    	}
	    	newHead=pHead;
	    	node=newHead.next;
	    	newHeadre=node;
	    	while(newHead.next.next!=null){
	    		newHead.next=newHead.next.next;
	    		newHead=newHead.next;
	    		node.next=node.next.next;
	    		node=node.next;
	    	}
	    	newHead.next=null;
	    	node.next=null;
	    	return newHeadre;
	    }
	   
//**************************�������к�Ϊĳһֵ��·��***********************************************	
	    /*method2:����ȫ�ֱ���ArrayList<ArrayList<Integer>> listall ��ArrayList<Integer> list ÿ�����������ӽڵ㣬
	     * ��ʼ����ʱ��return֮ǰ��ɾ��list��һ���ڵ�, �����ɱ������淽���е��ظ������ֲ�����ArrayList<Integer> */
	    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	    	ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
	    	ArrayList<ArrayList<Integer>> arrayleft = new ArrayList<ArrayList<Integer>>();
	    	ArrayList<ArrayList<Integer>> arrayright = new ArrayList<ArrayList<Integer>>();	    	
	        if(root==null || target==0 ||target<root.val)return array;
	        if(root.val==target && root.left==null && root.right==null){
	        	ArrayList<Integer> arrayfindl = new ArrayList<Integer>();
	        	arrayfindl.add(new Integer(root.val));
	        	array.add(arrayfindl);
	        }
	        if(root.left!=null){	        
	        	arrayleft=FindPath(root.left,target-root.val);
	        	if (arrayleft.size()>0){	        		
	        		for(int i=0;i<arrayleft.size();i++){
	        			ArrayList<Integer> arrayfindl = new ArrayList<Integer>();
	        			arrayfindl.add(root.val);
	        			for(int j=0;j<arrayleft.get(i).size();j++)arrayfindl.add(arrayleft.get(i).get(j));
	        			array.add(arrayfindl);
	        		}	        		
	        	}
	        }
	        if(root.right!=null){
	        	arrayright=FindPath(root.right,target-root.val);
	        	if (arrayright.size()>0){	        		
	        		for(int i=0;i<arrayright.size();i++){
	        			ArrayList<Integer> arrayfindr = new ArrayList<Integer>();
	        			arrayfindr.add(root.val);
	        			for(int j=0;j<arrayright.get(i).size();j++)arrayfindr.add(arrayright.get(i).get(j));
	        			array.add(arrayfindr);
	        		}	        		
	        	}
	        }
	        return array;
	    }
	   
//****************************�����������ĺ����������*****************************	   
	    //�������������ʣ� ������������ֵ��С�ڸ��ڵ��ֵ��������������ֵ�����ڸ��ڵ��ֵ
	    public boolean VerifySquenceOfBST(int [] sequence) {
	        if (sequence.length==0)return false;
	        ArrayList<Integer> left = new ArrayList<Integer>();
	        ArrayList<Integer> right = new ArrayList<Integer>();
	        
	        int i=0,temp=0;
	        for(i=0; i<sequence.length-1;i++){
	        	if(sequence[i]<sequence[sequence.length-1])left.add(sequence[i]);
	        	else break;
	        }
	        	int [] a=new int[left.size()];
	        if(a.length!=0){
	        	for(temp=0;temp<a.length;temp++){
	        		a[temp]=left.get(temp).intValue();
	        	}
	        	if(!VerifySquenceOfBST(a)) return false;
	        }
	        for(; i<sequence.length-1;i++){
	        	if(sequence[i]<sequence[sequence.length-1])return false;
	        	else{
	        		right.add(sequence[i]);
	        	}
	        }
	        if(right.size()!=0 &&!VerifySquenceOfBST(Arrays.copyOfRange(sequence, 
	        		sequence.length-right.size()-1, sequence.length-1))) return false;
	        return true;	        
	    }
	   
//***************************�������´�ӡ������****************************************	
	    //���ö���
	    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    	ArrayList<Integer> array = new ArrayList<Integer>();
	    	if (root == null)return array;
	    	queue.add(root);
	    	TreeNode node = root;
	    	while(queue.isEmpty()!=true){
	    		node = queue.poll();
	    		array.add(node.val);
	    		if(node.left!=null)queue.add(node.left);
	    		if(node.right!=null)queue.add(node.right);
	    	}
	    	return array;  		        
	    }
	   
//**********************ջ��ѹ�롢��������**************************************	   
	    public boolean IsPopOrder(int [] pushA,int [] popA) {
	    	if (pushA.length==0) return true;
	    	Stack<Integer> stack5 = new Stack<Integer>();
	    	int i=0, pi=0,flag=0;
	    	for(i=0; i<popA.length;i++){
	    		flag=0;
	    		if (stack5.isEmpty()==true)stack5.push(pushA[pi]);
	    		if(stack5.peek()==popA[i]){
	    			stack5.pop();flag=1;
	    		}else{
	    			while(pi<pushA.length){
	    				if(pushA[pi]==popA[i]){
	    					pi++;flag=1;break;
	    				}else{
	    					stack5.push(pushA[pi]);
	    					pi++;
	    				}
	    			}
	    			if(flag==0)return false;
	    		}
	    	}
	    	return true;	        
	    }
	   
//*****************************����min������ջ*******************************	 
	    //stack3.peek()�鿴ջ��Ԫ�ص�ֵ�� Iterator,��������stack�е�����Ԫ�أ�arraylistҲ�е�����
	   Stack<Integer> stack3 = new Stack<Integer>(); 
	   Stack<Integer> stack4 = new Stack<Integer>(); 

	   public void push(int node) {
	        stack3.push(node);
	    }
	    
	    public void pop() {
	    	stack3.pop();
	    }
	    
	    public int top() {
	    	return stack3.peek();        
	    }
	    
	    public int min() {
	    	int temp=stack3.peek();
	    	int min=stack3.peek();
	    	Iterator<Integer> ite = stack3.iterator();
	    	while(ite.hasNext()){
	    		temp=ite.next();
	    		if(temp<min)min=temp;
	    	}
	    	return min;
	   
	    	//method 2
//	    	int temp=stack3.peek();
//	    	int min=stack3.peek();
//	    	Iterator<Integer> ite = stack3.iterator();
//	    	while(stack3.isEmpty()!=true){
//	    		temp=stack3.pop();
//	    		stack4.push(temp);
//	    		if(temp<min)min=temp;
//	    	}
//	    	while(stack4.isEmpty()!=true){
//	    		temp=stack4.pop();
//	    		stack3.push(temp);
//	    	}
//	    	return min;
	    }
	   
//***************************˳ʱ���ӡ����***********************************	 
	    //����2��ÿ��ȷ���þ�����ĸ��ǵ����꼴�ɣ�ע��ֻ��һ�к�һ�������
	    public ArrayList<Integer> printMatrix(int [][] matrix) {
	        ArrayList<Integer> arr = new ArrayList<Integer>();
	        int num=0,loop=0,i=0,j=0;
	        if(matrix.length==1 && matrix[0].length==1){
	        	arr.add(matrix[0][0]);
	        	return arr;
	        }
	        if(matrix.length<matrix[0].length)num=matrix.length;
	        else num = matrix[0].length;
	        for(loop=0;loop<(num+1)/2;loop++){
	        	i=loop;
	        	for(j=loop;j<matrix[0].length-loop-1;j++){//System.out.println("--------sqy-3-------"+j +matrix[i][j]);
	        		arr.add(matrix[i][j]);
	        	}
	        	int temm=i;
	        	for(;i<matrix.length-loop-1;i++){//System.out.println("--------sqy-3-------"+j +matrix[i][j]);
	        		arr.add(matrix[i][j]);
	        	}
	        	int temmj=j;
	        	if(temm!=i){	        	
	        	for(;j>loop;j--){//System.out.println("--------sqy-3-------"+j +matrix[i][j]);
	        		arr.add(matrix[i][j]);
	        	}
	        	}else arr.add(matrix[i][j]);
	        	if(temmj!=j){
	        	for(;i>loop;i--){//System.out.println("--------sqy-3-------"+j +matrix[i][j]);
	        		arr.add(matrix[i][j]);
	        	}
	        	}else if(temm!=i)arr.add(matrix[i][j]);
	        }
	        return arr;
	    }
	   
//***************************�������ľ���***********************************	   
	    public void Mirror(TreeNode root) {
	    	TreeNode tr = new TreeNode(0);
	    	if(root!=null){
	    		tr=root.left;
	    		root.left = root.right;
	    		root.right = tr;
	    		Mirror(root.left);
	    		Mirror(root.right);
	    	}	        
	    }
	   
//******************�����ӽṹ***********************************************	   
	    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	    	if ( root2 ==null) return false;
	    	if(root1 == null) return false;
	    	if (root1.val==root2.val){
	    		if( JudgeEqual(root1,root2))return true;
	    		else if((HasSubtree(root1.left,root2))|| HasSubtree(root1.right,root2))return true;
	    	}
	    	return false;	    	
	    }
	    public boolean JudgeEqual(TreeNode root1,TreeNode root2) {
	    	if(root2==null) return true;
	    	if(root1==null) return false;
	    	if (root1.val==root2.val){
	    		if(JudgeEqual(root1.left,root2.left) && JudgeEqual(root1.right,root2.right))return true;
	    		else {
	    			return false;}
	    	}  
	    	return false;
	    }
	    //test for it
//    	TreeNode tr = new TreeNode(8);
//    	tr.left =new TreeNode(8);
//    	tr.right=new TreeNode(7);
//    	tr.right.left=null;
//    	tr.right.right=null;
//    	tr.left.left=new TreeNode(9);
//    	tr.left.left.right=null;
//    	tr.left.left.left=null;
//    	tr.left.right=new TreeNode(3);
//    	tr.left.right.left=new TreeNode(4);
//    	tr.left.right.left.right=null;
//    	tr.left.right.left.left=null;
//    	tr.left.right.right=new TreeNode(7);
//    	tr.left.right.right.left=null;
//    	tr.left.right.right.right=null;
//    	
//    	TreeNode tr2 = new TreeNode(8);
//    	tr2.left = new TreeNode(9);
//    	tr2.left.right = null;
//    	tr2.left.left = null;
//    	tr2.right = new TreeNode(2);
//    	tr2.right.left = null;
//    	tr2.right.right = null;
//    	System.out.println(ss.HasSubtree(tr,tr2));
	   
//*************************�ϲ��������������***********************************	   
	    public ListNode Merge(ListNode list1,ListNode list2) {
	        if(list2 ==null)return list1;
	        if(list1 ==null)return list2;
	    	ListNode temp1=list1,temp2=list1;
	        ListNode head= new ListNode(0);
	        if(list1.val>list2.val){
	        	temp1=list2;list2=list1;list1=temp1;
	        }
	        head=list1;
	        while(list1!=null && list2!=null){
	        	while( list1.next!=null && list1.next.val<=list2.val )list1=list1.next;
	        	temp1=list1.next;list1.next=list2;list1=temp1;
	        	while(list2.next!=null && list2.next.val<=list1.val)list2=list2.next;
	        	temp2=list2.next;list2.next=list1;list2=temp2;
	        }   
	        return head;
	    }
	   
//*************************��ת����*************************************	  
	    //ָ�����η�ת���������stack��¼��ֵ���ٱ���һ�ν������е�ֵ�ĵ�
	    public ListNode ReverseList(ListNode head) {
	    	Stack<Integer> st1 = new Stack<Integer>();
	    	ListNode node = head;
	    	while (node!=null){
	    		st1.push(node.val);
	    		node=node.next;	    		
	    	}
	    	node = head;
	    	while (node!=null){
	    		node.val=st1.pop();
	    		node=node.next;	    			    		
	    	}
	    	return head;
	    }
	   
//**************************�����е�����k���ڵ�**********************************	  
	    //����2��˫ָ�룬��һ���ƶ�k��Ȼ��ڶ����͵�һ��һ���ƶ�����һ��Ϊ��ʱ���ڶ�ָ�뼴ָ������k��
	    public ListNode FindKthToTail(ListNode head,int k) {
	    	if(head==null)return null;
	    	ListNode node = head;
	    	int num=0;
	    	while (node!=null){
	    		node=node.next;
	    		num++;
	    	}
	    	if(k>num)return null;
	    	node=head;
	    	for(int i=0;i<num-k;i++)node=node.next;
	    	return node;
	    }
	   
//****************************��������˳��ʹ����λ��ż��ǰ��****************************	
	    //���½��ռ�ʵ�֣������½�����arraylist�ֱ�����ż���ٺ�����
	    public void reOrderArray(int [] array) {
	    	// another method
//	        int i=0,j=0,temp=0;
//	        while(i<array.length-1 && j<array.length-1){
//	        	for(;i<array.length-1;i++){
//	        		if((array[i] & 1)==0)break;
//	        	}
//	        	if(j<i)j=i;
//	        	for(;j<array.length-1;j++){
//	        		if((array[j] & 1)==1)break;
//	        	}
//	        	if((array[i] & 1)==0 && (array[j] & 1)==0)break;
//
//	        	temp=array[i];array[i]=array[j];
//	        	for(int tempin=j;tempin>i+1;tempin--){
//	        		array[tempin]=array[tempin-1];
//	        	}
//	        	array[i+1]=temp;
//	        }
	        ArrayList<Integer> ls1 = new ArrayList<Integer>();
	        ArrayList<Integer> ls2 = new ArrayList<Integer>();
	        for(int i=0;i<array.length;i++){
	        	if((array[i] & 1)==1)ls1.add(array[i]);
	        	else ls2.add(array[i]);
	        }
	        int i=0,m=0;
	        for(i=0;i<ls1.size();i++)array[m++]=ls1.get(i);
	        for(i=0;i<ls2.size();i++)array[m++]=ls2.get(i);        
	        
	    }
	   
//**************************��ֵ�������η�**************************************	   
	    public double Power(double base, int exponent) {
	    	double total=1;
	        if (base <0.001 && base>-0.001) return 0.0;
	        if(exponent==0) return 1.0;
	        if(exponent >0){
	        	for(int i=1; i<=exponent;i++) total = total*base;
	        }else if(exponent<0){
	        	for(int i=1; i<=-exponent;i++) total = total*base;
	        	total = 1/total;
	        }
	        return total;
	    }
	   
//*********************��������1�ĸ���***************************************	   
	    //����2��Integer.toBinaryString(n).toCharArray();��ֱ��ת���ɸ����Ķ����Ʊ�ʾ--�������Լ���������Ʊ�ʾ
	    //����3��n = (n - 1) & n;  &&&&&&&&&&&&&һ�������Ķ������ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ�����&&&&&&&&&&&
	    public int NumberOf1(int n) {
	    	int num=0;
	    	if (n==0)return 0;
	    	if (n>0){		    	
	    		while(n>0){
	    			if( (n & 1) == 1){
	    				num=num+1;}
	    			n = n>>1;
	    		}
	    	}else{
	    		num=1;
	    		n = -n;
	    		int tempn=n,tempNum=0;
	    		while (n>0){
	    			if( (n & 1) == 1){num=num+1;break;}else tempNum=tempNum+1;
	    			n = n>>1;
	    		}
	    		if(n!=0)n=n>>1;
	    		while (n>0){
	    			if( (n & 1) == 1){num=num+1;}
	    			n = n>>1;
	    		}
	    		num = 32-num+1-tempNum+1;	    		
	    		}
	    	if(num==33)num=1;
	    	return num;
	    }

//**********************���θ���****************************************	   
	    public int RectCover(int target) {
	    	if (target==0)return 0;
	    	if(target==1)return 1;
	    	if (target==2)return 2;
	    	int fn=0;
	    	fn = RectCover(target-1)+RectCover(target-2);
	    	return fn;

	    }
	   
//*********************��̬��̨��*****************************************	   	   
	    public int JumpFloorII(int target) {
	        if(target==1 )return 1;
	        if(target==0 )return 0;
	        
	        int fn =0,i=1;
	        for (i=1; i<target; i++){
	        	fn = fn+JumpFloorII(target-i);
	        }
	        fn = fn+1;
	        return fn;
	    }
	   
//*********************��̨��*****************************************	   
	    public int JumpFloor(int target) {
	        if(target==1 )return 1;
	        if(target==0 )return 0;
        if(target==2 )return 2;

	    	int fn1=1,fn2=2,fn=0,i=0;
	        for(i=3;i<=target;i++){
	        	fn=fn1+fn2;
	        	fn1=fn2;
	        	fn2=fn;	        	
	        }
	        return fn2;	 
    }
	   
//**********************쳲���������********************************************	   
	    //�ݹ�û��forѭ��Ч�ʸ�
	    public int Fibonacci(int n) {
	        if(n==1 )return 1;
	        if(n==0 )return 0;
//	        int fn = Fibonacci(n-1)+Fibonacci(n-2);
//	        return fn;
	    	int fn1=0,fn2=1,fn=0,i=0;
	        for(i=2;i<=n;i++){
	        	fn=fn1+fn2;
	        	fn1=fn2;
	        	fn2=fn;	        	
	        }
	        return fn2;	        
	    }  
	   
//********************��ת�����е���С����********************************************	   
	    public int minNumberInRotateArray(int [] array) {
	        if(array.length==0)return 0;
	        int low=0,high=array.length-1,mid=high/2;
	        while(low< mid && mid<high){
	        	if(array[mid]<array[high]){
	        		high=mid;mid=low+(high-low)/2;
	        	}else{low=mid;mid=low+(high-low)/2;}
	        }
	        int  base=mid-2;
	        for(int i=0;i<5;i++){
	        	if (array[base+i]<array[mid])mid=base+i;
	        }	        
	        return array[mid];
	    }
	   
//*****************������ջʵ�ֶ���***************************************
	    Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
//	    public void push(int node) {
//	    	while(!stack2.isEmpty()){
//	    		int temp=stack2.pop();
//	    		stack1.add(temp);
//	    	}
//	    	stack1.add(node);	        
//	    }
//	    
//	    public int pop() {
//	    	while(!stack1.isEmpty()){
//	    		int temp =stack1.pop();
//	    		stack2.add(temp);
//	    	}
//	    	int retu = stack2.pop();
//	    	return retu;	    
//	    }
	    
//***************** �ؽ�������*************************************************
	    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	    	if(in.length==0)return null;
	    	TreeNode tr=new TreeNode(pre[0]);
	    	int i;
	    	for(i=0; i<pre.length; i++){
	    		if(in[i]==pre[0])break;
	    	}
	    	int [] leftpre = new int[i];
	    	int [] leftin = new int[i];
	    	int [] rightpre = new int[pre.length-i-1];
	    	int [] rightin = new int[pre.length-i-1];
	    	for (int j=0;j<i;j++){
	    		leftpre[j]=pre[j+1];
	    		leftin[j]=in[j];
	    	}
	    	for (int j=i+1;j<pre.length;j++){
	    		rightpre[j-i-1]=pre[j];
	    		rightin[j-i-1]=in[j];
	    	}
	    	
	    	tr.left = reConstructBinaryTree(leftpre,leftin);
	    	tr.right = reConstructBinaryTree(rightpre,rightin);
	    	return tr;
	    }
	    
//************************��β��ͷ��ӡ����*************************************************
	    //����2������stack
	    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    	ArrayList<Integer> list = new ArrayList(0);
	    	ListNode node = new ListNode(0);
	    	node = listNode;
	    	int i=0,length=0,j=0;
	    	if (listNode==null)return null;
		while(node.next!=null){
		length++;node=node.next;
		}
		if (length==0)return null;
		for (j=0;j<length;j++){
			node = listNode;
			for (i=0; i<length-j; i++){
				node = node.next;	    		
			}
			list.add(node.val);
		}
		return list;
	        
	    }	   
	   
//*****************************�滻�ո�*********************************
	    public String replaceSpace(StringBuffer str) {
	        StringBuilder temstr = new StringBuilder();
	        int i=0,j=0;
	        for(i=0; i<str.length(); i++){
	        	if(str.charAt(i)==' '){
	        		temstr.append('%');
	        		temstr.append('2');
	        		temstr.append('0');
	        	}else{
	        		temstr.append(str.charAt(i));
	        	}
	        }
	        return temstr.toString();	    	
	    }       
	   
//********************************��ά�����еĲ���**********************************
    //method2:�������½�Ϊ�������Ԫ�أ�ÿ���ж����½Ǽ���
	    public boolean Find(int target, int [][] array) {
        int row1 = array.length;
        int row2;
        int i=0,j=0;

        row2=array[0].length;   
        for(i=0;i<row2;i++){
            if(array[0][i]==target)return true;
            if(array[0][i]>target){row2=i;break;}
        }
        for(i=0;i<row1;i++){
            if(array[i][0]==target)return true;
            if(array[i][0]>target){row1=i;break;}
        }
        for(i=0; i<row1;i++){
        	int middle=row2/2;
        	int low=0,high=row2;
        	while(middle>low && middle<=high){
        		if (array[i][middle]>target){
        			high=middle;
        			middle=(middle-low)/2+low;
        		}else if(array[i][middle]==target){
        			return true;
        		}else{
        			low=middle;
        			middle=(high-middle)/2+middle;
        		}
        	}
        }
        return false;
    }
    

}
