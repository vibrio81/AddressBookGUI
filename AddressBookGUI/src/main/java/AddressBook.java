import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook {
    // Components
    private JFrame f;
    private JPanel p = new JPanel();
    private JButton view;
    private JButton create;


    public AddressBook(){
        // Frame Functionalities
        f = new JFrame("Address Book"); // Frame create & Name
        f.setLayout(new FlowLayout()); // Frame Layout
        f.setSize(300,100); // Frame Size
        f.setLocationRelativeTo(null); // Frame Location ==> set to middle of the screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame close operation
        f.getContentPane().setBackground(new Color(92, 50, 168));

        // panels
        //p = new JPanel();

        // Buttons
        create = new JButton("Add New");
        view = new JButton("View Contacts");

        create.setBackground(new Color(3, 177, 252));
        create.setOpaque(true);
        create.setBorderPainted(false);

        view.setBackground(new Color(3, 177, 252));
        view.setOpaque(true);
        view.setBorderPainted(false);

        // Create Button Actions
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNew();
                f.setVisible(false);
            }
        });


        // View Button Actions
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewContacts();
                f.setVisible(false);
            }
        });


        // Adding Buttons to panel
        p.add(create);
        p.add(view);


        // Adding panel to frame & Frame visibility
        f.add(p);
        f.setVisible(true);

    }
    public static void main(String[] args) {
        new AddressBook();
    }
}