package com.example.belajar_spring_mysql.repository

import com.example.belajar_spring_mysql.model.Role
import org.springframework.data.repository.CrudRepository

interface RoleRepository :CrudRepository<Role,Int>{

}