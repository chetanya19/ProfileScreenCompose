package com.zikman.constraintlayoutassignmentw1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.zikman.constraintlayoutassignmentw1.R
import com.zikman.constraintlayoutassignmentw1.data.DataUtils
import com.zikman.constraintlayoutassignmentw1.ui.patterns.ButtonPro
import com.zikman.constraintlayoutassignmentw1.ui.patterns.ButtonType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(
    profileImage: Int,
    feedImageList: List<String>,
    userName: String,
    userLocation: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                ProfileHeader(
                    profileImage = profileImage,
                    userName = userName,
                    userLocation = userLocation
                )
            }
            item {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(count = 2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalItemSpacing = 10.dp
                ) {
                    items(feedImageList) {
                        AsyncImage(
                            model = it,
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.FillBounds,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(
    profileImage: Int,
    userName: String,
    userLocation: String,
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        val (
            topViewSpace, profilePic, name, location, followButton, followButtonBottomSpace,
            messageButton, messageButtonBottomSpace
        ) = createRefs()
        val context = LocalContext.current

        Spacer(
            modifier = Modifier
                .constrainAs(topViewSpace)
                {
                    top.linkTo(parent.top)
                }
                .fillMaxWidth()
                .height(76.dp)
        )
        Image(
            painter = painterResource(id = profileImage),
            contentDescription = "Profile Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .constrainAs(profilePic) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topViewSpace.bottom)
                }
                .size(128.dp)
                .clip(CircleShape)
        )
        Text(
            text = userName,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .constrainAs(name) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(profilePic.bottom)
                }
                .padding(top = 35.dp)
        )
        Text(
            text = userLocation,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .constrainAs(location) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(name.bottom)
                }
                .padding(top = 15.dp, bottom = 35.dp)
        )

        ButtonPro(
            buttonType = ButtonType.Solid.ordinal,
            buttonText = "Follow",
            modifier = Modifier
                .constrainAs(followButton) {
                    top.linkTo(location.bottom)
                }
                .fillMaxWidth()
                .height(50.dp),
            onClick = {
                Toast.makeText(context, "Follow Button Clicked", Toast.LENGTH_LONG).show()
            }
        )
        Spacer(
            modifier = Modifier
                .constrainAs(followButtonBottomSpace)
                {
                    top.linkTo(followButton.bottom)
                }
                .fillMaxWidth()
                .height(15.dp)
        )
        ButtonPro(
            buttonType = ButtonType.Border.ordinal,
            buttonText = "Message",
            modifier = Modifier
                .constrainAs(messageButton) {
                    top.linkTo(followButtonBottomSpace.bottom)
                }
                .fillMaxWidth()
                .height(50.dp),
            onClick = {
                Toast.makeText(context, "Message Button Clicked", Toast.LENGTH_LONG).show()
            }
        )
        Spacer(
            modifier = Modifier
                .constrainAs(messageButtonBottomSpace)
                {
                    top.linkTo(messageButton.bottom)
                }
                .fillMaxWidth()
                .height(25.dp)
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        profileImage = R.drawable.profile_pic,
        feedImageList = DataUtils.feedImageList,
        "Chetanya Arora",
        "Bengaluru, India"
    )
}

@Preview
@Composable
fun ProfileScreenHeaderPreview() {
    ProfileHeader(
        profileImage = R.drawable.profile_pic,
        "Chetanya Arora",
        "Bengaluru, India"
    )
}