package com.revature.jetcomposefirstsample

import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toFile
import coil.imageLoader
import coil.memory.MemoryCache
import com.revature.jetcomposefirstsample.ui.theme.JetComposeFirstSampleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.math.sqrt

class MTBox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeFirstSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun PdfViewer(
    modifier: Modifier=Modifier,
    uri: Uri,
    verticalArrangement: Arrangement.Vertical
        =Arrangement
        .spacedBy(8.dp)
)
{
    val rendererScope = rememberCoroutineScope()
    val mutex = remember { Mutex() }

    val renderer by produceState<PdfRenderer?>(null, uri)
    {
        rendererScope.launch(Dispatchers.IO)
        {
            val input = ParcelFileDescriptor.open(uri.toFile(),
                ParcelFileDescriptor.MODE_READ_ONLY)
            value = PdfRenderer(input)
        }

        awaitDispose {
            val currentRenderer = value
            rendererScope.launch(Dispatchers.IO)
            {
                mutex.withLock {
                    currentRenderer?.close()
                }
            }
        }
    }

    val context = LocalContext.current
    val imageLoader = LocalContext.current.imageLoader
    val imageLoadingScope = rememberCoroutineScope()

    BoxWithConstraints(modifier=Modifier.fillMaxWidth()) {
        val width = with (LocalDensity.current)
            {maxWidth.toPx()}
            .toInt()
        val height = (width*sqrt(2f)).toInt()
        val pageCount by remember(renderer) {derivedStateOf {renderer?.pageCount ?: 0}}
        LazyColumn(
            verticalArrangement = verticalArrangement
        ) {
            items(
                count = pageCount,
                key = {index -> "$uri-$index"}
            ) {index ->
                val cacheKey = MemoryCache.Key("$uri-$index")
                var bitmap by remember { mutableStateOf(imageLoader.memoryCache[cacheKey]) }
                if (bitmap==null) {
                    DisposableEffect
                }
            }
        }
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetComposeFirstSampleTheme {
        PdfViewer()
    }
}