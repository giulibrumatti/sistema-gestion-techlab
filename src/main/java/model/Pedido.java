package model;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Producto> listProduct;

    public Pedido() {
        listProduct = new ArrayList<>();
    }

    public Pedido(ArrayList<Producto> listProduct) {
        this.listProduct = listProduct;
    }

    public Producto searchForId(Integer id){
        for(Producto pro : listProduct){
            if(pro.getId().equals(id)){
                return pro;
            }
        }
        return null;
    }

    public void addProduct(Producto product){
        this.listProduct.add(product);
    }

    public void deleteProductById(Integer id){
        this.listProduct.remove(searchForId(id));
    }

    public String editProduct(Integer id, String name, Double cost, Integer stock){
        Producto pro = searchForId(id);
        pro.setName(name);
        pro.setCost(cost);
        pro.setStock(stock);
        return pro.toString();
    }

    public void seeOrder(){
        for (Producto pro : listProduct){
            pro.displayInfo();
        }
    }

    public ArrayList<Producto> getListProduct() {
        return listProduct;
    }

    public Double totalAmount(){
        Double amount = 0.0;
        for (Producto pro : listProduct){
            amount = amount + pro.getCost();
        }
        return amount;
    }

    public void setListProduct(ArrayList<Producto> listProduct) {
        this.listProduct = listProduct;
    }
}
