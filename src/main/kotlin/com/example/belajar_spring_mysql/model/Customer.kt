package com.example.belajar_spring_mysql.model

import jakarta.persistence.*

@Entity(name = "customer")
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int = 0

    var nameCustomer:String = ""
}