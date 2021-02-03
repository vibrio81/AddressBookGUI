import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddNew {
    // Components
    private JFrame f;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;


    private JTextField t1;
    private JTextField t2;
    private JTextField t3;


    private JButton back;
    private JButton submit;
    private JButton clear;


    public AddNew(){
        f = new JFrame("Add New | Address Book");
        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.setSize(350, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(92, 50, 168));

        // Panels
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        p1.setBackground(new Color(92, 50, 168, 100));
        p1.setOpaque(true);
        p2.setBackground(new Color(92, 50, 168, 100));
        p2.setOpaque(true);
        p3.setBackground(new Color(92, 50, 168, 100));
        p3.setOpaque(true);
        p4.setBackground(new Color(92, 50, 168, 100));
        p4.setOpaque(true);
        p5.setBackground(new Color(92, 50, 168, 100));
        p5.setOpaque(true);




        // Labels
        l1 = new JLabel("Name:");
        l2 = new JLabel("Phone:");
        l3 = new JLabel("Email:");





        // Text Fields
        t1 = new JTextField(21);
        t2 = new JTextField(20);
        t3 = new JTextField(20);



        // Buttons
        back = new JButton("Back");
        clear = new JButton("Clear");
        submit = new JButton("Submit");

        back.setBackground(new Color(3, 177, 252));
        back.setOpaque(true);
        back.setBorderPainted(false);

        clear.setBackground(new Color(3, 177, 252));
        clear.setOpaque(true);
        clear.setBorderPainted(false);

        submit.setBackground(new Color(3, 177, 252));
        submit.setOpaque(true);
        submit.setBorderPainted(false);


        // Back Button Action
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddressBook();
                f.setVisible(false);
            }
        });


        // Clear Button Action
        clear.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");

        });


        // Submit Button Action
        submit.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter("Contacts.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);

                String name = t1.getText();
                String phone = t2.getText();
                String email = t3.getText();


                bw.write(name+"\t"+phone+"\t"+email+"\n");
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            finally {
                new AddressBook();
                f.setVisible(false);
            }
        });


        // Adding Components to Frame
        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(l3);
        p3.add(t3);
        p5.add(back);
        p5.add(clear);
        p5.add(submit);

        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);


        f.setVisible(true);
    }

    public static void main(String[] args) {
        new AddNew();
    }
}