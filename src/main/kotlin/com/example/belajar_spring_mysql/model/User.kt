package com.example.belajar_spring_mysql.model

import jakarta.persistence.*

@Entity(name = "user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int = 0
    var userName:String = ""

    var email:String = ""

    @ManyToOne
    @JoinColumn(name = "idRole", referencedColumnName = "id")
    var idRole:Role? = null
}