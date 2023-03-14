package GestionStage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OffreStage {


	public static ArrayList<String> get_offres_stage(String nom_entreprise) throws FileNotFoundException {
		// read file content to arraylist
		Scanner s = new Scanner(new File("src/GestionStage/"+nom_entreprise+"-offres.txt"));
		ArrayList<String> liste_offres = new ArrayList<String>();
		while (s.hasNextLine()){
			liste_offres.add(s.nextLine());
		}
		s.close();
		return liste_offres;
	}

	public static  List get_one_offre(String nom_entreprise, int index_start , int index_fin, ArrayList<String> offres) throws FileNotFoundException{
		List mon_offre = new ArrayList<String>();
		//offres = get_offres_stage(nom_entreprise);
		mon_offre = offres.subList(index_start, index_fin);
		
		return mon_offre;
	}
	

}
