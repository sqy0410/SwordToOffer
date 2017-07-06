package eclipse_test;

public abstract class B extends A{  
	public B(){
        setName("JNC");
    }
    
    /**
     * 重写父类方法，实现多态
     */
    public String drink(){
        return "喝的是 " + getName();
    }
    
    /**
     * 重写toString()
     */
    public String toString(){
        return "Wine : " + getName();
    }
    
//    public static String drink(){
//        return "喝的是 ";
//    }
    
    //public abstract void cry();
	}