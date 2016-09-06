package service;

import java.lang.reflect.Method;
import java.util.List;

public class BOException extends Exception{
	private String message = null;
	
	public static void executeGetMethod(Object obj) throws Throwable {
		try {
		    Class c = Class.forName(obj.getClass().getName());
		    Method m[] = c.getDeclaredMethods();
		    Object result;
		    for (int i = 0; i < m.length; i++) {
		    	if (m[i].getName().startsWith("get")) {
		    		result = m[i].invoke(obj, null);
		    		if(result!=null && result instanceof List){
		    			for (Object tmp:(List)result) {
		    				executeGetMethod(tmp);
		    			}
				
		    		}
		    	}
		    }
		} catch (Exception e) {
		    if(e.getCause()!=null)
			throw e.getCause();
		    else
			throw e;
		}
	}

	public BOException() {
		super();
	}

	public BOException(String message) {
		super(message);
		this.message = message;
	}

	public BOException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
