import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		
		List<String> names = Arrays.asList("Jhon", "Pat", "Nathan", "Julie");
		for(String name:names) {
			if(name.startsWith("J")) {
				System.out.println(name);
			}
	
	}
	}

}
