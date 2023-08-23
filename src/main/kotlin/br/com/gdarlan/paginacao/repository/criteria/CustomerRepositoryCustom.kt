package br.com.gdarlan.paginacao.repository.criteria

import br.com.gdarlan.paginacao.entity.CustomerEntity
import br.com.gdarlan.paginacao.repository.criteria.params.CustomerSearchCriteria
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CustomerRepositoryCustom {

    fun getWithFilter(params: CustomerSearchCriteria, pageable: Pageable): Page<CustomerEntity>
}