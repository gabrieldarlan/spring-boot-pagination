package br.com.gdarlan.paginacao.controller

import br.com.gdarlan.paginacao.service.CountriesService
import org.springframework.data.domain.Pageable
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("countries")
class CountriesController(
    private val countriesService: CountriesService
) {

    @GetMapping("/teste")
    fun teste(): String = "hello world"

    @GetMapping
    fun findAll(
        @RequestParam(name = "id", required = false) id: Long?,
        pageable: Pageable
    ): ResponseEntity<Any> {
        val listaCountries = countriesService.findAll(pageable)
        for (country in listaCountries) {
            val idResponse = country.id
            country.add(linkTo<CountriesController> { findById(idResponse!!) }.withSelfRel())
        }
        return ResponseEntity.ok(listaCountries);
    }

    @GetMapping("findbyid/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        val country = countriesService.findById(id)
        return ResponseEntity.ok(country)
    }
}