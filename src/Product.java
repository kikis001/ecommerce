package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Product {
  private String name;
  private double price;
  private String description;
  private Category category;

  public Product(String name, double price, String description, Category category) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public Category getCategory() {
    return category;
  }

  public void addToCart(JButton button, final Cart cart) {
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cart.addProduct(Product.this);
      }
    });
  }
}
