import java.io.*;

public class Exercice3 {

	public static void copierAvecNumeros(String source, String dest) throws IOException {
		
		FileReader fr = new FileReader(source);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(dest);
		BufferedWriter bw = new BufferedWriter(fw);
		String s;
		int id=0;
		while((s = br.readLine()) != null) {
			bw.write(++id + ": " + s);
			bw.newLine();
		}
		bw.close();fw.close();br.close();fr.close();
		
	}
	
	public static long copierBinaire(String source, String dest) throws IOException {
		
		InputStream is = new FileInputStream(source);
		InputStreamReader isr = new InputStreamReader(is);
		OutputStream os = new FileOutputStream(dest);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		long oct=0;
		int c;
		while((c=isr.read()) != -1) {
			osw.write(c);
			oct++;
		}
		osw.close();os.close();isr.close();is.close();
		return oct;
		
	}


	public static void main(String[] args) throws IOException {
		
		copierAvecNumeros("C:/tp_fichiers/produits.txt", "C:/tp_fichiers/produits_num.txt");
		long oct = copierBinaire("C:/tp_fichiers/produits.txt", "C:/tp_fichiers/archives/produits_copie.txt");
		System.out.println("nbr octets : " + oct);
		
		

	}

}
