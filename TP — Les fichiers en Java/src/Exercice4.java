import java.io.*;
import java.util.*;


import java.io.*;
import java.util.*;


import java.io.*;
import java.util.*;

public class Exercice4 {

    public static void sauvegarder(ArrayList<Produit> liste, String nom) {

        try {
            FileOutputStream fos = new FileOutputStream(nom);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(liste);

            oos.close();
            fos.close();

            System.out.println(liste.size() + " produits sauvegardes");

        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        } catch (IOException e) {
            System.out.println("Erreur d'ecriture");
        }
    }

    public static ArrayList<Produit> charger(String nom) {

        ArrayList<Produit> liste = new ArrayList<Produit>();

        try {
            FileInputStream fis = new FileInputStream(nom);
            ObjectInputStream ois = new ObjectInputStream(fis);

            liste = (ArrayList<Produit>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        } catch (IOException e) {
            System.out.println("Erreur de lecture");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe introuvable");
        }

        return liste;
    }

    public static void main(String[] args) {

        File f = new File("C:/tp_fichiers/produits.txt");
        ArrayList<Produit> liste = new ArrayList<Produit>();

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String s;

            while ((s = br.readLine()) != null) {
                String[] parties = s.split(";");

                int num = Integer.parseInt(parties[0]);
                String designation = parties[1];
                float prix = Float.parseFloat(parties[2]);

                Produit p = new Produit(num, designation, prix);

                liste.add(p);
            }

            fr.close();
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        } catch (IOException e) {
            System.out.println("Erreur de lecture");
        }
        
        sauvegarder(liste, "C:/tp_fichiers/stock.dat");
        liste = charger("C:/tp_fichiers/stock.dat");
        Produit p = new Produit(6, "Webcam", 350);
        liste.add(p);
        sauvegarder(liste, "C:/tp_fichiers/stock.dat");
        liste = charger("C:/tp_fichiers/stock.dat");


        for (Produit prod : liste) {
            System.out.println(prod);
        }

    }
}
