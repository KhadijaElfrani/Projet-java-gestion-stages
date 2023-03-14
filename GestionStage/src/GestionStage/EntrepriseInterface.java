package GestionStage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JTextArea;

public class EntrepriseInterface extends JFrame {
	
	private JPanel contentPane, historiquePanel, menuPanel, offreTitrePanel;
	public JLabel quitterBtn, poserOffreLabel, logoLabel, deconnexionLabel, historiqueLabel, bienvenueLabel, espaceLabel, saveOffreLabel, descriptionLabel;
	JLabel dateFinLabel, dateDebutLabel, eurosLabel, montantLabel, lieuLabel, titreOffreLabel, sujetLabel, ajouterOffreLabel;
	private JPanel deconnexionPanel, poserOffrePanel;
	private JPanel ajouterOffreFormPanel, saveOffrePanel, afficherDetailsPanel;
	private JTextField titreOffreTxt;
	private JTextField sujetTxt;
	private JTextField lieuTxt;
	private JTextField montantTxt;
	private JTextField dateDebutTxt;
	private JTextField dateFinTxt;
	private JTextArea descriptionTxt;
	private JPanel afficherHistoriquePanel, retourHistoriquePanel;
	private JLabel afficherHistoriqueLabel, showDetailsIcon, retourBtnLabel;
	private JLabel offreTitreLabel, afficherDetailsLabel;
	//ArrayList<String> offres;


	public EntrepriseInterface(String nom) {
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
					EntrepriseInterface.this.dispose();
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
		
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0, 139, 139));
		menuPanel.setBorder(new LineBorder(new Color(0, 139, 139), 2, true));
		menuPanel.setBounds(0, 0, 200, 400);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		logoLabel = new JLabel("");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setBounds(63, 11, 100, 100);
		logoLabel.setIcon(new ImageIcon(getClass().getResource("logoSmall.png")));
		menuPanel.add(logoLabel);
		
		deconnexionPanel = new JPanel();
		deconnexionPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Êtes-vous sûr de vouloir déconnecter? ","confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					EntrepriseInterface.this.dispose();
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
		
		deconnexionLabel = new JLabel("D\u00E9connexion");
		deconnexionLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		deconnexionLabel.setForeground(new Color(255, 255, 255));
		deconnexionLabel.setBounds(5, 5, 90, 20);
		deconnexionPanel.add(deconnexionLabel);
		
		poserOffrePanel = new JPanel();
		poserOffrePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				poserOffrePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				historiquePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				ajouterOffreFormPanel.setVisible(true);
				afficherHistoriquePanel.setVisible(false);
			}
		});
		poserOffrePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		poserOffrePanel.setBackground(new Color(0, 128, 128));
		poserOffrePanel.setBounds(0, 150, 200, 50);
		menuPanel.add(poserOffrePanel);
		poserOffrePanel.setLayout(null);
		
		poserOffreLabel = new JLabel("Poser une Offre de stage");
		poserOffreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		poserOffreLabel.setForeground(new Color(255, 255, 255));
		poserOffreLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		poserOffreLabel.setBounds(10, 10, 180, 30);
		poserOffrePanel.add(poserOffreLabel);
		
		historiquePanel = new JPanel();
		historiquePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				historiquePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				poserOffrePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				ajouterOffreFormPanel.setVisible(false);
				afficherHistoriquePanel.setVisible(true);
				afficher_titre_offre(40,nom);
			}
		});
		historiquePanel.setLayout(null);
		historiquePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		historiquePanel.setBackground(new Color(0, 128, 128));
		historiquePanel.setBounds(0, 200, 200, 50);
		menuPanel.add(historiquePanel);
		
		historiqueLabel = new JLabel("Historique");
		historiqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		historiqueLabel.setForeground(Color.WHITE);
		historiqueLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		historiqueLabel.setBounds(10, 11, 180, 30);
		historiquePanel.add(historiqueLabel);
		
		bienvenueLabel = new JLabel("Bienvenue dans votre espace "+ nom);
		bienvenueLabel.setForeground(new Color(255, 255, 255));
		bienvenueLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		bienvenueLabel.setBounds(210, 40, 300, 20);
		contentPane.add(bienvenueLabel);
		
		espaceLabel = new JLabel("Espace Entreprise");
		espaceLabel.setForeground(new Color(220, 20, 60));
		espaceLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		espaceLabel.setBounds(210, 16, 300, 20);
		contentPane.add(espaceLabel);
		
		ajouterOffreFormPanel = new JPanel();
		ajouterOffreFormPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		ajouterOffreFormPanel.setBackground(new Color(32, 178, 170));
		ajouterOffreFormPanel.setBounds(210, 71, 580, 318);
		contentPane.add(ajouterOffreFormPanel);
		ajouterOffreFormPanel.setLayout(null);
		ajouterOffreFormPanel.setVisible(false);
		
		ajouterOffreLabel = new JLabel("Ajouter une nouvelle offre de stage");
		ajouterOffreLabel.setBounds(204, 7, 201, 14);
		ajouterOffreLabel.setForeground(new Color(255, 255, 255));
		ajouterOffreFormPanel.add(ajouterOffreLabel);
		
		titreOffreLabel = new JLabel("Titre de l'offre :");
		titreOffreLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		titreOffreLabel.setForeground(new Color(255, 255, 255));
		titreOffreLabel.setBounds(10, 36, 111, 14);
		ajouterOffreFormPanel.add(titreOffreLabel);
		
		titreOffreTxt = new JTextField();
		titreOffreTxt.setBounds(97, 33, 172, 20);
		ajouterOffreFormPanel.add(titreOffreTxt);
		titreOffreTxt.setColumns(10);
		
		sujetLabel = new JLabel("Sujet du stage");
		sujetLabel.setForeground(Color.WHITE);
		sujetLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		sujetLabel.setBounds(10, 72, 111, 14);
		ajouterOffreFormPanel.add(sujetLabel);
		
		sujetTxt = new JTextField();
		sujetTxt.setColumns(10);
		sujetTxt.setBounds(97, 69, 172, 20);
		ajouterOffreFormPanel.add(sujetTxt);
		
		lieuLabel = new JLabel("Lieu :");
		lieuLabel.setForeground(Color.WHITE);
		lieuLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lieuLabel.setBounds(10, 106, 111, 14);
		ajouterOffreFormPanel.add(lieuLabel);
		
		lieuTxt = new JTextField();
		lieuTxt.setColumns(10);
		lieuTxt.setBounds(97, 103, 172, 20);
		ajouterOffreFormPanel.add(lieuTxt);
		
		montantLabel = new JLabel("Montant :");
		montantLabel.setForeground(Color.WHITE);
		montantLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		montantLabel.setBounds(10, 144, 111, 14);
		ajouterOffreFormPanel.add(montantLabel);
		
		montantTxt = new JTextField();
		montantTxt.setColumns(10);
		montantTxt.setBounds(97, 141, 172, 20);
		ajouterOffreFormPanel.add(montantTxt);
		
		eurosLabel = new JLabel("euros");
		eurosLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		eurosLabel.setForeground(new Color(255, 255, 255));
		eurosLabel.setName("eurosLabel");
		eurosLabel.setBounds(279, 144, 46, 14);
		ajouterOffreFormPanel.add(eurosLabel);
		
		dateDebutLabel = new JLabel("Date D\u00E9but :");
		dateDebutLabel.setForeground(Color.WHITE);
		dateDebutLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		dateDebutLabel.setBounds(10, 184, 111, 14);
		ajouterOffreFormPanel.add(dateDebutLabel);
		
		dateDebutTxt = new JTextField();
		dateDebutTxt.setColumns(10);
		dateDebutTxt.setBounds(97, 181, 172, 20);
		ajouterOffreFormPanel.add(dateDebutTxt);
		
		dateFinLabel = new JLabel("Date Fin :");
		dateFinLabel.setForeground(Color.WHITE);
		dateFinLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		dateFinLabel.setBounds(294, 184, 111, 14);
		ajouterOffreFormPanel.add(dateFinLabel);
		
		dateFinTxt = new JTextField();
		dateFinTxt.setColumns(10);
		dateFinTxt.setBounds(359, 181, 172, 20);
		ajouterOffreFormPanel.add(dateFinTxt);
		
		descriptionLabel = new JLabel("Description :");
		descriptionLabel.setForeground(Color.WHITE);
		descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		descriptionLabel.setBounds(10, 219, 111, 14);
		ajouterOffreFormPanel.add(descriptionLabel);
		
		saveOffrePanel = new JPanel();
		saveOffrePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ajouter_offre_stage(nom, titreOffreTxt, sujetTxt, lieuTxt, montantTxt, dateDebutTxt, dateFinTxt, descriptionTxt);
				JOptionPane.showMessageDialog(null, "Offre enregistrée !");
			}
		});
		saveOffrePanel.setLayout(null);
		saveOffrePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		saveOffrePanel.setBackground(new Color(0, 128, 128));
		saveOffrePanel.setBounds(460, 280, 100, 30);
		ajouterOffreFormPanel.add(saveOffrePanel);
		
		saveOffreLabel = new JLabel("Enregistrer");
		saveOffreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveOffreLabel.setForeground(Color.WHITE);
		saveOffreLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		saveOffreLabel.setBounds(5, 5, 90, 20);
		saveOffrePanel.add(saveOffreLabel);
		
		descriptionTxt = new JTextArea();
		descriptionTxt.setBounds(97, 209, 434, 60);
		ajouterOffreFormPanel.add(descriptionTxt);
		
	
		afficherHistoriquePanel = new JPanel();
		afficherHistoriquePanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		afficherHistoriquePanel.setBackground(new Color(0, 139, 139));
		afficherHistoriquePanel.setBounds(210, 70, 580, 319);
		contentPane.add(afficherHistoriquePanel);
		afficherHistoriquePanel.setLayout(null);
		afficherHistoriquePanel.setVisible(false);
		
		afficherHistoriqueLabel = new JLabel("Historique des offres");
		afficherHistoriqueLabel.setForeground(Color.WHITE);
		afficherHistoriqueLabel.setBounds(204, 7, 201, 14);
		afficherHistoriquePanel.add(afficherHistoriqueLabel);
		
		
		afficherDetailsPanel = new JPanel();
		afficherDetailsPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		afficherDetailsPanel.setBackground(new Color(0, 0, 0));
		afficherDetailsPanel.setBounds(210, 70, 580, 319);
		contentPane.add(afficherDetailsPanel);
		afficherDetailsPanel.setLayout(null);
		afficherDetailsPanel.setVisible(false);
		
		afficherDetailsLabel = new JLabel("Détails de l'offre");
		afficherDetailsLabel.setForeground(Color.WHITE);
		afficherDetailsLabel.setBounds(204, 7, 201, 14);
		afficherDetailsPanel.add(afficherDetailsLabel);
		
		retourHistoriquePanel = new JPanel();
		retourHistoriquePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// revenir à l'historique en cliquant sur retour
				afficherDetailsPanel.setVisible(false);
				afficherHistoriquePanel.setVisible(true);
				
			}
		});
		retourHistoriquePanel.setLayout(null);
		retourHistoriquePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		retourHistoriquePanel.setBackground(new Color(0, 128, 128));
		retourHistoriquePanel.setBounds(10, 7, 70, 30);
		afficherDetailsPanel.add(retourHistoriquePanel);
		
		retourBtnLabel = new JLabel("Retour");
		retourBtnLabel.setForeground(Color.WHITE);
		retourBtnLabel.setBounds(7, 0, 70, 30);
		retourHistoriquePanel.add(retourBtnLabel);
		
		
		
	}
	
	public void afficher_titre_offre(int y , String nom_entreprise) {
		final ArrayList<String> offres;
		int i;
		
		try {
			offres = OffreStage.get_offres_stage(nom_entreprise);
			// affiche que le titre de chaque offre
			
			int espace=0;
			for(i = 1 ; i<=offres.size() ; i+=8)
			{
				String titre = offres.get(i);
				offreTitrePanel = new JPanel();
				offreTitrePanel.setBackground(new Color(255, 255, 255));
				offreTitrePanel.setBounds(10, y+espace, 560, 30);
				afficherHistoriquePanel.add(offreTitrePanel);
				offreTitrePanel.setLayout(null);
				
				showDetailsIcon = new JLabel("");
				showDetailsIcon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						afficherDetailsPanel.setVisible(true);
						afficherHistoriquePanel.setVisible(false);
						
						try {
							int y=0;
							List<String> mon_offre = OffreStage.get_one_offre(nom_entreprise, 0, 8, offres);
							
							 for(String info : mon_offre) {
								 	JLabel infoLabel = new JLabel(info);
								 	infoLabel.setBounds(10, 40+y, 510, 30);
								 	infoLabel.setForeground(Color.WHITE);
								 	afficherDetailsPanel.add(infoLabel);
						            //System.out.println(info);
						            y+=20;
						        }
						} catch (FileNotFoundException e1) {
							
						}
						
					}
				});
				showDetailsIcon.setBounds(520, 0, 30, 30);
				showDetailsIcon.setIcon(new ImageIcon(getClass().getResource("showIcone.png")));
				offreTitrePanel.add(showDetailsIcon);
				
				offreTitreLabel = new JLabel(offres.get(i));
				offreTitreLabel.setBounds(0, 0, 510, 30);
				offreTitrePanel.add(offreTitreLabel);
				espace+=40;
				System.out.println(offres.get(i));
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void ajouter_offre_stage(String nom_entreprise, JTextField titre, JTextField sujet, JTextField lieu, JTextField montant, JTextField date_d , JTextField date_f , JTextArea description ) {
		try {
			// enregistrer les offres de chaque entreprise séparément
			FileWriter ecrireOffre = new FileWriter("src/GestionStage/"+nom_entreprise+"-offres.txt", true);
			BufferedWriter bufWrite = new BufferedWriter(ecrireOffre);
			bufWrite.append(nom_entreprise + "\r\n" + titre.getText() + "\r\n" + sujet.getText() + "\r\n" + lieu.getText() + "\r\n" + montant.getText() + "\r\n" + date_d.getText() + "\r\n" + date_f.getText() + "\r\n" + description.getText() + "\r\n");
			bufWrite.close();
			
			FileWriter ecrireTitre = new FileWriter("src/GestionStage/entreprise-titres.txt", true);
			BufferedWriter bufTitre = new BufferedWriter(ecrireTitre);
			bufTitre.append(titre.getText() + "\r\n");
			bufTitre.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
}
