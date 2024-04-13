package com.brayandev.users_gse.ui.views.userDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brayandev.users_gse.R
import com.brayandev.users_gse.domain.model.UserItemModel
import com.brayandev.users_gse.ui.theme.Primary
import com.brayandev.users_gse.ui.theme.Second

@Composable
fun UserDetailScreen(viewModel: UserDetailViewModel) {
    val state by viewModel.state

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
    } else {
        state.user?.let { UserScreen(it) }
    }
}

@Composable
fun UserScreen(user: UserItemModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Column(Modifier.fillMaxSize()) {
            Icon(
                modifier = Modifier.fillMaxWidth().size(80.dp)
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .align(Alignment.CenterHorizontally),
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Icon_image",
                tint = Second,
            )
            BasicInformation(user)
            AddressScreen(user)
            CompanyScreen(user)
        }
    }
}

@Composable
fun BasicInformation(user: UserItemModel) {
    Column {
        Text(
            text = user.username,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp, vertical = 4.dp),
            textAlign = TextAlign.Center,
            color = Primary,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier.align(Alignment.Start)
                .padding(horizontal = 4.dp, vertical = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_name_detail), color = Primary)
            Text(text = user.name, color = Second)
        }
        Row(
            modifier = Modifier.align(Alignment.Start)
                .padding(horizontal = 4.dp, vertical = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_email_detail), color = Primary)
            Text(text = user.email, color = Second)
        }
        Row(
            modifier = Modifier.align(Alignment.Start)
                .padding(horizontal = 4.dp, vertical = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_phone), color = Primary)
            Text(text = user.phone, color = Second)
        }
        Row(
            modifier = Modifier.align(Alignment.Start)
                .padding(horizontal = 4.dp, vertical = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_website_detail), color = Primary)
            Text(text = user.website, color = Second)
        }
    }
}

@Composable
fun AddressScreen(user: UserItemModel) {
    Column {
        Text(
            text = stringResource(R.string.text_address),
            color = Primary,
            modifier = Modifier.align(Alignment.Start)
                .padding(horizontal = 4.dp, vertical = 4.dp),
        )
        Row(
            modifier = Modifier.padding(start = 32.dp, top = 4.dp, bottom = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_street), color = Primary)
            Text(text = user.address.street, color = Second)
        }
        Row(
            modifier = Modifier.padding(start = 32.dp, top = 4.dp, bottom = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_suite), color = Primary)
            Text(text = user.address.suite, color = Second)
        }
        Row(
            modifier = Modifier.padding(start = 32.dp, top = 4.dp, bottom = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_city), color = Primary)
            Text(text = user.address.city, color = Second)
        }
        Row(
            modifier = Modifier.padding(start = 32.dp, top = 4.dp, bottom = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_zip_code), color = Primary)
            Text(text = user.address.zipcode, color = Second)
        }
    }
}

@Composable
fun CompanyScreen(user: UserItemModel) {
    Column {
        Text(
            text = stringResource(R.string.text_company),
            color = Primary,
            modifier = Modifier.align(Alignment.Start)
                .padding(horizontal = 4.dp, vertical = 4.dp),
        )
        Row(
            modifier = Modifier.padding(start = 32.dp, top = 4.dp, bottom = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_name_company), color = Primary)
            Text(text = user.company.name, color = Second)
        }
        Column(
            modifier = Modifier.padding(start = 32.dp, top = 4.dp, bottom = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_catchPhrase), color = Primary)
            Text(text = user.company.catchPhrase, color = Second)
        }
        Row(
            modifier = Modifier.padding(start = 32.dp, top = 4.dp, bottom = 4.dp),
        ) {
            Text(text = stringResource(R.string.text_bs), color = Primary)
            Text(text = user.company.bs, color = Second)
        }
    }
}
