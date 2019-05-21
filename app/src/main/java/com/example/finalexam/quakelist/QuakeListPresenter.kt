package com.example.finalexam.quakelist

import android.app.Activity
import android.content.Context
import com.example.finalexam.models.QuakeModel
import com.example.finalexam.utils.NetworkUtils
import com.example.finalexam.utils.QueryUtils

class QuakeListPresenter : QuakeListProtocol.Presenter, QuakeListProtocol.InteractorOutput {
    override var view: QuakeListProtocol.View? = null
    override var interactor: QuakeListProtocol.Interactor? = null
    override var router: QuakeListProtocol.Router? = null

    // ///////////////////
    // Presenter Interface
    // ///////////////////
    override fun requestQuakes() {
        val context = (view as Activity).baseContext
        if (NetworkUtils.hasInternetConnection(context)) {
            val url = QueryUtils.url(QueryUtils.settingsFromPreferences(context))
            interactor?.requestQuakes(url)
            view?.showProgress()
        } else {
            println("No internet connection")
            onQuakesFailed()
        }
    }

    override fun showQuakeDetail(context: Context, url: String) {
        router?.createQuakeDetail(context, url)
    }

    override fun showSettingsScreen(context: Context) {
        router?.createSettingScreen(context)
    }

    override fun destroy() {
        view = null
        interactor = null
        router = null
    }

    // Interactor Output Interface
    override fun onQuakesSuccess(quakes: ArrayList<QuakeModel>) {
        view?.hideProgress()
        view?.onQuakesSuccess(quakes)
    }

    override fun onQuakesFailed() {
        view?.hideProgress()
        view?.onQuakesFailed()
    }
}