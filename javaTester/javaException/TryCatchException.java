package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {

	public static void main(String[] args) throws IOException {
		// -
		int number = 10;
		try {
			// nếu đúng: chạy hết đoạn code trong try và ko qua catch
			// nếu sai: gặp Exception- nhảy qua catch
			number = number / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(number);

		// -
		String[] browserName = { "chrome", "Firefox", "Safari" };
		try {
             browserName[0] = "Edge chromium";
             browserName[3] = "IE";
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String browser : browserName) {
			System.out.println(browser);
		}
		FileOutputStream outputStream = null;
	try {
		outputStream = new FileOutputStream("");
		outputStream.write(65);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}finally{
		try {
			outputStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
		
		
	}
}
