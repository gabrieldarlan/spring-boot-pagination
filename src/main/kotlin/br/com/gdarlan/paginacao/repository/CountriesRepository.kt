package br.com.gdarlan.paginacao.repository

import br.com.gdarlan.paginacao.entity.CountriesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CountriesRepository : JpaRepository<CountriesEntity, Long>