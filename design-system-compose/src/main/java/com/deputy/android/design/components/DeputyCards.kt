package com.deputy.android.design.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deputy.android.design.theme.DeputyTheme

@Composable
fun DeputyCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable () ->
    Unit
) {
    onClick?.let {
        modifier.clickable {
            onClick()
        }
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = 1.dp,
        content = content,
        backgroundColor = DeputyTheme.colors.BackgroundQuaternary
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DeputyCardPreview() {
    DeputyTheme {
        DeputyCard(modifier = Modifier.padding(12.dp)) {
            Column(modifier = Modifier.padding(15.dp)) {
                DeputyPrimaryButton(text = "This is a test")
            }
        }
    }
}
