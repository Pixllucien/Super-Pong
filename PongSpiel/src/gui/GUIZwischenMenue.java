package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import game.GameLogic;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class GUIZwischenMenue extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GameLogic objGameLogic;
    private JTextField tFPointPlayer1;
    private JTextField tFPointplayer2;

    public GUIZwischenMenue(GameLogic gameLogic) {
        this.objGameLogic = gameLogic;
        System.out.println("GUIZwischenMenue Constructor called");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUeberschrift = new JLabel("Einstellungen");
        lblUeberschrift.setBounds(6, 26, 438, 57);
        lblUeberschrift.setFont(new Font("Monospaced", Font.PLAIN, 20));
        lblUeberschrift.setHorizontalAlignment(SwingConstants.CENTER);
        lblUeberschrift.setForeground(Color.WHITE);
        contentPane.add(lblUeberschrift);

        JButton btnRestart = new JButton("Neustart");
        btnRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("GUIZwischenMenue Button Neustart gedrückt");
                GameLogic spiellogik = new GameLogic();
                new Gui(spiellogik);
                dispose();    
            }
        });
        btnRestart.setBounds(128, 130, 215, 30);
        btnRestart.setBackground(Color.WHITE);
        contentPane.add(btnRestart);

        JButton btnToMainMenu = new JButton("Zurück zum Hauptmenü");
        btnToMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("GUIZwischenMenue Button Zurück zum Hauptmenü gedrückt");
                GUIMain guiMain = new GUIMain(objGameLogic);
                guiMain.setVisible(true);
                dispose();      
            }
        });
        btnToMainMenu.setBounds(128, 165, 215, 30);
        btnToMainMenu.setBackground(Color.WHITE);
        btnToMainMenu.setForeground(Color.BLACK);
        contentPane.add(btnToMainMenu);

        JButton btnQuit = new JButton("Spiel Beenden");
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("GUIZwischenMenue Button Spiel Beenden gedrückt");
                System.exit(0);
            }
        });
        btnQuit.setBounds(128, 200, 215, 30);
        btnQuit.setBackground(Color.WHITE);
        btnQuit.setForeground(Color.BLACK);
        contentPane.add(btnQuit);

        tFPointPlayer1 = new JTextField();
        tFPointPlayer1.setBackground(Color.BLACK);
        tFPointPlayer1.setForeground(Color.WHITE);
        tFPointPlayer1.setEnabled(false);
        tFPointPlayer1.setEditable(false);
        tFPointPlayer1.setBounds(6, 6, 130, 26);
        contentPane.add(tFPointPlayer1);
        tFPointPlayer1.setColumns(10);

        tFPointplayer2 = new JTextField();
        tFPointplayer2.setForeground(Color.WHITE);
        tFPointplayer2.setEnabled(false);
        tFPointplayer2.setEditable(false);
        tFPointplayer2.setColumns(10);
        tFPointplayer2.setBackground(Color.BLACK);
        tFPointplayer2.setBounds(314, 6, 130, 26);
        contentPane.add(tFPointplayer2);

//        tFPointPlayer1.setText("Spieler 1: " + objGameLogic.getPunkteSp1());
//        tFPointplayer2.setText("Spieler 2: " + objGameLogic.getPunkteSp2());
    }
}
