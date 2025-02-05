/*
 * Copyright 2021 Google Inc. All rights reserved.
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

package com.google.wear.soyted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.wear.soyted.login.AuthRepository
import com.google.wear.soyted.login.LoginFlow
import com.google.wear.soyted.ui.RememberWearAppScreens
import com.google.wear.soyted.util.Toaster
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RememberWearActivity : ComponentActivity() {
    private val viewModel by viewModels<RememberWearViewModel>()

    @Inject
    lateinit var toaster: Toaster

    @Inject
    lateinit var loginFlow: LoginFlow

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.refetchIfStale()

        setContent {
            RememberWearAppScreens(viewModel)
        }
    }
}

