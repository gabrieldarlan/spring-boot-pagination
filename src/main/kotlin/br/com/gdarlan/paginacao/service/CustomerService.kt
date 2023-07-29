package br.com.gdarlan.paginacao.service

import br.com.gdarlan.paginacao.entity.CustomerEntity
import br.com.gdarlan.paginacao.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    fun getAll(pageable: Pageable): Page<CustomerEntity> {
        return customerRepository.findAll(pageable);
    }

    fun save(customerEntity: CustomerEntity) {
        customerRepository.save(customerEntity)
    }

}
