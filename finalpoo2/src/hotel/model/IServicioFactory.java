package hotel.model;


public interface IServicioFactory {
    ServicioExtra crearServicio(int id, String nom, String desc, double precio);
}


class AlimentoFactory implements IServicioFactory {
    @Override
    public ServicioExtra crearServicio(int id, String nom, String desc, double precio) {
        return new ServicioExtra(id, nom, desc, precio, TipoServicio.RESTAURANTE);
    }
}


class BienestarFactory implements IServicioFactory {
    @Override
    public ServicioExtra crearServicio(int id, String nom, String desc, double precio) {
        return new ServicioExtra(id, nom, desc, precio, TipoServicio.SPA);
    }
}


class LogisticaFactory implements IServicioFactory {
    @Override
    public ServicioExtra crearServicio(int id, String nom, String desc, double precio) {
        return new ServicioExtra(id, nom, desc, precio, TipoServicio.LAVANDERIA);
    }
}