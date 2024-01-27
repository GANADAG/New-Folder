package day0117;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_03 {
	
	public static void fileWrite()
	{
		FileWriter fw=null;
		String fileName="C:\\sist0403\\file\\test1.txt";
		
		try {
			fw=new FileWriter(fileName);
			
			fw.write("Have a nice day\n");//메모장 줄넘김
			fw.write("오늘은 수요일\n");//메모장 줄넘김
			fw.write("new Date().toString");//메모장 줄넘김
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void fileWrite2()
	{
		FileWriter fw=null;
		String fileName="C:\\sist0403\\file\\test1.txt";
		
		try {
			fw=new FileWriter(fileName,true);
			
			fw.write("\n내이름은 이현주\n");
			fw.write("\n내이름은 이현주\n");
			fw.write("\n내이름은 이현주\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileWrite();
		fileWrite2();
		
	}

}
