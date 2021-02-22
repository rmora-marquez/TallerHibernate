package orm.data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import orm.dominio.Direccion;
import orm.dominio.Mercado;
import orm.dominio.Producto;
import orm.dominio.Rol;
import orm.dominio.Usuario;


public class RelacionesDao {
    private SessionFactory sessionFactory;
    
    public RelacionesDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
      sessionFactory = metadata.getSessionFactoryBuilder().build();
    }    
    
    public void ejemploUnoAUno(){
        Usuario usu = new Usuario("jj@email.com","jj010101", "Juan José", "Perez");
        Direccion dir = new Direccion("Benito juarez 45", "Col. Centro", "Oxaca", "Mexico");
        usu.setDireccion(dir);
        dir.setUsuario(usu);
        
        Session session = sessionFactory.openSession();    
        session.beginTransaction();                
        session.save(usu);
        session.getTransaction().commit();
        session.close();
    }
    
    public void ejemploUnoAMuchos(){
        Usuario usu = new Usuario("pp@email.com","pp010101", "Pedro", "Picapiedra");
        Direccion dir = new Direccion("25 pte 114", "Juarez", "Puebla", "Mexico");
        usu.setDireccion(dir);
        dir.setUsuario(usu);
        
        Rol rol1 = new Rol("CLIENTE", usu);
        Rol rol2 = new Rol("ADMIN", usu);
        List<Rol> roles = new ArrayList<>();
        roles.add(rol1); 
        roles.add(rol2);        
        usu.setRolList(roles);        
        
        Session session = sessionFactory.openSession();    
        session.beginTransaction();                
        session.save(usu);
        session.getTransaction().commit();
        session.close();
    }
    
    public void ejemploMuchosAMuchos(){
        Producto prod1 = new Producto("Salero de cristal",88.5, 15);
        Producto prod2 = new Producto("Pimentero de cristal", 88.5, 15);
        Mercado mer1 = new Mercado("China");
        Mercado mer2 = new Mercado("Corea");
        
        List<Producto> prodLista = new ArrayList<>();
        prodLista.add(prod1);
        prodLista.add(prod2);
        List<Mercado> merLista = new ArrayList<>();
        merLista.add(mer1);
        merLista.add(mer2);
        
        prod1.setMercadoList(merLista);
        prod2.setMercadoList(merLista);
        
        mer1.setProductoList(prodLista);
        mer2.setProductoList(prodLista);
                
        Session session = sessionFactory.openSession();    
        session.beginTransaction();                
        session.save(prod1);
        session.save(prod2);
        session.getTransaction().commit();
        session.close();
    }
}
