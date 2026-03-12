package com.example.praticeapp


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AboutScreen()
        }
    }
}

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4))
            .verticalScroll(rememberScrollState())
    ) {
        AboutNavBar()
        AboutContent()
        AboutFooter()
    }
}

// ── Navigation bar ────────────────────────────────────────────────────────────

@Composable
fun AboutNavBar() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF222222))
            .statusBarsPadding()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Home", color = Color.White, fontSize = 13.sp)
        }

        Box(
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Login", color = Color.White, fontSize = 13.sp)
        }

        Box(
            modifier = Modifier
                .clickable { }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            // Highlight current page
            Text("About", color = Color(0xFFFFD700), fontSize = 13.sp, fontWeight = FontWeight.Bold)
        }

        Box(
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, CollectionsActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Collections", color = Color.White, fontSize = 13.sp)
        }

        Box(
            modifier = Modifier
                .clickable { }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Profile", color = Color.White, fontSize = 13.sp)
        }
    }
}

// ── About content card ────────────────────────────────────────────────────────

@Composable
fun AboutContent() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 60.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = "About Rare Collectables App",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // Paragraphs
            AboutParagraph(
                "The Rare Collectables App is designed for collectors who want to manage " +
                        "and track their valuable items in one place."
            )

            AboutParagraph(
                "Users can explore different collectables, store images of their collections, " +
                        "add detailed information about each item, and monitor the rarity and value " +
                        "of their collectables."
            )

            AboutParagraph(
                "The application also allows users to track price changes and set price alerts " +
                        "so they can stay updated on the market value of their items."
            )

            AboutParagraph(
                "This app helps collectors organize their collections, discover rare items, " +
                        "and understand the value of their collectables more easily."
            )
        }
    }
}

@Composable
fun AboutParagraph(text: String) {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = text,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        color = Color(0xFF333333)
    )
}

// ── Footer ────────────────────────────────────────────────────────────────────

@Composable
fun AboutFooter() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF222222))
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Rare Collectables App", color = Color.White)
    }
}