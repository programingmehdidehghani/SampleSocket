package com.example.smaplesocketcrypto.domain.model

sealed class ExampleModels {
    data class SymbolModel(
        val a: String
    ) : ExampleModels()

    data class LastPriceModel(
        val b: String
    ) : ExampleModels()

    data class ChangePriceModel(
        val b: String
    ) : ExampleModels()
}