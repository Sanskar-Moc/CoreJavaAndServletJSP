package com.wileyEdge.reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{
	String info() default "";
}

class Annotated{
	@Test(info="AWESOME")
	public void foo(String myParam) {
        System.out.println("Inside foo " + myParam);
    }
//	@Test(info="AWESOME")
	public void zoo(String myParam) {
    	System.out.println("Inside zoo " + myParam);
    }
}

class TestAnnotationParser{
	public void parse(Class cls)throws Exception {
		Method[]methods=cls.getMethods();
		for(Method method:methods) {
			if (method.isAnnotationPresent(Test.class)) {
				Test test=method.getAnnotation(Test.class);
				String info=test.info();
				if ("AWESOME".equals(info)) {
					method.invoke(Annotated.class.newInstance(),"COOL");
				}
			}
		}
	}
}

public class AnnotationDemo  {
	public static void main(String[] args) throws Exception {
		TestAnnotationParser parser=new TestAnnotationParser();
		parser.parse(Annotated.class);
	}
}
