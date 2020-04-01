package com.github.coraandroidtest.core.utils

object CoraHelper {

    private val hashMapNewContact: HashMap<String, Any?> = hashMapOf()

    fun insertFieldNewContact(hashMapField: String, field: Any?) {
        hashMapNewContact[hashMapField] = field
    }

    fun getUserSavedPartially(): HashMap<String, Any?> {
        return hashMapNewContact
    }
}