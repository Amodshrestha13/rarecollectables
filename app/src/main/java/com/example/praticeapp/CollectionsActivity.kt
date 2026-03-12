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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.platform.LocalContext


class CollectionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollectionsScreen()
        }
    }
}

// ── Data model ────────────────────────────────────────────────────────────────

data class Collectable(
    val title: String,
    val description: String,
    val rating: Int,       // out of 5
    val rarity: String,
    val price: String
)

val sampleCollectables = listOf(
    Collectable(
        title = "Hot Wheels Treasure Hunt",
        description = "Rare Hot Wheels car from 1995 series.",
        rating = 5,
        rarity = "Ultra Rare",
        price = "\$120"
    ),
    Collectable(
        title = "Vintage Comic",
        description = "First edition classic comic book.",
        rating = 4,
        rarity = "Rare",
        price = "\$250"
    ),
    Collectable(
        title = "Antique Coin",
        description = "Historic coin from early 1900s.",
        rating = 5,
        rarity = "Legendary",
        price = "\$500"
    )
)

// ── Screen ────────────────────────────────────────────────────────────────────

@Composable
fun CollectionsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4))
            .verticalScroll(rememberScrollState())
    ) {
        AppNavBar()
        PageHeader()
        CollectablesGrid()
        AddCollectableButton()
        AppFooter()
    }
}

// ── Navigation bar ────────────────────────────────────────────────────────────

@Composable
fun AppNavBar() {
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
            Text("Home", color = Color.White, fontSize = 16.sp)
        }
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

// ── Page header ───────────────────────────────────────────────────────────────

@Composable
fun PageHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Collectables",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Track and manage your rare collectables",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

// ── Cards grid ────────────────────────────────────────────────────────────────

@Composable
fun CollectablesGrid() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        sampleCollectables.forEach { item ->
            CollectableCard(item)
        }
    }
}

@Composable
fun CollectableCard(item: Collectable) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {

            // Placeholder image area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "[ Image ]", color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Title
            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Description
            Text(text = item.description, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(6.dp))

            // Star rating
            val stars = "★".repeat(item.rating) + "☆".repeat(5 - item.rating)
            Text(text = stars, color = Color(0xFFFFD700), fontSize = 18.sp)

            Spacer(modifier = Modifier.height(4.dp))

            // Rarity
            Text(
                text = "Rarity: ${item.rarity}",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB30000),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Price
            Text(
                text = "Current Price: ${item.price}",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Button
            Button(
                onClick = { /* TODO: set price alert */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF222222),
                    contentColor = Color.White
                )
            ) {
                Text("Set Price Alert")
            }
        }
    }
}

// ── Add new collectable ───────────────────────────────────────────────────────

@Composable
fun AddCollectableButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { /* TODO: open add dialog */ },
            modifier = Modifier.width(200.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF222222),
                contentColor = Color.White
            )
        ) {
            Text("+ Add New Collectable")
        }
    }
}

// ── Footer ────────────────────────────────────────────────────────────────────

@Composable
fun AppFooter() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF222222))
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Rare Collectables", color = Color.White)
    }
}