package com.zikman.constraintlayoutassignmentw1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun FormScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        val context = LocalContext.current
        val (r1, r2, r3, r4, r5, r6) = createRefs()
        var nameState by remember {
            mutableStateOf("")
        }
        var purposeState by remember {
            mutableStateOf("")
        }
        var addressState by remember {
            mutableStateOf("")
        }
        var genderState by remember {
            mutableStateOf("")
        }
        Text(
            text = "Course Application Form",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.constrainAs(r1) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, margin = 30.dp)
            }
        )
        TextField(
            value = nameState,
            label = { Text("Full Name") },
            onValueChange = {
                nameState = it
            },
            modifier = Modifier
                .constrainAs(r2) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(r1.bottom, margin = 20.dp)
                }
                .fillMaxWidth()
        )
        TextField(
            value = purposeState,
            label = { Text("Purpose Of Joining Course") },
            onValueChange = {
                purposeState = it
            },
            modifier = Modifier
                .constrainAs(r3) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(r2.bottom, margin = 20.dp)
                }
                .fillMaxWidth()
                .height(120.dp)
        )
        TextField(
            value = addressState,
            label = { Text("Address") },
            onValueChange = {
                addressState = it
            },
            modifier = Modifier
                .constrainAs(r4) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(r3.bottom, margin = 20.dp)
                }
                .fillMaxWidth()
                .height(70.dp)
        )
        Row(
            modifier = Modifier
                .constrainAs(r5) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(r4.bottom, margin = 20.dp)
                }
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = genderState == "Male",
                onClick = { genderState = "Male" },
                colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.tertiary)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text("Male")
            Spacer(modifier = Modifier.size(16.dp))
            RadioButton(
                selected = genderState == "Female",
                onClick = { genderState = "Female" },
                colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.tertiary)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text("Female")
            Spacer(modifier = Modifier.size(16.dp))

        }
        Button(
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier
                .constrainAs(r6) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 50.dp)
                }
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Submit",
                style = MaterialTheme.typography.bodyLarge,

            )
        }
    }
}

@Preview
@Composable
fun FormScreenPreview() {
    FormScreen()
}