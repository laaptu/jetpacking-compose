package org.ahivs.jetpacking.app.deputy

import android.graphics.Color
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.deputy.android.design.components.DeputyCircularProgressIndicator
import com.deputy.android.design.components.DeputyLoadingButton
import com.deputy.android.design.components.DeputySecondaryButton
import com.deputy.android.design.theme.DeputyTheme
import com.deputy.android.design.utils.clickableWithoutRipple
import com.deputy.android.design.utils.isTablet
import org.ahivs.jetpacking.app.R

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Preview
@Composable
fun ApproveMultipleTimesheetScreen(
    groups: Map<String, PendingTimeSheetGroup> = emptyMap(),
    onApproveClick: () -> Unit = {},
    onCancelClick: () -> Unit = {},
    uiProgress: UIProgress = UIProgress.Hide
) {
    DeputyTheme {
        Card(
            shape = RoundedCornerShape(
                topStart = 14.dp,
                topEnd = 14.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            ),
            modifier = Modifier.fillMaxSize(),
            backgroundColor = DeputyTheme.colors.BackgroundSecondary
        ) {
            val modifier = Modifier.padding(horizontal = 15.dp)
            Column(modifier = Modifier.fillMaxSize()) {
                TopBar(modifier)
                Divider()
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {

                        groups.forEach { (groupId, pendingTimeSheetGroup) ->
                            item(key = groupId) {
                                SectionHeader(
                                    headingDate = pendingTimeSheetGroup.group.groupName,
                                    headingTotal = pendingTimeSheetGroup.group.groupTotal.toString()
                                )
                            }

                            itemsIndexed(items = pendingTimeSheetGroup.pendingTimeSheets) { index, pendingTimeSheet ->
                                ListItem()
                            }
                        }
                    }
                    BottomView(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomStart),
                        onApproveClick = onApproveClick,
                        onCancelClick = onCancelClick,
                        onApproveProgress = uiProgress == UIProgress.Show,
                        totalCount = TotalCount(10)
                    )
                }

            }
        }
    }
}


@ExperimentalAnimationApi
@Composable
fun SlideUp(content: @Composable AnimatedVisibilityScope.() -> Unit) {
    AnimatedVisibility(
        modifier = Modifier.fillMaxSize(),
        visible = true,
//        enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
//        exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(),
    ) {
        content
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
            style = DeputyTheme.typography.callout
        )


        Text(
            text = stringResource(id = R.string.pending_timesheets),
            modifier = Modifier.weight(1f),
            style = DeputyTheme.typography.headline,
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
            isHeaderSelected = isHeaderSelected,
            isFirstItem = true
        )
        ListItem(
            showTopCurve = true,
            showDivider = true
        )
//        Divider(modifier = Modifier.offset(x = 48.dp))
        ListItem(
            showDivider = true
        )
//        Divider(modifier = Modifier.offset(x = 48.dp))
        ListItem(
            showBottomCurve = true
        )
    }
}

@Composable
fun AllApprovedView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.padding(bottom = 80.dp),
            painter = painterResource(id = R.drawable.ic_all_approved),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = 80.dp),
            text = stringResource(id = R.string.all_timesheets_approved),
            style = DeputyTheme.typography.body1,
            color = DeputyTheme.colors.TextSecondaryLabel
        )
    }
}

@Composable
fun EmptyProgressView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DeputyCircularProgressIndicator()
    }
}

@Composable
fun RetryView(
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit = {}
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_warning),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.could_not_load_timesheets),
            style = DeputyTheme.typography.body1,
            color = DeputyTheme.colors.TextSecondaryLabel
        )
        Spacer(modifier = Modifier.height(15.dp))
        DeputySecondaryButton(
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp),
            onClick = onRetryClick,
            text = stringResource(id = R.string.try_again)
        )
    }
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    headingDate: String = "",
    headingTotal: String = "",
    isFirstItem: Boolean = false,
    onHeaderClick: () -> Unit = {},
    isHeaderSelected: Boolean = false
) {
    println("##SectionHeader recomposed")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = if (isFirstItem) 15.dp else 10.dp,
                bottom = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HeaderImage(
            isSelected = isHeaderSelected,
            onClick = onHeaderClick,
            headingDate = headingDate
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = headingDate,
            modifier = Modifier.weight(1f),
            color = DeputyTheme.colors.TextSecondaryLabel,
            fontSize = 15.sp,
            style = DeputyTheme.typography.subhead,
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = headingTotal,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End,
            color = DeputyTheme.colors.TextSecondaryLabel,
            style = DeputyTheme.typography.subhead,
            fontSize = 15.sp,
            maxLines = 1
        )

    }
}

@Composable
fun HeaderImage(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
    headingDate: String = ""
) {
    Crossfade(targetState = isSelected) {
        when (it) {
            true -> Icon(
                painter = painterResource(id = R.drawable.ic__check),
                contentDescription = stringResource(
                    id = R.string.cdr_unselect_all_of,
                    headingDate
                ),
                tint = DeputyTheme.colors.TintPrimary,
                modifier = modifier
                    .size(27.dp)
                    .background(
                        color = DeputyTheme.colors.FillSecondary,
                        shape = CircleShape
                    )
                    .clickableWithoutRipple(onClick = onClick)
                    .padding(6.dp)
            )
            false -> Box(
                modifier = modifier
                    .size(27.dp)
                    .clickableWithoutRipple(
                        onClickLabel = stringResource(
                            id = R.string.cdr_select_all_of,
                            headingDate
                        ),
                        onClick = onClick
                    )
                    .background(
                        color = DeputyTheme.colors.FillSecondary,
                        shape = CircleShape
                    )

            )

        }
    }
}


/**
 *     F  L
 *     T  T  = no border, curve top curve bottom
 *     T  F  = border, curve top  NO curve bottom
 *     F T  = no border, NO curve top  curve bottom
 *     F F  = border, NO curve top NO curve bottom
 *
 * */

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    onListItemClick: () -> Unit = {},
    showTopCurve: Boolean = false,
    showBottomCurve: Boolean = false,
    showDivider: Boolean = false
) {

    val topCornerRadius = if (showTopCurve) 10.dp else 0.dp
    val bottomCornerRadius = if (showBottomCurve) 10.dp else 0.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = DeputyTheme.colors.BackgroundPrimary,
                shape = RoundedCornerShape(
                    topStart = topCornerRadius,
                    topEnd = topCornerRadius,
                    bottomEnd = bottomCornerRadius,
                    bottomStart = bottomCornerRadius
                )
            )
    ) {
        var isSelected by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier.padding(
                start = 15.dp,
                top = 15.dp,
                bottom = 18.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage(
                imageUrl = "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
                onClick = { isSelected = !isSelected },
                isSelected = isSelected
            )
            Spacer(modifier = Modifier.width(13.dp))
            Column {
                Text(
                    text = "9:02am -5:12pm",
                    style = DeputyTheme.typography.headline
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconText(
                        iconResId = R.drawable.ic_cal,
                        text = "9am - 5pm", rowScope = this
                    )
                    IconText(
                        iconResId = R.drawable.ic_cafe,
                        text = "30m", rowScope = this
                    )
                    IconText(
                        iconResId = R.drawable.ic_msg,
                        text = "1", rowScope = this
                    )
                }
            }
        }
        if (showDivider)
            Divider(modifier = Modifier.padding(start = 70.dp))
    }
}

@Composable
fun IconText(
    modifier: Modifier = Modifier,
    iconResId: Int? = null,
    text: String = "",
    rowScope: RowScope
) {
    rowScope.run {
        iconResId?.let {
            Icon(
                painter = painterResource(id = iconResId), contentDescription = null,
                tint = DeputyTheme.colors.FillPrimary
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = text,
            style = DeputyTheme.typography.body2,
            color = DeputyTheme.colors.TextSecondaryLabel,
            fontSize = 15.sp

        )
        Spacer(modifier = Modifier.width(18.dp))
    }
}


@Composable
fun ProfileImage(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    imageUrl: String = "",
    isSelected: Boolean = false
) {
    Crossfade(targetState = isSelected) {
        when (it) {
            true -> Icon(
                painter = painterResource(id = R.drawable.ic__check),
                contentDescription = stringResource(
                    id = R.string.cdr_unselect_timesheet
                ),
                tint = DeputyTheme.colors.OtherFills7Bg,
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = DeputyTheme.colors.TintPrimary,
                        shape = CircleShape
                    )
                    .clickableWithoutRipple(onClick = onClick)
                    .padding(15.dp)
            )
            false -> Image(
                painter = rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                        crossfade(true)
                    }
                ),
                contentDescription = stringResource(id = R.string.cdr_select_timesheet),
                modifier = Modifier
                    .size(48.dp)
                    .clickableWithoutRipple(
                        onClickLabel = stringResource(
                            id = R.string.cdr_select_timesheet
                        ),
                        onClick = onClick
                    )
                    .background(
                        color = DeputyTheme.colors.FillSecondary,
                        shape = CircleShape
                    )

            )

        }
    }
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
    println("## BottomView recomposed ")
    AnimatedVisibility(
        visible = totalCount.isVisible(),
        enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(),
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(
                topStart = 18.dp,
                topEnd = 18.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            ),
            elevation = 3.dp,
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
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 5.dp),
                    onClick = onCancelClick,
                    text = stringResource(id = R.string.cancel)
                )
                DeputyLoadingButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 5.dp),
                    buttonClick = onApproveClick,
                    buttonText = stringResource(id = R.string.approve, totalCount.getTotal()),
                    showProgress = onApproveProgress,
                    onClickLabel = stringResource(id = R.string.cdr_approve, totalCount.getTotal())
                )
            }
        }
    }


}