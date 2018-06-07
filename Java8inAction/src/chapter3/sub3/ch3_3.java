package chapter3.sub3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ch3_3 {
	public static void main(String[] args) throws IOException {
		//System.out.println(processFile());
		String oneLine = processFile((BufferedReader br) -> br.readLine());
		String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
		
		System.out.println(oneLine);
		System.out.println(twoLine);
	}
	
	public static String processFile() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
			return br.readLine();
		}catch(IOException e) {
			return e.getMessage();
		}
	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
			return p.process(br);
		}catch(IOException e) {
			return e.getMessage();
		}
	}
}


interface BufferedReaderProcessor{
	String process(BufferedReader br) throws IOException;
}