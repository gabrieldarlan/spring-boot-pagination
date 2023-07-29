package br.com.gdarlan.paginacao.service

import br.com.gdarlan.paginacao.entity.CountriesEntity
import br.com.gdarlan.paginacao.repository.CountriesRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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
}