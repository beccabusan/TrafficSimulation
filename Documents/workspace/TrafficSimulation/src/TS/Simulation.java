package TS;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;



public class Simulation{

	/*
    public static void openFile() throws IOException {
FileInputStream inputstream = new FileInputStream("input.properties");
	Properties prop = new Properties();
	prop.load(inputstream);
	String Ankomst = prop.getProperty("ankomst");
	Double ankomst = Double.parseDouble(Ankomst);
	String Period = prop.getProperty("period");
	int period = Integer.parseInt(Period);
	String Green1 = prop.getProperty("green1");
	int green1 = Integer.parseInt(Green1);
	String Green2 = prop.getProperty("green2");
	int green2 = Integer.parseInt(Green2);
	String R0 = prop.getProperty("r0_");
	int r0_ = Integer.parseInt(R0);
	String R1 = prop.getProperty("r1_");
	int r1_ = Integer.parseInt(R1);
	inputstream.close();
 }*/

	public static void main(String [] args){
		Properties prop = new Properties();

		try {	

			FileInputStream inputstream = new FileInputStream(args[0]);

			prop.load(inputstream);
			String Ankomst = prop.getProperty("ankomst");
			/*    byte[] b = Ankomst.getBytes("US-ASCII");
	    for(int i = 0; i<b.length; i++){
	    	if (b[i] < 58 && b[i] > 49){ */
			Double ankomst = Double.parseDouble(Ankomst);
			String Period = prop.getProperty("period");
			int period = Integer.parseInt(Period);
			String Green1 = prop.getProperty("green1");
			int green1 = Integer.parseInt(Green1);
			String Green2 = prop.getProperty("green2");
			int green2 = Integer.parseInt(Green2);
			String R0 = prop.getProperty("r0_");
			int r0_ = Integer.parseInt(R0);
			String R1 = prop.getProperty("r1_");
			int r1_ = Integer.parseInt(R1);
			inputstream.close();

			System.out.println("Ankomstintensitet(bilar/sek): " + ankomst);
			System.out.println("Period: " + period);
			System.out.println("Grönperiod rakt fram: " + green1);
			System.out.println("Grönperiod sväng: " + green2);
			System.out.println("Väglängd: " + r0_);
			System.out.println("Svängfilens längd: " + r1_ + "\n");

			Lane r0 = new Lane(r0_);
			Lane r1 = new Lane(r1_);
			Lane r2 = new Lane(r1_);
			Light s1 = new Light(period, green1);
			Light s2 = new Light(period, green2);

			TrafficSystem newsystem = new TrafficSystem(r0, r1, r2, s1, s2, ankomst);



			for(int i = 0; i < period; i++){
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}

				newsystem.step();
				newsystem.print();
			}
			newsystem.printStatistics();

		}
		catch(IOException e){
			System.out.println("File not found");
			System.exit(0);


		}
		catch(NumberFormatException e){
			System.out.println("Wrong input in property file");
			System.exit(0);


		}
	}        
}
