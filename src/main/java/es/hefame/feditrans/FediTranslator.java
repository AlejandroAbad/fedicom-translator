package es.hefame.feditrans;


//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.text.SimpleDateFormat;


import es.hefame.feditrans.fedicom2.F2Transmission;

public class FediTranslator {
	
	// private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyyMMddhhmmss");
	

	public static void main(String[] args) throws Exception{
		
		String tr1 = 	   "01022020092108295610101001@hefame 63510581..30101001            152673365                       00000000000                 ..304000000067332570001000010-2020000638657-D                                   06                                                  ..30500001000001000000..0199..";

		F2Transmission fedi2Transmission2 = new F2Transmission(tr1);
		System.out.println(fedi2Transmission2);
		
		// fedi2Transmission2.lanzarCobete();
		
		/*
		
		
		//File f = new File("C:\\Users\\Alejandro_AC.HEFAME\\Desktop\\palasaca.malditos.temp");
		BufferedReader buffer = new BufferedReader(new FileReader(f));
		
		//long lastSendTime = 0;
		
		String line = null;
		while( (line = buffer.readLine()) != null) {
			
			long time = DATEFORMAT.parse(line.substring(8, 22)).getTime();
			String trama = line.substring( line.indexOf("Recibido: ") + 10 );

	
			
			try {
				Thread.sleep(200);
				F2Transmission fedi2Transmission = new F2Transmission(trama);
				// fedi2Transmission.lanzarCobete();
				System.out.println(fedi2Transmission.getCabecera());
			} catch (InterruptedException ie) {
				Thread.interrupted();
			} catch (Exception ioobE) {
				System.err.println("ERROR TRAMA - " + time + " - " + trama);
				ioobE.printStackTrace();
			}
		}
		
		buffer.close();
		*/
		
		
		
		 
	}
	
	
}
