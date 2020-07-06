package com.iamninad.mn.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@Schema(name="Employee")
data class Employee(@JsonProperty("id") var id: String?,
                    @JsonProperty("name") val name: String,
                    @JsonProperty("emailId") val emailId: String,
                    @JsonProperty("mobile") val mobile: String,
                    @JsonProperty("department") val department: String,
                    @JsonProperty("address") val address: String,
                    @JsonProperty("location") val location: String,
                    @JsonProperty("skills") val skills: Array<String>)