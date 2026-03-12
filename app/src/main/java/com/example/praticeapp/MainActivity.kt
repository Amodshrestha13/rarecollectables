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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.statusBarsPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RareCollectablesApp()
        }
    }
}

@Composable
fun RareCollectablesApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AppNavigationBar()
        WelcomeSection()
        CollectablesSection()
        Footer()
    }
}

@Composable
fun AppNavigationBar() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF222222))
            .statusBarsPadding()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Each nav item is a Box so the whole area is tappable
        Box(
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Login", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, AboutActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("About", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, CollectionsActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Collections", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, ProfileActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Profile", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun WelcomeSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF333333))
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Rare Collectables",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Discover valuable and rare items from collectors around the world.",
            color = Color.White
        )
    }
}

@Composable
fun CollectablesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Latest Valuable Collectables",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        CollectableCard(
            title = "Rare Hot Wheels Car",
            description = "Limited edition Hot Wheels model highly valued by collectors."
        )
        CollectableCard(
            title = "Vintage Coin",
            description = "An antique coin from 1900 with significant historical value."
        )
        CollectableCard(
            title = "Classic Comic Book",
            description = "Original edition comic book loved by collectors worldwide."
        )
    }
}

@Composable
fun CollectableCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = description)
        }
    }
}

@Composable
fun Footer() {
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