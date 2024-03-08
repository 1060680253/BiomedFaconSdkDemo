package com.biomed.facon.ftc.demo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.biomed.facon.ftc.sdk.DetectionManager
import com.biomed.facon.ftc.sdk.ITesterInfo


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DetectionManager.setUserTag("18812345678")
        findViewById<View>(R.id.openDeteBtn).setOnClickListener {
            val isSuccess = DetectionManager.startDetect(this, ITesterInfo
                .Builder()
                .iTesterId("7878121")
                .iTesterBirthday("1998-06-12")
                .iTesterGender("男")
                .iTesterName("小李")
                .iTesterHeight(180)
                .iTesterWeight(120)
                .build()){
                Toast.makeText(this@MainActivity,it,Toast.LENGTH_SHORT).show()
            }
            if(!isSuccess){
                Toast.makeText(this@MainActivity,"初始化中，或者初始化失败",Toast.LENGTH_SHORT).show()
            }
        }
    }

}