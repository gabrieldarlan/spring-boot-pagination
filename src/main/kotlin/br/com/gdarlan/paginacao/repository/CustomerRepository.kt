package br.com.gdarlan.paginacao.repository

import br.com.gdarlan.paginacao.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<CustomerEntity, Long> {
}