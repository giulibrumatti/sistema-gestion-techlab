package model;

import java.text.Normalizer;

public class Producto {
    private static Integer SIGUIENTE_ID = 1;
    private Integer id;
    private String name;

    private Integer stock;
    private Double cost;

    private Integer amountBuy;

    public Producto(){

    }

    public Producto(String name, Double cost, Integer stock) {
        this.name = name;
        this.stock = stock;
        this. cost = cost;
        this.amountBuy = 0;
        this.id = SIGUIENTE_ID;
        SIGUIENTE_ID++;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getCost() {
        return cost;
    }

    public Integer subtractStock(Integer amount){
        this.stock = this.stock - amount;
        return this.stock;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean containsName(String search){
        String nameLowerCase = this.name.toLowerCase();
        nameLowerCase = this.normalizeWord(nameLowerCase);
        search = this.normalizeWord(search);
        return nameLowerCase.contains(search.toLowerCase());
    }

    protected String normalizeWord(String word) {

        String normalize = Normalizer.normalize(word, Normalizer.Form.NFD);

        return normalize.replaceAll("\\p{M}", "");
    }


    public void displayInfo() {
        System.out.println("#########################");
        System.out.printf("""
                Id: %s
                Nombre: %s
                Precio: %s
                Stock: %s
                """, this.id, this.name, this.cost, this.stock);
        System.out.println("#########################");
    }
}
