import src.Cart;
import src.Category;
import src.Product;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
  public static void main(String[] args) {
    Cart cart = new Cart();
    JFrame frame = new JFrame("Productos");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTextArea textArea = new JTextArea(20, 20);
    JScrollPane scrollPane = new JScrollPane(textArea);
    textArea.setEditable(false);

    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(0, 1));

    Product product1 = new Product("Cerave", 970, "Limpia profundamente y refresca la piel mientras remueve el exceso de grasa y maquillaje, ayudando a restaurar la barrera natural de la piel ", new Category("Belleza"));
    JButton button1 = new JButton("Agregar");
    button1.setPreferredSize(new Dimension(100, 30));
    product1.addToCart(button1, cart);
    panel.add(new JLabel("Product name: " + product1.getName()));
    panel.add(new JLabel("Price: $" + product1.getPrice()));
    panel.add(new JLabel("Description: " + product1.getDescription()));
    panel.add(new JLabel("Category: " + product1.getCategory().getName()));
    panel.add(button1);

    Product product2 = new Product("Pescado", 37.50, "Filete de pescado", new Category("Comestibles"));
    JButton button2 = new JButton("Agregar");
    button2.setPreferredSize(new Dimension(100, 30));
    product2.addToCart(button2, cart);
    panel.add(new JLabel("Product name: " + product2.getName()));
    panel.add(new JLabel("Price: $" + product2.getPrice()));
    panel.add(new JLabel("Description: " + product2.getDescription()));
    panel.add(new JLabel("Category: " + product2.getCategory().getName()));
    panel.add(button2);

    Product product3 = new Product("Pechuga", 107.73, "Pechuga de pollo sin piel", new Category("Comestibles"));
    JButton button3 = new JButton("Agregar");
    button1.setPreferredSize(new Dimension(100, 30));
    product1.addToCart(button3, cart);
    panel.add(new JLabel("Product name: " + product3.getName()));
    panel.add(new JLabel("Price: $" + product3.getPrice()));
    panel.add(new JLabel("Description: " + product3.getDescription()));
    panel.add(new JLabel("Category: " + product3.getCategory().getName()));
    panel.add(button3);

    Product product4 = new Product("Ace", 119.52, "Ace Limpieza Completa es un detergente en polvo que puede ser utilizado para lavar tanto la ropa blanca como la ropa de color", new Category("Limpieza"));
    JButton button4 = new JButton("Agregar");
    button4.setPreferredSize(new Dimension(100, 30));
    product4.addToCart(button4, cart);
    panel.add(new JLabel("Product name: " + product4.getName()));
    panel.add(new JLabel("Price: $" + product4.getPrice()));
    panel.add(new JLabel("Description: " + product4.getDescription()));
    panel.add(new JLabel("Category: " + product4.getCategory().getName()));
    panel.add(button4);
    
    Product product5 = new Product("Fabuloso", 369, "Fabuloso frescura activa antibacterial aroma lavanda fresca", new Category("Limpieza"));
    JButton button5 = new JButton("Agregar");
    button5.setPreferredSize(new Dimension(100, 30));
    product5.addToCart(button5, cart);
    panel.add(new JLabel("Product name: " + product5.getName()));
    panel.add(new JLabel("Price: $" + product5.getPrice()));
    panel.add(new JLabel("Description: " + product5.getDescription()));
    panel.add(new JLabel("Category: " + product5.getCategory().getName()));
    panel.add(button5);
    
    Product product6 = new Product("Protector Solar Facial La Roche Posay Anthelios", 481, "UVMUNE Fluido Invisible para todo tipo de piel FPS50+", new Category("Belleza"));
    JButton button6 = new JButton("Agregar");
    button6.setPreferredSize(new Dimension(100, 30));
    product6.addToCart(button6, cart);
    panel.add(new JLabel("Product name: " + product6.getName()));
    panel.add(new JLabel("Price: $" + product6.getPrice()));
    panel.add(new JLabel("Description: " + product6.getDescription()));
    panel.add(new JLabel("Category: " + product6.getCategory().getName()));
    panel.add(button6);

    // genera 5 productos más
    // for (int i = 7; i <= 11; i++) {
    //   Product product = new Product("Producto " + i, i * 10.0, "Descripción del producto " + i, new Category("Categoría " + i));
    //   JButton button = new JButton("Agregar");
    //   button.setPreferredSize(new Dimension(100, 30));
    //   product.addToCart(button, cart);
    //   panel.add(new JLabel(product.getName()));
    //   panel.add(new JLabel("$" + product.getPrice()));
    //   panel.add(new JLabel(product.getDescription()));
    //   panel.add(new JLabel(product.getCategory().getName()));
    //   panel.add(button);
    // }

    frame.add(panel, BorderLayout.CENTER);

    JPanel cartPanel = new JPanel();
    cartPanel.setLayout(new GridLayout(0, 1));
    cartPanel.setPreferredSize(new Dimension(150, 400));
    frame.add(cartPanel, BorderLayout.EAST);

    JButton showCartButton = new JButton("Carrito");
    showCartButton.setPreferredSize(new Dimension(100, 30));
    showCartButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        List<Product> products = cart.getProducts();
        StringBuilder sb = new StringBuilder();
        double total = 0.0;
      for (Product product : products) {
        sb.append(product.getName() + " - $" + product.getPrice() + "\n");
        total += product.getPrice();
      }
      sb.append("Total: $" + total);
      textArea.setText(sb.toString());
      JOptionPane.showMessageDialog(frame, scrollPane, "Productos en el carrito", JOptionPane.INFORMATION_MESSAGE);
      }
    });
    cartPanel.add(showCartButton);

    frame.setVisible(true);
  }
}