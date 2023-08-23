package br.com.gdarlan.paginacao.repository.criteria

import br.com.gdarlan.paginacao.entity.CustomerEntity
import br.com.gdarlan.paginacao.repository.criteria.params.CustomerSearchCriteria
import br.com.gdarlan.paginacao.repository.pagination.CustomerPage
import org.springframework.data.domain.Page

interface CustomerRepositoryCustom2 {

    fun getWithFilter2(params: CustomerSearchCriteria, customerPage: CustomerPage): Page<CustomerEntity>
}