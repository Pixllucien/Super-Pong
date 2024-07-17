package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import game.GameLogic;
import javax.swing.JCheckBox;


public class GUIMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GameLogic objGameLogic;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain frameMain = new GUIMain(new GameLogic());
					frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public GUIMain(GameLogic gameLogic) {
		this.objGameLogic = gameLogic;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUeberschrift = new JLabel("PONG");
		lblUeberschrift.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblUeberschrift.setHorizontalAlignment(SwingConstants.CENTER);
		lblUeberschrift.setForeground(Color.WHITE);
		lblUeberschrift.setBounds(6, 26, 438, 57);
		contentPane.add(lblUeberschrift);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        
				if (objGameLogic.multiplayer == true) {
					System.out.println("Spielmodus: Multiplayer");
				} else {
					System.out.println("Spielmodus: Singleplayer");
				}
				System.out.println("Ausgewählte Schwierigkeit: " + objGameLogic.getSchwierigkeit());

				// Initiierung GameLogic and Gui
				GameLogic spiellogik = new GameLogic();
				Runnable onCloseAction = () -> {
					new GUIZwischenMenue(spiellogik); // Öffnet das neue Fenster
				};
//				new Gui(spiellogik);
				Gui gui = new Gui(spiellogik);
				dispose(); // Close the current window	
				
				
				
			}
		});
		btnStart.setBackground(Color.WHITE);
		btnStart.setForeground(Color.BLACK);
		btnStart.setBounds(175, 95, 117, 29);
		contentPane.add(btnStart);

		JButton btnEinstellungen = new JButton("Einstellungen");
		btnEinstellungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIEinstellungen guiEinstellungen = new GUIEinstellungen(gameLogic);
				guiEinstellungen.setVisible(true);
				dispose(); // Close the current window
			}
		});
		btnEinstellungen.setForeground(Color.BLACK);
		btnEinstellungen.setBackground(Color.WHITE);
		btnEinstellungen.setBounds(175, 137, 117, 29);
		contentPane.add(btnEinstellungen);

		JButton btnVerlassen = new JButton("Verlassen");
		btnVerlassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnVerlassen.setForeground(Color.BLACK);
		btnVerlassen.setBackground(Color.WHITE);
		btnVerlassen.setBounds(175, 178, 117, 29);
		contentPane.add(btnVerlassen);
	}


	//GUI Einstellungen

	private class GUIEinstellungen extends JFrame {
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JRadioButton rdbtnEinzelspieler;
		private JRadioButton rdbtnMehrspieler;
		private GameLogic objGameLogic; // Deklaration des GameLogic-Objekts
		private JSlider sliderSchwierigkeit;

		public GUIEinstellungen(GameLogic gameLogic) {
			this.objGameLogic = gameLogic; // Initialisierung des GameLogic-Objekts

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblUeberschrift = new JLabel("Einstellungen");
			lblUeberschrift.setFont(new Font("Monospaced", Font.PLAIN, 20));
			lblUeberschrift.setHorizontalAlignment(SwingConstants.CENTER);
			lblUeberschrift.setForeground(Color.WHITE);
			lblUeberschrift.setBounds(6, 26, 438, 57);
			contentPane.add(lblUeberschrift);

			JLabel lblSpieler = new JLabel("Spieler");
			lblSpieler.setForeground(Color.WHITE);
			lblSpieler.setBackground(Color.BLACK);
			lblSpieler.setBounds(6, 95, 61, 16);
			contentPane.add(lblSpieler);

			Panel panel_Spieler = new Panel();
			panel_Spieler.setBounds(6, 117, 149, 82);
			contentPane.add(panel_Spieler);
			panel_Spieler.setLayout(null);

			rdbtnEinzelspieler = new JRadioButton("Einzelspieler (PvC)");
			rdbtnEinzelspieler.setBounds(0, 6, 223, 23);
			panel_Spieler.add(rdbtnEinzelspieler);
			rdbtnEinzelspieler.setBackground(Color.LIGHT_GRAY);
			rdbtnEinzelspieler.setForeground(Color.WHITE);

			rdbtnMehrspieler = new JRadioButton("Mehrspieler (PvP)");
			rdbtnMehrspieler.setBounds(0, 42, 223, 23);
			panel_Spieler.add(rdbtnMehrspieler);
			rdbtnMehrspieler.setForeground(Color.WHITE);
			rdbtnMehrspieler.setBackground(Color.LIGHT_GRAY);

			//Vorherige Auswahl wiederherstellen beim Öffnen
			if(objGameLogic.multiplayer == true) {
				rdbtnMehrspieler.setSelected(false);
			} else {
				rdbtnEinzelspieler.setSelected(true);
			}

			ButtonGroup gruppeSpieler = new ButtonGroup();
			gruppeSpieler.add(rdbtnEinzelspieler);
			gruppeSpieler.add(rdbtnMehrspieler);

			JLabel lblZurueck = new JLabel("←");
			lblZurueck.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblZurueck.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					// Abfragen und Speichern der Auswahl bei Multiplayer
			
					gameLogic.schwierigkeit = sliderSchwierigkeit.getValue();

					//Fenstr wieder öffnen
						GUIMain guiMain = new GUIMain(objGameLogic);
						guiMain.setVisible(true);
						dispose();              
				}
			});
			lblZurueck.setBackground(Color.BLACK);
			lblZurueck.setForeground(Color.WHITE);
			lblZurueck.setBounds(6, 6, 61, 16);
			contentPane.add(lblZurueck);

			sliderSchwierigkeit = new JSlider();
			sliderSchwierigkeit.setSnapToTicks(true);
			sliderSchwierigkeit.setMinorTickSpacing(1);
			sliderSchwierigkeit.setPaintLabels(true);
			sliderSchwierigkeit.setPaintTicks(true);
			sliderSchwierigkeit.setValue(gameLogic.getSchwierigkeit());
			sliderSchwierigkeit.setMaximum(2);
			sliderSchwierigkeit.setBounds(207, 147, 200, 52);
			contentPane.add(sliderSchwierigkeit);

			//Beschriftung SliderSchwierigkeit
			Hashtable<Integer, JLabel> labels = new Hashtable<>();
			JLabel lblEinfach = new JLabel("Einfach");
			lblEinfach.setForeground(Color.WHITE);
			labels.put(0, lblEinfach);
			JLabel lblMittel = new JLabel("Mittel");
			lblMittel.setForeground(Color.WHITE);
			labels.put(1, lblMittel);
			JLabel lblSchwer = new JLabel("Schwer");
			lblSchwer.setForeground(Color.WHITE);
			labels.put(2, lblSchwer);
			sliderSchwierigkeit.setLabelTable(labels);
			
		
			
		}
	}
}
