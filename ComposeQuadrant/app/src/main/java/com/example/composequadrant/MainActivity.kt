package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .weight(weight = 1f)
        ) {
            Quadrant(
                title = stringResource(R.string.text_composable_title),
                description = stringResource(R.string.text_composable_description),
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .weight(weight = 1f)
            )
            Quadrant(
                title = stringResource(R.string.image_composable_title),
                description = stringResource(R.string.image_composable_description),
                modifier = Modifier
                    .background(color = Color(0xFFD0BCFF))
                    .weight(weight = 1f)
            )
        }
        Row(
            modifier = Modifier
                .weight(weight = 1f)
        ) {
            Quadrant(
                title = stringResource(R.string.row_composable_title),
                description = stringResource(R.string.row_composable_description),
                modifier = Modifier
                    .background(color = Color(0xFFB69DF8))
                    .weight(weight = 1f)
            )
            Quadrant(
                title = stringResource(R.string.column_composable_title),
                description = stringResource(R.string.column_composable_description),
                modifier = Modifier
                    .background(color = Color(0xFFF6EDFF))
                    .weight(weight = 1f)
            )
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(all = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}