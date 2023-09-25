package com.example.app.view

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app.view.repositoryDetail.RepositoryDetailViewModel
import com.example.app.view.repositoryDetail.RepositoryDetailViewModelFactory

@Composable
fun RepositoryDetail(context: Context, id: String ) {
    val viewModel: RepositoryDetailViewModel =
        viewModel(
            factory = RepositoryDetailViewModelFactory(
                context
            )
        )

    val item = viewModel.getItemRepository(id)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Author: ${item?.author}",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Stargazers: ${item?.stargazersCount}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Forks: ${item?.forksCount}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}