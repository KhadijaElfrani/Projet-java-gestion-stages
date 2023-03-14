package GestionStage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class StagiaireInterface extends JFrame {

	private JPanel contentPane, stageValidePanel, offresPanel, offreTitrePanel,afficherDetailsPanel;
	public JLabel quitterBtn, catalogueLabel, affichercatalogueTitre, offresValideTitre, showDetailsIcon, validationLabel;
	private JPanel deconnexionPanel, offresValidePanel, demandeValidationPanel;

	public StagiaireInterface(String nom) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		setContentPane(contentPane);
		
		quitterBtn = new JLabel("QUITTER");
		quitterBtn.setBounds(721, 11, 69, 23);
		quitterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Êtes-vous sûr de vouloir quitter ? ","confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					StagiaireInterface.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				quitterBtn.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitterBtn.setForeground(Color.WHITE);

			}
		});
		contentPane.setLayout(null);
		quitterBtn.setFont(new Font("Arial Black", Font.BOLD, 11));
		quitterBtn.setForeground(new Color(255, 255, 255));
		contentPane.add(quitterBtn);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0, 139, 139));
		menuPanel.setBorder(new LineBorder(new Color(0, 139, 139), 2, true));
		menuPanel.setBounds(0, 0, 200, 400);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setBounds(50, 15, 100, 100);
		logoLabel.setIcon(new ImageIcon(getClass().getResource("logoSmall.png")));
		menuPanel.add(logoLabel);
		
		deconnexionPanel = new JPanel();
		deconnexionPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Êtes-vous sûr de vouloir déconnecter? ","confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					StagiaireInterface.this.dispose();
					CommencerInterface accueil = new CommencerInterface();
					accueil.setVisible(true);
				}
				
			}
		});
		deconnexionPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		deconnexionPanel.setBackground(new Color(255, 51, 102));
		deconnexionPanel.setBounds(50, 350, 100, 30);
		menuPanel.add(deconnexionPanel);
		deconnexionPanel.setLayout(null);
		
		JLabel deconnexionLabel = new JLabel("D\u00E9connexion");
		deconnexionLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		deconnexionLabel.setForeground(new Color(255, 255, 255));
		deconnexionLabel.setBounds(5, 5, 90, 20);
		deconnexionPanel.add(deconnexionLabel);
		
		JPanel cataloguePanel = new JPanel();
		cataloguePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cataloguePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				stageValidePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				offresPanel.setVisible(true);
				offresValidePanel.setVisible(false);
				afficher_titres_offres();
				
			
			}
		});
		cataloguePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cataloguePanel.setBackground(new Color(0, 128, 128));
		cataloguePanel.setBounds(0, 150, 200, 50);
		menuPanel.add(cataloguePanel);
		cataloguePanel.setLayout(null);
		
		catalogueLabel = new JLabel("Catalogue Offres de stage");
		catalogueLabel.setForeground(new Color(255, 255, 255));
		catalogueLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		catalogueLabel.setBounds(10, 10, 180, 30);
		cataloguePanel.add(catalogueLabel);
		
		stageValidePanel = new JPanel();
		stageValidePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stageValidePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				cataloguePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				offresValidePanel.setVisible(true);
				offresPanel.setVisible(false);
			}
		});
		stageValidePanel.setLayout(null);
		stageValidePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		stageValidePanel.setBackground(new Color(0, 128, 128));
		stageValidePanel.setBounds(0, 200, 200, 50);
		menuPanel.add(stageValidePanel);
		
		JLabel stageValideLabel = new JLabel("Mes stages valid\u00E9es");
		stageValideLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stageValideLabel.setForeground(Color.WHITE);
		stageValideLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		stageValideLabel.setBounds(10, 11, 180, 30);
		stageValidePanel.add(stageValideLabel);
		
		JLabel bienvenueLabel = new JLabel("Bienvenue dans votre espace "+ nom);
		bienvenueLabel.setForeground(new Color(255, 255, 255));
		bienvenueLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		bienvenueLabel.setBounds(210, 40, 300, 20);
		contentPane.add(bienvenueLabel);
		
		JLabel lblEspaceStagiaire = new JLabel("Espace Stagiaire");
		lblEspaceStagiaire.setForeground(new Color(220, 20, 60));
		lblEspaceStagiaire.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblEspaceStagiaire.setBounds(210, 16, 300, 20);
		contentPane.add(lblEspaceStagiaire);
		
		//panel pour grouper les offres de stages
		
		offresPanel = new JPanel();
		offresPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		offresPanel.setBackground(new Color(0, 139, 139));
		offresPanel.setBounds(210, 70, 580, 319);
		contentPane.add(offresPanel);
		offresPanel.setLayout(null);
		offresPanel.setVisible(false);
		
		// panel pour regrouper les stages validées par une etablissement
		offresValidePanel = new JPanel();
		offresValidePanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		offresValidePanel.setBackground(new Color(0, 0, 0));
		offresValidePanel.setBounds(210, 71, 580, 318);
		contentPane.add(offresValidePanel);
		offresPanel.setLayout(null);
		offresPanel.setVisible(false);
		
		
		affichercatalogueTitre = new JLabel("Catalogue des offres");
		affichercatalogueTitre.setForeground(Color.WHITE);
		affichercatalogueTitre.setBounds(204, 7, 201, 14);
		offresPanel.add(affichercatalogueTitre);
		
		offresValideTitre = new JLabel("Mes offres validés");
		offresValideTitre.setForeground(Color.WHITE);
		offresValideTitre.setBounds(204, 7, 201, 14);
		offresValidePanel.add(offresValideTitre);
		
		//panel pour afficher les details de l'offre
		afficherDetailsPanel = new JPanel();
		afficherDetailsPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		afficherDetailsPanel.setBackground(new Color(0, 0, 0));
		afficherDetailsPanel.setBounds(210, 71, 580, 318);
		afficherDetailsPanel.setVisible(false);
		contentPane.add(afficherDetailsPanel);
		
		//validation bouton
		demandeValidationPanel = new JPanel();
		demandeValidationPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Demande Envoyé !");
				
			}
		});
		afficherDetailsPanel.setLayout(null);
		demandeValidationPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		demandeValidationPanel.setBackground(new Color(255, 51, 102));
		demandeValidationPanel.setBounds(130, 270, 280, 30);
		afficherDetailsPanel.add(demandeValidationPanel);
		demandeValidationPanel.setLayout(null);
		
		
		validationLabel = new JLabel("Demander validation pour ce stage");
		validationLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		validationLabel.setForeground(new Color(255, 255, 255));
		validationLabel.setBounds(5, 5, 280, 20);
		demandeValidationPanel.add(validationLabel);
		
	}
	
	public void afficher_titres_offres() {
		String ligne;
		int espace =0;
		try {
			FileReader lireTitres = new FileReader("src/GestionStage/entreprise-titres.txt");
			BufferedReader bufReadTitres = new BufferedReader(lireTitres);
			while((ligne = bufReadTitres.readLine()) != null) {
				offreTitrePanel = new JPanel();
				offreTitrePanel.setBackground(new Color(255, 255, 255));
				offreTitrePanel.setBounds(10, 40+espace, 560, 30);
				offresPanel.add(offreTitrePanel);
				offreTitrePanel.setLayout(null);
				
				showDetailsIcon = new JLabel("");
				showDetailsIcon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
							afficherDetailsPanel.setVisible(true);
							offresPanel.setVisible(false);
							afficher_infos_offre() ;
					}
				});
				showDetailsIcon.setBounds(520, 0, 30, 30);
				showDetailsIcon.setIcon(new ImageIcon(getClass().getResource("showIcone.png")));
				offreTitrePanel.add(showDetailsIcon);
				
				JLabel offreTitreLabel = new JLabel(ligne);
				offreTitreLabel.setBounds(0, 0, 510, 30);
				offreTitrePanel.add(offreTitreLabel);
				espace+=40;
			}
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public void afficher_infos_offre() {
		int y=0;
		String ligne;
		FileReader lireNoms;
		ArrayList<String> infos = new ArrayList<String>();
		try {
			lireNoms = new FileReader("src/GestionStage/entreprise-noms.txt");
		BufferedReader bufReadNoms = new BufferedReader(lireNoms);
		while((ligne = bufReadNoms.readLine()) != null) {
			infos = OffreStage.get_offres_stage(ligne);
			try {
				List<String> mon_offre = OffreStage.get_one_offre(ligne, 0, 8, infos);
				
				 for(String info : mon_offre) {
					 	JLabel infoLabel = new JLabel(info);
					 	infoLabel.setBounds(10, 40+y, 510, 30);
					 	infoLabel.setForeground(Color.WHITE);
					 	afficherDetailsPanel.add(infoLabel);
			            y+=20;
			        }
			} catch (FileNotFoundException e1) {
				
			}
			
		}
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void envoyer_demande_validation(String nom_stagiaire , String titre) throws IOException {
		FileWriter ecrireDemande = new FileWriter("src/GestionStage/demandes.txt", true);
		BufferedWriter bufDemande = new BufferedWriter(ecrireDemande);
		bufDemande.append(nom_stagiaire + " -- " + titre + "\r\n");
		bufDemande.close();
		
	}
}
