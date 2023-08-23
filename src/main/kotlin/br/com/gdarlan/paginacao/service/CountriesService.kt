package br.com.gdarlan.paginacao.service

import br.com.gdarlan.paginacao.entity.CountriesEntity
import br.com.gdarlan.paginacao.repository.CountriesRepository
import br.com.gdarlan.paginacao.repository.specification.CountrySpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service

@Service
class CountriesService(
    private val countriesRepository: CountriesRepository
) {
    fun findAll(pageable: Pageable): Page<CountriesEntity> {
        return countriesRepository.findAll(pageable);
    }

    fun findById(id: Long): CountriesEntity {
        return countriesRepository.findById(id).get()
    }

    fun getWithFilter(name: String?, pageable: Pageable): Page<CountriesEntity> {
        val specification: Specification<CountriesEntity> = CountrySpecification(name = name)
        return countriesRepository.findAll(specification, pageable)


    }

}