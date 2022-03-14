package com.example.lifecycleaware

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


class MainActivityObserver: LifecycleObserver {

    private lateinit var txt: TextView  // Can't access main ui views
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun mainOnCreate() {
        Log.d("tage", "observer on create")

    }
}