package com.jetpack.paging

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

object Tools {
    private val viewModelJob = SupervisorJob()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val workScope = CoroutineScope(Dispatchers.IO + viewModelJob)
    @JvmStatic
    fun test(task:Runnable) {
        var str = "abc"

        workScope.launch {
            log(" str =  $str")

            log(" workScope.launch ${Thread.currentThread().name}")

            str = "cdefg"

            uiScope.launch {

                task.run()

                log(" str =  $str")
                log(" uiScope.launch ${Thread.currentThread().name}")
            }
        }
    }

    fun log(msg:String){
        Log.d("debug_tag",msg)
    }

}