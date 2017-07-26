package es.antoniotejada.kweatherapp.domain.commands

/**
 * Created by apptodev on 25/7/17.
 */
interface Command<out T> {
    fun execute(): T
}