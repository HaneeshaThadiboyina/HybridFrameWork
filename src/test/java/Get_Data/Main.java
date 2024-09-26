package Get_Data;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		GetDataToSendKeys data = new GetDataToSendKeys();
			Object[] arr;
			arr = data.controllerdatabaseRead_LKA(1, "sheet1");
			for (Object object : arr) {
				System.out.println(object);
			}
			
	}

}
