package com.example.kotlinreader.screens.login

data class LoadingState(val status: Status, val message: String? = null) {
    companion object {
        val IDLE = LoadingState(status = Status.IDLE)
        val LOADING = LoadingState(status = Status.LOADING)
        val SUCCESS = LoadingState(status = Status.SUCCESS)
        val FAILED = LoadingState(status = Status.FAILED)
    }

    enum class Status {
        IDLE,
        LOADING,
        SUCCESS,
        FAILED
    }
}
