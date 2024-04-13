package com.brayandev.users_gse.ui.views.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.brayandev.users_gse.domain.model.UserItemModel
import com.brayandev.users_gse.ui.theme.Primary
import com.brayandev.users_gse.ui.theme.Second
import com.brayandev.users_gse.ui.views.navigation.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreen(navController: NavController, viewModel: UsersViewModel) {
    val state by viewModel.state

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Usarios",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Primary,
                        )
                    }
                })
            },
        ) { padding ->
            if (state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    modifier = Modifier.padding(padding),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(4.dp),
                ) {
                    items(state.users) { user ->
                        UserItem(user, navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserItem(user: UserItemModel, navController: NavController) {
    val scope = rememberCoroutineScope()
    val tooltipState = rememberTooltipState(isPersistent = true)
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { navController.navigate(Routes.UserDetail.createRoute(user.id)) },
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .align(Alignment.CenterVertically),
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Icon_image",
                tint = Second,
            )
            Column {
                Text(
                    text = "Nombre: ${user.name}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp),
                    fontWeight = FontWeight.Bold,
                    color = Primary,
                )
                Text(
                    text = "Email: ${user.email}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp),
                    color = Primary,
                )
            }
            TooltipBox(
                positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                state = tooltipState,
                tooltip = {
                    RichTooltip(
                        title = { Text(text = "Website") },
                        text = {
                            Text(text = user.website)
                        },
                        action = {
                            TextButton(onClick = { scope.launch { tooltipState.dismiss() } }) {
                                Text(
                                    text = "Cerrar",
                                )
                            }
                        },
                    )
                },
            ) {
                IconButton(onClick = { scope.launch { tooltipState.show() } }) {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 8.dp),
                        imageVector = Icons.Rounded.Link,
                        contentDescription = "Icon_image",
                        tint = Second,
                    )
                }
            }
        }
    }
}
