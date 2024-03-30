package com.nemanja02.catlist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nemanja02.catlist.RetrofitInstance
import com.nemanja02.catlist.model.Breed


private val topBarContainerColor = Color.LightGray.copy(alpha = 0.5f)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatListScreen() {
    val breeds = remember { mutableStateOf<List<Breed>>(emptyList()) }

    LaunchedEffect(Unit) {
        breeds.value = RetrofitInstance.api.getBreeds()
    }

    // Display it as cards one under the other, use material3 Card
    LazyColumn {
        items(breeds.value) { breed ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        // Handle card click
                    }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    breed.image?.let { image ->
                        Image(
                            painter = rememberAsyncImagePainter(image.url),
                            contentDescription = breed.name,
                            modifier = Modifier.size(200.dp, 150.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(text = breed.name, style = MaterialTheme.typography.bodyLarge)
                    Text(
                        text = if (breed.description.length > 250) "${breed.description.take(250)}..." else breed.description,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        breed.temperament.split(",").shuffled().take(3).forEach { temperament ->
                            AssistChip(
                                onClick = { /* Handle chip click */ },
                                label = { Text(temperament.trim()) }
                            )
                        }
                    }
                }
            }
        }
    }
}