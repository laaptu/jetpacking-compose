package org.ahivs.jetpacking.app.basic

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ahivs.jetpacking.app.R
import org.ahivs.jetpacking.app.theme.MyApplicationTheme

class BasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MessageCard(message = Message("Charles Dickens", "Great Expectations"))
            }
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
                tint = colorResource(id = R.color.purple_200)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = message.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.body2
                )
            }
        }

    }

    @Preview
    @Composable
    fun PreviewMessageChard() {
        MyApplicationTheme {
            MessageCard(message = Message("Charles Dickens", "Great Expectations"))
        }
    }
}