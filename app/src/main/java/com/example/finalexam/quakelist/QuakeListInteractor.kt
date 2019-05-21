package com.example.finalexam.quakelist

import com.androidnetworking.common.ANRequest
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.finalexam.data.QuakeRepository
import com.example.finalexam.models.QuakeSettingModel
import com.example.finalexam.utils.QueryUtils
import org.json.JSONObject

class QuakeListInteractor : QuakeListProtocol.Interactor {
    override var presenter: QuakeListProtocol.InteractorOutput? = null
    private var task: ANRequest<out ANRequest<*>>? = null

    override fun requestQuakes(url: String) {
        task = QuakeRepository.getQuakes(url)?.apply {
            getAsJSONObject(listener)
        }
    }

    override fun destroy() {
        if (task != null) {
            task?.cancel(true)
            task = null
        }
        presenter = null
    }

    private val listener = object : JSONObjectRequestListener {
        override fun onResponse(response: JSONObject) {
            presenter?.onQuakesSuccess(QueryUtils.extractQuakes(response))
        }

        override fun onError(error: ANError) {
            presenter?.onQuakesFailed()
        }
    }
}