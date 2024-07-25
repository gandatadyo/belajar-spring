package com.example.belajar_spring_mysql.controller

import com.example.belajar_spring_mysql.model.Role
import com.example.belajar_spring_mysql.model.User
import com.example.belajar_spring_mysql.repository.RoleRepository
import com.example.belajar_spring_mysql.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path= ["/user"])
class UserController(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val roleRepository: RoleRepository
){

    data class DataUserRequest (
        val username: String = "",
        val email: String = "",
        val idRole: Int = 0
    )

    @PostMapping(path = ["/add"])
    private fun insertUser(@RequestBody dataBody: DataUserRequest):ResponseEntity<*>{
        val user = User()
        user.userName = dataBody.username
        user.email = dataBody.email
        val role: Role? = roleRepository.findById(dataBody.idRole).orElse(null)
        user.idRole = role
        userRepository.save(user)

        val response = object { val message = "Successfully" }
        return ResponseEntity.ok(response)
    }

    @GetMapping(path = ["all"])
    private fun listUser():ResponseEntity<*>{
        val listUser = userRepository.findAll()
        return ResponseEntity.ok(listUser)
    }
}