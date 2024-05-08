package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Zemlja;

	@Dependent
	public class ZemljeService {
		
		@Inject
		private EntityManager em;
		
		@Transactional
		public void sacuvajZemlje (List <Zemlja> zemlje) {
			
			List <Zemlja> sacuvaneZemlje = getSveZemlje();
			zemlje.removeAll(sacuvaneZemlje);
			
			for (Zemlja zemlja : zemlje) {
				em.merge(zemlja);
			}
		}
		
		@Transactional
		public List<Zemlja> getSveZemlje() {
			return em.createNamedQuery(Zemlja.GET_ALL, Zemlja.class).getResultList();
		}
	}
