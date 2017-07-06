package eclipse_test;

public abstract class A {
    public A(){
    }
    private String name;
    
    public String namee;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String drink(){
        return "ºÈµÄÊÇ ";
    }
    
    /**
     * ÖØÐ´toString()
     */
    public String toString(){
        return null;
    }
    public abstract void cry();

}
