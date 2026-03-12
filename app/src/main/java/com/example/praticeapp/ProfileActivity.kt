package com.example.praticeapp


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4))
            .verticalScroll(rememberScrollState())
    ) {
        ProfileNavBar()

        Spacer(modifier = Modifier.weight(1f))
        ProfileContent()
        Spacer(modifier = Modifier.weight(1f))

        ProfileFooter()
    }
}

// ── Navigation bar ────────────────────────────────────────────────────────────

@Composable
fun ProfileNavBar() {
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
                .clickable {
                    val intent = Intent(context, AboutActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("About", color = Color.White, fontSize = 13.sp)
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
            // Highlight current page
            Text("Profile", color = Color(0xFFFFD700), fontSize = 13.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// ── Profile card ──────────────────────────────────────────────────────────────

@Composable
fun ProfileContent() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Profile picture placeholder (circle)
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E0))
                    .border(2.dp, Color(0xFFCCCCCC), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "📷", fontSize = 36.sp)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Title
            Text(
                text = "User Profile",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Info rows
            Column(modifier = Modifier.fillMaxWidth()) {
                ProfileInfoRow(label = "Account Name", value = "Collector123")
                ProfileInfoRow(label = "Email", value = "collector@email.com")
                ProfileInfoRow(label = "Total Collectables", value = "15")
                ProfileInfoRow(label = "Favorite Category", value = "Hot Wheels")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Edit Profile button
            Button(
                onClick = { /* TODO: open edit profile */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF222222),
                    contentColor = Color.White
                )
            ) {
                Text("Edit Profile", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color(0xFF444444)
        )
    }
    HorizontalDivider(color = Color(0xFFEEEEEE), thickness = 1.dp)
}

// ── Footer ────────────────────────────────────────────────────────────────────

@Composable
fun ProfileFooter() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF222222))
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "© 2026 Rare Collectables", color = Color.White)
    }
}