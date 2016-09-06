package phi.bo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phi.dao.ITestDAO;
import phi.dao.to.Note;
import phi.dao.to.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TestBo {
	@Autowired
	private ITestDAO tagDAO; 
	
	@Transactional(value="db",rollbackFor=Exception.class)
	public void createData(String json) throws Exception {
		try {
			Test tag = new Test();
			tag.setTag_name(json);
			tag.setTag_sn(29);
			tagDAO.persistUser(tag);
			
			Test tag1 = new Test();
			tag1.setTag_name("AAAAAA");
			tag1.setTag_sn(28);
			tagDAO.persistUser1(tag1);
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional("db")
	public void getUserById() throws Exception {
		try {
			Test tag = new Test();
			tag.setTag_name("bensonAAA11111");
			tag.setTag_sn(100);
			ArrayList<Note> list = tagDAO.getUserById(tag);
			/*
			ArrayList<Note> list = tagDAO.getUserById(tag);
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(list, new TypeToken<ArrayList<Note>>() {}.getType());
			System.out.println("AAAAAAA : " +  json);
			*/
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(list);
			System.out.println(json);
			
			/*
			Gson gson = new GsonBuilder()
		    .setExclusionStrategies(new ExclusionStrategy() {
		        public boolean shouldSkipClass(Class<?> clazz) {
		            return (clazz == Note.class);
		        }
		      
		        public boolean shouldSkipField(FieldAttributes f) {
		            return false;
		        }
		     })
		   
		    .serializeNulls()
		    .create();
			//String json = gson.toJson(list);
			for(Note sl : list){
				//System.out.println("Student Name "+ sl.getContent() + ":::::" + sl.getTestList());
				//System.out.println(sl);
				
				//for(Test t1 : sl.getTestList()){
				//	System.out.println("Student Name "+ t1.getTag_name());
				//	System.out.println("note "+ t1.getNote());
				//}
				String json = gson.toJson(sl);
				System.out.println("AAAAAAA : " +  json);
			}
			*/
			
			//System.out.println(list.toString());
			/*
			for(Test test : list.getTestList()){
				System.out.println("Student Name "+ test.getTag_name());
			}
			*/
		} catch (Exception e) {
			throw e;
		}
	}
}
