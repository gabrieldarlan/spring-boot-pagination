package br.com.gdarlan.paginacao.repository.criteria.params

class CustomerSearchCriteria(
    private var firstName: String? = "",
    private var lastName: String? = "",
) {

    fun getFirstName() = firstName

    fun getLastName() = lastName
}
