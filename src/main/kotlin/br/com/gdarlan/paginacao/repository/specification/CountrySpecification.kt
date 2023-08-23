package br.com.gdarlan.paginacao.repository.specification

import br.com.gdarlan.paginacao.entity.CountriesEntity
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class CountrySpecification(
    private val name: String?
) : Specification<CountriesEntity> {
    private val predicates: MutableList<Predicate> = ArrayList()

    override fun toPredicate(
        root: Root<CountriesEntity>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        if (!name.isNullOrBlank()) {
            predicates.add(criteriaBuilder.equal(root.get<String>("name"), name))
        }
        return criteriaBuilder.and(*predicates.toTypedArray<Predicate>())
    }
}