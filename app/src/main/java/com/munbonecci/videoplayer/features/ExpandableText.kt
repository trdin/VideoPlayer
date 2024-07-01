package com.munbonecci.videoplayer.features

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpandableText(
    summary: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ex tellus, tempus id volutpat nec, efficitur quis odio. In hac habitasse platea dictumst. In feugiat eget orci sed porta. Vestibulum in lobortis turpis. Aliquam urna risus, gravida eu ante et, vestibulum porta justo. Morbi eleifend metus massa, eget commodo lorem faucibus ut. Aliquam efficitur, justo ut molestie molestie, ligula nulla aliquam dolor, vel venenatis eros arcu sit amet nisl. Quisque in tempus diam, a pretium metus. Morbi vulputate nisl ut metus consequat lacinia. Sed aliquet ex a ante placerat ornare. Morbi laoreet, turpis sed faucibus fringilla, velit tellus sodales orci, a tempor augue turpis quis lectus. Vivamus iaculis a nibh eu sagittis. Etiam eu sollicitudin purus. Maecenas eu eleifend mauris. Mauris arcu augue, gravida non risus ac, condimentum pulvinar velit." ,
    numberOfLines: Int = 5
) {

    var isShrunk by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp, top = 16.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() }, // here to prevent the ripple effect
                indication = null
            ) {
                isShrunk = !isShrunk
            },

        ) {

        Text(
            text = summary,
            maxLines = if (isShrunk) numberOfLines else Int.MAX_VALUE,
            modifier = Modifier.fillMaxWidth()
                .animateContentSize(),
            color = Color.White,
            lineHeight = 20.sp,
            overflow = TextOverflow.Ellipsis,
            onTextLayout= { textLayoutResult ->
                isShrunk = textLayoutResult.hasVisualOverflow
            }

        )

        if (isShrunk) {
            Text(
                text = "Show More",
                textDecoration= TextDecoration.Underline,
                color = Color.Blue,
            )

        }

    }
}