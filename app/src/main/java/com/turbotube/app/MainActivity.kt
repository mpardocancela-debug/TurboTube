package com.turbotube.app

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 32, 28, 32)
            setBackgroundColor(0xFF101010.toInt())
        }

        val title = TextView(this).apply {
            text = "TurboTube"
            textSize = 32f
            setTextColor(0xFFFFFFFF.toInt())
            gravity = Gravity.CENTER
        }
        root.addView(title, matchWrap())

        val subtitle = TextView(this).apply {
            text = "Tu acceso rápido a YouTube"
            textSize = 16f
            setTextColor(0xFFCCCCCC.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 10, 0, 24)
        }
        root.addView(subtitle, matchWrap())

        val search = EditText(this).apply {
            hint = "Buscar vídeos en YouTube"
            singleLine = true
            textSize = 16f
            setTextColor(0xFFFFFFFF.toInt())
            setHintTextColor(0xFFAAAAAA.toInt())
            setPadding(16, 12, 16, 12)
            setBackgroundColor(0xFF292929.toInt())
        }
        root.addView(search, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { bottomMargin = 14 })

        val searchButton = Button(this).apply {
            text = "Buscar en YouTube"
            setOnClickListener {
                val query = search.text.toString().trim()
                if (query.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Escribe qué quieres buscar", Toast.LENGTH_SHORT).show()
                } else {
                    openYouTube("https://www.youtube.com/results?search_query=" + Uri.encode(query))
                }
            }
        }
        root.addView(searchButton, matchWidthWrap())

        val openButton = Button(this).apply {
            text = "Abrir YouTube"
            setOnClickListener { openYouTube("https://www.youtube.com") }
        }
        root.addView(openButton, matchWidthWrap())

        setContentView(root)
    }

    private fun matchWrap() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    private fun matchWidthWrap() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    ).apply { topMargin = 8 }

    private fun openYouTube(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(this, "No se ha encontrado una aplicación para abrir YouTube", Toast.LENGTH_LONG).show()
        }
    }
}
