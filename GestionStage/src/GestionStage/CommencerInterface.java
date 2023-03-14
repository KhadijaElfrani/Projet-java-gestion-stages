package GestionStage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class CommencerInterface extends JFrame {
	private JPanel contentPane;
	LoginInterface login = new LoginInterface();
	CreerCompteInterface signup = new CreerCompteInterface();
	public static ButtonGroup G;
	public static String type;


	public CommencerInterface() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		setContentPane(contentPane);
		
		JPanel connecterPanel = new JPanel();
		connecterPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		connecterPanel.setBounds(49, 306, 120, 40);
		connecterPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CommencerInterface.this.setVisible(false);
				login.setVisible(true);
				recupererType();
			}
		});
		contentPane.setLayout(null);
		connecterPanel.setBackground(new Color(255, 51, 102));
		contentPane.add(connecterPanel);
		connecterPanel.setLayout(null);
		
		JLabel seConnecterBtn = new JLabel("Se connecter");
		seConnecterBtn.setHorizontalAlignment(SwingConstants.CENTER);
		seConnecterBtn.setBackground(new Color(255, 255, 255));
		seConnecterBtn.setForeground(new Color(255, 255, 255));
		seConnecterBtn.setFont(new Font("Arial Black", Font.PLAIN, 13));
		seConnecterBtn.setBounds(10, 11, 100, 14);
		connecterPanel.add(seConnecterBtn);
		
		JLabel quitterBtn = new JLabel("QUITTER");
		quitterBtn.setBounds(721, 11, 69, 23);
		quitterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Êtes-vous sûr de vouloir quitter ? ","confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					CommencerInterface.this.dispose();
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
		quitterBtn.setFont(new Font("Arial Black", Font.BOLD, 11));
		quitterBtn.setForeground(new Color(255, 255, 255));
		contentPane.add(quitterBtn);
		
		JLabel txtLabel = new JLabel("Vous êtes ?");
		txtLabel.setBounds(44, 88, 114, 23);
		txtLabel.setForeground(new Color(255, 255, 255));
		txtLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		contentPane.add(txtLabel);
		
		JLabel txtLabel1 = new JLabel("Bienvenue dans Gstages");
		txtLabel1.setBounds(44, 32, 266, 30);
		txtLabel1.setForeground(new Color(255, 255, 255));
		txtLabel1.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(txtLabel1);
		
		JRadioButton stagiaireRadioBtn = new JRadioButton("Stagiaire");
		stagiaireRadioBtn.setBounds(49, 141, 146, 23);
		stagiaireRadioBtn.setBackground(new Color(0, 139, 139));
		stagiaireRadioBtn.setForeground(new Color(255, 255, 255));
		stagiaireRadioBtn.setFont(new Font("Arial Black", Font.PLAIN, 14));
		stagiaireRadioBtn.setActionCommand("Stagiaire");
		contentPane.add(stagiaireRadioBtn);
		
		JRadioButton entrepriseRadioBtn = new JRadioButton("Entreprise");
		entrepriseRadioBtn.setBounds(49, 190, 146, 23);
		entrepriseRadioBtn.setForeground(Color.WHITE);
		entrepriseRadioBtn.setFont(new Font("Arial Black", Font.PLAIN, 14));
		entrepriseRadioBtn.setBackground(new Color(0, 139, 139));
		entrepriseRadioBtn.setActionCommand("Entreprise");
		contentPane.add(entrepriseRadioBtn);
		
		JRadioButton etabRadioBtn = new JRadioButton("Établissement");
		etabRadioBtn.setBounds(49, 237, 146, 23);
		etabRadioBtn.setForeground(Color.WHITE);
		etabRadioBtn.setFont(new Font("Arial Black", Font.PLAIN, 14));
		etabRadioBtn.setBackground(new Color(0, 139, 139));
		etabRadioBtn.setActionCommand("Etablissement");
		contentPane.add(etabRadioBtn);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setBounds(388, 46, 300, 300);
		bgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(bgLabel);
		bgLabel.setIcon(new ImageIcon(getClass().getResource("bg.gif")));
		
		JLabel txtLabel2 = new JLabel("Projet réalisé par : Khadija ELFRANI IATIC3 2021/2022");
		txtLabel2.setBounds(223, 363, 313, 14);
		contentPane.add(txtLabel2);
		setLocationRelativeTo(null);
		
		G = new ButtonGroup();
		G.add(etabRadioBtn);
		G.add(entrepriseRadioBtn);
		G.add(stagiaireRadioBtn);
		stagiaireRadioBtn.setSelected(true);
		
		JPanel creerComptePanel = new JPanel();
		creerComptePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		creerComptePanel.setBounds(198, 306, 120, 40);
		creerComptePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CommencerInterface.this.dispose();
				signup.setVisible(true);
				recupererType();
			}
		});
		creerComptePanel.setLayout(null);
		creerComptePanel.setBackground(new Color(255, 51, 102));
		contentPane.add(creerComptePanel);
		
		JLabel creerCompteBtn = new JLabel("Créer compte");
		creerCompteBtn.setHorizontalAlignment(SwingConstants.CENTER);
		creerCompteBtn.setForeground(Color.WHITE);
		creerCompteBtn.setFont(new Font("Arial Black", Font.PLAIN, 13));
		creerCompteBtn.setBackground(Color.WHITE);
		creerCompteBtn.setBounds(10, 11, 100, 14);
		creerComptePanel.add(creerCompteBtn);
	}
	
	public static String recupererType() {
		if(G.getSelection().getActionCommand() == "Stagiaire") {
			type = "stagiaire";
		}
		else if (G.getSelection().getActionCommand() == "Entreprise") {
			type = "entreprise";
		}
		else if (G.getSelection().getActionCommand() == "Etablissement") {
			type = "etablissement";
		}
		System.out.println(type);
		return type;
	}
}
