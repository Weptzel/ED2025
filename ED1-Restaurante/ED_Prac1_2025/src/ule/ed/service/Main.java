package ule.ed.service;

public class Main {
    public static void main(String[] args) {
        // Crear un servicio para una mesa con 4 personas y 2 niños
        Service service = new Service(4, 2);
        
        // Crear platos
        Dish dish1 = new Dish("Pizza", 1.0); // Un plato de pizza con precio 10.5
        Dish dish2 = new Dish("Pasta", 1.0);  // Un plato de pasta con precio 8.0
        
        // Agregar platos al servicio (mesa)
        service.getOrder().add(dish1);
        service.getOrder().add(dish2);
        
        // Establecer las cantidades de los platos
        dish1.setCount(1);  // 2 pizzas
        dish2.setCount(1);  // 3 pastas
        
        // Imprimir el servicio
        System.out.println("Servicio inicial: " + service.toString());
        
        // Obtener el total del servicio
        double total = service.getTotalService();
        System.out.println("Total del servicio: " + total);
        
        // Agregar otro plato
        Dish dish3 = new Dish("Ensalada", 1.0);  // Un plato de ensalada con precio 5.0
        dish3.setCount(1);  // 1 ensalada
        service.getOrder().add(dish3);  // Agregarlo al pedido
        
        // Imprimir el servicio después de agregar el nuevo plato
        System.out.println("Servicio después de agregar ensalada: " + service.toString());
        
        // Obtener el nuevo total del servicio
        double newTotal = service.getTotalService();
        System.out.println("Nuevo total del servicio: " + newTotal);
    }
}
