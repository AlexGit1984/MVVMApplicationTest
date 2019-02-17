package me.mvvm.com.myapplication.di

import me.mvvm.com.myapplication.AndroidApplication
import me.mvvm.com.myapplication.mainscreen.di.MainComponent

/**
 * Created by Alexander Karpenko on 09.09.18.
 * java.karpenko@gmail.com
 */

open class Injector {


    lateinit var component: AppComponent

    var mainComponent: MainComponent? = null


    companion object {

        var msInjector: Injector? = Injector()
        @JvmStatic
        fun init(app: AndroidApplication?) {
            msInjector?.component = DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .roomModule(RoomModule(app))
                    .networkApiModule(NetworkApiModule(app?.applicationContext))
                    .build()
        }

    }


    fun plusMainActivity(): MainComponent {
        if (mainComponent == null) {
//            mainComponent = component.plus(MainModule())
        }
        return mainComponent as MainComponent
    }


}