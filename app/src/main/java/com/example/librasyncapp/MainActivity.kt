package com.example.librasyncapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the WebView by its ID
        val webView: WebView = findViewById(R.id.webView)

        // Enable JavaScript and DOM Storage (Crucial for web apps)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        // Ensure links and redirects open inside the app, not in the external browser
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        // Load the HTML file from the local assets folder
        webView.loadUrl("file:///android_asset/index.html")
    }

    // This ensures that if the user hits the back button on their phone,
    // it goes back a page in the app rather than closing the app entirely.
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val webView: WebView = findViewById(R.id.webView)
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}