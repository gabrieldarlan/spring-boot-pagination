package br.com.gdarlan.paginacao.repository.criteria.impl

import br.com.gdarlan.paginacao.entity.CustomerEntity
import br.com.gdarlan.paginacao.repository.criteria.CustomerRepositoryCustom
import br.com.gdarlan.paginacao.repository.criteria.params.CustomerSearchCriteria
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class CustomerRepositoryCustomImpl(
    private val entityManager: EntityManager
) : CustomerRepositoryCustom {


    override fun getWithFilter(
        params: CustomerSearchCriteria,
        pageable: Pageable
    ): Page<CustomerEntity> {
        val criteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery: CriteriaQuery<CustomerEntity> = criteriaBuilder.createQuery(CustomerEntity::class.java)

        val root: Root<CustomerEntity> = criteriaQuery.from(CustomerEntity::class.java)

//        var predicates: MutableList<Predicate> = ArrayList()
//        predicates.add(criteriaBuilder.equal())


        if (!params.getFirstName().isNullOrBlank()) {
            criteriaQuery
                .select(root)
                .where(criteriaBuilder.equal(root.get<String>("firstName"), params.getFirstName()))
        }

        if (!params.getLastName().isNullOrBlank()) {
            criteriaQuery
                .select(root)
                .where(criteriaBuilder.equal(root.get<String>("lastName"), params.getLastName()))
        }


        val query = entityManager.createQuery(criteriaQuery)

        return PageImpl(query.resultList, pageable, 1L)
    }
}