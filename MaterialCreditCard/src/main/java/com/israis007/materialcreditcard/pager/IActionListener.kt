package com.israis007.materialcreditcard.pager

interface IActionListener {

    fun onActionComplete(creditCardFragment: CreditCardFragment)

    fun onEdit(creditCardFragment: CreditCardFragment, edit: String)
}