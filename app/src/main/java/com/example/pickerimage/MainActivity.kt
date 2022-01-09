package com.example.pickerimage

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.listeners.IPickResult
import kotlinx.android.synthetic.main.activity_main.*
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.core.app.ActivityCompat
import android.widget.Toast
import com.example.pickerimage.list.ListActivity
import com.vansuita.pickimage.dialog.PickImageDialog
import com.vansuita.pickimage.enums.EPickType
import com.vansuita.pickimage.bundle.PickSetup

class MainActivity : AppCompatActivity() , IPickResult {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       img.setOnClickListener {
           if (cameraPermissionGranted()) {
               choosePic()
           } else {
               val request_code = 20
               askCameraPermission(request_code)
           }
       }

        btn.setOnClickListener {
            startActivity(Intent(this@MainActivity , ListActivity::class.java))
        }

    }

    private fun askCameraPermission(requestCode: Int) {
        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CAMERA), requestCode)
    }

    private fun cameraPermissionGranted(): Boolean {
        return (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
    }


    private fun choosePic() {
        val setup = PickSetup()
            .setTitle("settitle")
            .setProgressText("progress text")
            .setPickTypes(EPickType.GALLERY)
            .setSystemDialog(true)
        PickImageDialog.build(setup).show(this)
    }




    override fun onPickResult(r: PickResult?) {
        if (r != null) {
            img.setImageBitmap(r.bitmap)
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        if (requestCode == 20) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                choosePic()
            } else {
                Toast.makeText(this, "نیاز به اجازه ی دسترسی دوربین", Toast.LENGTH_SHORT).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}