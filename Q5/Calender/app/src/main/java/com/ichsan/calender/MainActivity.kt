package com.ichsan.calender

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ichsan.calender.databinding.ActivityMainBinding
import com.ichsan.calender.databinding.DialogAddBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bind : ActivityMainBinding
    private val taskFragment = TaskFragment()
    private val settingFragment = SettingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)

        bind.btnAdd.setOnClickListener(this)
        bind.llTask.setOnClickListener(this)
        bind.llSetting.setOnClickListener(this)
        val home = supportFragment(taskFragment)
        if (home == true) colorTask()

    }
    private fun colorSetting() {
        bind.tvTask.setTextColor(ContextCompat.getColor(this, R.color.grey_1))
        bind.icTask.setColorFilter(ContextCompat.getColor(this, R.color.grey_1), android.graphics.PorterDuff.Mode.SRC_IN)
        bind.tvSettings.setTextColor(ContextCompat.getColor(this, R.color.blue_primary))
        bind.icSetting.setColorFilter(ContextCompat.getColor(this, R.color.blue_primary), android.graphics.PorterDuff.Mode.SRC_IN)
    }
    private fun colorTask(){
        bind.tvTask.setTextColor(ContextCompat.getColor(this, R.color.blue_primary))
        bind.icTask.setColorFilter(ContextCompat.getColor(this, R.color.blue_primary), android.graphics.PorterDuff.Mode.SRC_IN)
        bind.tvSettings.setTextColor(ContextCompat.getColor(this, R.color.grey_1))
        bind.icSetting.setColorFilter(ContextCompat.getColor(this, R.color.grey_1), android.graphics.PorterDuff.Mode.SRC_IN)
    }
    private fun supportFragment(fragment: Fragment) : Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragment).commit()
        return true
    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.ll_task -> {
                supportFragment(taskFragment)
                colorTask()
            }
            R.id.ll_setting ->{
                supportFragment(settingFragment)
                colorSetting()
            }
            R.id.btn_add -> showDialog()
        }
    }

    private fun showDialog(){
        val rootView = DialogAddBinding.inflate(LayoutInflater.from(this))
        val dialog = AlertDialog.Builder(this)
            .setView(rootView.root)
            .setCancelable(true)
            .create()
        dialog.show()
        rootView.btnSave.setOnClickListener { dialog.dismiss() }

    }
}