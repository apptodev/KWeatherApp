package es.antoniotejada.kweatherapp.domain.commands

import es.antoniotejada.kweatherapp.data.ForecastRequest
import es.antoniotejada.kweatherapp.domain.mappers.ForecastDataMapper
import es.antoniotejada.kweatherapp.domain.model.ForecastList

/**
 * Created by apptodev on 25/7/17.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}