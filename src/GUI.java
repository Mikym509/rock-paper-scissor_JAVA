import javax.swing.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.io.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GUI {
    JFrame frame = new JFrame();    //JFrame non deve essere privato
    private JButton SASSOButton;
    private JButton FORBICEButton;
    private JTextField scelta_avversario;
    private JButton CARTAButton;
    private JPanel Rootpanel;
    private JTextField punteggio_NPC;
    private JTextField punteggio_utente;
    private JLabel TITOLO;
    private JButton informations;
    private JTextField scelta_utente;
    private JButton NPCButton;
    private JButton VERIFICAButton;
    private JTextField Vincitore;
    private JButton PUNTIButton;
    private int punteggio_finale_UTENTE = 0;
    private int punteggio_finale_NPC = 0;

    public GUI(){
        //--------------------------------------------------//
        //con setEnabled(false) faccio che in modo che i componenti non possano essere modificati o cliccati
        scelta_utente.setEnabled(false);
        scelta_avversario.setEnabled(false);
        punteggio_utente.setEnabled(false);
        punteggio_NPC.setEnabled(false);
        Vincitore.setEnabled(false);
        NPCButton.setEnabled(false);
        VERIFICAButton.setEnabled(false);
        PUNTIButton.setEnabled(false);
        //--------------------------------------------------//

        //--------------------------------------------------//
        //con setHorizontalAlignment(JTextField.CENTER) metto il testo all'interno del componente al centro
        Vincitore.setHorizontalAlignment(JTextField.CENTER);
        scelta_utente.setHorizontalAlignment(JTextField.CENTER);
        scelta_avversario.setHorizontalAlignment(JTextField.CENTER);
        punteggio_utente.setHorizontalAlignment(JTextField.CENTER);
        punteggio_NPC.setHorizontalAlignment(JTextField.CENTER);
        //--------------------------------------------------//

        float f_size = 20;
        frame.setTitle("SASSO,CARTA,FORBICE");
        frame.setSize(550,350);
        //Rootpanel.setBackground(Color.CYAN);      //cambiare lo sfondo del colore ad un componente
        //SASSOButton.setForeground(Color.black);       //cambiare il colore di sfondo del comoponente
        //SASSOButton.setBackground(Color.yellow);      //cambiare il colore del testo
        TITOLO.setFont(TITOLO.getFont().deriveFont(f_size));        //modificare la grandezza del font
        frame.add(Rootpanel);
        informations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"\n 1. Scegli la tua mossa cliccando uno dei tasti(SASSO,CARTA,FORBICE) e aspetta la mossa dell'avversario. \n 2. Clicca il pulsante NPC per far partire la scelta dell'avversario \n 3. Clicca VERIFICA per vedere chi ha vinto \n 4. Puoi fare un'altro turno oppure puoi vedere chi ha fatto più punti \n \n BUON DIVERTIMENTO!");
            }
        });
        SASSOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String interfaccia = "SASSO";
                scelta_utente.setText(interfaccia);
                CARTAButton.setEnabled(false);
                FORBICEButton.setEnabled(false);
                NPCButton.setEnabled(true);
                PUNTIButton.setEnabled(false);
                Vincitore.setText("");
            }
        });
        CARTAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String interfaccia = "CARTA";
                scelta_utente.setText(interfaccia);
                SASSOButton.setEnabled(false);
                FORBICEButton.setEnabled(false);
                NPCButton.setEnabled(true);
                PUNTIButton.setEnabled(false);
                Vincitore.setText("");
            }
        });
        FORBICEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String interfaccia = "FORBICE";
                scelta_utente.setText(interfaccia);
                SASSOButton.setEnabled(false);
                CARTAButton.setEnabled(false);
                NPCButton.setEnabled(true);
                PUNTIButton.setEnabled(false);
                Vincitore.setText("");
            }
        });
        NPCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int casuale = 0;
                String scelta = "";
                casuale = rand.nextInt((3 - 1)+1) + 1;
                if(casuale == 1){
                    scelta = "SASSO";
                    scelta_avversario.setText(scelta);
                }else if(casuale == 2){
                    scelta = "CARTA";
                    scelta_avversario.setText(scelta);
                }else if(casuale == 3){
                    scelta = "FORBICE";
                    scelta_avversario.setText(scelta);
                }
                NPCButton.setEnabled(false);
                VERIFICAButton.setEnabled(true);
            }
        });
        VERIFICAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String punteggio_String_U = "";     //punteggio di stringhe per utente
                String punteggio_String_NPC = "";       //punteggio di stringhe per NPC
                if(scelta_utente.getText().contentEquals("SASSO") && scelta_avversario.getText().contentEquals("SASSO")){
                    Vincitore.setText("PARITA'");
                    punteggio_finale_NPC += 5;
                    punteggio_finale_UTENTE += 5;
                }else if(scelta_utente.getText().contentEquals("SASSO") && scelta_avversario.getText().contentEquals("CARTA")){
                    Vincitore.setText("IL COMPUTER ");
                    punteggio_finale_UTENTE += 5;
                    punteggio_finale_NPC += 10;
                }else if(scelta_utente.getText().contentEquals("SASSO") && scelta_avversario.getText().contentEquals("FORBICE")){
                    Vincitore.setText("L'UTENTE");
                    punteggio_finale_UTENTE += 10;
                    punteggio_finale_NPC += 5;
                }else if (scelta_utente.getText().contentEquals("CARTA") && scelta_avversario.getText().contentEquals("CARTA")){
                    Vincitore.setText("PARITA'");
                    punteggio_finale_NPC += 5;
                    punteggio_finale_UTENTE += 5;
                }else if (scelta_utente.getText().contentEquals("CARTA") && scelta_avversario.getText().contentEquals("SASSO")){
                    Vincitore.setText("L'UTENTE");
                    punteggio_finale_UTENTE += 10;
                    punteggio_finale_NPC += 5;
                }else if(scelta_utente.getText().contentEquals("CARTA") && scelta_avversario.getText().contentEquals("FORBICE")){
                    Vincitore.setText("IL COMPUTER ");
                    punteggio_finale_UTENTE += 5;
                    punteggio_finale_NPC += 10;
                }else if(scelta_utente.getText().contentEquals("FORBICE") && scelta_avversario.getText().contentEquals("FORBICE")){
                    Vincitore.setText("PARITA'");
                    punteggio_finale_NPC += 5;
                    punteggio_finale_UTENTE += 5;
                }else if(scelta_utente.getText().contentEquals("FORBICE") && scelta_avversario.getText().contentEquals("SASSO")){
                    Vincitore.setText("IL COMPUTER ");
                    punteggio_finale_UTENTE += 5;
                    punteggio_finale_NPC += 10;
                }else if(scelta_utente.getText().contentEquals("FORBICE") && scelta_avversario.getText().contentEquals("CARTA")){
                    Vincitore.setText("L'UTENTE");
                    punteggio_finale_UTENTE += 10;
                    punteggio_finale_NPC += 5;
                }
                SASSOButton.setEnabled(true);
                CARTAButton.setEnabled(true);
                FORBICEButton.setEnabled(true);
                PUNTIButton.setEnabled(true);
                scelta_utente.setText("");
                scelta_avversario.setText("");
            }
        });
        PUNTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Punt_UTENTE = "";        //stringa per punteggio utente
                String Punt_NPC = "";       //stringa per punteggio NPC
                Punt_UTENTE = String.valueOf(punteggio_finale_UTENTE);
                Punt_NPC = String.valueOf(punteggio_finale_NPC);
                punteggio_utente.setText(Punt_UTENTE);
                punteggio_NPC.setText(Punt_NPC);

                SASSOButton.setEnabled(false);
                CARTAButton.setEnabled(false);
                FORBICEButton.setEnabled(false);
                NPCButton.setEnabled(false);
                VERIFICAButton.setEnabled(false);
            }
        });
    }
}