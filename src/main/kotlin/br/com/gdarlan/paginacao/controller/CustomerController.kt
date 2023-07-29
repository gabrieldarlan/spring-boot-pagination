package br.com.gdarlan.paginacao.controller

import br.com.gdarlan.paginacao.controller.mapper.CustomerMapper
import br.com.gdarlan.paginacao.controller.model.CustomerModel
import br.com.gdarlan.paginacao.controller.model.assembler.CustomerModelAssembler
import br.com.gdarlan.paginacao.controller.request.CustomerRequest
import br.com.gdarlan.paginacao.entity.CustomerEntity
import br.com.gdarlan.paginacao.service.CustomerService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController(
    val customerService: CustomerService,
    val customerModelAssembler: CustomerModelAssembler,
    val pagedResourcesAssembler: PagedResourcesAssembler<CustomerEntity>
) {

    @PostMapping
    fun save(@RequestBody customerRequest: CustomerRequest): ResponseEntity<Any> {
        val customer = CustomerMapper.toEntity(customerRequest)
        customerService.save(customer)
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    fun findAll(pageable: Pageable): PagedModel<CustomerModel> {
        val customerPage = customerService.getAll(pageable)
        return pagedResourcesAssembler.toModel(customerPage, customerModelAssembler)
    }
}