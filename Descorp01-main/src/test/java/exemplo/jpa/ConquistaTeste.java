package exemplo.jpa;

import java.util.Date;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConquistaTeste extends Teste {

    @Test
    public void persistirConquista() {
        //Streets of Rage
        Jogo jogo = em.find(Jogo.class, 2);      
        assertEquals("Streets of Rage", jogo.getNome());

        Conquista conquista = new Conquista();
        conquista.setNome("Good Ending");
        conquista.setDescricao("Não se alie a Mr. X, o desafie e o vença.");
        conquista.setJogo(jogo);
        conquista.setPontos(500);
        
        em.persist(conquista);
        em.flush();
        System.out.println("ConquistaTeste - flush");

        assertNotNull(conquista.getId());

        System.out.println("ConquistaTeste - conquista Id:" + conquista.getId());
    }

    @Test
    public void consultarConquista() {
        System.out.println("ConquistaTeste - Iniciando consultarConquista");      
        Conquista conquista = em.find(Conquista.class, 1);
        assertNotNull(conquista);
        assertEquals("Black Cat", conquista.getNome());
        assertEquals("Conquiste sete vidas", conquista.getDescricao());
        assertEquals(100, conquista.getPontos());

        System.out.println("ConquistaTeste - Terminando consultarConquista");
    }
   /*
    @Test
    public void removerConquista() {
        System.out.println("ConquistaTeste - Iniciando removerConquista");
        TypedQuery<Conquista> query = em.createNamedQuery("Conquista.DelDependencia", Conquista.class);
        query.setParameter("id", "1");
        
        TypedQuery<Conquista> query2 = em.createNamedQuery("Conquista.PorNome", Conquista.class);
        query.setParameter("nome", "Black Cat");
        Conquista conquista = query.getSingleResult();
        assertNotNull(conquista);
        em.remove(conquista);
        em.flush();
        assertEquals(0, query.getResultList().size());
        System.out.println("ConquistaTeste - Terminando removerConquista");
*/
    }

