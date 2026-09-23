package com.aitaskorganizer.app.ui.inbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aitaskorganizer.app.ui.components.BrutalBox
import com.aitaskorganizer.app.ui.inbox.viewmodel.InboxUiState
import com.aitaskorganizer.app.ui.inbox.viewmodel.InboxViewModel
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.BauhausBlack
import com.aitaskorganizer.app.ui.theme.BauhausWhite
import com.aitaskorganizer.app.ui.theme.SuccessGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasteTextScreen(
    viewModel: InboxViewModel,
    onBack: () -> Unit,
    onSuccess: (Long) -> Unit
) {
    var text by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is InboxUiState.Success) {
            onSuccess((uiState as InboxUiState.Success).sourceId)
            viewModel.resetState()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "PASTE TEXT", 
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (text.isNotBlank() && uiState !is InboxUiState.Loading) {
                        IconButton(onClick = { viewModel.analyzeText(text) }) {
                            Icon(
                                Icons.Default.Check, 
                                contentDescription = "Analyze",
                                tint = SuccessGreen
                            )
                        }
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(AppDimens.PaddingMedium)
        ) {
            Text(
                text = "Enter raw text, meeting notes, or messages for AI analysis:",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = AppDimens.PaddingSmall)
            )

            BrutalBox(
                backgroundColor = Color.White,
                cornerRadius = AppDimens.CornerRadiusSmall,
                modifier = Modifier.weight(1f)
            ) {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.fillMaxSize(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    placeholder = { Text("Paste your text here...") }
                )
            }

            if (uiState is InboxUiState.Loading) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppDimens.PaddingMedium),
                    color = BauhausBlack
                )
            }

            if (uiState is InboxUiState.Error) {
                Text(
                    text = (uiState as InboxUiState.Error).message,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = AppDimens.PaddingSmall)
                )
            }

            Spacer(modifier = Modifier.height(AppDimens.PaddingMedium))

            BrutalBox(
                backgroundColor = BauhausBlack,
                cornerRadius = AppDimens.CornerRadiusSmall,
                onClick = if (text.isNotBlank() && uiState !is InboxUiState.Loading) {
                    { viewModel.analyzeText(text) }
                } else null,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AppDimens.ButtonHeight),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (uiState is InboxUiState.Loading) "ANALYZING..." else "ANALYZE WITH AI",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
