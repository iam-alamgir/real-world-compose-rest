package com.cryptenet.rwl_rest

import android.content.Context
import com.cryptenet.rwl_rest.di.modules.app.appModule
import com.cryptenet.rwl_rest.di.modules.base.baseModule
import com.facebook.stetho.Stetho
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

class RealWorldApplication : SplitCompatApplication(), DIAware {
    override val di by DI.lazy {
        import(androidXModule(this@RealWorldApplication))

        import(appModule)
        import(baseModule)
    }

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this

        initTimber()
        initStetho()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}
