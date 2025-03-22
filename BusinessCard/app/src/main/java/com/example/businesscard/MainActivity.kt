package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFD2E7D4))
    ) {
        BusinessCardMainArea(
            modifier = Modifier
                .weight(1f)
        )
        BusinessCardContacts()
    }
}

@Composable
fun BusinessCardMainArea(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "android logo",
            modifier = Modifier
                .background(color = Color(0xFF083041))
                .size(width = 100.dp, height = 100.dp)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 48.sp,
        )
        Text(
            text = stringResource(R.string.job),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF016C3B),
        )
    }
}

@Composable
fun BusinessCardContacts(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Contact(
            icon = Icons.Default.Phone,
            text = stringResource(R.string.phone_number),
        )
        Contact(
            icon = Icons.Default.Share,
            text = stringResource(R.string.sns_account),
        )
        Contact(
            icon = Icons.Default.Email,
            text = stringResource(R.string.email),
        )
    }
}

@Composable
fun Contact(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF016C3B),
        )
        Spacer(
            modifier.width(12.dp)
        )
        Text(
            text = text,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard( )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardMainAreaPreview() {
    BusinessCardTheme {
        BusinessCardMainArea()
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardContactsPreview() {
    BusinessCardTheme {
        BusinessCardContacts()
    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    BusinessCardTheme {
        Contact(
            icon = Icons.Default.Share,
            text = stringResource(R.string.sns_account),
        )
    }
}