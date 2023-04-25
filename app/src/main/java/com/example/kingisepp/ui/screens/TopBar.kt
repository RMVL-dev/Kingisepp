package com.example.kingisepp.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.kingisepp.R

@Composable
fun KingTopBar(
    modifier: Modifier = Modifier,
    @DrawableRes topBarImage: Int,
    @StringRes topBarText: Int,
    isShowingList: Boolean,
    navigateBack: () -> Unit
){

    Row(modifier = modifier
        .padding(8.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isShowingList)
            IconButton(onClick = navigateBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back Button"
                )
            }
        ItemImage(
            imageRes = topBarImage,
            size = 50,
            screen = 1
        )
        ItemText(
            text = stringResource(
                id = topBarText
            )
        )
    }
}

@Composable
fun ItemText(
    text:String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        modifier = modifier
            .padding(8.dp)

    )
}

@Composable
fun ItemImage(
    @DrawableRes imageRes:Int,
    modifier: Modifier = Modifier,
    descriptor: String = "",
    size: Int = 64,
    height: Int = 194,
    screen: Int
){
    when(screen){
        1->{
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = descriptor,
                modifier = modifier
                    .size(size.dp)
                    .padding(8.dp)
            )
        }
        2 -> {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
                    .height(height.dp),
                contentScale = ContentScale.Crop
            )
        }
    }


}