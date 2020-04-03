package com.niit.jdbcPrac;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		try{
			Writer w = new FileWriter("d:/data.txt");
			String content = "Gaadi wala aaya , ghar se kachra nikaal";
			w.write(content);
			w.close();
			System.out.println("Data written");
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
