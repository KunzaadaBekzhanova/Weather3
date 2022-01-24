package kg.tutorialapp.weather3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView1)
        val call = weatherApi.getWeather()
        call.enqueue(object: Callback<ForeCast> {
            override fun onResponse(call: Call<ForeCast>, response: Response<ForeCast>) {
                if(response.isSuccessful){
                    val foreCast = response.body()

                    foreCast?.let{
                        textView.text = it.curren?.weather!![0].description
                        textView2.text = it.timeZone

                    }
                }
            }

            override fun onFailure(call: Call<ForeCast>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message, Toast.LENGTH_LONG)
            }

        })
    }
    private val okhhtp by lazy{

            val interceptor = HttpLoggingInterceptor().apply{level = HttpLoggingInterceptor.Level.BODY}

         okHttpClient.Builder(interceptor).addInterceptor().build()
        }
    }

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhhtp)
            .build()
    }
    private val weatherApi by lazy{
        retrofit.create(WeatherApi::class.java)
    }
