import model.Pedido;
import model.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestionMain {
    public static void main(String[] args) {
        ArrayList<Producto> products = new ArrayList<>();
        addProductExample(products);

        ArrayList<Pedido> orders = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int optionUser = 0;
        do {
            try{
                System.out.println("""
              Menu principal:
                1) Agregar producto
                2) Listar productos
                3) Buscar/Actualizar producto
                4) Eliminar producto
                5) Crear un pedido
                6) Listar pedidos
                7) Salir
              
              Elija una opción:
              """);
                optionUser = input.nextInt();

                switch (optionUser){
                    case 1 -> addProduct(products);
                    case 2 -> listProducts(products);
                    case 3 -> searchProduct(products);
                    case 4 -> deleteProduct(products);
                    case 5 -> createOrder(orders, products);
                    case 6 -> listOrder(orders);
                    case 7 -> System.out.println("Gracias por usar la app!");
                    default -> System.out.println("Opcion incorrecta");
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Hubo un error inesperado");
            }
        }while (optionUser != 7);

    }

    public static void createOrder(ArrayList<Pedido> orders, ArrayList<Producto> products) {
        Pedido order = new Pedido();
        Scanner input = new Scanner(System.in);

        System.out.println("🛒 Menú para agregar un pedido:");
        listProducts(products);

        boolean nextSelect = true;
        while (nextSelect) {
            System.out.println("Seleccione el ID del producto a agregar al pedido:");
            String idSelect = input.nextLine();

            try {
                int idParse = Integer.parseInt(idSelect);
                Producto productoSeleccionado = null;

                // Buscar producto por ID
                for (Producto product : products) {
                    if (product.getId().equals(idParse)) {
                        productoSeleccionado = product;
                        break;
                    }
                }

                if (productoSeleccionado != null) {
                    System.out.println("➡️ Producto seleccionado:");
                    productoSeleccionado.displayInfo();

                    if (confirmarAccion(input, "¿Confirma la acción?")) {
                        order.addProduct(productoSeleccionado);
                        System.out.println("✅ Producto agregado al pedido.");
                    }

                    nextSelect = confirmarAccion(input, "¿Desea continuar con la selección de productos?");
                } else {
                    System.out.println("❌ No se encontró un producto con ese ID.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Eso no es un número válido.");
            }
        }

        orders.add(order);
        System.out.println("☣ Pedido cargado exitosamente");
    }
    public static boolean confirmarAccion(Scanner input, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            System.out.println("1 - Sí");
            System.out.println("2 - No");

            String seleccion = input.nextLine();
            if (seleccion.equals("1")) return true;
            if (seleccion.equals("2")) return false;

            System.out.println("⚠️ Opción inválida. Ingrese 1 o 2.");
        }
    }

    private static void listOrder(ArrayList<Pedido> orders){
        if (orders.isEmpty()){
            System.out.println("No hay pedido todavia :(");
        }else {
            for (Pedido order : orders){
                order.seeOrder();
            }
        }
    }



    private static void searchProduct(ArrayList<Producto> products) {
        System.out.println("Buscador de productos: ");
        Scanner input = new Scanner(System.in);
        String search = input.nextLine();
        ArrayList<Producto> productsFound = new ArrayList<>();

        for (Producto product : products){
            if (product.containsName(search)){
                productsFound.add(product);
            }
        }

        if (productsFound.isEmpty()){
            System.out.println("No encontramos productos....");
        }else{
            for (Producto product : productsFound){
                product.displayInfo();
            }
        }
    }

    private static void listProducts(ArrayList<Producto> products) {
        if (products.isEmpty()){
            System.out.println("No hay producto todavia :(");
        }else {
            for (Producto product : products){
                product.displayInfo();
            }
        }
    }

    public static void addProduct(ArrayList<Producto> productos){
        Scanner input = new Scanner(System.in);
        System.out.println("Menu para agregar un producto:");
        System.out.println("Ingrese el nombre del producto: ");
        String name = input.nextLine();
        System.out.printf("Ingrese el precio de %s: ", name);
        double cost = input.nextDouble();
        System.out.printf("Ingrese el stock de %s: ", name);
        int stock = input.nextInt();
        Producto producto = new Producto(name, cost, stock);

        productos.add(producto);

        System.out.println("☣ Producto cargado exitosamente! ☣");
    }

    public static void addProductExample(ArrayList<Producto> productos) {
        productos.add(new Producto("Monitor", 1000.0, 10));
        productos.add(new Producto("Micrófono", 2000.0, 10));
        productos.add(new Producto("Teclado mecánico", 1500.0, 15));
        productos.add(new Producto("Mouse gamer", 1200.0, 20));
        productos.add(new Producto("Laptop", 1500.0, 5));
        productos.add(new Producto("Tablet", 800.0, 7));
        productos.add(new Producto("Disco duro externo", 250.0, 12));
        productos.add(new Producto("Memoria USB 64GB", 50.0, 25));
        productos.add(new Producto("Router Wi-Fi", 180.0, 10));
        productos.add(new Producto("Smartphone", 1200.0, 8));
        productos.add(new Producto("Audífonos Bluetooth", 220.0, 18));
        productos.add(new Producto("Cámara Web HD", 130.0, 10));
        productos.add(new Producto("Impresora", 400.0, 6));
        productos.add(new Producto("Proyector", 900.0, 4));
        productos.add(new Producto("Reproductor multimedia", 300.0, 9));
        productos.add(new Producto("Smartwatch", 350.0, 11));
        productos.add(new Producto("Lector de tarjetas", 80.0, 14));
        productos.add(new Producto("Estabilizador de voltaje", 110.0, 10));
        productos.add(new Producto("Cable HDMI", 30.0, 30));
        productos.add(new Producto("Panel táctil USB", 200.10, 5));
    }

    private static void deleteProduct(ArrayList<Producto> products) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el ID del producto a eliminar: ");
        int idDelete = input.nextInt();
        boolean isDelete = false;
        boolean isFound = false;
        for (Producto product : products) {
            if (product.getId() == idDelete) {
                isFound = true;
                System.out.println("El producto que quiere eliminar es el siguiente: ");
                product.displayInfo();
                System.out.println("Confirma la accion?");
                System.out.println("1 - SI");
                System.out.println("2 - NO");
                int optionDelete = input.nextInt();
                if (optionDelete == 1) {
                    System.out.println("ELIMINANDO");
                    products.remove(product);
                    isDelete = true;
                    break;
                }
            }
        }
    }
}
