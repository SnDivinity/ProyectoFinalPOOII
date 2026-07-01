package hotel.model;

// 1. La interfaz principal (el archivo debe llamarse igual que esta interfaz)
public interface IServicioFactory {
    ServicioExtra crearServicio(int id, String nom, String desc, double precio);
}

// 2. Primera fábrica concreta
class AlimentoFactory implements IServicioFactory {
    @Override
    public ServicioExtra crearServicio(int id, String nom, String desc, double precio) {
        return new ServicioExtra(id, nom, desc, precio, TipoServicio.RESTAURANTE);
    }
}

// 3. Segunda fábrica concreta
class BienestarFactory implements IServicioFactory {
    @Override
    public ServicioExtra crearServicio(int id, String nom, String desc, double precio) {
        return new ServicioExtra(id, nom, desc, precio, TipoServicio.SPA);
    }
}

// 4. Tercera fábrica concreta
class LogisticaFactory implements IServicioFactory {
    @Override
    public ServicioExtra crearServicio(int id, String nom, String desc, double precio) {
        return new ServicioExtra(id, nom, desc, precio, TipoServicio.LAVANDERIA);
    }
}