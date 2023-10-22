package com.zikman.constraintlayoutassignmentw1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.zikman.constraintlayoutassignmentw1.data.DataUtils
import com.zikman.constraintlayoutassignmentw1.ui.screens.ProfileScreen
import com.zikman.constraintlayoutassignmentw1.ui.theme.ConstraintLayoutAssignmentW1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutAssignmentW1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen(
                        profileImage = R.drawable.profile_pic,
                        feedImageList = DataUtils.feedImageList,
                        userName = "Chetanya Arora",
                        userLocation = "Bengaluru, India"
                    )
                }
            }
        }
    }
}