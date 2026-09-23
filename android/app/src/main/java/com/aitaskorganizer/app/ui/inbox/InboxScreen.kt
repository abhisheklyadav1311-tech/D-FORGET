package com.aitaskorganizer.app.ui.inbox

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.CloudUpload
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aitaskorganizer.app.di.RepositoryModule
import com.aitaskorganizer.app.ui.components.BrutalBox
import com.aitaskorganizer.app.ui.inbox.viewmodel.InboxUiState
import com.aitaskorganizer.app.ui.inbox.viewmodel.InboxViewModel
import com.aitaskorganizer.app.ui.inbox.viewmodel.InboxViewModelFactory
import com.aitaskorganizer.app.ui.theme.AppDimens
import com.aitaskorganizer.app.ui.theme.BauhausBlack
import com.aitaskorganizer.app.ui.theme.BauhausRed
import com.aitaskorganizer.app.ui.theme.BauhausWhite
import com.aitaskorganizer.app.ui.theme.BauhausYellow
import com.aitaskorganizer.app.ui.theme.SuccessGreen
import androidx.compose.ui.unit.sp

@Composable
fun InboxScreen(
    onNavigateToAnalysisResult: (Long) -> Unit = {},
    onNavigateToPasteText: () -> Unit = {},
    viewModel: InboxViewModel = viewModel(
        factory = InboxViewModelFactory(RepositoryModule.sourceRepository)
    )
) {
    var rawText by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let { viewModel.uploadFile(it, context.contentResolver, "image") }
    }

    val pdfPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let { viewModel.uploadFile(it, context.contentResolver, "pdf") }
    }

    LaunchedEffect(uiState) {
        if (uiState is InboxUiState.Success) {
            onNavigateToAnalysisResult((uiState as InboxUiState.Success).sourceId)
            viewModel.resetState()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BauhausWhite),
        contentPadding = PaddingValues(
            start = AppDimens.ScreenHorizontalPadding,
            end = AppDimens.ScreenHorizontalPadding,
            top = AppDimens.ScreenTopPadding,
            bottom = 100.dp
        ),
        verticalArrangement = Arrangement.spacedBy(AppDimens.PaddingLarge)
    ) {
        // Hero title
        item {
            Column(modifier = Modifier.padding(top = 8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "AI INBOX",
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Black,
                        color = BauhausBlack
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Outlined.AutoAwesome,
                        contentDescription = null,
                        tint = BauhausRed,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "DROP ANYTHING HERE. I'LL EXTRACT TASKS, TOPICS, AND DEADLINES AUTOMATICALLY.",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = BauhausBlack.copy(alpha = 0.8f)
                )
            }
        }

        // Main Ingestion Hub
        item {
            BrutalBox(
                backgroundColor = BauhausYellow,
                cornerRadius = AppDimens.CornerRadiusSmall,
                modifier = Modifier.fillMaxWidth(),
                onClick = onNavigateToPasteText
            ) {
                Column(
                    modifier = Modifier.padding(AppDimens.PaddingLarge),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ContentPaste,
                        contentDescription = null,
                        tint = BauhausBlack,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "ANALYZE CLIPBOARD / TEXT",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black,
                        color = BauhausBlack
                    )
                    Text(
                        text = "PASTE RAW EMAILS, NOTES, OR CHAT",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = BauhausBlack.copy(alpha = 0.7f)
                    )
                }
            }
        }

        // Modalities Grid
        item {
            Text(
                text = "OTHER MODALITIES",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Black,
                letterSpacing = 1.sp,
                color = BauhausBlack
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                UploadOptionCard(
                    icon = Icons.Outlined.Image,
                    label = "IMAGE",
                    backgroundColor = BauhausWhite,
                    iconColor = BauhausRed,
                    modifier = Modifier.weight(1f),
                    onClick = { imagePickerLauncher.launch("image/*") }
                )
                UploadOptionCard(
                    icon = Icons.Outlined.Description,
                    label = "PDF",
                    backgroundColor = BauhausWhite,
                    iconColor = BauhausBlack,
                    modifier = Modifier.weight(1f),
                    onClick = { pdfPickerLauncher.launch("application/pdf") }
                )
                UploadOptionCard(
                    icon = Icons.Outlined.AutoAwesome,
                    label = "MAGIC",
                    backgroundColor = BauhausWhite,
                    iconColor = SuccessGreen,
                    modifier = Modifier.weight(1f),
                    onClick = { /* Future: Auto-scan feature */ }
                )
            }
        }

        // Recent Activity placeholder
        item {
            Text(
                text = "RECENTLY ANALYZED",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Black,
                letterSpacing = 1.sp,
                color = BauhausBlack
            )
            Spacer(modifier = Modifier.height(12.dp))
            BrutalBox(
                backgroundColor = BauhausWhite,
                cornerRadius = AppDimens.CornerRadiusSmall,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(BauhausRed, RoundedCornerShape(4.dp))
                            .border(1.dp, BauhausBlack, RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Outlined.Description, contentDescription = null, tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text("College Notice.pdf", fontWeight = FontWeight.Bold)
                        Text("Analyzed 2h ago • 2 tasks extracted", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Composable
private fun UploadOptionCard(
    icon: ImageVector,
    label: String,
    backgroundColor: Color,
    iconColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    BrutalBox(
        backgroundColor = backgroundColor,
        cornerRadius = AppDimens.CornerRadiusSmall,
        modifier = modifier,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Black,
                color = BauhausBlack
            )
        }
    }
}
