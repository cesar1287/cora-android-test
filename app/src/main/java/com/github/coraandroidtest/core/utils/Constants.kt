package com.github.coraandroidtest.core.utils

import com.github.coraandroidtest.core.database.entity.Bank

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