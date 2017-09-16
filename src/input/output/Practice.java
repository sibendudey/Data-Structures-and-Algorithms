package input.output;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] in = new char[50];
		//File file = new File("demo.txt");
		Path path = Paths.get("C://Sibendu/demo.txt");
		System.out.println("getFileName:" + path.getFileName());
		System.out.println("getName(1):" + path.subpath(0,2));
		System.out.println("getPath:" + path.toString());

	}

}
