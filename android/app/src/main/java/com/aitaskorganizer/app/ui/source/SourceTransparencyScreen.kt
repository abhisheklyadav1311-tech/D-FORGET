package com.aitaskorganizer.app.ui.source

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aitaskorganizer.app.data.remote.dto.SourceDto
import com.aitaskorganizer.app.ui.components.BrutalBox
import com.aitaskorganizer.app.ui.source.viewmodel.SourceDetailUiState
import com.aitaskorganizer.app.ui.source.viewmodel.SourceDetailViewModel
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.BauhausBlack
import com.aitaskorganizer.app.ui.theme.BauhausWhite
import com.aitaskorganizer.app.ui.theme.BauhausYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SourceTransparencyScreen(
    viewModel: SourceDetailViewModel,
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "SOURCE LOG", 
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BauhausWhite,
                    titleContentColor = BauhausBlack
                )
            )
        },
        containerColor = BauhausWhite
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (val state = uiState) {
                is SourceDetailUiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = BauhausBlack
                    )
                }
                is SourceDetailUiState.Error -> {
                    ErrorContent(
                        message = state.message,
                        onRetry = { viewModel.loadSource() }
                    )
                }
                is SourceDetailUiState.Success -> {
                    SourceDetailContent(source = state.source)
                }
            }
        }
    }
}

@Composable
fun SourceDetailContent(source: SourceDto) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(AppDimens.PaddingMedium),
        verticalArrangement = Arrangement.spacedBy(AppDimens.PaddingLarge)
    ) {
        // Metadata Section
        BrutalBox(
            backgroundColor = BauhausYellow,
            cornerRadius = AppDimens.CornerRadiusSmall
        ) {
            Column(
                modifier = Modifier.padding(AppDimens.PaddingMedium)
            ) {
                Text(
                    text = "METADATA",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(AppDimens.PaddingSmall))
                MetadataItem(label = "Source ID", value = "#${source.id}")
                MetadataItem(label = "Type", value = source.type.uppercase())
                source.filename?.let { MetadataItem(label = "File Name", value = it) }
                MetadataItem(label = "Processed At", value = source.createdAt)
            }
        }

        // Original Text Section
        Column {
            Text(
                text = "ORIGINAL INPUT",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(bottom = AppDimens.PaddingSmall)
            )
            
            BrutalBox(
                backgroundColor = Color.White,
                cornerRadius = AppDimens.CornerRadiusSmall
            ) {
                Text(
                    text = source.originalText ?: "No text content found.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(AppDimens.PaddingMedium),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Transparency Note
        BrutalBox(
            backgroundColor = Color.White,
            cornerRadius = AppDimens.CornerRadiusSmall
        ) {
            Row(
                modifier = Modifier.padding(AppDimens.PaddingMedium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Info, 
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(AppDimens.PaddingMedium))
                Text(
                    text = "This log represents the raw data received by the AI engine. " +
                           "Use this to verify the accuracy of generated task proposals.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
private fun MetadataItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun ErrorContent(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimens.PaddingLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Error loading source details",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(AppDimens.PaddingSmall))
        Text(text = message, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(AppDimens.PaddingLarge))
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(containerColor = BauhausBlack)
        ) {
            Text("Retry")
        }
    }
}
