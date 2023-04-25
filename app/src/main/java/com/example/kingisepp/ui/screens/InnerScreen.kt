package com.example.kingisepp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kingisepp.R
import com.example.kingisepp.data.attractionList
import com.example.kingisepp.items.Attractrion




@Composable
fun InnerList(
    attractionListName: List <Attractrion>,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(8.dp)
    ){
        items(attractionListName){ item ->
            InnerCard(attraction = item)
        }
    }
}


@Composable
fun InnerCard(
    modifier: Modifier = Modifier,
    attraction:Attractrion = Attractrion(
        name = R.string.church,
        image = R.drawable.attraction_one
    )
){
    Card(modifier = modifier) {
        Column (modifier = modifier.padding(8.dp)) {
            ItemImage(
                imageRes = attraction.image,
                screen = 2
            )
            Spacer(modifier = Modifier.height(5.dp))
            ItemText(
                text = stringResource(id = attraction.name)
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun AttractionCardPreview(){
    InnerList(
        attractionListName = attractionList
    )
}