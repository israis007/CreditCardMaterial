package com.israis007.materialcreditcard.pager

import android.text.TextWatcher
import androidx.fragment.app.Fragment

abstract class CreditCardFragment(contentLayoutId: Int) : Fragment(contentLayoutId), TextWatcher, IFocus {

    var iActionListener: IActionListener? = null

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    fun onEdit(edit: String){
        iActionListener?.onEdit(this, edit)
    }

    fun onComplete(){
        iActionListener?.onActionComplete(this)
    }
}