package GestionStage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Personne {
	public static String nom;
	public String email;
	
	
	public static void SignupUtilisateur(String type ,JTextField nom, JTextField email, JPasswordField motdepass) {
		try {
			FileWriter ecrireInfo = new FileWriter("src/GestionStage/" + type + "s.txt", true);
			BufferedWriter bufWrite = new BufferedWriter(ecrireInfo);
			bufWrite.append(nom.getText() + " - " + email.getText() + " - " + motdepass.getText()+"\r\n");
			bufWrite.close();
			if(type == "entreprise") {
				File file = new File("src\\GestionStage\\"+nom.getText() + "-offres.txt");
				file.createNewFile();
				
				FileWriter ecrireNom = new FileWriter("src/GestionStage/entreprise-noms.txt", true);
				BufferedWriter bufNom = new BufferedWriter(ecrireNom);
				bufNom.append(nom.getText() + "\r\n");
				bufNom.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static boolean loginUtilisateur(String type , JTextField email, JPasswordField motdepass) {
		boolean trouve = false;
		
		try {
			FileReader lireInfo = new FileReader("src/GestionStage/" + type + "s.txt");
			BufferedReader bufRead = new BufferedReader(lireInfo);
			String ligne;
			String infoSaisi = email.getText() + " - " + motdepass.getText();
			while((ligne = bufRead.readLine()) != null) {
				if(ligne.indexOf(infoSaisi) == -1) {
					trouve = false;
				}
				else {
					trouve = true;
					String infos[] = ligne.split(" - ");
					nom = infos[0];
					System.out.println(nom + " connecté");
					if(type == "stagiaire") {
						StagiaireInterface espaceStagiaire = new StagiaireInterface(nom);
						espaceStagiaire.setVisible(true);
						
					}
					else if (type == "etablissement") {
						EtablissementInterface espaceEtab = new EtablissementInterface();
						espaceEtab.setVisible(true);
					}
					else if (type == "entreprise") {
						EntrepriseInterface espaceEntreprise = new EntrepriseInterface(nom);
						espaceEntreprise.setVisible(true);
					}
				}
			}
			if (trouve == false) {
				System.out.println(type + "Introuvable");
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return trouve;
			
	}

}
