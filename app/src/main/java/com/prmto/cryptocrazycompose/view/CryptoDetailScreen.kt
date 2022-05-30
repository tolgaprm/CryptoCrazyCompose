package com.prmto.cryptocrazycompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.prmto.cryptocrazycompose.model.Crypto
import com.prmto.cryptocrazycompose.util.Resource
import com.prmto.cryptocrazycompose.viewmodel.CryptoDetailViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CryptoDetailScreen(
    navController: NavController,
    cryptoId: String,
    cryptoPrice: String,
    viewModel: CryptoDetailViewModel = hiltViewModel()
) {

    // Step 1 -> Wrong
    /* val scope = rememberCoroutineScope()

     scope.launch {
         cryptoItem = viewModel.getCrypto(cryptoId)
     }*/


    // Step 2 -> Better

    /*
     var cryptoItem by remember {
        mutableStateOf<Resource<Crypto>>(Resource.Loading())
    }
    LaunchedEffect(key1 = Unit) {
        cryptoItem = viewModel.getCrypto(cryptoId)
    }*/

    // Bunu yukarıdakilere göre daha az kodla yapıyoruz
    val cryptoItem by produceState<Resource<Crypto>>(initialValue = Resource.Loading()) {
        value = viewModel.getCrypto(cryptoId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            when (cryptoItem) {

                is Resource.Success -> {
                    val selectedCrypto = cryptoItem.data!![0]
                    Text(
                        text = selectedCrypto.name,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary,
                        textAlign = TextAlign.Center
                    )

                    Image(
                        painter = rememberImagePainter(data = selectedCrypto.logoUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(200.dp, 200.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = cryptoPrice,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center
                    )
                }

                is Resource.Error -> {
                    Text(text = cryptoItem.message!!)
                }

                is Resource.Loading -> {
                    CircularProgressIndicator(color = MaterialTheme.colors.primary)
                }
            }
        }
    }
}