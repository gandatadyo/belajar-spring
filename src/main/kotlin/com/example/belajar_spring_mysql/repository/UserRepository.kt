package com.example.belajar_spring_mysql.repository

import com.example.belajar_spring_mysql.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository :CrudRepository<User,Int>{

}