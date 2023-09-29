package com.uptc.frw;

import com.uptc.frw.entity.Categoria;
import com.uptc.frw.entity.Estante;
import com.uptc.frw.entity.Mueble;
import com.uptc.frw.entity.Pieza;
import com.uptc.frw.persistence.PersistenceUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;


public class Principal {


    public static void main(String[] args) {
       // insertarEnBaseDeDatos();
       // obtenerListaPiezasMueble(1L);
        //obtenerListaEstantesMueble(1L);
       //obtenerListaMueblesPorCategoria(2L);
     //  removerListaMueblesPorCategoria(2L);
        consultarMueblesIdPar();
    }

    public static void consultarMueblesIdPar() {
        EntityManager em = PersistenceUtil.getEntityManager();
        List<Object[]> objects = em.createQuery("SELECT m.nombreMueble, c.nombreCategoria FROM Mueble m JOIN m.categoria c WHERE m.id % 2=0",
                Object[].class
        ).getResultList();

        recorreListaObj(objects);
    }
    public static void recorreListaObj(List<Object[]> objects){
        for (Object[] o : objects){
            for (Object h : o){
                System.out.print(h+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Resultados "+ objects.size());
    }
    public static void removerListaMueblesPorCategoria(Long idCategoria){
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Categoria categoria= em.find(Categoria.class,idCategoria);

        for (int i = 0; i < categoria.getListaMuebles().size(); i++) {
            Mueble mueble = em.find(Mueble.class, categoria.getListaMuebles().get(i).getIdMueble());
            System.out.println("Se elimino el mueble con id: "+mueble.getIdMueble());
            em.remove(mueble);

        }


        em.getTransaction().commit();
    }

    /**
     * Método obtiene la lista de los muebles por categoria dada
     * @param idCategoria
     */
    public static void obtenerListaMueblesPorCategoria(Long idCategoria){
        EntityManager em = PersistenceUtil.getEntityManager();
        Categoria categoria= em.find(Categoria.class,idCategoria);
        System.out.println("Listado de muebles para la categoria con id: "+idCategoria);
        for (int i = 0; i < categoria.getListaMuebles().size(); i++) {
            System.out.println("------- "+categoria.getListaMuebles().get(i));
        }
    }
    /**
     * Método obtiene el listado de estantes para crear un mueble
     * @param idMueble
     */
    public static void obtenerListaEstantesMueble(Long idMueble){
        EntityManager em = PersistenceUtil.getEntityManager();
        Mueble mueble= em.find(Mueble.class,idMueble);
        System.out.println("Listado de estantes para el mueble con id: "+idMueble);
        for (int i = 0; i < mueble.getListaPiezas().size(); i++) {
            System.out.println("------- "+mueble.getListaPiezas().get(i).getEstante());
        }

    }

    /**
     * Método obtiene la lista de piezas para un mueble determinado
     * @param idMueble
     */
    public static void obtenerListaPiezasMueble(Long idMueble){
        EntityManager em = PersistenceUtil.getEntityManager();
        Mueble mueble= em.find(Mueble.class,idMueble);
        System.out.println("Listado de piezas para el mueble con id: "+idMueble);
        for (int i = 0; i < mueble.getListaPiezas().size(); i++) {

            System.out.println("------- "+mueble.getListaPiezas().get(i).toString());
        }

    }
    public static void insertarEnBaseDeDatos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();

        Categoria categoria1 = new Categoria("BUENA");
        Categoria categoria2 = new Categoria("MEDIA");
        Categoria categoria3 = new Categoria("ALTA");
        Categoria categoria4 = new Categoria("BAJA");
        Categoria categoria5 = new Categoria("PREMIUM");

        List<Mueble> listMuebles =new ArrayList<>();
        categoria1.setListaMuebles(listMuebles);
        categoria2.setListaMuebles(listMuebles);
        categoria3.setListaMuebles(listMuebles);
        categoria4.setListaMuebles(listMuebles);
        categoria5.setListaMuebles(listMuebles);


        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(categoria3);
        em.persist(categoria4);
        em.persist(categoria5);
        em.getTransaction().commit();

        EntityManager em2 = PersistenceUtil.getEntityManager();
        em2.getTransaction().begin();

        Estante estante1 = new Estante(2);
        Estante estante2 = new Estante(3);
        Estante estante3 = new Estante(6);
        Estante estante4 = new Estante(7);
        Estante estante5 = new Estante(9);

        em2.persist(estante1);
        em2.persist(estante5);
        em2.persist(estante4);
        em2.persist(estante3);
        em2.persist(estante2);
        em2.getTransaction().commit();

        EntityManager em3 = PersistenceUtil.getEntityManager();
        em3.getTransaction().begin();

        Pieza piezas1 = new Pieza("sofa",estante1);
        Pieza piezas2 = new Pieza("silla",estante2);
        Pieza piezas3 = new Pieza("cama",estante1);
        Pieza piezas4 = new Pieza("escritorio",estante3);
        Pieza piezas5 = new Pieza("mesa",estante5);


        List<Mueble> listMueblesP =new ArrayList<>();
        piezas1.setListaMuebles(listMueblesP);
        piezas1.setListaMuebles(listMueblesP);
        piezas1.setListaMuebles(listMueblesP);
        piezas1.setListaMuebles(listMueblesP);
        piezas1.setListaMuebles(listMueblesP);




        em3.persist(piezas1);
        em3.persist(piezas2);
        em3.persist(piezas3);
        em3.persist(piezas4);
        em3.persist(piezas5);
        em3.getTransaction().commit();

        EntityManager em4 = PersistenceUtil.getEntityManager();
        em4.getTransaction().begin();
        Mueble mueble1 = new Mueble("mueble1",100F,categoria1);
        Mueble mueble2 = new Mueble("mueble2",95F,categoria2);
        Mueble mueble3 = new Mueble( "mueble3",45F,categoria3);
        Mueble mueble4 = new Mueble("mueble4",85F,categoria4);
        Mueble mueble5 = new Mueble( "mueble5",65F,categoria5);

        List<Pieza> listPiezasM= new ArrayList<>();
        mueble1.setListaPiezas(listPiezasM);
        mueble2.setListaPiezas(listPiezasM);
        mueble3.setListaPiezas(listPiezasM);
        mueble4.setListaPiezas(listPiezasM);
        mueble5.setListaPiezas(listPiezasM);

        mueble1.getListaPiezas().add(piezas2);
        mueble1.getListaPiezas().add(piezas1);
        mueble1.getListaPiezas().add(piezas3);

        em4.persist(mueble1);
        em4.persist(mueble2);
        em4.persist(mueble3);
        em4.persist(mueble4);
        em4.persist(mueble5);

        em4.getTransaction().commit();

    }



}
