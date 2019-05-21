package com.somnath.java8;

@FunctionalInterface
public interface IComplex {
	void print();
    default void defaultMethod(){
        System.out.println("Default");
    }

    static void staticMethod(){
        System.out.println("Static");
    }    
}

class MyClass implements IComplex {

    public static void main(String[] args) {

        //MyClass.staticMethod(); //not valid - static method may be invoked on containing interface class only
        IComplex.staticMethod(); //valid
    }
    
    @Override
    public void defaultMethod(){
        System.out.println("Default");
    }

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
}
