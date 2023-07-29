package br.com.gdarlan.paginacao.entity

import javax.persistence.*

@Entity
@Table(name = "customer")
data class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,
    @Column(nullable = false, unique = true, name = "customer_id")
    val customerId: String,
    @Column(nullable = false, unique = true, name = "first_name")
    val firstName: String,
    @Column(nullable = false, unique = true, name = "last_name")
    val lastName: String
)