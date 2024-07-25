package com.example.belajar_spring_mysql.controller

import com.example.belajar_spring_mysql.model.Role
import com.example.belajar_spring_mysql.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path= ["/role"])
class RoleController(
    @Autowired private val roleRepository: RoleRepository
){

    data class DataRoleRequest (
        val nameRole: String = "",
    )

    @PostMapping(path = ["/add"])
    private fun insertUser(@RequestBody dataBody: DataRoleRequest):ResponseEntity<*>{
        val user = Role()
        user.nameRole = dataBody.nameRole
        roleRepository.save(user)

        val response = object { val message = "Successfully" }
        return ResponseEntity.ok(response)
    }

    @GetMapping(path = ["all"])
    private fun listUser():ResponseEntity<*>{
        val listUser = roleRepository.findAll()
        return ResponseEntity.ok(listUser)
    }
}