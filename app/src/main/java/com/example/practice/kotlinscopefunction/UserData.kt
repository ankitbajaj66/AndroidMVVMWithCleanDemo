package com.example.practice.kotlinscopefunction

/**
 *Created by Ankit Bajaj on 05-02-2020.
 */
data class UserData(var name: String? = null, var company: String? = null) {

    fun setCompanyNew(company: String?) {
        this.company = company
    }
}