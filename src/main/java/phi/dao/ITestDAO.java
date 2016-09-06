package phi.dao;

import java.util.ArrayList;

import phi.dao.to.Note;
import phi.dao.to.Test;

public interface ITestDAO {
	public void persistUser(Test test) throws Exception;
	public void persistUser1(Test test) throws Exception;
	public ArrayList<Note> getUserById(Test test) throws Exception;
}
