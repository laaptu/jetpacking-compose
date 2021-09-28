package org.ahivs.jetpacking.app.deputy

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deputy.android.design.components.DeputyBlueLoadingButton
import com.deputy.android.design.components.DeputySecondaryButton
import com.deputy.android.design.theme.DeputyTheme
import com.deputy.android.design.utils.clickableWithoutRipple
import com.deputy.android.design.utils.isTablet
import org.ahivs.jetpacking.app.R

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Preview
@Composable
fun ApproveMultipleTimesheetScreen() {

    DeputyTheme {
        Card(
            shape = RoundedCornerShape(
                topStart = 14.dp,
                topEnd = 14.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            ),
            backgroundColor = DeputyTheme.colors.BackgroundSecondary
        ) {
            val modifier = Modifier.padding(horizontal = 15.dp)
            Column() {
                TopBar(modifier)
                Divider()
                TimesheetList(modifier.weight(1f))
                BottomView(
                    onApproveClick = {
                        println("### Progress bar clicked")
                    }
                )
            }
        }
    }


}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    isAllSelected: Boolean = false,
    selectAllEnabled: Boolean = true,
    selectAllClickAction: () -> Unit = {},
    closeClickAction: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(if (isAllSelected) R.string.unselect_all else R.string.select_all),
            modifier = Modifier
                .clickable(enabled = selectAllEnabled) {
                    selectAllClickAction()
                }
                .fillMaxHeight()
                .weight(if (isTablet()) 0.18f else 0.5f)
                .padding(start = 15.dp, end = 15.dp)
                .wrapContentHeight(Alignment.CenterVertically),
            color = DeputyTheme.colors.TintPrimary,
            fontSize = 16.sp
        )


        Text(
            text = stringResource(id = R.string.pending_timesheets),
            modifier = Modifier.weight(1f),
            fontSize = 17.sp,
            color = DeputyTheme.colors.TextPrimaryLabel
        )
        Image(
            painter = painterResource(id = R.drawable.ic_close_round),
            contentDescription = stringResource(id = R.string.cdr_close_pending_timesheet_screen),
            modifier = Modifier
                .clickable { closeClickAction() }
                .fillMaxHeight()
                .padding(start = 15.dp, end = 15.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
    }
}


@Composable
fun TimesheetList(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var isHeaderSelected by remember {
            mutableStateOf(false)
        }
        SectionHeader(
            headingDate = "Mon, 13 Jun", headingTotal = "25 hours",
            onHeaderClick = {
                isHeaderSelected = !isHeaderSelected
                println("## Header selected = $isHeaderSelected")
            },
            isHeaderSelected = isHeaderSelected
        )
    }
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    headingDate: String = "",
    headingTotal: String = "",
    onHeaderClick: () -> Unit = {},
    isHeaderSelected: Boolean = false
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Crossfade(targetState = isHeaderSelected) {
            when (it) {
                true -> Icon(
                    painter = painterResource(id = R.drawable.ic__check),
                    contentDescription = stringResource(
                        id = R.string.cdr_unselect_all_of,
                        headingDate
                    ),
                    tint = DeputyTheme.colors.TintPrimary,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                        .background(
                            color = DeputyTheme.colors.FillSecondary,
                            shape = CircleShape
                        )
                        .clickableWithoutRipple(onClick = onHeaderClick)
                        .padding(6.dp)
                )
                false -> Box(
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                        .clickableWithoutRipple(
                            onClickLabel = stringResource(
                                id = R.string.cdr_select_all_of,
                                headingDate
                            ),
                            onClick = onHeaderClick
                        )
                        .background(
                            color = DeputyTheme.colors.FillSecondary,
                            shape = CircleShape
                        )

                )

            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = headingDate,
            modifier = Modifier.weight(1f),
            color = DeputyTheme.colors.TextSecondaryLabel,
            fontSize = 15.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = headingTotal,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End,
            color = DeputyTheme.colors.TextSecondaryLabel,
            fontSize = 15.sp,
            maxLines = 1
        )

    }
}


@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    onListItemClick: () -> Unit = {}
) {

}


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun BottomView(
    modifier: Modifier = Modifier,
    onCancelClick: () -> Unit = {},
    onApproveClick: () -> Unit = {},
    onApproveProgress: Boolean = false,
    totalCount: TotalCount = TotalCount()
) {
    var showProgress by remember {
        mutableStateOf(false)
    }
    AnimatedVisibility(
        visible = true,
        enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
    ) {
        Card(
            shape = RoundedCornerShape(
                topStart = 14.dp,
                topEnd = 14.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            ),
            elevation = 2.dp,
            backgroundColor = DeputyTheme.colors.BackgroundPrimary
        ) {
            Row(
                modifier = Modifier.padding(
                    top = 15.dp, bottom = 25.dp,
                    start = 15.dp,
                    end = 15.dp
                )
            ) {
                DeputySecondaryButton(
                    onClick = {
                        showProgress = !showProgress
                              println("## cancel click")

                    }, modifier = Modifier
                        .weight(1f)
                        .padding(end = 5.dp),
                    text = stringResource(id = R.string.cancel)
                )
                DeputyBlueLoadingButton(
                    buttonClick = onApproveClick, buttonModifier = Modifier
                        .weight(1f)
                        .padding(start = 5.dp),
                    buttonText = stringResource(id = R.string.approve, totalCount.getTotal()),
                    showProgress = showProgress
                )
            }
        }
    }


}