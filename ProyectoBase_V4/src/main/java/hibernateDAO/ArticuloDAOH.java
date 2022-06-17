package hibernateDAO;

import hibernate.Articulo;
import hibernate.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class ArticuloDAOH {
    public void create(Articulo a){
        
        //Primero que nada, crear una sesión
        Session session= HibernateUtil.getSessionFactory().getCurrentSession(); //ya tenemos la sesión
        
        //Necesitamos la transacción
        Transaction transaction= session.getTransaction();  //getTransaction es un tipo de EntityTransaction
        
        try{
            
            //Recibimos un alumno que ya se lleno en algún lugar
//            session.save(a);    //El tachado significa que el método es DEPRECIADO 
                                //En pocas palabras, ocupa otro método
                                
            transaction.begin();    //Ya me funcionará el CATCH
            session.persist(a); //Mismo método que el JPA 
            //session.merge(a);   //ACTUALIZAR
            //session.remove(a);    //ELIMINAR  
            
            transaction.commit();
        }catch(HibernateException he){
            
            if(transaction.isActive() && transaction!=null){    // Con HIBERNATE nos toca hacer la gestión de l
                                                                // la transacción
                transaction.rollback();
            }
        }

    }
    
    public void delete(Articulo a){
        
        //Primero que nada, crear una sesión
        Session session= HibernateUtil.getSessionFactory().getCurrentSession(); //ya tenemos la sesión
        
        //Necesitamos la transacción
        Transaction transaction= session.getTransaction();  //getTransaction es un tipo de EntityTransaction
        
        try{
            
            transaction.begin();    //Ya me funcionará el CATCH
//            session.persist(a); //Mismo método que el JPA 
            //session.merge(a);   //ACTUALIZAR
            session.remove(a);    //ELIMINAR  
            
            transaction.commit();
        }catch(HibernateException he){
            
            if(transaction.isActive() && transaction!=null){    // Con HIBERNATE nos toca hacer la gestión de l
                                                                // la transacción
                transaction.rollback();
            }
        }

    }
    
    public void update(Articulo a){
        
        //Primero que nada, crear una sesión
        Session session= HibernateUtil.getSessionFactory().getCurrentSession(); //ya tenemos la sesión
        
        //Necesitamos la transacción
        Transaction transaction= session.getTransaction();  //getTransaction es un tipo de EntityTransaction
        
        try{
            
            transaction.begin();    //Ya me funcionará el CATCH
//            session.persist(a); //Mismo método que el JPA 
              session.merge(a);   //ACTUALIZAR
//            session.remove(a);    //ELIMINAR  
            
            transaction.commit();
        }catch(HibernateException he){
            
            if(transaction.isActive() && transaction!=null){    // Con HIBERNATE nos toca hacer la gestión de l
                                                                // la transacción
                transaction.rollback();
            }
        }

    }
    
    
    public List readAll(){
        
        Session session= HibernateUtil.getSessionFactory().getCurrentSession(); 
        Transaction transaction= session.getTransaction();
        List resultados=  new ArrayList();
        
        try{
            transaction.begin();    
            
            //PARA UN SELECT ONE
            
//            a= (Alumno)session.get(Alumno,a.getId());
            
            
            //Query de Hibernate, asegurarse de eso, ver línea 8
            Query q= session.createQuery("from Articulo",Articulo.class);   //técnicamente es un JPA modificado
            resultados=q.list();
            
            
            transaction.commit();
        }catch(HibernateException he){
            
            if(transaction.isActive() && transaction!=null){    // Con HIBERNATE nos toca hacer la gestión de l
                                                                // la transacción
                transaction.rollback();
            }
        }
        
        return resultados;
    }
    
    
    public Articulo read(Articulo c){
        
        Session session= HibernateUtil.getSessionFactory().getCurrentSession(); 
        Transaction transaction= session.getTransaction();
        List resultados=  new ArrayList();
        
        try{
            transaction.begin();    
            
            //PARA UN SELECT ONE
            
            c= (Articulo)session.get(Articulo.class,c.getIdArticulo());
 
            transaction.commit();
        }catch(HibernateException he){
            
            if(transaction.isActive() && transaction!=null){    // Con HIBERNATE nos toca hacer la gestión de l
                                                                // la transacción
                transaction.rollback();
            }
        }
        
        return c;
    }
    
    
        public static void main(String[] args) {
        Articulo c= new Articulo();
        ArticuloDAOH dao=new ArticuloDAOH();
        
        // ---> INSERTAR <----
//        c.setNombreArticulo("Z");
//        c.setDescripcionArticulo("Z");
//        c.setExistencias(0);
//        c.setStockMinimo(0);
//        c.setStockMaximo(0);
//        c.setPrecio(0);
//        c.setIdCategoria(13); 
//        dao.create(c);
        

        // ---> LISTAR <----
//       System.out.println(dao.readAll());

        // ---> LISTAR UNO <----
//        c.setIdArticulo(6);
//        System.out.println(dao.read(c));
        

        // ---> DELETE <---
        //PARA QUE SE ELIMINE, TODOS LOS CAMPOS DEBEN DE ESTAR CON ALGÚN VALOR, NO IMPORTA CUÁL
//        c.setIdArticulo(18);
//        c.setDescripcionArticulo("");
//        c.setExistencias(0);
//        c.setIdCategoria(0);
//        c.setNombreArticulo("");
//        c.setPrecio(0d);
//        c.setStockMaximo(0);
//        c.setStockMinimo(0);
//        dao.delete(c);


        // ---> UPDATE <---
        //PARA QUE SE ELIMINE, TODOS LOS CAMPOS DEBEN DE ESTAR CON ALGÚN VALOR, NO IMPORTA CUÁL
//        c.setIdArticulo(12);
//        c.setDescripcionArticulo("B");
//        c.setExistencias(0);
//        c.setIdCategoria(13);
//        c.setNombreArticulo("B");
//        c.setPrecio(0d);
//        c.setStockMaximo(0);
//        c.setStockMinimo(0);
//        dao.update(c);
        
        
    }
    
}
