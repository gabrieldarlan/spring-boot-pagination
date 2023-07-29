package br.com.gdarlan.paginacao.controller.mapper

import br.com.gdarlan.paginacao.controller.request.CustomerRequest
import br.com.gdarlan.paginacao.entity.CustomerEntity

object CustomerMapper {
    fun toEntity(customerRequest: CustomerRequest): CustomerEntity = CustomerEntity(
        customerId = customerRequest.customerId,
        firstName = customerRequest.firstName,
        lastName = customerRequest.lastName
    )
}