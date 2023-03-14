package com.example.smaplesocketcrypto.domain.model

sealed class ExampleModels {
    data class SymbolModel(
        val s: String
    ) : ExampleModels()

    data class LastPriceModel(
        val c: String
    ) : ExampleModels()

    data class ChangePriceModel(
        val P: String
    ) : ExampleModels()
}