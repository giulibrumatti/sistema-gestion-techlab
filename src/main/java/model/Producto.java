package model;

public class Producto {
    private Long id;
    private String name;

    private Integer stock;
    private Double cost;

    public Producto(){

    }

    public Producto(Long id, String name, Double cost, Integer stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this. cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
