package br.com.gdarlan.paginacao.entity

import org.springframework.hateoas.RepresentationModel
import javax.persistence.*

@Entity
@Table(name = "countries")
data class CountriesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null,
    val name: String
) : RepresentationModel<CountriesEntity>()
