package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import game.GameLogic;

import javax.swing.JRadioButton;
import java.awt.Panel;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GUIEinstellungen extends JFrame {
	
	
	

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
        //rdbtnMehrspieler.setSelected(true);
        rdbtnMehrspieler.setForeground(Color.WHITE);
        rdbtnMehrspieler.setBackground(Color.LIGHT_GRAY);
        
        //Vorherige Auswahl wiederherstellen beim Öffnen
        if(objGameLogic.getMultiplayer()) {
        	rdbtnMehrspieler.setSelected(true);
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
                if (rdbtnEinzelspieler.isSelected()) {
                    objGameLogic.setMultiplayer(false); // Singleplayer
                } else if (rdbtnMehrspieler.isSelected()) {
                    objGameLogic.setMultiplayer(true); // Multiplayer
                }
                GUIMain guiMain = new GUIMain(objGameLogic);
                guiMain.setVisible(true);
                dispose();
            }
        });
        lblZurueck.setBackground(Color.BLACK);
        lblZurueck.setForeground(Color.WHITE);
        lblZurueck.setBounds(6, 6, 61, 16);
        contentPane.add(lblZurueck);
    }
}
