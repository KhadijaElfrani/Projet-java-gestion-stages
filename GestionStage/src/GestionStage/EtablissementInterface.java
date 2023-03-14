package GestionStage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EtablissementInterface extends JFrame {
	
	private JPanel contentPane, historiquePanel;
	public JLabel quitterBtn, demandeValidationLabel;
	private JPanel deconnexionPanel;

	public EtablissementInterface() {
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
					EtablissementInterface.this.dispose();
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
					EtablissementInterface.this.dispose();
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
		
		JPanel demandeValidationPanel = new JPanel();
		demandeValidationPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				demandeValidationPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				historiquePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

			}
		});
		demandeValidationPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		demandeValidationPanel.setBackground(new Color(0, 128, 128));
		demandeValidationPanel.setBounds(0, 150, 200, 50);
		menuPanel.add(demandeValidationPanel);
		demandeValidationPanel.setLayout(null);
		
		demandeValidationLabel = new JLabel("Demandes de validation");
		demandeValidationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		demandeValidationLabel.setForeground(new Color(255, 255, 255));
		demandeValidationLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		demandeValidationLabel.setBounds(10, 10, 180, 30);
		demandeValidationPanel.add(demandeValidationLabel);
		
		historiquePanel = new JPanel();
		historiquePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				historiquePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				demandeValidationPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			}
		});
		historiquePanel.setLayout(null);
		historiquePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		historiquePanel.setBackground(new Color(0, 128, 128));
		historiquePanel.setBounds(0, 200, 200, 50);
		menuPanel.add(historiquePanel);
		
		JLabel historiqueLabel = new JLabel("Historique");
		historiqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		historiqueLabel.setForeground(Color.WHITE);
		historiqueLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		historiqueLabel.setBounds(10, 11, 180, 30);
		historiquePanel.add(historiqueLabel);
		
		JLabel bienvenueLabel = new JLabel("Bienvenue dans votre espace");
		bienvenueLabel.setForeground(new Color(255, 255, 255));
		bienvenueLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		bienvenueLabel.setBounds(210, 40, 300, 20);
		contentPane.add(bienvenueLabel);
		
		JLabel espaceLabel = new JLabel("Espace \u00C9tablissement");
		espaceLabel.setForeground(new Color(220, 20, 60));
		espaceLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		espaceLabel.setBounds(210, 16, 300, 20);
		contentPane.add(espaceLabel);
	}

}
