package Cart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Interface extends JFrame{
    private static DecimalFormat formatSum = new DecimalFormat("#.##");
    private JLabel label = new JLabel("Продукти:");
    private JComboBox<String> products = new JComboBox();
    private JLabel pricesLabel = new JLabel("Цени:");
    private JTextArea pricesTextArea = new JTextArea();
    private JScrollPane productsPrices = new JScrollPane(pricesTextArea);
    private JLabel userChoice = new JLabel("Вие избрахте:");
    private JButton buy = new JButton("Buy");
    private JButton remove = new JButton("Remove");
    private JButton finish = new JButton("Finish");
    private JButton removeAll = new JButton("Remove All");
    private JList<String> chosenList = new JList<>();
    private DefaultListModel<String> model = new DefaultListModel<>();
    private JScrollPane listScrollPane = new JScrollPane(chosenList);

    public Interface() {
        super("Shopping Cart");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,2,2,2));

        container.add(label);
        container.add(products);
        products.addItem("Ябълка");
        products.addItem("Круша");
        products.addItem("Ягода");
        products.addItem("Кайсия");
        products.addItem("Праскова");
        products.addItem("Ананас");
        products.addItem("Слива");
        products.addItem("Портокал");

        pricesTextArea.setText("Ябълки - 2.00лв\nКруши - 2.20лв\nЯгоди - 3.10лв\nКайсии - 2.30лв\nПраскови - 3.00лв\n"
                + "Ананаси - 2.50лв\nСливи - 2.60лв\nПортокали - 2.10лв");
        container.add(pricesLabel);
        container.add(productsPrices);

        container.add(userChoice);
        container.add(listScrollPane);
        chosenList.setModel(model);

        container.add(buy);
        buy.addActionListener(new buyEventListener());
        container.add(remove);
        remove.addActionListener(new removeEventListener());
        container.add(finish);
        finish.addActionListener(new finishEventListener());
        container.add(removeAll);
        removeAll.addActionListener(new removeAllEventListener());
    }

    private double sum = 0;

    class buyEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double applePrice = 2.00;
            double pearPrice = 2.20;
            double strawberryPrice = 3.10;
            double apricotPrice = 2.30;
            double peachPrice = 3.00;
            double pineapplePrice = 2.50;
            double plumPrice = 2.60;
            double orangePrice = 2.10;
            String selectedItem = (String) products.getSelectedItem();
            model.addElement(selectedItem);
            chosenList.setSelectedIndex(0);
            switch (selectedItem) {
                case "Ябълка": sum+= applePrice; break;
                case "Круша": sum+= pearPrice; break;
                case "Ягода": sum+= strawberryPrice; break;
                case "Кайсия": sum+= apricotPrice; break;
                case "Праскова": sum+= peachPrice; break;
                case "Ананас": sum+= pineapplePrice; break;
                case "Слива": sum+= plumPrice; break;
                case "Портокал": sum+= orangePrice; break;
                default: break;
            }
        }
    }

    class removeEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double applePrice = 2.00;
            double pearPrice = 2.20;
            double strawberryPrice = 3.10;
            double apricotPrice = 2.30;
            double peachPrice = 3.00;
            double pineapplePrice = 2.50;
            double plumPrice = 2.60;
            double orangePrice = 2.10;
            int chosenIndex = chosenList.getSelectedIndex();
            String listSelectedItem = chosenList.getSelectedValue();
            if (chosenIndex >= 0) {
                model.removeElementAt(chosenIndex);
                chosenList.setSelectedIndex(0);
                switch (listSelectedItem) {
                    case "Ябълка": sum-= applePrice; break;
                    case "Круша": sum-= pearPrice; break;
                    case "Ягода": sum-= strawberryPrice; break;
                    case "Кайсия": sum-= apricotPrice; break;
                    case "Праскова": sum-= peachPrice; break;
                    case "Ананас": sum-= pineapplePrice; break;
                    case "Слива": sum-= plumPrice; break;
                    case "Портокал": sum-= orangePrice; break;
                    default: break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Количката е празна!\nКупете нещо, моля!", "Empty Cart", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class finishEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tellSum = "Дължима сума: " + formatSum.format(sum) + "лв.";
            JOptionPane.showMessageDialog(null,tellSum,"Total Sum",JOptionPane.PLAIN_MESSAGE);
        }
    }

    class removeAllEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.removeAllElements();
            sum -= sum;
        }
    }
}
