package com.gmail.photoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ArticleDetailActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        if(intent != null){
            findViewById<TextView>(R.id.detailTitle).text = intent.getStringExtra("title")
            findViewById<TextView>(R.id.detailDescription).text = intent.getStringExtra("desc")
            val imgView = findViewById<ImageView>(R.id.detailImage)
            Picasso.get().load(intent.getStringExtra("imgURL")).into(imgView)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleDetailActivity> {
        override fun createFromParcel(parcel: Parcel): ArticleDetailActivity {
            return ArticleDetailActivity(parcel)
        }

        override fun newArray(size: Int): Array<ArticleDetailActivity?> {
            return arrayOfNulls(size)
        }
    }
}