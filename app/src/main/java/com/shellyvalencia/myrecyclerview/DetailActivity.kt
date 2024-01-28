package com.shellyvalencia.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataHarbinger = intent.getParcelableExtra<Harbinger>("key_harbinger")!!

        val tvDetailName:TextView = findViewById(R.id.tv_detail_name)
        val tvDetailCodename:TextView = findViewById(R.id.tv_detail_codename)
        val tvDetailDescription:TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto:ImageView = findViewById(R.id.iv_detail_photo)
        val actionShare:Button = findViewById(R.id.action_share)

        tvDetailName.text = dataHarbinger.name
        tvDetailCodename.text = dataHarbinger.codename
        tvDetailDescription.text = dataHarbinger.description
        ivDetailPhoto.setImageResource(dataHarbinger.photo)
        actionShare.setOnClickListener(this)
    }

    override fun onClick(v: View) {
    when (v.id) {

        R.id.action_share -> {
            val intent = Intent()
			intent.action = Intent.ACTION_SEND
			intent.type = "text/plain"

			startActivity(Intent.createChooser(intent, "Please select app: "))
        }
    }
}
}