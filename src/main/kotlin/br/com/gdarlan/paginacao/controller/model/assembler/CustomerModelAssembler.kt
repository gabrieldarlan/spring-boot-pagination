package br.com.gdarlan.paginacao.controller.model.assembler

import br.com.gdarlan.paginacao.controller.model.CustomerModel
import br.com.gdarlan.paginacao.entity.CustomerEntity
import org.springframework.beans.BeanUtils
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.stereotype.Component

@Component
class CustomerModelAssembler : RepresentationModelAssembler<CustomerEntity, CustomerModel> {
    override fun toModel(entity: CustomerEntity): CustomerModel {
        val model = CustomerModel(
            id = entity.id,
            customerId = entity.customerId,
            firstName = entity.firstName,
            lastName = entity.lastName
        )
        BeanUtils.copyProperties(entity, model)
        return model
    }
}