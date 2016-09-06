package service;

import java.util.ArrayList;
import java.util.List;

public class TypeConversion {
	
	public static List<Integer> StrToInt(List<String> stringList) throws Exception {
		List<Integer> intList = new ArrayList<Integer>();
		for(int i = 0; i < stringList.size(); i++){
			try {
				if(stringList.get(i) != null && stringList.get(i).matches("[0-9]+")){
					int num = Integer.parseInt(stringList.get(i));
					intList.add(num);
				}else{
					throw new ServiceException("String to Int 包含不屬於Int字元");
				}
			} catch (Exception e) {
				throw e;
			}
		}
		return intList;
	}
}
