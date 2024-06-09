package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import actions.Main;
import game.GameLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private GameLogic objGameLogic;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public GUIMain frameMain;

            public void run() {
                try {
                    frameMain = new GUIMain(new GameLogic());
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

        JButton lblStart = new JButton("Start");
        lblStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (objGameLogic.getMultiplayer()) {
                    System.out.println("Multiplayer");
                } else {
                    System.out.println("Singleplayer");
                }
                System.out.println(objGameLogic.schwierigkeit);
                

               
                GameLogic spiellogik = new GameLogic();
        		new Gui(spiellogik);
        		dispose();
                
            }
        });
        lblStart.setBackground(Color.WHITE);
        lblStart.setForeground(Color.BLACK);
        lblStart.setBounds(175, 95, 117, 29);
        contentPane.add(lblStart);

        JButton lblEinstellungen = new JButton("Einstellungen");
        lblEinstellungen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIEinstellungen guiEinstellungen = new GUIEinstellungen(objGameLogic);
                guiEinstellungen.setVisible(true);
                dispose();
            }
        });
        lblEinstellungen.setForeground(Color.BLACK);
        lblEinstellungen.setBackground(Color.WHITE);
        lblEinstellungen.setBounds(175, 137, 117, 29);
        contentPane.add(lblEinstellungen);

        JButton lblVerlassen = new JButton("Verlassen");
        lblVerlassen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lblVerlassen.setForeground(Color.BLACK);
        lblVerlassen.setBackground(Color.WHITE);
        lblVerlassen.setBounds(175, 178, 117, 29);
        contentPane.add(lblVerlassen);
    }
}
