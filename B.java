package eclipse_test;

public abstract class B extends A{  
	public B(){
        setName("JNC");
    }
    
    /**
     * ��д���෽����ʵ�ֶ�̬
     */
    public String drink(){
        return "�ȵ��� " + getName();
    }
    
    /**
     * ��дtoString()
     */
    public String toString(){
        return "Wine : " + getName();
    }
    
//    public static String drink(){
//        return "�ȵ��� ";
//    }
    
    //public abstract void cry();
	}