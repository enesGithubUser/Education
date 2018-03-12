package com.enes.tgb;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName("com.enes.tgb.CalledClass");
		CalledClass calledClass = (CalledClass) c.newInstance();
		
		Method m = c.getDeclaredMethod("PrintMethod", String.class);
		m.setAccessible(true);
		m.invoke(calledClass, "test");
		
		Class<?> c2 = Class.forName("com.enes.tgb.Main");
		Main main = (Main) c2.newInstance();
		
		Method m2 = c2.getDeclaredMethod("PrintMethodThisClass", String.class);
		m2.setAccessible(true);
		m2.invoke(main, "test this class");		
		
	}
	
	@SuppressWarnings("unused")
	private void PrintMethodThisClass(String name){
		System.out.println("PrintMethod printing with " + name + " ... ");
	}

}
