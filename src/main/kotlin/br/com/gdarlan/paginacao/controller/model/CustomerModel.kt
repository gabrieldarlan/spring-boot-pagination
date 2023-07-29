package br.com.gdarlan.paginacao.controller.model

import org.springframework.hateoas.RepresentationModel

class CustomerModel(
    val id: Long? = null,
    val customerId: String,
    val firstName: String,
    val lastName: String
) : RepresentationModel<CustomerModel>() {
}