package consultas;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.devmedia.introducaojpql.dao.JPAUtil;
import br.com.devmedia.introducaojpql.domain.Episodio;
import br.com.devmedia.introducaojpql.domain.Serie;

public class ConsultasJPQL {
	// SELECT S FROM SERIES S
	
	public  List<Serie> listarTodasSeries(){
		EntityManager em = JPAUtil.getEntityManager();
		
		String queryJPQL = "SELECT s FROM Serie s";
		return em.createQuery(queryJPQL, Serie.class).getResultList();
	}
	public List<Serie> listarSeriesCriadasNoAno2008(int ano){
		EntityManager em = JPAUtil.getEntityManager();
		String queryJQPL="SELECT s FROM Serie s WHERE s.anoCriacao = :anoDesejado";
		
		return em.createQuery(queryJQPL, Serie.class).setParameter("anoDesejado", ano).getResultList();
	}
	
	public List<Serie> listarSeriesCujoNomeContenha(String nome){
		EntityManager em = JPAUtil.getEntityManager();
		String queryJQPL="SELECT s FROM Serie s WHERE s.nome LIKE = :nome";
		
		return em.createQuery(queryJQPL, Serie.class).setParameter("nome",  "%" + nome + "%").getResultList();
	}
	public String recuperarSeriePorAnoENome(String nome, int ano) {
		EntityManager em = JPAUtil.getEntityManager();
		String query = "SELECT s.nome FROM Serie s WHERE s.nome LIKE :nome AND s.anoCriacao = :ano";
		return em.createQuery(query, String.class).setParameter("nome", nome).setParameter("ano", ano).getSingleResult();
	}
	
	public List<Episodio> listarEpisodioDaSerie(String nome){
		EntityManager em = JPAUtil.getEntityManager();
		String query= "SELECT e FROM Episodio e WHERE e.temporada.serie.nome LIKE :nome";
		
		return em.createQuery(query, Episodio.class).setParameter("nome", nome).getResultList();
	}
	
	public List<Serie> recuperarSeriesComNumeroMinimoDeTemporada(int temporadas){
		EntityManager em = JPAUtil.getEntityManager();
		String query = "SELECT s From Serie s JOIN s.temporadas t WHERE t.numero = :qtdTemporadas";
		
		return em.createQuery(query, Serie.class).setParameter("qtdTemporadas", temporadas).getResultList();
	}
	
	
	
}
