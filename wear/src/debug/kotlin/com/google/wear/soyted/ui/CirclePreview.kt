/*
 * Copyright 2022 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.wear.soyted.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text

@Preview(
    device = Devices.WEAR_OS_LARGE_ROUND,
    showSystemUi = true
)
@Composable
fun ListPreview() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        (1..10).forEach {
            Text("$it")
        }
    }
}

@Preview(
    widthDp = 228,
    heightDp = 228,
    device = Devices.WEAR_OS_LARGE_ROUND,
    showSystemUi = true
)
@Composable
fun ScalingListPreview() {
    ScalingLazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        items(10) {
            Text("$it")
        }
    }
}