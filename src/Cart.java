package src;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private List<Product> products = new ArrayList<Product>();

  public void addProduct(Product product) {
    products.add(product);
  }

  public List<Product> getProducts() {
    return products;
  }

  /* Creditos por la función getTotal a Carmi 
    La idea de la suma la obtube por Carmi, cuando me mencionó el simbolo sigma (Σ) 
   */
  public int getTotal() {
    int total = 0;
    for (Product product : products) {
      total += product.getPrice();
    }
    return total;
  }
}
