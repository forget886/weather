package sync;

import java.io.File;

import org.junit.Test;

public class FileTest {

	@Test
	public void getFile(){
		File file = new File("/data/appdatas/cat/server.xml");
		
		System.out.println(file.exists());
	}
}
