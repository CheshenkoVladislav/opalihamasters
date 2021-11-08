package com.example.opalihamasters.mainactivity.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.opalihamasters.NavControllerProvider
import com.example.opalihamasters.R
import com.example.opalihamasters.mainactivity.NavGraph
import com.example.opalihamasters.ui.theme.OpalihaMastersTheme

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    OpalihaMastersTheme {
        Main()
    }
}

@Composable
fun Main(viewModel: MainViewModel? = null) {
    Scaffold(
        drawerContent = {
            NavDrawer()
        },
        backgroundColor = MaterialTheme.colors.background
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (text1, text2) = createRefs()
            Item(
                modifier = Modifier
                    .itemBackground()
                    .clickable {
                        viewModel?.onClickServices()
                    }
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                        bottom.linkTo(text2.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(Dp(16f)),
                drawableId = R.drawable.services,
                text = "Услуги"
            )
            Item(
                modifier = Modifier
                    .itemBackground()
                    .padding(Dp(16f))
                    .clickable {
                        viewModel?.onClickProfile()
                    }
                    .constrainAs(text2) {
                        top.linkTo(text1.bottom)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(text1.start)
                        end.linkTo(text1.end)
                    },
                drawableId = R.drawable.profile,
                text = "Профиль"
            )
        }
    }
}

@Composable
private fun Item(
    modifier: Modifier,
    drawableId: Int,
    text: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onPrimary)
        )
        Text(
            textAlign = TextAlign.Center,
            text = text,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
private fun Modifier.itemBackground() = this.background(
    color = MaterialTheme.colors.onBackground,
    shape = RoundedCornerShape(corner = CornerSize(size = Dp(15f)))
)

@Composable
fun NavDrawer() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "One", modifier = Modifier.fillMaxWidth())
        Text(text = "Two", modifier = Modifier.fillMaxWidth())
        Text(text = "Three", modifier = Modifier.fillMaxWidth())
    }
}