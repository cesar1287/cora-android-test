package com.github.coraandroidtest.base

import androidx.appcompat.app.AppCompatDelegate
import java.lang.Exception
import java.util.*

open class BaseRepository {

//    val api : RiotApi = ApiService.riotApi
//    val apiDDragon: DDragonRiotApi = ApiService.dDragonRiotApi
//    val db = FirebaseFirestore.getInstance()
//    val auth = FirebaseAuth.getInstance()
//
//    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Resource {
//        return safeApiResult(call)
//    }
//
//    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>) : Resource{
//        try {
//            val response = call.invoke()
//
//            return if(response.isSuccessful) {
//                Resource.success(response.body())
//            } else {
//                val error = ErrorUtils.parseError(response)
//
//                error?.message?.let {  message ->
//                    Resource.error(message)
//                } ?: run {
//                    Resource.error(ERROR_DEFAULT)
//                }
//            }
//        } catch (error : Exception) {
//            return Resource.error(ERROR_DEFAULT)
//        }
//    }
//
//    fun getUserFirestore(): Customer? {
//        val docRef = db
//            .collection(ConstantsUtil.FirestoreDataBaseNames.DATABASE_CUSTOMERS)
//            .document(auth.currentUser?.uid ?: UUID.randomUUID().toString())
//
//        val result = Tasks.await(docRef.get())
//
//        return result.toObject(Customer::class.java)
//    }
//
//    fun saveUserFirestore() {
//        val currentUser = auth.currentUser
//
//        val newUser = hashMapOf(
//            ConstantsUtil.FirestoreDataBaseFields.FIELD_USER_NAME to currentUser?.displayName,
//            ConstantsUtil.FirestoreDataBaseFields.FIELD_USER_EMAIL to currentUser?.email,
//            ConstantsUtil.FirestoreDataBaseFields.FIELD_USER_PREMIUM to false,
//            ConstantsUtil.FirestoreDataBaseFields.FIELD_USER_COLOR_PREFERENCE to
//                    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
//                        FIELD_USER_COLOR_PREFERENCE_DARK
//                    else
//                        FIELD_USER_COLOR_PREFERENCE_LIGHT
//        )
//
//        db.collection(
//            ConstantsUtil.FirestoreDataBaseNames.DATABASE_CUSTOMERS
//        ).document(
//            auth.currentUser?.uid ?: UUID.randomUUID().toString()
//        ).set(
//            newUser
//        )
//    }
}