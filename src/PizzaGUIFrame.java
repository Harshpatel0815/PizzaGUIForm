import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PizzaGUIFrame extends JFrame
{
    private JPanel mainPanel, titlePanel, crustPanel, crustPanelSmall, sizePanel, toppingsPanel, toppingsPanelSmall, displayPanel, buttonPanel;
    private JLabel titleLabel, crustLabel, sizeLabel,toppingLabel;
    private ButtonGroup crustButtons;
    private JRadioButton thinButton, regularButton, deepdishButton;
    private JComboBox sizeBox;
    private JCheckBox pepperoniBox, sausageBox, mushroomBox, baconBox, peppersBox, mozzarellaBox;
    private JTextArea receiptText;
    private JScrollPane receiptScroll;
    private JButton orderButton, clearButton, quitButton;
    private ActionListener quit = new quitListener();
    private ActionListener order = new orderListener();
    private ActionListener clear = new clearListener();

    private String crustSelect, sizeSelect, receipt;
    private String[] sizeList;
    private ArrayList<String> selectedToppings;
    private double total, subtotal, tax, sizePrice;

    PizzaGUIFrame()
    {
        setTitle("Pizza Order");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        titlePanel = new JPanel();
        crustPanel = new JPanel();
        crustPanelSmall = new JPanel();
        sizePanel = new JPanel();
        toppingsPanel = new JPanel();
        toppingsPanelSmall = new JPanel();
        displayPanel = new JPanel();
        buttonPanel = new JPanel();

        titleLabel = new JLabel("Pizza Order Form");
        crustLabel = new JLabel("Crust");
        sizeLabel = new JLabel("Size");
        toppingLabel = new JLabel("Toppings");

        crustButtons = new ButtonGroup();
        thinButton = new JRadioButton("Thin");
        thinButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        regularButton = new JRadioButton("Regular");
        regularButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        deepdishButton = new JRadioButton("Deep Dish");
        deepdishButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        String[] sizeList = {"Small", "Medium", "Large", "Super"};
        sizeBox = new JComboBox(sizeList);
        sizeBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        pepperoniBox = new JCheckBox("Pepperoni");
        pepperoniBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        sausageBox = new JCheckBox("Sausage");
        sausageBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        mushroomBox = new JCheckBox("Mushroom");
        mushroomBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        baconBox = new JCheckBox("Bacon");
        baconBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        peppersBox = new JCheckBox("Peppers");
        peppersBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        mozzarellaBox = new JCheckBox("Extra Mozzarella");
        mozzarellaBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        receiptText = new JTextArea(10,50);
        receiptScroll = new JScrollPane(receiptText);

        orderButton = new JButton("Order");
        orderButton.addActionListener(order);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(clear);
        quitButton = new JButton("Quit");
        quitButton.addActionListener(quit);

        selectedToppings = new ArrayList<String>();

        add(mainPanel);
        mainPanel.setLayout(new GridLayout(6,1));

        mainPanel.add(titlePanel);
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.add(titleLabel);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));

        mainPanel.add(crustPanel);
        crustPanel.setLayout(new GridLayout(2,1));
        crustPanel.add(crustLabel);
        crustLabel.setHorizontalAlignment(JLabel.CENTER);
        crustLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        crustPanel.add(crustPanelSmall);
        crustPanelSmall.setLayout(new GridLayout(1,3));
        crustButtons.add(thinButton);
        crustButtons.add(regularButton);
        crustButtons.add(deepdishButton);
        crustPanelSmall.add(thinButton);
        crustPanelSmall.add(regularButton);
        crustPanelSmall.add(deepdishButton);

        mainPanel.add(sizePanel);
        sizePanel.setLayout(new GridLayout(2,1));
        sizePanel.add(sizeLabel);
        sizeLabel.setHorizontalAlignment(JLabel.CENTER);
        sizeLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        sizePanel.add(sizeBox);

        mainPanel.add(toppingsPanel);
        toppingsPanel.setLayout(new GridLayout(2,1));
        toppingsPanel.add(toppingLabel);
        toppingLabel.setHorizontalAlignment(JLabel.CENTER);
        toppingLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        toppingsPanel.add(toppingsPanelSmall);
        toppingsPanelSmall.setLayout(new GridLayout(2,3));
        toppingsPanelSmall.add(pepperoniBox);
        toppingsPanelSmall.add(sausageBox);
        toppingsPanelSmall.add(mushroomBox);
        toppingsPanelSmall.add(baconBox);
        toppingsPanelSmall.add(peppersBox);
        toppingsPanelSmall.add(mozzarellaBox);

        mainPanel.add(displayPanel);
        displayPanel.add(receiptScroll);

        mainPanel.add(buttonPanel);
        buttonPanel.add(orderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(quitButton);

    }

    private class orderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            if(thinButton.isSelected())
            {
                crustSelect = "Thin Crust";
            }
            else if(regularButton.isSelected())
            {
                crustSelect = "Regular Crust";
            }
            else if(deepdishButton.isSelected())
            {
                crustSelect = "Deep Dish Crust";
            }
            else
            {
                crustSelect = "none";
            }

            sizeSelect = sizeBox.getSelectedItem().toString();
            if(sizeSelect.equals("Small"))
            {
                sizePrice = 8;
                subtotal += sizePrice;
            }
            else if(sizeSelect.equals("Medium"))
            {
                sizePrice = 12;
                subtotal += sizePrice;
            }
            else if(sizeSelect.equals("Large"))
            {
                sizePrice = 16;
                subtotal += sizePrice;
            }
            else if(sizeSelect.equals("Super"))
            {
                sizePrice = 20;
                subtotal += sizePrice;
            }
            else
            {
                sizePrice = 0;
                subtotal += sizePrice;
            }

            if(pepperoniBox.isSelected())
            {
                subtotal += 1;
                selectedToppings.add("Pepperoni");
            }
            if(sausageBox.isSelected())
            {
                subtotal += 1;
                selectedToppings.add("Sausage");
            }
            if(mushroomBox.isSelected())
            {
                subtotal += 1;
                selectedToppings.add("Mushrooms");
            }
            if(baconBox.isSelected())
            {
                subtotal += 1;
                selectedToppings.add("Bacon");
            }
            if(peppersBox.isSelected())
            {
                subtotal += 1;
                selectedToppings.add("Peppers");
            }
            if(mozzarellaBox.isSelected())
            {
                subtotal += 1;
                selectedToppings.add("Extra Mozzarella");
            }
            tax = subtotal * 0.07;
            total = subtotal + tax;
            if(selectedToppings.size() == 0){
                receipt = String.format("==============================\n"
                                + "%s, %s             %.2f\n\n"
                                + "Sub-total:            %.2f\n"
                                + "Tax:             %.2f\n"
                                + "------------------------------\n"
                                + "Total:             %.2f\n"
                                + "==============================",
                        crustSelect, sizeSelect, sizePrice, subtotal, tax, total);
            }
            else if(selectedToppings.size() == 1){
                receipt = String.format("==============================\n"
                                + "%s, %s             %.2f\n"
                                + "%s             1.00\n\n"
                                + "Sub-total:             %.2f\n"
                                + "Tax:             %.2f\n"
                                + "------------------------------\n"
                                + "Total:             %.2f\n"
                                + "==============================",
                        crustSelect, sizeSelect, sizePrice, selectedToppings.get(0),  subtotal, tax, total);
            }
            else if(selectedToppings.size() == 2){
                receipt = String.format("==============================\n"
                                + "%s, %s             %.2f\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n\n"
                                + "Sub-total:             %.2f\n"
                                + "Tax:             %.2f\n"
                                + "------------------------------\n"
                                + "Total:             %.2f\n"
                                + "==============================",
                        crustSelect, sizeSelect, sizePrice, selectedToppings.get(0), selectedToppings.get(1), subtotal, tax, total);
            }
            else if(selectedToppings.size() == 3){
                receipt = String.format("==============================\n"
                                + "%s, %s             %.2f\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n\n"
                                + "Sub-total:            %.2f\n"
                                + "Tax:             %.2f\n"
                                + "------------------------------\n"
                                + "Total:             %.2f\n"
                                + "==============================",
                        crustSelect, sizeSelect, sizePrice, selectedToppings.get(0), selectedToppings.get(1), selectedToppings.get(2), subtotal, tax, total);
            }
            else if(selectedToppings.size() == 4){
                receipt = String.format("==============================\n"
                                + "%s, %s             %.2f\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n\n"
                                + "Sub-total:            %.2f\n"
                                + "Tax:             %.2f\n"
                                + "------------------------------\n"
                                + "Total:             %.2f\n"
                                + "==============================",
                        crustSelect, sizeSelect, sizePrice, selectedToppings.get(0), selectedToppings.get(1), selectedToppings.get(2), selectedToppings.get(3), subtotal, tax, total);
            }
            else if(selectedToppings.size() == 5){
                receipt = String.format("==============================\n"
                                + "%s, %s             %.2f\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n\n"
                                + "Sub-total:             %.2f\n"
                                + "Tax:             %.2f\n"
                                + "------------------------------\n"
                                + "Total:             %.2f\n"
                                + "==============================",
                        crustSelect, sizeSelect, sizePrice, selectedToppings.get(0), selectedToppings.get(1), selectedToppings.get(2), selectedToppings.get(3), selectedToppings.get(4), subtotal, tax, total);
            }
            else if(selectedToppings.size() == 6){
                receipt = String.format("==============================\n"
                                + "%s, %s             %.2f\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n"
                                + "%s             1.00\n\n"
                                + "Sub-total:             %.2f\n"
                                + "Tax:             %.2f\n"
                                + "------------------------------\n"
                                + "Total:             %.2f\n"
                                + "==============================",
                        crustSelect, sizeSelect, sizePrice, selectedToppings.get(0), selectedToppings.get(1), selectedToppings.get(2), selectedToppings.get(3), selectedToppings.get(4), selectedToppings.get(5), subtotal, tax, total);
            }
            receiptText.append(receipt);

        }
    }

    private class clearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            crustButtons.clearSelection();
            sizeBox.setSelectedItem("");
            pepperoniBox.setSelected(false);
            sausageBox.setSelected(false);
            mushroomBox.setSelected(false);
            baconBox.setSelected(false);
            peppersBox.setSelected(false);
            mozzarellaBox.setSelected(false);
            receiptText.setText(null);
            subtotal = 0;
            total = 0;
            selectedToppings.clear();
        }
    }

    private class quitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }
}