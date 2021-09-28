package com.deputy.android.ds.views.checkboxes

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.checkbox.MaterialCheckBox

/**
 * Custom CheckBox having the functionality to
 * trigger or not trigger check change listener on checkbox check and uncheck.
 * Typical use case for this is on RecyclerView ViewHolder where there maybe need to
 * NOT trigger check change listener on setting check/uncheck value, but may need to
 * trigger the check change listener on user check/uncheck action or other custom action.
 *
 *  cb.setChecked(true/false, ignoreCheckedChangeListener = true)
 *  cb.setOnCheckedChangeListener(), need to trigger the the check change listener
 *
 * If the use case doesn't satisfy as mentioned above, revert to Android provided default CheckBox.
 * This is NOT the default CheckBox for the entire app.
 * See it's usage for more.
 */

class DeputyCheckBox : MaterialCheckBox {

    private var checkedChangeListener: OnCheckedChangeListener? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun setOnCheckedChangeListener(listener: OnCheckedChangeListener?) {
        super.setOnCheckedChangeListener(listener)
        checkedChangeListener = listener
    }

    fun setChecked(checked: Boolean, ignoreCheckedChangeListener: Boolean = false) {
        if (ignoreCheckedChangeListener) {
            super.setOnCheckedChangeListener(null)
        }
        isChecked = checked
        super.setOnCheckedChangeListener(checkedChangeListener)
    }
}
