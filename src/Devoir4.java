
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Devoir4 extends JFrame {

    private JTextField txtNom;
    private JTextField txtNomCadeau;
    private JTextField txtDescription;
    private JTextField txtPrenom;
    private JTextField txtEmail;
    private JTextField txtAdresseRue;
    private JTextField txtAdresseRueExtra;
    private JTextField txtVille;
    private JTextField txtPays;

    public Devoir4() {
        init();
        allComponents();
    }

    private void allComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel frmContact = new JPanel();
        JPanel frmCadeau = new JPanel();
        JPanel frmAmiCadeaux = new JPanel();

        frmContact.setLayout(null);
        frmCadeau.setLayout(null);
        frmAmiCadeaux.setLayout(null);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(70, 20, 50, 30);
        frmContact.add(lblNom);

        JLabel lblNomCadeau = new JLabel("Nom du cadeau");
        lblNomCadeau.setBounds(70, 20, 100, 30);
        frmCadeau.add(lblNomCadeau);

        txtNom = new JTextField();
        txtNom.setBounds(350, 20, 250, 30);
        frmContact.add(txtNom);

        txtNomCadeau = new JTextField();
        txtNomCadeau.setBounds(350, 20, 250, 30);
        frmCadeau.add(txtNomCadeau);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setBounds(70, 60, 80, 30);
        frmCadeau.add(lblDescription);

        txtDescription = new JTextField();
        txtDescription.setBounds(350, 60, 250, 30);
        frmCadeau.add(txtDescription);


        JLabel lblPrenom = new JLabel("Prénom");
        lblPrenom.setBounds(70, 60, 50, 30);
        frmContact.add(lblPrenom);

        txtPrenom = new JTextField();
        txtPrenom.setBounds(350, 60, 250, 30);
        frmContact.add(txtPrenom);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(70, 100, 50, 30);
        frmContact.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(350, 100, 250, 30);
        frmContact.add(txtEmail);

        JLabel lblAdresseRue = new JLabel("Adresse Rue");
        lblAdresseRue.setBounds(70, 140, 80, 30);
        frmContact.add(lblAdresseRue);

        txtAdresseRue = new JTextField();
        txtAdresseRue.setBounds(350, 140, 250, 30);
        frmContact.add(txtAdresseRue);

        JLabel lblAdresseRueExtra = new JLabel("Adresse Rue Extra");
        lblAdresseRueExtra.setBounds(70, 180, 120, 30);
        frmContact.add(lblAdresseRueExtra);

        txtAdresseRueExtra = new JTextField();
        txtAdresseRueExtra.setBounds(350, 180, 250, 30);
        frmContact.add(txtAdresseRueExtra);

        JLabel lblVille = new JLabel("Ville");
        lblVille.setBounds(70, 220, 50, 30);
        frmContact.add(lblVille);

        txtVille = new JTextField();
        txtVille.setBounds(350, 220, 250, 30);
        frmContact.add(txtVille);

        JLabel lblPays = new JLabel("Pays");
        lblPays.setBounds(70, 260, 50, 30);
        frmContact.add(lblPays);

        txtPays = new JTextField();
        txtPays.setBounds(350, 260, 250, 30);
        frmContact.add(txtPays);

        JButton btnSaveCadeau = new JButton("Save Cadeau");
        btnSaveCadeau.setBounds(290, 190, 120, 30);
        btnSaveCadeau.setBackground(Color.ORANGE);
        btnSaveCadeau.setForeground(Color.BLACK);
        frmCadeau.add(btnSaveCadeau);

        btnSaveCadeau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomCadeau = txtNomCadeau.getText();
                String description = txtDescription.getText();

                Cadeau cadeau = new Cadeau(nomCadeau, description);
                List<Cadeau> cadeaux = new ArrayList<>();
                cadeaux.add(cadeau);

                String fichierCadeau = "Cadeau.txt";
                ecrireCadeaux(cadeaux, fichierCadeau);
                
                txtNomCadeau.setText("");
                txtDescription.setText("");
            }
        });

        JButton btnSaveContact = new JButton("Save Contact");
        btnSaveContact.setBounds(50, 320, 120, 30);
        btnSaveContact.setBackground(Color.orange);
        btnSaveContact.setForeground(Color.black);
        frmContact.add(btnSaveContact);

        btnSaveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = txtNom.getText();
                String prenom = txtPrenom.getText();
                String email = txtEmail.getText();
                String adresseRue = txtAdresseRue.getText();
                String adresseRueExtra = txtAdresseRueExtra.getText();
                String ville = txtVille.getText();
                String pays = txtPays.getText();

               
                Contact contact = new Contact(nom, prenom, email, adresseRue, adresseRueExtra, ville, pays);
                List<Contact> contacts = new ArrayList<>();
                contacts.add(contact);

                String fichier = "Amis.txt";

                ecrireContactsDansFichier(contacts, fichier);

                txtNom.setText("");
                txtPrenom.setText("");
                txtEmail.setText("");
                txtAdresseRue.setText("");
                txtAdresseRueExtra.setText("");
                txtVille.setText("");
                txtPays.setText("");
            }
        });

        JLabel lblAmi = new JLabel("Choisir un ami:");
        lblAmi.setBounds(30, 20, 100, 30);
        frmAmiCadeaux.add(lblAmi);

        JComboBox<String> cmbAmi = new JComboBox<>();
        cmbAmi.setBounds(130, 20, 150, 30);
        frmAmiCadeaux.add(cmbAmi);

        String fichier = "Amis.txt";
        listAmis(cmbAmi, fichier);
        
        
        JLabel lblCadeau = new JLabel("Choisir un cadeau:");
        lblCadeau.setBounds(350, 20, 140, 30);
        frmAmiCadeaux.add(lblCadeau);

        JComboBox<String> cmbCadeau = new JComboBox<>();
        cmbCadeau.setBounds(480, 20, 150, 30);
        frmAmiCadeaux.add(cmbCadeau);

        String fichierCadeau = "Cadeau.txt";
        listCadeux(cmbCadeau, fichierCadeau);

        JList<String> lstCadeaux = new JList<>(new DefaultListModel<>());
        lstCadeaux.setBounds(40, 70, 590, 300);
        frmAmiCadeaux.add(lstCadeaux);

        // Add listener for selection change in the gift list
        cmbCadeau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFriend = (String) cmbAmi.getSelectedItem();
                String selectedGift = (String) cmbCadeau.getSelectedItem();
                DefaultListModel<String> model = (DefaultListModel<String>) lstCadeaux.getModel();
                model.addElement(selectedFriend + " received " + selectedGift);
            }
        });

        // Add panels to the tabbed pane
        tabbedPane.add("Contact", frmContact);
        tabbedPane.add("Cadeau", frmCadeau);
        tabbedPane.add("Amis cadeaux", frmAmiCadeaux);

        add(tabbedPane);

        setVisible(true);
    }

    private void init() {
        setTitle("Devoir");
        setSize(700, 500);

        setLayout(new GridLayout(1, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void ecrireContactsDansFichier(List<Contact> contacts, String nomFichier) {
        try {
            FileWriter writer = new FileWriter(nomFichier, true);
            for (Contact contact : contacts) {
                writer.append(contact.getNom() + "," + contact.getPrenom() + "," + contact.getEmail() + "," + contact.getAdresseRue() + "," + contact.getAdresseRueExtra() + "," + contact.getVille() + "," + contact.getPays() + "\n");
            }
            writer.close();
        } catch (IOException e) {
        	
        }
    }

    public void ecrireCadeaux(List<Cadeau> cadeaux, String nomFichier) {
        try {
            FileWriter writer = new FileWriter(nomFichier, true);
            for (Cadeau cadeau : cadeaux) {
                writer.append(cadeau.getNom() + "," + cadeau.getDescription() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            
        }
    }

    public void listCadeux(JComboBox<String> comboBox, String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lst = line.split(",");
                comboBox.addItem(lst[0] + " ==> " + lst[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listAmis(JComboBox<String> comboBox, String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lst = line.split(",");
                comboBox.addItem(lst[0] + " " + lst[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Devoir4 devoir4 = new Devoir4();
    }
}



























