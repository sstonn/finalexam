package com.example.finalexam.quakelist

import android.content.Context
import com.example.finalexam.models.QuakeModel

abstract class QuakeListProtocol {
    interface View {
        var presenter: Presenter?

        fun onQuakesSuccess(quakes: ArrayList<QuakeModel>)
        fun onQuakesFailed()
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {
        var view: View?
        var interactor: Interactor?
        var router: Router?

        fun requestQuakes()
        fun destroy()
        fun showQuakeDetail(context: Context, url: String)
        fun showSettingsScreen(context: Context)
    }

    interface Interactor {
        var presenter: InteractorOutput?

        fun requestQuakes(url: String)
        fun destroy()
    }

    interface InteractorOutput {
        fun onQuakesSuccess(quakes: ArrayList<QuakeModel>)
        fun onQuakesFailed()
    }

    interface Router {
        fun presenter(view: View): QuakeListProtocol.Presenter
        fun createQuakeDetail(context: Context, url: String)
        fun createSettingScreen(context: Context)
    }
}