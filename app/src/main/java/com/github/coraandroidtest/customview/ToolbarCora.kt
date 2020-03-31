package com.github.coraandroidtest.customview

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.coraandroidtest.R
import com.github.coraandroidtest.core.utils.Toolbar.TOOL_BAR_TYPE_CONTACTS
import com.github.coraandroidtest.core.utils.Toolbar.TOOL_BAR_TYPE_NEW_CONTACT
import kotlinx.android.synthetic.main.toolbar_cora_contacts.view.*
import kotlinx.android.synthetic.main.toolbar_cora_new_contact.view.*

class ToolbarCora @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var toolbarType: Int = TOOL_BAR_TYPE_CONTACTS

    private var toolbarTitleString: String? = null

    private var toolbarProgress: Int? = null

    init {
        setupStyleables(attrs)
        setToolbarType(toolbarType)
        setProgress(toolbarProgress)
    }

    private fun setupStyleables(attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ToolbarCora,
            0, 0).apply {
            try {
                toolbarType = getInteger(
                    R.styleable.ToolbarCora_toolbarType, TOOL_BAR_TYPE_CONTACTS
                )
                toolbarTitleString = getString(R.styleable.ToolbarCora_titleToolbarCora)
                toolbarProgress = getInteger(
                    R.styleable.ToolbarCora_progressToolbarCora,
                    0
                )
            } finally {
                recycle()
            }
        }
    }

    /***
     * Altera tipo da toolbar reinicializando todos os componentes da mesma
     * @param type Tipo da toolbar
     */
    private fun setToolbarType(type: Int) {
        if (!isInEditMode) {
            this.removeAllViews()
        }

        toolbarType = type

        val toolbarLayout: Int = when (type) {
            TOOL_BAR_TYPE_CONTACTS ->
                R.layout.toolbar_cora_contacts
            TOOL_BAR_TYPE_NEW_CONTACT ->
                R.layout.toolbar_cora_new_contact
            else ->
                R.layout.toolbar_cora_contacts
        }

        inflate(context, toolbarLayout, this)

        if (!isInEditMode) {
            initView()
        }
    }

    private fun initView() {
        setDefaultTitle()
        setListener()
    }

    private fun setListener() {
//        backButton?.setOnClickListener { listener?.onBackPressedToolbar() }
//        buttonChoose?.setOnClickListener { listener?.onClickChooseProduct() }
//        iconHelp?.setOnClickListener { listener?.onClickHelp() }
//        iconClose?.setOnClickListener { listener?.onBackPressedToolbar() }
    }

    private fun setTitle(title: String?) {
        tvToolbarContactsTitle?.text = title
    }

    private fun setDefaultTitle() {
        val name = (context as? Activity)?.componentName
        name?.let {
            val activityInfo = context.packageManager.getActivityInfo(
                it, PackageManager.GET_META_DATA)

            var title : String? = activityInfo.loadLabel(context.packageManager).toString()

            if (title.isNullOrEmpty() || title == resources.getString(R.string.app_name)) {
                title = toolbarTitleString ?: resources.getString(R.string.app_name)
            }

            setTitle(title)
        }

    }

    private fun setProgress(progress: Int?) {
        progress?.let {
            if (it in 0..100) {
                pbToolBar?.progress = progress
            }
        }
    }

    interface ToolBarItauListener {
        fun onBackPressedToolbar()
        fun onClickChooseProduct()
        fun onClickHelp()
    }
}