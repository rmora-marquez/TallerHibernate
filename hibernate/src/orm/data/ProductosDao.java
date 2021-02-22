package orm.data;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;


import org.hibernate.query.Query;
import orm.persistencia.Producto;

public class ProductosDao {
    private SessionFactory sessionFactory;
    private Session session;
    
    public ProductosDao(){      
      StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
      MetadataSources sources = new MetadataSources(registry);
      Metadata metadata = sources.getMetadataBuilder().build();
      sessionFactory = metadata.getSessionFactoryBuilder().build();
       
/*
StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()            
        .applySetting("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
        .applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/orm")
        .applySetting("hibernate.connection.username", "root")
        .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
        .applySetting("hibernate.show_sql", "true")
        .build();
Metadata metadata = new MetadataSources( standardRegistry )
    //.addAnnotatedClass( MyEntity.class )
    //.addAnnotatedClassName( "org.hibernate.example.Customer" )    
    .addResource( "orm/persistencia/producto.hbm.xml" )    
    .getMetadataBuilder().build();    
    sf = metadata.getSessionFactoryBuilder().build();
*/
/*
<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/orm?zeroDateTimeBehavior=convertToNull</property>
<property name="hibernate.connection.username">root</property>  
*/
        
     
    }
    
    public List<Producto> findAll(){
        session = sessionFactory.openSession();
        List<Producto> lista = null;
        Query<Producto> query = session.createQuery("SELECT p FROM Producto p",
                Producto.class);
        lista = query.list();
        session.close();
        return lista;                
        
    }
    
    public List<Producto> buscarPorPrecio(Double precio){
        session = sessionFactory.openSession();
        List<Producto> lista = null;
        String hql = "SELECT p FROM Producto p WHERE p.precio >= ?1";
        Query<Producto> query = session.createQuery(hql,
                Producto.class);
        query.setParameter(1, precio);
        lista = query.list();
        session.close();
        return lista;                        
    }
    
    public List<Producto> buscarOrdenAsc(){
        session = sessionFactory.openSession();
        List<Producto> lista = null;
        String hql = "SELECT p FROM Producto p "
                + " WHERE p.cantidad > 0"
                + " ORDER BY p.precio";
        Query<Producto> query = session.createQuery(hql,
                Producto.class);        
        lista = query.list();
        session.close();
        return lista;                        
    }
    
    public List<Producto> masHql(){
        session = sessionFactory.openSession();
        List<Producto> lista = null;
        String hql = "SELECT p FROM Producto p "
                + " WHERE p.cantidad > 0"
                + " ORDER BY p.precio";
        String hql2 = "Select p " + "from Producto p " 
                + " where e.precio " 
                + " Between 300 and 400";
        String hql3 = "SELECT p.nombre,p.precio FROM Producto p "
                + " WHERE p.nombre like %m%";
        String hql4 = "SELECT MAX(p.precio) FROM Producto p ";
        String hql5 = "SELECT UPPER(p.nombre) FROM Producto p ";
        
//        Query<Producto> query = session.createNamedQuery("Productos.findAll",
//                Producto.class);
        String sql = "SELECT * FROM PRODUCTOS";
         NativeQuery query2 = session.createNativeQuery(sql,
                Producto.class); 
        
        lista = query2.list();
        session.close();
        return lista;                        
    }
    
    
    
    public void getSession(){
        Session session = sessionFactory.openSession();    
        session.beginTransaction();
        try{        
            //... Código de base de datos
            // Alta, baja o modificiacion
            session.getTransaction().commit();
        
        } catch(Exception ex){
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void ejemploCrear(){
        //Creamos una entidad
        Producto prod = new Producto(105, "Cuarderno de Godzilla", 60.0, 25);
        Session session = sessionFactory.openSession();    
        session.beginTransaction();        
        session.save(prod); //<|--- Aqui guardamos el objeto en la base de datos.
        session.getTransaction().commit();
        session.close();
    }
    
    
    public void ejemploLeer(){        
        //Buscamos el id 101
        Integer id = 101;
        Session session = sessionFactory.openSession();    
        //No requiere transaccion -> session.beginTransaction();        
        Producto prod = session.get(Producto.class, id);
        System.out.println("id: " + prod.getId() + 
                ",nombre: " + prod.getNombre() + 
                ",cantidad: " + prod.getCantidad() + 
                ",precio: " + prod.getPrecio() );
        //No requiere transaccion -> session.getTransaction().commit();
        session.close();
    }
    
    public void ejemploActualizar(){        
        //Buscamos el id 101
        Integer id = 101;
        Session session = sessionFactory.openSession();    
        session.beginTransaction();        
        Producto prod = session.get(Producto.class, id);
        prod.setPrecio(200.0);
        session.update(prod);
        session.getTransaction().commit();
        session.close();
    }
    
    public void ejemploBorrar(){        
        //Buscamos el id 101
        Integer id = 101;
        Session session = sessionFactory.openSession();    
        session.beginTransaction();        
        Producto prod = session.get(Producto.class, id);
        session.delete(prod);
        session.getTransaction().commit();
        session.close();
    }
    
    
    
    
}
