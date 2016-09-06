package service;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;

public class OperateImage {
	
	private String strIMDir;
	
	public OperateImage(String IMDir) {
		strIMDir = IMDir;
		ProcessStarter.setGlobalSearchPath(strIMDir);
	}
	
	public static void resize(String src, String des, Integer desWidth, Integer desHeight) throws Exception {
		// create command
		ConvertCmd cmd = new ConvertCmd();
		
		// create the operation, add images and operators/options
		IMOperation op = new IMOperation();
		op.addImage(src);
		op.resize(desWidth, desHeight);
		op.addImage(des);
		
		// execute the operation
		cmd.run(op);
	}
	
	public static void resizeGif(String src, String des, Integer desWidth, Integer desHeight, Character special) throws Exception {
		// create command
		ConvertCmd cmd = new ConvertCmd();
		
		// create the operation, add images and operators/options
		IMOperation op = new IMOperation();
		op.addImage(src);
		op.coalesce();
		
		if (desHeight == null || desHeight == 0) {
            op.resize(desWidth);
        } else {
            if (special != null) {
                op.resize(desWidth, desHeight, special);
            } else {
                op.resize(desWidth, desHeight);
            }
        }
        op.layers("optimize");
		op.addImage(des);
		// execute the operation
		cmd.run(op);
		
		
	}
	
	
}