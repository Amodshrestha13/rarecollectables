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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4))
            .verticalScroll(rememberScrollState())
    ) {
        LoginNavBar()

        // Center the login box vertically — spacer fills remaining space
        Spacer(modifier = Modifier.weight(1f))
        LoginBox()
        Spacer(modifier = Modifier.weight(1f))

        LoginFooter()
    }
}

// ── Navigation bar ────────────────────────────────────────────────────────────

@Composable
fun LoginNavBar() {
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
            // Highlight current page
            Text("Login", color = Color(0xFFFFD700), fontSize = 13.sp, fontWeight = FontWeight.Bold)
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
                .clickable {
                    val intent = Intent(context, ProfileActivity::class.java)
                    context.startActivity(intent)
                }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text("Profile", color = Color.White, fontSize = 13.sp)
        }
    }
}

// ── Login box ─────────────────────────────────────────────────────────────────

@Composable
fun LoginBox() {
    var accountName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .padding(horizontal = 40.dp),
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
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Account Name field
            LoginField(
                label = "Account Name",
                value = accountName,
                onValueChange = { accountName = it },
                placeholder = "Enter your account name",
                isPassword = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password field
            LoginField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter your password",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login button
            Button(
                onClick = { /* TODO: handle login */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF222222),
                    contentColor = Color.White
                )
            ) {
                Text("Log In", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun LoginField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation()
            else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = if (isPassword) KeyboardType.Password
                else KeyboardType.Text
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFCCCCCC),
                focusedBorderColor = Color(0xFF222222)
            )
        )
    }
}

// ── Footer ────────────────────────────────────────────────────────────────────

@Composable
fun LoginFooter() {
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