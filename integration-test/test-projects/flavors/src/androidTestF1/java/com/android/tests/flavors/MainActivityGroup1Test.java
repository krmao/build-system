/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.tests.flavors;

import static org.junit.Assert.*;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * An example of an {@link ActivityInstrumentationTestCase2} of a specific activity {@link Focus2}.
 * By virtue of extending {@link ActivityInstrumentationTestCase2}, the target activity is
 * automatically launched and finished before and after each test. This also extends {@link
 * android.test.InstrumentationTestCase}, which provides access to methods for sending events to the
 * target activity, such as key and touch events. See {@link #sendKeys}.
 *
 * <p>In general, {@link android.test.InstrumentationTestCase}s and {@link
 * ActivityInstrumentationTestCase2}s are heavier weight functional tests available for end to end
 * testing of your user interface. When run via a {@link android.test.InstrumentationTestRunner},
 * the necessary {@link android.app.Instrumentation} will be injected for you to user via {@link
 * #getInstrumentation} in your tests.
 *
 * <p>See {@link com.example.android.apis.AllTests} for documentation on running all tests and
 * individual tests in this application.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityGroup1Test {
    @Rule public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    private TextView mResOverLay;
    private TextView mResOverLay1;
    private TextView mBuildConfig1;
    private TextView mCodeOverlay1;

    @Before
    public void setUp() {
        final MainActivity a = rule.getActivity();
        // ensure a valid handle to the activity has been returned
        assertNotNull(a);

        mResOverLay = (TextView) a.findViewById(R.id.resoverlay);
        mResOverLay1 = (TextView) a.findViewById(R.id.resoverlay1);
        mBuildConfig1 = (TextView) a.findViewById(R.id.buildconfig1);
        mCodeOverlay1 = (TextView) a.findViewById(R.id.codeoverlay1);
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this test doesn't pass, the
     * test case was not set up properly and it might explain any and all failures in other tests.
     * This is not guaranteed to run before other tests, as junit uses reflection to find the tests.
     */
    @MediumTest
    @Test
    public void testPreconditions() {
        assertNotNull(mResOverLay);
        assertNotNull(mResOverLay1);
        assertNotNull(mBuildConfig1);
        assertNotNull(mCodeOverlay1);
    }

    @MediumTest
    @Test
    public void testResOverlay() {
        assertEquals("f1", mResOverLay.getText().toString());
        assertEquals("f1", mResOverLay1.getText().toString());
    }

    @MediumTest
    @Test
    public void testBuildConfig() {
        assertEquals("f1", mBuildConfig1.getText().toString());
    }

    @MediumTest
    @Test
    public void testCodeOverlay() {
        assertEquals("f1", mCodeOverlay1.getText().toString());
    }
}
