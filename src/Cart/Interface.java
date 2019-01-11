package Cart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JFrame{
    private JLabel label = new JLabel("Продукти:");
    private JComboBox<String> products = new JComboBox();
    private JLabel pricesLabel = new JLabel("Цени:");
    private JTextArea pricesTextArea = new JTextArea();
    private JScrollPane productsPrices = new JScrollPane(pricesTextArea);
    private JLabel userChoice = new JLabel("Вие избрахте:");
    private JTextArea choiceTextArea = new JTextArea();
    private JScrollPane userScrollPane = new JScrollPane(choiceTextArea);
    private JButton buy = new JButton("Buy");
    private JButton remove = new JButton("Remove");
    private JButton finish = new JButton("Finish");

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
        container.add(userScrollPane);

        container.add(buy);
        buy.addActionListener(new buyEventListener());
        container.add(remove);
        remove.addActionListener(new removeEventListener());
        container.add(finish);
        finish.addActionListener(new finishEventListener());
    }

    private double sum = 0;

    class buyEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double applePrice = 2;
            double pearPrice = 2.2;
            double strawberryPrice = 3.1;
            double apricotPrice = 2.3;
            double peachPrice = 3;
            double pineapplePrice = 2.5;
            double plumPrice = 2.6;
            double orangePrice = 2.1;
            String selectedItem = (String) products.getSelectedItem();
            choiceTextArea.append(selectedItem + "\n");
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
            double applePrice = 2;
            double pearPrice = 2.2;
            double strawberryPrice = 3.1;
            double apricotPrice = 2.3;
            double peachPrice = 3;
            double pineapplePrice = 2.5;
            double plumPrice = 2.6;
            double orangePrice = 2.1;
            String selectedItem = (String) products.getSelectedItem();
            switch (selectedItem) {
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
        }
    }

    class finishEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tellSum = "Дължима сума: " + sum + "лв.";
            JOptionPane.showMessageDialog(null,tellSum,"Output",JOptionPane.PLAIN_MESSAGE);
        }
    }
}
