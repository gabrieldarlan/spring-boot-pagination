package br.com.gdarlan.paginacao.repository

import br.com.gdarlan.paginacao.entity.CountriesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface CountriesRepository : JpaRepository<CountriesEntity, Long>, JpaSpecificationExecutor<CountriesEntity>