package com.acme.a3csci3130;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateContactTest {

    private String textToFind;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    /**
     * Test Create Contact
     */
    @Test
    public void createContact(){
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Bill"),closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("000012345"));
        onView(withId(R.id.primary)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("bigwall"));
        onView(withId(R.id.province)).perform(typeText("AB"));
        onView(withId(R.id.submitButton1)).perform(click());
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).check(matches(withText("Bill")));
        onView(withId(R.id.number)).check(matches(withText("000012345")));
        onView(withId(R.id.primary)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("bigwall")));
        onView(withId(R.id.province)).check(matches(withText("AB")));
    }
 



}
