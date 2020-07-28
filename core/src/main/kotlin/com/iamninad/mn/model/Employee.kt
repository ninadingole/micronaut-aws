package com.iamninad.mn.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import javax.persistence.*

@Entity
@Schema(name = "Employee")
data class Employee(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonProperty("id") var id: Long?,
        @Column @JsonProperty("name") var name: String,
        @Column @JsonProperty("emailId") var emailId: String,
        @Column @JsonProperty("mobile") var mobile: String,
        @Column @JsonProperty("department") var department: String,
        @Column @JsonProperty("address") var address: String,
        @Column @JsonProperty("location") var location: String) : Serializable