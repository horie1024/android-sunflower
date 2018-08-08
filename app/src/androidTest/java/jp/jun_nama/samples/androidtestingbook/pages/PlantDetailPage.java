/*
 * Copyright (C) 2018 TOYAMA Sumio <jun.nama@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.jun_nama.samples.androidtestingbook.pages;

import android.support.test.espresso.ViewInteraction;
import com.google.samples.apps.sunflower.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

public class PlantDetailPage {

    public void goBackPlantList() {
        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("上へ移動"),
                        PageUtils.childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        PageUtils.childAtPosition(
                                                withId(R.id.appbar),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());
    }

    public void assertAddButtonVisibility(boolean visible) {
        ViewInteraction imageButton = onView(withId(R.id.fab));
        if (visible) {
            imageButton.check(matches(isDisplayed()));
        } else {
            imageButton.check(matches(not(isDisplayed())));

        }
    }

    public void addToMyGarden() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab),
                        PageUtils.childAtPosition(
                                PageUtils.childAtPosition(
                                        withId(R.id.garden_nav_fragment),
                                        0),
                                2),
                        isDisplayed()));
        floatingActionButton.perform(click());
    }
}
