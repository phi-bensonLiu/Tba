package phi.controller.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import phi.bo.TestBo;

@Controller
public class TestController {
	@Autowired
	private TestBo tagBo; 
	
	//@Autowired
	//private DataSourceTransactionManager transactionManager;
	/*
	@RequestMapping(value = "/insertTest1")
	@Transactional(rollbackFor=Exception.class)
	public void InsertTest1(HttpServletResponse response, HttpServletRequest request, String json) throws Exception {
		//Transaction
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    TransactionStatus status = transactionManager.getTransaction(def);
	    
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		
		Test tag = new Test();
		tag.setTag_name("benson");
		try {
			tagDAO.save(tag);
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
			throw e;
		}
	}
	*/
	@RequestMapping(value = "/insertTest2")
	public void InsertTest2(HttpServletResponse response, HttpServletRequest request, String json) throws Exception {
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		
		json = "benson";
		try {
			tagBo.createData(json);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value = "/queryTest")
	public void queryTest(HttpServletResponse response, HttpServletRequest request, String json) throws Exception {
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		
		json = "benson";
		try {
			tagBo.getUserById();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
