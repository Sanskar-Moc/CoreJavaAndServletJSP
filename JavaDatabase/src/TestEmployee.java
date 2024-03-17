
public class TestEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("Employee");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
