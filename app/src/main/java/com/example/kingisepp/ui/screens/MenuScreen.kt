package com.example.kingisepp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.kingisepp.data.mainMenuList
import com.example.kingisepp.items.Attractrion


@Composable
fun MenuList(
    menuList: List<Attractrion> = mainMenuList,
    modifier: Modifier = Modifier,
    onClickMenuItem: (Attractrion) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(menuList) { item ->
            MenuItem(
                menuItem = item,
                onClickMenuItem = onClickMenuItem
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuItem(
    menuItem: Attractrion,
    descriptor:String = "",
    modifier: Modifier = Modifier,
    onClickMenuItem:(Attractrion) -> Unit
){
    Card(
        modifier = modifier,
        elevation = 4.dp,
        onClick = {onClickMenuItem(menuItem)}
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically)
        {
            ItemImage(
                imageRes = menuItem.image,
                size = 64,
                screen = 1
            )
            ItemText(text = stringResource(id = menuItem.name))
        }
    }
}
