package com.example.kingisepp.ui.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kingisepp.data.mainMenuList
import com.example.kingisepp.data.museumsList
import com.example.kingisepp.data.natureList
import com.example.kingisepp.data.restaurantsList
import com.example.kingisepp.items.Attractrion
import com.example.kingisepp.ui.viewmodel.KingViewModel


@Composable
fun KingApp(
    menuList: List<Attractrion> = mainMenuList,
    modifier: Modifier = Modifier
) {
    val kingViewModel: KingViewModel = viewModel()
    val uiState = kingViewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            KingTopBar(
                topBarImage = uiState.value.topBarImage,
                topBarText = uiState.value.topBarText,
                isShowingList = uiState.value.isShowingList,
                navigateBack = { kingViewModel.navigateBack() }
            )
        }
    ) { innerPadding ->
        if (!uiState.value.isShowingList)
            MenuList(
                onClickMenuItem = {
                    kingViewModel.updateCurrentList(it)
                },
                modifier = Modifier.padding(innerPadding)
            )
        else
            InnerList(
                attractionListName = uiState.value.currentList,
                modifier = Modifier.padding(innerPadding)
            )
    }

}


@Preview(showBackground = true)
@Composable
fun ItemPreview(){
    KingApp()
}