package com.example.mysubmission

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mysubmission.DetailActivity.Companion.extras

class DetailActivity : AppCompatActivity() {

    companion object{
        const val ITEM_TITTLE = "ITEM TITLE"
        const val ITEM_LOCATION = "LOKASI ITEM"
        const val ITEM_DESC = "DESKRIPSI ITEM"

        val extras: Bundle = Intent.extras!!
        val byteArray = extras.getByteArray("img")
        val img = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val photo: ImageView = findViewById(R.id.img_detail_photo)
        val nama: TextView = findViewById(R.id.tv_item_title)
        val lokasi: TextView = findViewById(R.id.tv_item_location)
        val detail: TextView = findViewById(R.id.tv_item_desc)

        photo.setImageBitmap(img)


        val title = intent.getStringExtra(ITEM_TITTLE)
        val location = intent.getStringExtra(ITEM_LOCATION)
        val deskripsi = intent.getStringExtra(ITEM_DESC)

        nama.text = title
        lokasi.text = location
        detail.text = deskripsi
    }
}
