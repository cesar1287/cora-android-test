package com.github.coraandroidtest.core.utils

import androidx.annotation.StyleRes
import com.github.coraandroidtest.R
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.utils.Mask.MASK_CPF

object Database {
    val PREPOPULATE_DATA = listOf(
        Bank(bankName = "Itau", bankCode = 302, bankMain = true),
        Bank(bankName = "Banco do Brasil", bankCode = 302, bankMain = true),
        Bank(bankName = "Bradesco", bankCode = 302, bankMain = true),
        Bank(bankName = "Santander", bankCode = 302, bankMain = true),
        Bank(bankName = "Safra", bankCode = 302, bankMain = true),
        Bank(bankName = "Banco BMG", bankCode = 302),
        Bank(bankName = "Caixa", bankCode = 302),
        Bank(bankName = "C6 Bank", bankCode = 302),
        Bank(bankName = "Nu Pagamentos", bankCode = 302)
    )
}

object Toolbar {
    const val TOOL_BAR_TYPE_CONTACTS  = 0
    const val TOOL_BAR_TYPE_NEW_CONTACT = 1
}

object Mask {
    const val MASK_CPF = "###.###.###-##"
    const val MASK_AGENCY = "####"
    const val MASK_ACCOUNT = "######-#"
}

object EditTextCora {
    const val FIELD_TYPE_NONE = 0
    const val FIELD_TYPE_CPF = 1
    const val FIELD_TYPE_NAME = 2
    const val FIELD_TYPE_NUMBER = 3
    const val MAX_LENGTH_DEFAULT = 30
    const val MAX_LENGTH_CPF = MASK_CPF.length
    const val MAX_LENGTH_NAME = 30
    @StyleRes
    const val STYLE_DEFAULT = R.style.EditTextCora
    const val PLACEHOLDER_NAME = "Cesar Rodrigues"
    const val PLACEHOLDER_CPF = "123.456.789-11"
    const val PLACEHOLDER_AGENCY = "0000"
    const val PLACEHOLDER_ACCOUNT = "000000-0"
}

object NewContact {
    const val HASH_MAP_CPF = "cpf"
    const val HASH_MAP_NAME = "name"
    const val HASH_MAP_BANK = "bank"
    const val HASH_MAP_AGENCY = "agency"
    const val HASH_MAP_ACCOUNT = "account"
}