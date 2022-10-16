package com.example.books.models

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)

data class Data(

	@field:SerializedName("user")
	val user: User1? = null
)

data class User1(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("active")
	val active: Boolean? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class UserErrorResponse(

	@field:SerializedName("stack")
	val stack: String? = null,

	@field:SerializedName("error")
	val error: Error? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Error(

	@field:SerializedName("isOperational")
	val isOperational: Boolean? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)
