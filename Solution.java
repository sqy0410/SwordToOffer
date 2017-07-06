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
	    	int[] in={4,8,6,12,16,14,10};
	    	for(int i=0;i<7;i++)pre[i]=i+1;
	    	
	    	System.out.println(ss.NumberOf1(-1));
	    	ss.reOrderArray(in);
//	    	for(int re=0;re<in.length;re++){
//	        	System.out.println(in[re]);}
	    	ArrayList<Integer> arr = new ArrayList<Integer>();
	    	arr=ss.printMatrix(array);
	    	ss.push(3);
	    	System.out.println(ss.VerifySquenceOfBST(in));
	    	
	    	TreeNode tr = new TreeNode(10);
//	    	tr.left =new TreeNode(5);
//	    	tr.right=new TreeNode(12);
//	    	tr.right.left=null;
//	    	tr.right.right=null;
//	    	tr.left.left=new TreeNode(4);
//	    	tr.left.left.right=null;
//	    	tr.left.left.left=null;
//	    	tr.left.right=new TreeNode(7);
//	    	tr.left.right.left=null;
//	    	tr.left.right.right=null;

	    	System.out.println(ss.FindPath(tr, 10));

	    	
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
//******************************复杂链表的复制********************************	   
	    public RandomListNode Clone(RandomListNode pHead)
	    {
	    	
	        
	    }
	   
//**************************二叉树中和为某一值的路径***********************************************	
	    /*method2:设置全局变量ArrayList<ArrayList<Integer>> listall 和ArrayList<Integer> list 每查找完左右子节点，
	     * 开始回退时（return之前）删除list中一个节点, 这样可避免下面方法中的重复创建局部变量ArrayList<Integer> */
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
	   
//****************************二叉搜索树的后序遍历序列*****************************	   
	    //二叉搜索树性质： 左子树的所有值都小于根节点的值。右子树的所有值都大于根节点的值
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
	   
//***************************从上往下打印二叉树****************************************	
	    //利用队列
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
	   
//**********************栈的压入、弹出序列**************************************	   
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
	   
//*****************************包含min函数的栈*******************************	 
	    //stack3.peek()查看栈顶元素的值。 Iterator,迭代器有stack中的所有元素，arraylist也有迭代器
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
	   
//***************************顺时针打印矩阵***********************************	 
	    //方法2：每次确定好矩阵的四个角的坐标即可，注意只有一行和一竖的情况
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
	   
//***************************二叉树的镜像***********************************	   
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
	   
//******************树的子结构***********************************************	   
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
	   
//*************************合并两个排序的链表***********************************	   
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
	   
//*************************反转链表*************************************	  
	    //指针依次反转，或遍历用stack记录数值，再遍历一次将链表中的值改掉
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
	   
//**************************链表中倒数第k个节点**********************************	  
	    //方法2：双指针，第一个移动k，然后第二个和第一个一起移动，第一个为空时，第二指针即指向倒数第k个
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
	   
//****************************调整数组顺序使奇数位于偶数前面****************************	
	    //不新建空间实现，或者新建两个arraylist分别存放奇偶，再合起来
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
	   
//**************************数值的正数次方**************************************	   
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
	   
//*********************二进制中1的个数***************************************	   
	    //方法2：Integer.toBinaryString(n).toCharArray();可直接转化成该数的二进制表示--，不需自己算出二进制表示
	    //方法3：n = (n - 1) & n;  &&&&&&&&&&&&&一个整数的二进制有多少个1，就可以进行多少次这样的操作。&&&&&&&&&&&
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
	   
//**********************矩形覆盖****************************************	   
	    public int RectCover(int target) {
	    	if (target==0)return 0;
	    	if(target==1)return 1;
	    	if (target==2)return 2;
	    	int fn=0;
	    	fn = RectCover(target-1)+RectCover(target-2);
	    	return fn;

	    }
	   
//*********************变态跳台阶*****************************************	   	   
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
	   
//*********************跳台阶*****************************************	   
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
	   
//**********************斐波那契数列********************************************	   
	    //递归没有for循环效率高
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
	   
//********************旋转数组中的最小数字********************************************	   
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
	   
//*****************用两个栈实现队列***************************************
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
	    
//***************** 重建二叉树*************************************************
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
	    
//************************从尾到头打印链表*************************************************
	    //方法2：利用stack
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
	   
//*****************************替换空格*********************************
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
	   
//********************************二维数组中的查找**********************************
    //method2:矩阵右下角为矩阵最大元素，每次判断右下角即可
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
