package com.example.kingisepp.ui.viewmodel

import androidx.compose.runtime.currentRecomposeScope
import androidx.lifecycle.ViewModel
import com.example.kingisepp.R
import com.example.kingisepp.data.*
import com.example.kingisepp.items.Attractrion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class KingViewModel: ViewModel() {

    private val _uiState = MutableStateFlow (
            KingiseppModel(
                currentList = mainMenuList,
                topBarImage = R.drawable.village,
                topBarText = R.string.app_name,
                isShowingList = false
            )
    )

    val uiState: StateFlow<KingiseppModel> = _uiState

    fun updateCurrentList(mainMenuItem: Attractrion){
        var list:List<Attractrion>
        var topBarImage: Int
        var topBarText: Int

        when(mainMenuItem.name){
            R.string.attractions ->{
                list = attractionList
                topBarImage = R.drawable.attractive
                topBarText = R.string.attractions
            }
            R.string.nature ->{
                list = natureList
                topBarImage = R.drawable.nature
                topBarText = R.string.nature
            }
            R.string.museums ->{
                list = museumsList
                topBarImage = R.drawable.museum
                topBarText = R.string.museums
            }
            R.string.resto ->{
                list = restaurantsList
                topBarImage = R.drawable.food
                topBarText = R.string.resto
            }
            else -> {
                list = attractionList
                topBarImage = R.drawable.attractive
                topBarText = R.string.attractions
            }
        }

        _uiState.update {
            it.copy(
                currentList = list,
                topBarImage = topBarImage,
                topBarText = topBarText,
                isShowingList = true
            )
        }
    }

    fun navigateBack(){
        _uiState.update {
            it.copy(
                currentList = mainMenuList,
                topBarImage = R.drawable.village,
                topBarText = R.string.app_name,
                isShowingList = false
            )
        }
    }

    fun attractionMenuItem(){
        _uiState.update {
            it.copy(
                currentList = attractionList,
                topBarImage = R.drawable.attractive,
                topBarText = R.string.attractions
            )
        }
    }

    fun natureMenuItem(){
        _uiState.update {
            it.copy(
                currentList = natureList,
                topBarImage = R.drawable.nature,
                topBarText = R.string.nature
            )
        }
    }

    fun museumsMenuItem(){
        _uiState.update {
            it.copy(
                currentList = museumsList,
                topBarImage = R.drawable.museum,
                topBarText = R.string.museums
            )
        }
    }

    fun restaurantsMenuItem(){
        _uiState.update {
            it.copy(
                currentList = restaurantsList,
                topBarImage = R.drawable.food,
                topBarText = R.string.resto
            )
        }
    }

    fun resetScreens(){
        _uiState.update {
            it.copy(
                currentList = mainMenuList,
                topBarImage = R.drawable.village,
                topBarText =  R.string.app_name
            )
        }
    }
}