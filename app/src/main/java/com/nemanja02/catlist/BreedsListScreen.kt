package com.nemanja02.catlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nemanja02.catlist.model.Breed

@Composable
fun BreedsListScreen(navController: NavController) {
    val breeds = remember { mutableStateOf<List<Breed>>(emptyList()) }

    LaunchedEffect(Unit) {
        breeds.value = RetrofitInstance.api.getBreeds()
    }


    // Display the breeds in your UI

    Text(text = "Breeds List Screen")


    // create card for each breed
    for (breed in breeds.value) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    navController.navigate("breedsDetails/${breed.id}")
                }
        ) {
            Column {
                Text(text = breed.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = breed.description, style = MaterialTheme.typography.bodyLarge)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
