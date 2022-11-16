import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame{
    private JPanel panelMain;
    private JPanel panelTop;
    private JPanel panelRight;
    private JList listOrang;
    private JTextField textNama;
    private JTextField textEmail;
    private JTextField textTelepon;
    private JButton buttonExisting;
    private JButton buttonNew;
    private JCheckBox boxWanita;
    private JCheckBox boxPria;
    private JButton buttonClear;
    private ArrayList<Orang> people;
    private DefaultListModel ModelListOrang;


    Menu(){
        super("Warunk Maem");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        this.pack();

        people = new ArrayList<Orang>();
        ModelListOrang = new DefaultListModel();
        listOrang.setModel(ModelListOrang);

        buttonExisting.setEnabled(false);

        buttonExisting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nomorOrang = listOrang.getSelectedIndex();
                if (nomorOrang >= 0) {
                    Orang p = people.get(nomorOrang);
                    p.setNama(textNama.getText());
                    p.setEmail(textEmail.getText());
                    p.setNoTelp(textTelepon.getText());

                    refreshOrangList();
                }
            }
        });
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Orang p = new Orang(
                        textNama.getText(),
                        textEmail.getText(),
                        textTelepon.getText()
                );
                people.add(p);
                refreshOrangList();


            }
        });
        listOrang.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int nomorOrang = listOrang.getSelectedIndex();

                if (nomorOrang >= 0){
                    Orang p = people.get(nomorOrang);
                    textNama.setText(p.getNama());
                    textEmail.setText(p.getEmail());
                    textTelepon.setText(p.getNoTelp());

                    buttonExisting.setEnabled(true);

                }
                else{
                    buttonExisting.setEnabled(false);
                }

            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int nomorOrang = listOrang.getSelectedIndex();
                if (nomorOrang >= 0) {
                    Orang p = people.get(nomorOrang);
                    p.setNama(textNama.getText());
                    p.setEmail(textEmail.getText());
                    p.setNoTelp(textTelepon.getText());

                    people.remove(p);

                    refreshOrangList();
                }

            }
        });
    }

    public void refreshOrangList(){
        ModelListOrang.removeAllElements();
        System.out.println("Menghapus Orang Dari List...");
        for (Orang p : people){
            System.out.println("Menambah Orang Ke List: "+ p.getNama());
            ModelListOrang.addElement(p.getNama());
        }

    }

    public void addPerson(Orang p){
        people.add(p);
        refreshOrangList();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);

        Orang Dhiva = new Orang("Muhammad Dhiva Pradigta","dhivapradigta96@gmail.com","082297026677");
        Orang Ariz = new Orang("Ariz Muhammad Fajar","arizmuhammadfajar@gmail.com","082169145122");
        Orang test2 = new Orang("Ivan Danisworo Abaddi","ivandanisworo@gmail.com","082259808561");

        menu.addPerson(Dhiva);
        menu.addPerson(Ariz);
        menu.addPerson(test2);

    }
}
