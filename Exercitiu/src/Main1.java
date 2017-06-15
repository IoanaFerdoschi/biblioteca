
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		Scanner s = new Scanner(System.in);
		String text = s.next();
		StringBuilder sb = new StringBuilder();
		String path = "Untitled2.txt";
		while (!("stop".equals(text.toLowerCase()))) {
			for (char c : text.toCharArray()) {
				if (!(c >= '0' && c <= '9')) {
					sb.append(c);
				}
			}
			if (sb.length() == text.length()) {
				System.out.println("Text fara cifre!");
			} else
				System.out.println("Text cu cifre!");
			System.out.println(sb);
			
			
			try (BufferedWriter buffer = new BufferedWriter(new FileWriter(path, true))) {
				
				buffer.write(LocalTime.now() + "Text dat: " +text);
				buffer.newLine();
				buffer.write(LocalTime.now() + "Text Modificat: " + sb.toString());
				buffer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sb.delete(0, sb.length());
			text = s.next();
		}

		
	}

}
