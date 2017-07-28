package es.antoniotejada.kweatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import es.antoniotejada.kweatherapp.R
import es.antoniotejada.kweatherapp.data.ForecastRequest
import es.antoniotejada.kweatherapp.domain.commands.RequestForecastCommand
import es.antoniotejada.kweatherapp.domain.model.Forecast
import es.antoniotejada.kweatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.*

/**
 * Created by apptodev on 6/7/17.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result, object : ForecastListAdapter.OnItemClickListener {
                    override fun invoke(forecast: Forecast) {
                        toast(forecast.date)
                    }
                })
            }
        }
    }
}