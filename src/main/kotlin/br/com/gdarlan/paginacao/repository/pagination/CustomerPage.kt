package br.com.gdarlan.paginacao.repository.pagination

import org.springframework.data.domain.Sort

data class CustomerPage(
    var pageNumber: Int = 0,
    var pageSize: Int = 0,
    var sortDirection: Sort.Direction = Sort.Direction.ASC,
    var sortBy: String = "lastName"
) 