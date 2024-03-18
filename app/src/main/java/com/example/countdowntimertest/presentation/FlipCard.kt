
package com.example.countdowntimertest.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countdowntimertest.ui.theme.Card_Color
import com.example.countdowntimertest.ui.theme.Count_Down_Color

private val CARD_WIDTH = 70.dp
private val CARD_HEIGHT = 36.dp
private val TOP_SHAPE = RoundedCornerShape(4.dp, 4.dp, 8.dp,8.dp)
private val BOTTOM_SHAPE = RoundedCornerShape(8.dp, 8.dp, 4.dp, 4.dp)

@Composable
fun FlipCard(
    text: String,
    position: FlapPosition,
    elevation: Dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.requiredSize(width = CARD_WIDTH, height = CARD_HEIGHT).background(Card_Color),
        elevation= CardDefaults.cardElevation(
            defaultElevation = elevation
        ),
        shape = when (position) {
            FlapPosition.TOP -> TOP_SHAPE
            FlapPosition.BOTTOM -> BOTTOM_SHAPE
        }
    ) {
        Box(
            modifier = Modifier.background(Card_Color).fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontFamily = FontFamily.SansSerif,
                fontSize = 32.sp,
                color = Count_Down_Color,
                modifier = Modifier
                    .requiredWidth(IntrinsicSize.Min)
                    .requiredHeight(IntrinsicSize.Min)
                    .run {
                        when (position) {
                            FlapPosition.TOP -> offset(y = CARD_HEIGHT / 2)
                            FlapPosition.BOTTOM -> offset(y = CARD_HEIGHT / -2)
                        }
                    }
                    .offset(y = (-2).dp)
            )
        }
    }
}

enum class FlapPosition {
    TOP, BOTTOM
}
