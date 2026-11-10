import java.io.File;
import java.io.IOException;

public class Exercice1 {
	
	public static void main(String[] args) throws IOException {
		File f = new File("C:/tp_fichiers");
		if(!(f.exists())) {
			f.mkdir();
		}
		System.out.println(f.getAbsolutePath());
		File a = new File(f,"a.txt");
		File b = new File(f,"b.txt");
		File archives = new File(f,"archives");
		a.createNewFile();
		b.createNewFile();
		archives.mkdir();
		int nbr=0;
		int nbf=0;
		String[] list = f.list();;
		for (int i = 0; i < list.length; i++) {
		File l = new File(f, list[i]);
		if (l.isDirectory()) {
			System.out.println("REP:" + list[i]);
			nbr++;
		}
		else { 
		if (l.isFile()) { 
			System.out.println("Fichier :" + list[i] + " Size:" + l.length());
			nbf++;
		}
		else  System.out.println(f + " n'existe pas");
		}
		}
		System.out.println("nombre des repertoires : " + nbr);
		System.out.println("nombre des fichiers : " + nbf);
		
	}
}
