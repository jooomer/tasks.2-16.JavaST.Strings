/**
 * 
 */
package mvc.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Sergey
 *
 */
public class ReadWriteFile {
	
	public String readFile() {
		
		String text = "";
		String filePath = "";
		String fileName = "src/Text.txt";

		File file = new File(filePath + fileName);
		
		if (!file.exists()) {
			System.out.println("ERROR! File's not found.");
			System.exit(0);
		}
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				text += line + "\n";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return text;
	}
	
	


}
