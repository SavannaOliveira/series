package br.edu.ifrs.series.dao;

import br.edu.ifrs.series.dominio.Serie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SerieDAOJPA implements SerieDAO {

@PersistenceContext
	private EntityManager em;
	
	public List<Serie> listarTodas(){
		return em.createQuery("Select s FROM Serie s" , Serie.class).getResultList();	
	}
	
	@Override
    public Serie buscarPorId(Long id) {
        return em.find(Serie.class, id);
    }
	
    @Override
    public void salvar(Serie serie) {
        em.persist(serie);
    }
    @Override
    public void atualizar(Serie serie) {
        em.merge(serie);
    }
    @Override
    public void remover(Long id) {
        Serie serie = em.find(Serie.class, id);
        if (serie != null) {
            em.remove(serie);
        }
    }
}
