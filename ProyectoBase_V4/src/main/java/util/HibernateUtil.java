package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibernateUtil {

    //Necesitamos un mecanismo de REGISTRO: alguien que permita registrar una funcionalidad y lo ponga a 
    //disposicón del proyecto 
    private static StandardServiceRegistry registry;
    
    //Alguien que permita devolver un section factory
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
                //Configuramos el registro 
              registry = new StandardServiceRegistryBuilder().
                      configure("hibernate.cfg.xml").build();   //Nombre del archivo de configuración XML del HIBERNATE, asume que se encuentra en la raíz /src/main/resources/defaultpackage
                                                                //Si se quiere poner en otro paquete que no sea el default
                                                                //aquí le debemos poner, configure("nombreDelPaquete(tal vez remplazar puntos con diagonales)/hibernate.cfg.mx")
                MetadataSources ms = new MetadataSources(registry);
                Metadata m  = ms.getMetadataBuilder().build();
                sessionFactory = m.getSessionFactoryBuilder().build();
                
            }catch(Exception e){
                e.printStackTrace();
                if(registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}