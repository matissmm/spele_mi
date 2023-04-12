import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Spele implements ActionListener{
    JFrame frame;                                                       //galvenais lauks, kur viss tiek uzzīmēts
    JTextField textfield;                                               //lauks, kur izvada datora iegūtos punktus
    JTextField textfield2;                                              //lauks, kur izvada cilvēka iegūtos punktus
    JTextField textfieldRezultats;                                      //lauks, kur izvada kopējo rezutātu
    JButton[] skaitli = new JButton[6];                                 //izkārtojums spēles izvēles pogām
    JButton[] skaitli2 = new JButton[2];                                //izkārtojums spēlētāja izvēles pogām
    JButton viensButton,diviButton,trisButton,cetriButton,pieciButton,sesiButton;  //spēles izvēles pogas
    JPanel panel,panelIzvele,panelR;                                    //lauki, kur izvietotas pogas
    JButton datorsButton,cilveksButton;                                 //spēlētāja izvēles pogas
    JButton restartButton;                                              //spēles restartēšanas poga

    Font fonts = new Font("Serif",Font.BOLD,25);             //visa teksta fonts, izmēri, nodrošina to, ka var mainīt vienā vietā

    int skaititajs = 0;     //skaitītājs, ar kura palīdzību nosaka, kuram spēlētājam ir gājiens
    int viens = 1;          //daļa no 1. izvēles novērtējuma
    int divi = 2;           //daļa no 2. izvēles novērtējuma
    int tris = 3;           //daļa no 3. izvēles novērtējuma
    int cetri = 4;          //daļa no 4. izvēles novērtējuma
    int pieci = 5;          //daļa no 5. izvēles novērtējuma
    int sesi = 6;           //daļa no 6. izvēles novērtējuma
    public void metode(){       //izvēle nākamajam gājienam (tam kuru veic dators)
        if (skaititajs % 2 != 0) {      //ja ir nepāra skaitlis
            int [] izveles = new int [] {viens, divi, tris, cetri, pieci, sesi};  //83-87 pēc virsotņu vērtējumiem tos salīdzina, lai izvēlētos labāko
            int maksimums = izveles[0];
            for (int i=0;i<izveles.length;i++){         //salīdzina iespējamos gājienus, lai izvēlētos to ar labāko novērtējumu
                if (izveles[i]>maksimums) maksimums = izveles[i];
            }
            String pagsk = textfield.getText();             //nolasa kopējos punktus kā string vērtību
            int pagisk = Integer.parseInt(pagsk);           //string pārvērš par integer, lai ar to varētu tālāk darboties
            pagisk = pagisk + maksimums;                    //pārvērstajam integer pieskaita pēc novērtējuma labāko visotni
            String pagssk = Integer.toString(pagisk);       //atkal pārvērš no integer uz string
            textfield.setText(pagssk);                      //izprintē string vērtību logā
            if (maksimums == viens){
                viensButton.setBackground(new Color(255, 0, 0));        //pēc pogas nospiediena nomaina pogas krāsu uz sarkanu
                viensButton = new JButton("0");                          //nodrošina to, ka pogu var nospiest tikai vienu reizi
                viens = 0;                                                    //piešķir novērtējumu 0, jo jau vienreiz šis ir izvēlēts
            }
            if (maksimums == divi){
                diviButton.setBackground(new Color(255, 0, 0));        
                diviButton = new JButton("0");
                divi = 0;
            }
            if (maksimums == tris){
                trisButton.setBackground(new Color(255, 0, 0));        
                trisButton = new JButton("0");
                tris = 0;
            }
            if (maksimums == cetri){
                cetriButton.setBackground(new Color(255, 0, 0));        
                cetriButton = new JButton("0");
                cetri = 0;
            }
            if (maksimums == pieci){
                pieciButton.setBackground(new Color(255, 0, 0));
                pieciButton = new JButton("0");
                pieci = 0;
            }
            if (maksimums == sesi){
                sesiButton.setBackground(new Color(255, 0, 0));
                sesiButton = new JButton("0");
                sesi = 0;
            }
            skaititajs = skaititajs +1;                              //skaitītājam pieskaita 1, lai nākošais gājiens būtu otram spēlētājam
        }
    }
    Spele(){
        frame = new JFrame("Spēle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //nodrošinās to, ka programma pilnīgi tiks aizvērta ar krustiņu
        frame.setSize(415, 300);                        //izmēri
        frame.setLayout(null);
        frame.setResizable(false);

        textfield = new JTextField();                                //spēlētāja 1 punktu info
        textfield.setBounds(40, 25, 30, 30);        //izmēri
        textfield.setFont(fonts);                                    //izsauc un pielieto fontu
        textfield.setEditable(false);                              //nodrošina to, ka lietotājs izmainīt šo lauku
        textfield.setText("0");                                    //ievada sākotnējos punktus (0)
        textfield.setHorizontalAlignment(JTextField.CENTER);

        textfield2 = new JTextField();                               //spēlētāja 2 punktu info
        textfield2.setBounds(350, 25, 30, 30);
        textfield2.setFont(fonts);
        textfield2.setEditable(false);
        textfield2.setText("0");
        textfield2.setHorizontalAlignment(JTextField.CENTER);

        //spēles uzsācēja pogas
        datorsButton = new JButton("Dators");       //dators uzsāk spēli poga
        cilveksButton = new JButton("Cilvēks");     //cilvēks uzsāk spēli poga
        skaitli2[0] = datorsButton;                      //pogas pārveido lai ieliktu string
        skaitli2[1] = cilveksButton;
        for(int i=0;i<2;i++) {                           //ar ciklu izvieto spēlētāja uzsākšanas pogas
            skaitli2[i].addActionListener(this);
            skaitli2[i].setFont(fonts);
            skaitli2[i].setFocusable(false);
        }
        panelIzvele = new JPanel();                      //panelis spēlētāju pogām
        panelIzvele.setBounds(50, 150, 300, 25);
        panelIzvele.setLayout(new GridLayout(1,5));
        panelIzvele.setBackground(Color.GRAY);
        panelIzvele.add(datorsButton);                   //pievieno pogas panelim
        panelIzvele.add(cilveksButton);

        //spēles gājiena izvēles pogas
        viensButton = new JButton("1");             //izveido spēles izvēles pogas ar attiecīgajiem tekstiem uz tām
        diviButton = new JButton("2");
        trisButton = new JButton("3");
        cetriButton = new JButton("4");
        pieciButton = new JButton("5");
        sesiButton = new JButton("6");
        skaitli[0] = viensButton;                        //spēles pogas pievieno string, kurš nodrošinās izkārtojumu
        skaitli[1] = diviButton;
        skaitli[2] = trisButton;
        skaitli[3] = cetriButton;
        skaitli[4] = pieciButton;
        skaitli[5] = sesiButton;
        for(int i=0;i<6;i++) {                           //cikls spēles gājiena izvēles pogu izvietošanai
            skaitli[i].addActionListener(this);
            skaitli[i].setFont(fonts);
            skaitli[i].setFocusable(false);
        }
        panel = new JPanel();                            //panelis spēles gājiena izvēles pogu izvietošanai
        panel.setBounds(50, 75, 300, 25);
        panel.setLayout(new GridLayout(1,6));
        panel.setBackground(Color.GRAY);
        panel.add(viensButton);                          //panelī iezīmē spēles gājiena izvēles pogas
        panel.add(diviButton);
        panel.add(trisButton);
        panel.add(cetriButton);
        panel.add(pieciButton);
        panel.add(sesiButton);
        viensButton.setBackground(new Color(0, 255, 0));    //nokrāso pogas zaļas
        diviButton.setBackground(new Color(0, 255, 0));
        trisButton.setBackground(new Color(0, 255, 0));
        cetriButton.setBackground(new Color(0, 255, 0));
        pieciButton.setBackground(new Color(0, 255, 0));
        sesiButton.setBackground(new Color(0, 255, 0));

        //spēles atkārtošanas poga
        restartButton = new JButton("Atkārtot spēli");
        restartButton.setBounds(200, 225, 150, 25);
    
        //uzzīmē visu uz galvenā rāmja
        frame.add(restartButton);
        frame.add(panelIzvele);
        frame.add(panel);
        frame.add(textfield);
        frame.add(textfield2);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Spele sp = new Spele();                 //nodrošina to, ka spēle tiks palaista
    }
    //informācija par to, kas notiks, ja tiks nospiesta kāda no pogām:
    @Override
    public void actionPerformed(ActionEvent e) {
        String pag2 = textfield2.getText();                 //nolasa cilvēka punktus kā string
        int pagi2 = Integer.parseInt(pag2);                 //string pārveido par integer
        if(e.getSource() == datorsButton) {
            skaititajs = 1;                                 //nodrošina, ka pirmais sāks dators
            metode();                                       //nākošais gājiens
        }
        if(e.getSource() == cilveksButton) {
            skaititajs = 2;                                 //nodrošina, ka pirmais sāks cilvēks
        }
        if(e.getSource() == viensButton) {                  //pirmā poga
            if(skaititajs % 2 == 0) {
                pagi2 = pagi2 + 1;                          //pievieno vienu punktu, jo tika izvēlēta poga "1"
                String pags2 = Integer.toString(pagi2);     //integer pārveido par string, lai varētu izvadīt punktus
                textfield2.setText(pags2);                  //punktus jau kā string ieraksta laukā
            }
            viensButton.setBackground(new Color(255, 0, 0));    //pēc pogas nospiediena nomaina krāsu uz sarkanu
            viensButton = new JButton("0");                      //pārzīmē pogu, lai nodrošinātu to, ka to var nospiest tikai 1 reizi
            viens = 0;                                                //daļa no virsotņu novērtēšanas, nodrošina to, ka, ja pirmais ir izvēlēts, tad tam piešķir 0 vertību
            skaititajs = skaititajs +1;                               //nodrošina to, ka nākošais gājiens būs otram spēlētājam
            metode();                                                 //izsauc metodi, lai nodrošinātu nākošo gājienu
        }

        if(e.getSource() == diviButton) {
            if(skaititajs % 2 == 0) {
                pagi2 = pagi2 + 2;
                String pags2 = Integer.toString(pagi2);
                textfield2.setText(pags2);
            }
            diviButton.setBackground(new Color(255, 0, 0));
            diviButton = new JButton("0");
            divi = 0;
            skaititajs = skaititajs +1;
            metode();           // nākošais gājiens
        }

        if(e.getSource() == trisButton) {
            if(skaititajs % 2 == 0) {
                pagi2 = pagi2 + 3;
                String pags2 = Integer.toString(pagi2);
                textfield2.setText(pags2);
            }
            trisButton.setBackground(new Color(255, 0, 0));
            trisButton = new JButton("0");
            tris = 0;
            skaititajs = skaititajs +1;
            metode();           // nākošais gājiens
        }

        if(e.getSource() == cetriButton) {
            if(skaititajs % 2 == 0) {
                pagi2 = pagi2 + 4;
                String pags2 = Integer.toString(pagi2);
                textfield2.setText(pags2);
            }
            cetriButton.setBackground(new Color(255, 0, 0));
            cetriButton = new JButton("0");
            cetri = 0;
            skaititajs = skaititajs +1;
            metode();           // nākošais gājiens
        }
        if(e.getSource() == pieciButton) {
            if(skaititajs % 2 == 0) {
                pagi2 = pagi2 + 5;
                String pags2 = Integer.toString(pagi2);
                textfield2.setText(pags2);
            }
            pieciButton.setBackground(new Color(255, 0, 0));
            pieciButton = new JButton("0");
            pieci = 0;
            skaititajs = skaititajs +1;
            metode();           // nākošais gājiens
        }
        if(e.getSource() == sesiButton) {
            if(skaititajs % 2 == 0) {
                pagi2 = pagi2 + 6;
                String pags2 = Integer.toString(pagi2);
                textfield2.setText(pags2);
            }
            sesiButton.setBackground(new Color(255, 0, 0));
            sesiButton = new JButton("0");
            sesi = 0;
            skaititajs = skaititajs +1;
            metode();           // nākošais gājiens
        }

        if(e.getSource() == restartButton) {
            //nedarbojas, nevarēju izdomāt, kā uztaisīt
        }

        if (viens==0 && divi==0 && tris==0 && cetri==0 && pieci==0&& sesi==0) {    //ja visas pogas ir nospiestas, tad izvērtē punktus un izvada spēles iznākumu
            String pag11 = textfield.getText();                 //int to string punktiem no laukiem
            String pag22 = textfield2.getText();
            int pagi11 = Integer.parseInt(pag11);
            int pagi22 = Integer.parseInt(pag22);
            if (pagi11 > pagi22) {                //salīdzina punktus, ja lielāki datoram, tad dators uzvar
                textfieldRezultats = new JTextField();                             //uzzīmē lauku, kur tiks parādīts spēles rezultāts
                textfieldRezultats.setBounds(90, 20, 240, 30);    //izmēri laukam
                textfieldRezultats.setFont(fonts);                                 //izsauc un pielieto fontu
                textfieldRezultats.setEditable(false);                           //nodrošina, ka lietotājs nevar pārveidot lauku
                textfieldRezultats.setText("Uzvarētājs ir Dators!");             //izvada tekstu
                textfieldRezultats.setBorder(null);                         //noņem rāmi, kas bija apkārt
                frame.add(textfieldRezultats);                                     //uzzīmē galvenajā laukā
            }
            else if (pagi11 == pagi22) {          //salīdzina punktus, ja vienādi, tad neizšķirts
                textfieldRezultats = new JTextField();
                textfieldRezultats.setBounds(90, 20, 240, 30);
                textfieldRezultats.setFont(fonts);
                textfieldRezultats.setEditable(false);
                textfieldRezultats.setText("Rezultāts ir neizšķirts!");
                textfieldRezultats.setBorder(null);
                frame.add(textfieldRezultats);
            }
            else {                                 //tad ja uzvarētājs cilvēks
                textfieldRezultats = new JTextField();
                textfieldRezultats.setBounds(90, 20, 240, 30);
                textfieldRezultats.setFont(fonts);
                textfieldRezultats.setEditable(false);
                textfieldRezultats.setText("Uzvarētājs ir Cilvēks!");
                textfieldRezultats.setBorder(null);
                frame.add(textfieldRezultats);
            }
        }
    }
}