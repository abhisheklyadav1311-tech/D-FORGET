package com.aitaskorganizer.app.ui.analysis

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aitaskorganizer.app.data.remote.dto.ProposedTaskDto
import com.aitaskorganizer.app.ui.analysis.viewmodel.AnalysisUiState
import com.aitaskorganizer.app.ui.analysis.viewmodel.AnalysisViewModel
import com.aitaskorganizer.app.ui.theme.BauhausBlack
import com.aitaskorganizer.app.ui.theme.BauhausYellow
import com.aitaskorganizer.app.ui.theme.BauhausRed

@Composable
fun AnalysisResultScreen(
    sourceId: Long,
    viewModel: AnalysisViewModel,
    onBackClick: () -> Unit,
    onViewSource: (Long) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(sourceId) {
        viewModel.analyzeSource(sourceId)
    }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(16.dp)
                    .background(Color.White)
                    .border(2.5.dp, BauhausBlack, RoundedCornerShape(4.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = BauhausBlack
                        )
                    }
                    Text(
                        text = "AI ANALYSIS",
                        fontWeight = FontWeight.Black,
                        fontSize = 20.sp,
                        color = BauhausBlack
                    )
                }
            }
        },
        containerColor = Color(0xFFF5F0E8)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            when (val state = uiState) {
                is AnalysisUiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = BauhausYellow)
                    }
                }
                is AnalysisUiState.Error -> {
                    Text(text = "Error: ${state.message}", color = BauhausRed)
                }
                is AnalysisUiState.Success -> {
                    Text(
                        text = state.result.summary,
                        modifier = Modifier.padding(bottom = 16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Button(
                        onClick = { onViewSource(sourceId) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                            .border(2.5.dp, BauhausBlack, RoundedCornerShape(4.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Icon(Icons.Default.Description, contentDescription = null, tint = BauhausBlack)
                        Spacer(Modifier.width(8.dp))
                        Text("VIEW SOURCE LOG", color = BauhausBlack, fontWeight = FontWeight.Bold)
                    }
                    
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        items(state.result.tasks) { task ->
                            ProposedTaskItem(
                                task = task,
                                onConfirm = { viewModel.confirmTask(task, sourceId) }
                            )
                        }
                    }
                }
                else -> {}
            }
        }
    }
}

@Composable
fun ProposedTaskItem(
    task: ProposedTaskDto,
    onConfirm: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.5.dp, BauhausBlack, RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = task.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = null,
                    tint = BauhausYellow
                )
            }
            
            task.description?.let {
                Text(text = it, modifier = Modifier.padding(top = 8.dp))
            }
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Priority: ${task.priority}", style = MaterialTheme.typography.bodySmall)
                    task.deadline?.let {
                        Text(text = "Deadline: $it", style = MaterialTheme.typography.bodySmall)
                    }
                }
                
                Button(
                    onClick = onConfirm,
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BauhausYellow),
                    modifier = Modifier.border(2.dp, BauhausBlack, RoundedCornerShape(4.dp))
                ) {
                    Icon(Icons.Default.Check, contentDescription = null, tint = BauhausBlack)
                    Spacer(Modifier.width(4.dp))
                    Text("Confirm", color = BauhausBlack, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
