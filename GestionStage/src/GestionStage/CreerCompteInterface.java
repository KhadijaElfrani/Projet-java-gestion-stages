package GestionStage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class CreerCompteInterface extends JFrame {

	private JPanel contentPane;
	private JTextField nomTxt;
	public JLabel creerMessageLabel;

	public CreerCompteInterface() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setBackground(new Color(255, 255, 255));
		emailPanel.setBounds(247, 229, 300, 40);
		contentPane.add(emailPanel);
		emailPanel.setLayout(null);
		
		JTextField emailTxt = new JTextField();
		emailTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(emailTxt.getText().equals("Email")) {
					emailTxt.setText("");
				}
				else {
					emailTxt.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(emailTxt.getText().equals("")) {
					emailTxt.setText("Email");
				}
			}
		});
		emailTxt.setBorder(null);
		emailTxt.setForeground(new Color(0, 0, 0));
		emailTxt.setFont(new Font("Arial Black", Font.PLAIN, 11));
		emailTxt.setText("Email");
		emailTxt.setBounds(10, 5, 230, 30);
		emailPanel.add(emailTxt);
		emailTxt.setColumns(10);
		
		JLabel emailIcone = new JLabel("");
		emailIcone.setHorizontalAlignment(SwingConstants.CENTER);
		emailIcone.setBounds(254, 5, 36, 30);
		emailPanel.add(emailIcone);
		emailIcone.setIcon(new ImageIcon(getClass().getResource("emailIcone.png")));
		
		JPanel mdsPanel = new JPanel();
		mdsPanel.setBackground(Color.WHITE);
		mdsPanel.setBounds(247, 285, 300, 40);
		contentPane.add(mdsPanel);
		mdsPanel.setLayout(null);
		
		JPasswordField motdepassTxt = new JPasswordField();
		motdepassTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(motdepassTxt.getText().equals("Mot de passe")) {
					motdepassTxt.setEchoChar('●');
					motdepassTxt.setText("");
				}
				else {
					motdepassTxt.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(motdepassTxt.getText().equals("")) {
					motdepassTxt.setText("Mot de passe");
					motdepassTxt.setEchoChar((char)0);

				}
			}
		});
		motdepassTxt.setForeground(new Color(0, 0, 0));
		motdepassTxt.setFont(new Font("Arial Black", Font.PLAIN, 11));
		motdepassTxt.setBorder(null);
		motdepassTxt.setEchoChar((char)0);
		motdepassTxt.setText("Mot de passe");
		motdepassTxt.setBounds(10, 5, 230, 30);
		mdsPanel.add(motdepassTxt);
		
		JLabel mdpIcone = new JLabel("");
		mdpIcone.setHorizontalAlignment(SwingConstants.CENTER);
		mdpIcone.setBounds(254, 5, 36, 30);
		mdsPanel.add(mdpIcone);
		mdpIcone.setIcon(new ImageIcon(getClass().getResource("mdpIcone.png")));
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		loginPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nomTxt.getText().equals("") ||nomTxt.getText().equals("Nom et prénom") || emailTxt.getText().equals("") || 
						emailTxt.getText().equals("Email") || motdepassTxt.getText().equals("") || motdepassTxt.getText().equals("Mot de passe")) {
							creerMessageLabel.setText("* Veuillez Remplir tous les champs");
				}
				else {
					String type = CommencerInterface.recupererType();
					Personne.SignupUtilisateur(type, nomTxt, emailTxt, motdepassTxt);
					if(JOptionPane.showConfirmDialog(null,"Votre compte a bien été crée. Connecter-vous pour continuer ","confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					CreerCompteInterface.this.dispose();
					LoginInterface log = new LoginInterface();
					log.setVisible(true);
					}
					
				}
			}
			
		});
		loginPanel.setBackground(new Color(255, 51, 102));
		loginPanel.setBounds(339, 336, 120, 40);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel creerCompteLabel = new JLabel("Créer Compte");
		creerCompteLabel.setBackground(new Color(255, 255, 255));
		creerCompteLabel.setForeground(new Color(255, 255, 255));
		creerCompteLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		creerCompteLabel.setBounds(10, 11, 100, 14);
		loginPanel.add(creerCompteLabel);
		
		JLabel quitterBtn = new JLabel("QUITTER");
		quitterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Êtes-vous sûr de vouloir quitter ? ","confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					CreerCompteInterface.this.dispose();
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
		quitterBtn.setBounds(721, 11, 69, 23);
		contentPane.add(quitterBtn);
		
		JLabel logoImg = new JLabel("");
		logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		logoImg.setBounds(320, 10, 170, 152);
		contentPane.add(logoImg);
		logoImg.setIcon(new ImageIcon(getClass().getResource("logo.png")));
		
		JLabel accueilBtn = new JLabel("ACCUEIL");
		accueilBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreerCompteInterface.this.dispose();
				CommencerInterface back = new CommencerInterface();
				back.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				accueilBtn.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				accueilBtn.setForeground(Color.WHITE);
			}
		});
		accueilBtn.setForeground(Color.WHITE);
		accueilBtn.setFont(new Font("Arial Black", Font.BOLD, 11));
		accueilBtn.setBounds(15, 11, 69, 23);
		contentPane.add(accueilBtn);
		
		JPanel nomPanel = new JPanel();
		nomPanel.setLayout(null);
		nomPanel.setBackground(Color.WHITE);
		nomPanel.setBounds(247, 173, 300, 40);
		contentPane.add(nomPanel);
		
		nomTxt = new JTextField();
		nomTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(nomTxt.getText().equals("Nom")) {
					nomTxt.setText("");
				}
				else {
					nomTxt.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(nomTxt.getText().equals("")) {
					nomTxt.setText("Nom");
				}
			}
		});
		nomTxt.setText("Nom");
		nomTxt.setForeground(Color.BLACK);
		nomTxt.setFont(new Font("Arial Black", Font.PLAIN, 11));
		nomTxt.setColumns(10);
		nomTxt.setBorder(null);
		nomTxt.setBounds(10, 5, 230, 30);
		nomPanel.add(nomTxt);
		
		JLabel nomIcone = new JLabel("");
		nomIcone.setHorizontalAlignment(SwingConstants.CENTER);
		nomIcone.setBounds(254, 5, 36, 30);
		nomPanel.add(nomIcone);
		nomIcone.setIcon(new ImageIcon(getClass().getResource("nom.png")));
		
		creerMessageLabel = new JLabel("");
		creerMessageLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		creerMessageLabel.setForeground(Color.WHITE);
		creerMessageLabel.setBounds(15, 69, 250, 15);
		contentPane.add(creerMessageLabel);
	}
}
