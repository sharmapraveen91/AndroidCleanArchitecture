package com.praveen.androidcleanarchitecture.presentation.coindetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.praveen.androidcleanarchitecture.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center, content = {
            Text(
                text = teamMember.name,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height((4.dp)))
            Text(
                text = teamMember.position,
                style = MaterialTheme.typography.body2,
                fontStyle = FontStyle.Italic
            )
        }
    )
}