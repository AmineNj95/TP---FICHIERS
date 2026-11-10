import java.io.*;
public class Exercice2 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("C:/tp_fichiers/produits.txt");
		PrintWriter pw = new PrintWriter(f);
		
		pw.println("1;Ordinateur;5600.0");
		pw.println("2;Imprimante;1200.5");
		pw.println("3;Clavier;150.0");
		pw.println("4;Ecran;1800.0");
		
		pw.close();
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String s;
		int id, nbp=0;
		String produit, plusCher="";
		double prix, totalp=0, max=0;

		while((s=br.readLine()) != null) {
			String[] parties = s.split(";");
			id=Integer.parseInt(parties[0]);
			produit=parties[1];
			prix=Double.parseDouble(parties[2]);
			if(max<prix) {
				max=prix;
				plusCher=produit;
			}
			totalp+=prix;
			nbp++;
			System.out.println(id + " -- " + produit + " -- " + prix + " DH");
		}
		
		fr.close();br.close();
		
		System.out.printf("nbr produits : %d \n" , nbp); 
		System.out.println("prix total : " + totalp); 
		System.out.println("produit plus cher : " + plusCher);
		
		FileWriter fw = new FileWriter(f,true);
		fw.write("5;Souris;80.0\n");
		fw.close();
		
		FileReader fr2 = new FileReader(f);
		int nbc=0,nbl=0,x;
		while((x = fr2.read()) != -1) {
			System.out.print((char)x);
			nbc++;
			if(x == '\n') nbl++;
		}
		
		fr2.close();
		System.out.printf("nbr lignes : %d \n" , nbl); 
		System.out.printf("nbr caracteres : %d \n" , nbc); 
		
	}

}
