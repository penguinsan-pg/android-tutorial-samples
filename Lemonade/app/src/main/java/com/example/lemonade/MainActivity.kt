package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(LemonState.TREE) }
    var squeezeCount by remember { mutableStateOf(0) }
    var requiredSqueezeCount by remember { mutableStateOf(2) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Button(
            onClick = {
                if (state == LemonState.SQUEEZE) {
                    squeezeCount += 1
                }

                if (state == LemonState.SQUEEZE && squeezeCount < requiredSqueezeCount) {
                    // もう一度タップする必要がある
                } else {
                    val newState = state.next()
                    if (newState == LemonState.SQUEEZE) {
                        squeezeCount = 0
                        requiredSqueezeCount = (2..4).random()
                    }
                    state = newState
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC3ECD2),
            ),
            shape = RoundedCornerShape(percent = 15),
        ) {
            Image(
                painter = painterResource(state.painterId()),
                contentDescription = stringResource(state.contentDescriptionId()),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(state.messageId()),
            fontSize = 18.sp,
        )
    }
}

enum class LemonState {
    TREE {
        override fun painterId() = R.drawable.lemon_tree
        override fun contentDescriptionId() = R.string.lemon_tree_content_description
        override fun messageId() = R.string.lemon_tree_message
        override fun next() = LemonState.SQUEEZE
    },
    SQUEEZE {
        override fun painterId() = R.drawable.lemon_squeeze
        override fun contentDescriptionId() = R.string.lemon_squeeze_content_description
        override fun messageId() = R.string.lemon_squeeze_message
        override fun next() = LemonState.DRINK
    },
    DRINK {
        override fun painterId() = R.drawable.lemon_drink
        override fun contentDescriptionId() = R.string.lemon_drink_content_description
        override fun messageId() = R.string.lemon_drink_message
        override fun next() = LemonState.RESTART
    },
    RESTART {
        override fun painterId() = R.drawable.lemon_restart
        override fun contentDescriptionId() = R.string.lemon_restart_content_description
        override fun messageId() = R.string.lemon_restart_message
        override fun next() = LemonState.TREE
    };

    abstract fun painterId(): Int
    abstract fun contentDescriptionId(): Int
    abstract fun messageId(): Int
    abstract fun next(): LemonState
}
