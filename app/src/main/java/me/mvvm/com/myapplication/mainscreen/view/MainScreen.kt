package me.mvvm.com.myapplication.mainscreen.view

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.mvvm.com.myapplication.R
import me.mvvm.com.myapplication.data.database.User
import me.mvvm.com.myapplication.mainscreen.viewmodel.MainActivityVM
import me.mvvm.com.myapplication.ui.viewModels.base.BaseActivity

/**
 * Created by Alexander Karpenko on 09.09.18.
 * java.karpenko@gmail.com
 */
class MainScreen : BaseActivity() {


    lateinit var viewModel: MainActivityVM
    private val REQUEST_ENABLE_BT: Int = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityVM::class.java)
        viewModel.getUser()
        viewModel.getResponse()?.observe(this, Observer<List<User>> {
            sample_txt.text = it.toString()
        })
        button.setOnClickListener { viewModel.getUser() }

    }

    private fun handleError(t: Throwable?) {
        when (t) {
            is IllegalAccessException -> startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), REQUEST_ENABLE_BT)
            is IllegalStateException -> showToast("Your device does not support BT")
            else -> showToast(t?.message)
        }
    }

    private fun showToast(msg: String?) {
        if (!TextUtils.isEmpty(msg)) Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_ENABLE_BT) {
//            getDeviceList()
        }
    }


}


